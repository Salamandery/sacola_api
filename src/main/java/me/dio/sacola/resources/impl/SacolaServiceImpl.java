package me.dio.sacola.resources.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import me.dio.sacola.enumeration.FormaPagamento;
import me.dio.sacola.model.Item;
import me.dio.sacola.model.Restaurante;
import me.dio.sacola.model.Sacola;
import me.dio.sacola.repository.ItemRepository;
import me.dio.sacola.repository.ProdutoRepository;
import me.dio.sacola.repository.SacolaRepository;
import me.dio.sacola.resources.dto.ItemDto;
import me.dio.sacola.services.SacolaService;

@Service
@RequiredArgsConstructor
public class SacolaServiceImpl implements SacolaService {
    private final SacolaRepository sacolaRepository;
    private final ProdutoRepository produtoRepository;
    private final ItemRepository itemRepository;

    @Override
    public Sacola verSacola(Long id) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'verSacola'");
        return sacolaRepository.findById(id).orElseThrow(
            () -> {
                throw new RuntimeException("Essa sacola não existe!");
            }
        );
    }

    @Override
    public Sacola fecharSacola(Long id, int numeroformaPagamento) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'fecharSacola'");
        Sacola sacola = verSacola(id);

        if (sacola.getItens().isEmpty()) {
            throw new RuntimeException("Inclua item na sacola!");
        }

        FormaPagamento formaPagamento = numeroformaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
        sacola.setFormaPagamento(formaPagamento);
        sacola.setFechada(true);
        
        return sacolaRepository.save(sacola);
    }

    @Override
    public Item incluirItemNaSacola(ItemDto itemDto) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'incluirItemNaSacola'");
        Sacola sacola = verSacola(itemDto.getSacolaId());

        if (sacola.isFechada()) {
            throw new RuntimeException("Essa sacola está fechada!");
        }

        Item item = Item.builder()
            .quantidade(itemDto.getQuantidade())
            .sacola(sacola)
            .produto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(
                () -> {
                    throw new RuntimeException("Esse produto não existe!");
                }
            ))
            .build();

        List<Item> itensDaSacola = sacola.getItens();
        if (itensDaSacola.isEmpty()) {
            itensDaSacola.add(item);
        } else {
            Restaurante restauranteAtual = itensDaSacola.get(0).getProduto().getRestaurante();
            Restaurante restauranteDoItem = item.getProduto().getRestaurante();

            if (restauranteAtual.equals(restauranteDoItem)) {
                itensDaSacola.add(item);
            } else {
                throw new RuntimeException("Não é possivel adicionar produtos de restaurante diferentes.. feche a sacola ou esvazie");
            }
        }

        List<Double> valorDosItens = new ArrayList<>();

        for (Item itemDaSacola: itensDaSacola) {
           double valorItemdaSacola = itemDaSacola.getProduto().getValorUnitario() * itemDaSacola.getQuantidade();
           valorDosItens.add(valorItemdaSacola);
        }

        double valorItemdaSacola = valorDosItens.stream()
            .mapToDouble(valorTotal -> valorTotal)
            .sum();

        sacola.setValorTotal(valorItemdaSacola);
        sacolaRepository.save(sacola);

        return item;
    }
    
}
