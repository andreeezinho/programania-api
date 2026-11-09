# Programania API

A Programania API é o Backend de uma plataforma de incentivo à introdução à programação para crianças.
A aplicação é responsável por disponibilizar os serviços e recursos necessários para o funcionamento da plataforma,
incluindo autenticação, gerenciamento de usuários, fases e desafios de aprendizagem.

## Funcionalidades

- Autenticação de usuários.
- Login com e-mail e senha.
- Autenticação com Google (OAuth2).
- Gerenciamento de usuários.
- Cadastro e gerenciamento de fases.
- Vinculação de usuários às fases.
- Gerenciamento de desafios de programação.
- Controle de acesso e proteção de recursos.
- Comunicação com banco de dados MySQL.
- Transferência de dados por meio de DTOs.

## Tecnologias

- Java 21
- Spring Boot 4.1.0
- Spring Data JPA
- Spring Security
- Spring Web MVC
- Spring OAuth2 Client
- Java JWT
- Hibernate
- MySQL 8
- Lombok
- Maven

## Pré-requisitos

- Java JDK 21 instalado.
- MySQL Server instalado e configurado.
- Git instalado.
- IDE de desenvolvimento Java (IntelliJ IDEA, Eclipse ou VS Code).
- Maven (opcional, pois o projeto possui Maven Wrapper).

## Instalação

Clone o repositório e entre na pasta do projeto:

```bash
git clone https://github.com/andreeezinho/programania-api.git
cd programania-api
```

Configure as variáveis de ambiente necessárias para a aplicação.

Crie um arquivo `.env` na raiz do projeto ou configure as variáveis diretamente no ambiente de execução da IDE:

```env
DB_HOST=localhost
DB_PORT=3306
DB_DATABASE=nome_do_banco
DB_USER=seu_usuario
DB_PASSWORD=sua_senha

JTW_SECRET=sua_chave_secreta
APP_URL=http://localhost:8080

GOOGLE_CLIENT_ID=seu_client_id
GOOGLE_CLIENT_SECRET=seu_client_secret
```

Substitua os valores de exemplo pelas configurações do seu ambiente.

**Importante:** não compartilhe suas credenciais nem envie o arquivo `.env` para o repositório.

## Banco de dados

A aplicação utiliza MySQL para persistência dos dados e Spring Data JPA para comunicação com o banco.

O Hibernate está configurado com a propriedade `spring.jpa.hibernate.ddl-auto=validate`, responsável por validar se a
estrutura do banco corresponde às entidades mapeadas pela aplicação.

Portanto, o banco de dados e suas tabelas precisam estar previamente preparados e compatíveis com o modelo da aplicação.

O modelo entidade-relacionamento do projeto está disponível no arquivo `MER.mwb`.

## Executando em desenvolvimento

Com o MySQL configurado e as variáveis de ambiente disponíveis, inicie a aplicação utilizando o Maven Wrapper.

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

Por padrão, a API fica disponível em:

```text
http://localhost:8080
```

A porta também pode ser definida pela variável de ambiente `PORT`.

## Comandos disponíveis

| Comando | Descrição |
|---|---|
| `.\mvnw.cmd spring-boot:run` | Inicia a aplicação em desenvolvimento. |
| `.\mvnw.cmd clean` | Remove os arquivos gerados em compilações anteriores. |
| `.\mvnw.cmd compile` | Compila o projeto. |
| `.\mvnw.cmd test` | Executa os testes automatizados. |
| `.\mvnw.cmd package` | Gera o pacote da aplicação. |
| `.\mvnw.cmd clean package` | Limpa e gera um novo pacote. |

## Estrutura principal

O Backend utiliza uma arquitetura organizada em camadas, separando as responsabilidades de cada parte da aplicação.

```text
src/
└── main/
    ├── java/
    │   └── com/programania/api/
    │       ├── Config/        # Configurações gerais
    │       ├── Controllers/   # Rotas e requisições HTTP
    │       ├── DTO/           # Objetos de transferência de dados
    │       ├── Models/        # Entidades do banco de dados
    │       ├── Repositories/  # Acesso aos dados com JPA
    │       └── Services/      # Regras de negócio
    │
    └── resources/
        └── application.properties

.env
.env.example
mvnw
mvnw.cmd
pom.xml
```

### Organização das camadas

- **Config:** configurações gerais da aplicação, como CORS, rotas e autenticação.
- **Controllers:** definem os endpoints e recebem as requisições HTTP.
- **DTO:** formatam os dados transferidos entre as camadas e as respostas da API.
- **Models:** representam as entidades e os relacionamentos do banco de dados.
- **Repositories:** realizam a comunicação entre a aplicação e o banco de dados por meio do Spring Data JPA.
- **Services:** concentram as regras de negócio e coordenam as operações da aplicação.

## Arquitetura da aplicação

O fluxo de processamento das requisições segue a organização em camadas:

```text
Cliente (Frontend)
        |
        v
   Controller
        |
        v
     Service
        |
        v
    Repository
        |
        v
    Model / JPA
        |
        v
  Banco de Dados
```

Os DTOs são utilizados para organizar os dados recebidos e enviados pela API, evitando a exposição direta das entidades
quando não necessário.

## Autenticação e segurança

A aplicação utiliza Spring Security para gerenciamento de segurança e controle de acesso.

A autenticação contempla:

- Autenticação por credenciais.
- Integração com Google por meio de OAuth2 Client.
- Utilização de JSON Web Tokens (JWT).
- Proteção dos recursos da API.

As credenciais e configurações necessárias para os provedores de autenticação devem ser disponibilizadas por variáveis
de ambiente.

## Build de produção

Para gerar o pacote da aplicação:

```bash
./mvnw clean package
```

No Windows:

```powershell
.\mvnw.cmd clean package
```

O arquivo gerado ficará no diretório:

```text
target/
```

## Observações

- A aplicação utiliza a porta `8080` por padrão.
- O funcionamento depende de uma instância MySQL configurada e acessível.
- As variáveis de ambiente devem estar configuradas antes da inicialização.
- O projeto utiliza Maven Wrapper para facilitar a execução sem exigir uma instalação independente do Maven.
- O funcionamento completo da plataforma depende da integração entre o Backend e o Frontend.
- O modelo entidade-relacionamento está disponível no arquivo `MER.mwb`.
