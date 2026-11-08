# Programania API

API do projeto Programania construída com Spring Boot 4, Spring Security, JPA e MySQL.

## Visão geral

A documentação da API é gerada automaticamente pelo Springdoc/OpenAPI e pode ser acessada via Swagger UI.

## Swagger

Depois de iniciar a aplicação, acesse:

- Swagger UI: http://localhost:8080/swagger-ui/index.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

## Requisitos

- Java 21
- Maven Wrapper (`mvnw`)
- MySQL em execução
- Docker (opcional, para subir o banco local)

## Executando o projeto

Na raiz do projeto:

```powershell
cd C:\Users\felip\IdeaProjects\programania-api
```

Subir o banco MySQL com Docker:

```powershell
docker run --name programania-db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=programania -p 3308:3306 -d mysql:8.0
```

Importar os dados iniciais da pasta `mysql-teste (2)`:

```powershell
Get-ChildItem ".\mysql-teste (2)" -Filter *.sql | Sort-Object Name | ForEach-Object {
    Get-Content $_.FullName -Raw | docker exec -i programania-db mysql -uroot -proot programania
}
```

Iniciar a API:

```powershell
.\mvnw spring-boot:run
```

## Variáveis de ambiente

O projeto lê as variáveis do arquivo `.env` ou de variáveis de ambiente.

Exemplo de configuração:

```env
DB_HOST=localhost
DB_PORT=3308
DB_DATABASE=programania
DB_USER=root
DB_PASSWORD=root
JWT_SECRET=programania-secret
REDIRECT_URI=http://localhost:8080/login/oauth2/code/google
APP_FRONTEND_URL=http://localhost:3000
GOOGLE_CLIENT_ID=
GOOGLE_CLIENT_SECRET=
PORT=8080
```

## Autenticação

A API utiliza:

- JWT para autenticação interna
- OAuth2 com Google (`spring-boot-starter-oauth2-client`)

## Endpoints documentados pelo Swagger

A documentação OpenAPI gera automaticamente os seguintes caminhos:

### Autenticação
- `GET /auth`
- `GET /auth/google`
- `GET /auth/google-link`
- `GET /auth/google/success`
- `GET /auth/google/error`

### Saúde da API
- `GET /health`

### Usuários
- `GET /users`
- `GET /users/me`
- `GET /users/{uuid}`
- `PUT /users/{uuid}`
- `DELETE /users/{uuid}/delete`
- `PUT /users/{uuid}/password`

### Fases
- `GET /phases`
- `GET /phases/{uuid}`
- `POST /phases`
- `PUT /phases/{uuid}`
- `DELETE /phases/{uuid}/delete`

### Usuários de fase
- `GET /phase-users`
- `GET /phase-users/{uuid}`
- `POST /phase-users`
- `PUT /phase-users/{uuid}`

### Desafios
- `GET /desafios`
- `GET /desafios/{uuid}`
- `GET /desafios/nome/{nome}`
- `GET /desafios/fase/{faseUuid}`
- `POST /desafios`
- `PUT /desafios/{uuid}`

### Usuários em desafio
- `GET /desafio-usuario`
- `GET /desafio-usuario/{uuid}`
- `POST /desafio-usuario`
- `PUT /desafio-usuario/{uuid}`
- `DELETE /desafio-usuario/{uuid}/delete`

### Blocos
- `GET /blocks`
- `GET /blocks/{uuid}`
- `POST /blocks`
- `PUT /blocks/{uuid}`
- `DELETE /blocks/{uuid}/delete`

### Notificações
- `GET /notifications`
- `GET /notifications/{uuid}`
- `POST /notifications`
- `PUT /notifications/{uuid}`
- `DELETE /notifications/{uuid}/delete`

## Observações

- A documentação Swagger é gerada automaticamente a partir dos controllers REST.
- A UI pode ser acessada diretamente no navegador sem necessidade de gerar arquivos adicionais.
- Para deixar a documentação mais detalhada, pode-se complementar com anotações como `@Tag`, `@Operation`, `@ApiResponse` nos controllers.

## Links úteis

- http://localhost:8080/swagger-ui/index.html
- http://localhost:8080/v3/api-docs
- https://springdoc.org/
