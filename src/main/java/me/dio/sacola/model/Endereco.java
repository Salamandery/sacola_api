package me.dio.sacola.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Endereco {
    private String cep;
    private String complemento;
}
