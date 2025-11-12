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
- Banco de dados (PostgreSQL, MySQL ou outro de sua escolha)  
- Graylog  
- Docker e Docker Compose

---

## Como executar

1. Clonar o repositório:
   ```bash
   git clone https://github.com/seu-usuario/pessoa-api.git
   cd pessoa-api
