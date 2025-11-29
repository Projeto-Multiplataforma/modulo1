# Pessoa API

# Pessoa API

Esta API foi desenvolvida em **Spring Boot 3+** e implementa um CRUD de Pessoa (criar, ler, atualizar e deletar).  
O retorno das consultas é paginado, exibindo 10 registros por página, e apenas pessoas com o campo `ativo = true` são listadas.  
Os logs da aplicação são enviados para o Graylog.  
O projeto inclui um arquivo `docker-compose.yml` com todas as imagens necessárias (banco de dados, Graylog e aplicação).

---

## Tecnologias utilizadas

- Java 17  
- Spring Boot 3+  
- Spring Data JPA  
- Banco de dados 
- Graylog  
- Docker e Docker Compose

---

## Como executar

1. Clonar o repositório:
   ```bash
   git clone https://github.com/Projeto-Multiplataforma/modulo1
   cd modulo1/pessoa


# Separação de domain e springframework

O domain contém apenas regra de negócio, totalmente independente de frameworks.

O springframework contém infraestrutura, que depende do Spring, como controllers, adapters, configurações e implementações técnicas.

Essa separação segue o padrão Clean Architecture, deixando o domínio isolado e manutenível.

# Domain
Explicação do package domain

## entity

Contém as entidades centrais da regra de negócio, livres de dependências externas.

## exception

Define exceções específicas do domínio para representar erros de negócio.

## repository

Define interfaces/regras de persistência sem depender da implementação real.

## service

Implementa a lógica de negócio pura, usando apenas interfaces do domínio.

# springframework
Explicação do package springframework

## configuration/service

Cria beans pra os services.

## controller

Recebe as requisições da API.

## controller/adapter

Realiza a conversão entre modelos da API e modelos do domínio.

## controller/advice

Centraliza o tratamento global de erros da aplicação.

## controller/dto

Define os objetos de entrada e saída usados na API.

## repository

Contém detalhes técnicos das implementações de persistência.

## repository/client

Integração com Mongo.

## repository/orm

Mapeamentos ORM/JPA usados para persistência real no banco.

## PessoaRepositoryAdapter

Implementa a interface do domínio adaptando para o Spring Data.

## PessoaRepositoryImpl

Implementação concreta da persistência usando PessoaRepository
