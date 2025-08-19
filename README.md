# LiterAlura - Catálogo de Livros

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=CONCLUÍDO&color=GREEN&style=for-the-badge)

## 📖 Descrição do Projeto
LiterAlura é um catálogo de livros interativo que funciona via console. Este projeto foi desenvolvido como parte do desafio de programação da Alura, com o objetivo de praticar o consumo de APIs, manipulação de dados JSON e persistência de dados em um banco de dados relacional. A aplicação busca livros na API Gutendex, armazena as informações em um banco de dados PostgreSQL e permite que o usuário interaja com os dados através de um menu de opções.

---

### ✅ Funcionalidades

O programa oferece as seguintes opções no menu:

- **1. Buscar livro pelo título:** Realiza uma consulta na API Gutendex pelo título do livro, salva o livro e seu autor no banco de dados.
- **2. Listar livros registrados:** Exibe todos os livros que já foram salvos no banco de dados.
- **3. Listar autores registrados:** Mostra todos os autores salvos no banco de dados.
- **4. Listar autores vivos em um determinado ano:** Permite ao usuário inserir um ano e exibe os autores que estavam vivos naquele período.
- **5. Listar livros em um determinado idioma:** Exibe uma lista de livros filtrados por um idioma específico (ex: "en" para inglês, "pt" para português).
- **0. Sair:** Encerra a aplicação.

---

### 🛠️ Tecnologias Utilizadas

- **Java 17:** Linguagem principal do projeto.
- **Spring Boot 3:** Framework para criação da aplicação, gerenciamento de dependências e configuração.
- **Spring Data JPA:** Para persistência de dados e comunicação com o banco de dados.
- **PostgreSQL:** Banco de dados relacional utilizado para armazenar os livros e autores.
- **Maven:** Gerenciador de dependências do projeto.
- **API Gutendex:** API pública utilizada para a busca de dados dos livros.
- **Jackson:** Biblioteca para manipulação e conversão de dados JSON para objetos Java.

---

### 🚀 Como Executar o Projeto

Siga os passos abaixo para executar o projeto em sua máquina local.

**Pré-requisitos:**
- **Java 17** (ou superior) instalado.
- **Maven 4** (ou superior) instalado.
- **PostgreSQL 16** (ou superior) instalado e rodando.

**1. Clone o Repositório**
```bash
git clone (https://github.com/leonardoferrza/literalura-challenge.git)
```
**2. Configure o Banco de Dados**

Antes de executar, é essencial configurar a conexão com o seu banco de dados local.

-   Certifique-se de ter criado um banco de dados vazio no PostgreSQL com o nome `literalura`.
-   Abra o arquivo `src/main/resources/application.properties`.
-   Altere as seguintes linhas com as suas credenciais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=seu_usuario_postgres
spring.datasource.password=sua_senha_postgres
```
⚠️ **Importante:** Substitua `seu_usuario_postgres` e `sua_senha_postgres` pelas suas credenciais reais do PostgreSQL que você configurou durante a instalação.

**3. Execute a Aplicação**

Você pode iniciar a aplicação de duas maneiras:

**Opção A: Pela sua IDE (ex: IntelliJ, Eclipse)**
1.  Abra o projeto na sua IDE.
2.  Localize a classe principal `LiteraluraApplication.java`.
3.  Clique com o botão direito sobre o arquivo e selecione `Run 'LiteraluraApplication'`.

**Opção B: Via Terminal com Maven**
1.  Abra um terminal na pasta raiz do projeto.
2.  Execute o seguinte comando:
```bash
mvn spring-boot:run
```
## 🧑‍💻 Autor

**Leonardo Ferrza**

* LinkedIn: [leonardoferrza](https://www.linkedin.com/in/leonardoferrza)
* GitHub: [leonardoferrza](https://github.com/leonardoferrza)