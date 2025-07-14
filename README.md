# 🛒 Sacola API

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-blue?logo=java"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-2.7.13-brightgreen?logo=spring-boot"/>
  <img src="https://img.shields.io/badge/Build-Maven-blueviolet?logo=apache-maven"/>
  <img src="https://img.shields.io/badge/license-MIT-lightgrey"/>
</p>

<p align="center">
  <b>API de carrinho de compras para delivery, desenvolvida com Java 17 e Spring Boot.</b>
</p>

---

## 📑 Sumário
- [Tecnologias](#-tecnologias)
- [Padrões de Projeto](#-padrões-de-projeto)
- [Setup e Execução](#-setup-e-execução)
- [Configurações Principais](#-configurações-principais)
- [Licença](#-licença)
- [Autor](#-autor)

---

## 🚀 Tecnologias

<div align="left">
  <img src="https://img.shields.io/badge/Java-17-blue?logo=java"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-2.7.13-brightgreen?logo=spring-boot"/>
  <img src="https://img.shields.io/badge/H2-Database-informational?logo=h2"/>
  <img src="https://img.shields.io/badge/Lombok-1.18.24-orange?logo=lombok"/>
  <img src="https://img.shields.io/badge/Maven-Build-blueviolet?logo=apache-maven"/>
</div>

- **Java 17**
- **Spring Boot 2.7.13**
  - Spring Web
  - Spring Data JPA
  - Spring Boot Actuator
  - Spring Boot DevTools
- **H2 Database** (banco em memória)
- **Lombok** (boilerplate reduction)
- **Maven** (build e dependências)

---

## 🏛️ Padrões de Projeto

- <b>Injeção de Dependência</b> (Spring DI)
- <b>MVC</b> (Model-View-Controller)
- <b>Repository</b> (Spring Data)
- <b>Configuração por Propriedades</b> (application.properties)

---

## ⚙️ Setup e Execução

> <b>Pré-requisitos:</b> Java 17+ e Maven 3.6+

```bash
# Clone o repositório
$ git clone <url-do-repo>
$ cd sacola_api

# Execute a aplicação
$ mvn spring-boot:run

# Ou gere o JAR
$ mvn clean package
$ java -jar target/sacola.api-0.0.1-SNAPSHOT.jar
```

- Endpoint base: [`http://localhost:8081/`](http://localhost:8081/)
- Console H2: [`http://localhost:8081/h2-console`](http://localhost:8081/h2-console)
  - JDBC URL: `jdbc:h2:mem:testedb`
  - Usuário: `sa`
  - Senha: *(em branco)*

---

## 🔧 Configurações Principais

Arquivo: <code>application.properties</code>
```properties
server.port=8081
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testedb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.show-sql=true
```

---

## 📄 Licença

Distribuído sob a licença MIT. Veja [LICENSE](LICENSE) para mais informações.

---


## 👤 Autor
by **Rodolfo M. F. Abreu**