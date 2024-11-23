
# API: Sistema de Clínica Odontológica

  Este é um projeto de API desenvolvido em Java usando o framework Spring Boot. 
A API gerencia um sistema de Clínica Odontológica, com os campos: paciente, dentista, pagamento, consulta e tratamento.

## Requisitos

- Java 17 ou superior
- Maven (para gerenciamento de dependências)
- PostgreSQL 13.x ou superior (banco de dados)
- IDE para desenvolvimento (opcional, ex IntelliJ IDEA)
- Swagger para documentação da API (opcional)

## Instalação
- Clone o repositório:
   ```bash
   git clone <https://github.com/luanae/ClinicaOdontologica>
   cd ClinicaOdontologica
   ```

## Configuração do Banco de Dados

- Inicie o PostgreSQL e crie o banco de dados:
   ```sql
   CREATE DATABASE ClinicaOdontologica;
   ```
- Configure o banco no arquivo: src/main/resources/application.properties
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/ClinicaOdontologica
   spring.datasource.username=seuUser
   spring.datasource.password=suaSenha
   ```

## Execução

Para rodar o projeto, execute o seguinte comando no terminal:

```bash
mvn spring-boot:run
```

Ou clique no Run na parte superior da tela.

---

## Testes no Postman

- Importe a documentação da API no Postman usando a URL do OpenAPI (Swagger):
   ```
   http://localhost:8080/api-docs.json
   ```

- Configure a variável `{{base_url}}` como `http://localhost:8080` para facilitar o uso dos endpoints.

- Execute as requisições seguindo a ordem definida acima para evitar erros de relacionamento.

---

## Principais Endpoints

**Consulta:**
- GET /consulta: Retorna a lista de consultas agendadas.
- POST /consulta: Agenda uma nova consulta (associando Dentista e - Paciente).
- PUT /consulta/{id}: Atualiza detalhes da consulta (ex.: status).
- DELETE /consulta/{id}: Cancela uma consulta.

**Dentista:**
- GET /dentista: Retorna a lista de todos os dentistas.
- POST /dentista: Registra um novo dentista.
- PUT /dentista/{id}: Atualiza as informações de um dentista.
- DELETE /dentista/{id}: Exclui um dentista do sistema.

**Paciente:**
- GET /paciente: Retorna a lista de todos os pacientes.
- POST /paciente: Registra um novo paciente.
- PUT /paciente/{id}: Atualiza as informações de um paciente.
- DELETE /paciente/{id}: Exclui um paciente do sistema.

**Tratamento:**
- GET /tratamento: Retorna os tratamentos disponíveis.
- POST /tratamento: Registra um novo tratamento.
- PUT /tratamento/{id}: Atualiza as informações de um tratamento.
- DELETE /tratamento/{id}: Exclui um tratamento.

**Pagamento:**
- GET /pagamento: Retorna a lista de pagamentos realizados.
- POST /pagamento: Registra um pagamento para uma consulta.
- PUT /pagamento/{id}: Atualiza o status de pagamento.
- DELETE /pagamento/{id}: Exclui um pagamento.

---

## Documentação

A API estará disponível em http://localhost:8080, e a
documentação (Swagger) pode ser acessada em http://localhost:8080/swagger-ui/index.html

---
