# LiterAlura 📚

Projeto desenvolvido como desafio de programação para construção de um **Catálogo de Livros** em Java.

## Autor
**Amanda A. da Silva**

---

## Descrição
O LiterAlura é uma aplicação em **Java** que permite buscar livros através da API [Gutendex](https://gutendex.com/), salvar os resultados em um banco de dados **SQLite** e interagir via console para explorar os dados.

---

## Funcionalidades
- 🔍 **Buscar livro por título** (consulta na API e salva no banco)
- 📖 **Listar todos os livros cadastrados**
- ✍️ **Listar todos os autores**
- 🌍 **Filtrar livros por idioma**
- 🚪 **Sair da aplicação**

---

## Tecnologias Utilizadas
- Java 17+
- Maven
- SQLite (JDBC)
- Gson (para tratamento de JSON)

---

## Como Executar
1. Clone ou extraia este repositório.
2. Compile o projeto com Maven:
   ```bash
   mvn compile
   ```
3. Execute a aplicação:
   ```bash
   mvn exec:java -Dexec.mainClass="com.literalura.Main"
   ```

---

## Estrutura do Projeto
```
LiterAlura/
├── pom.xml
└── src
    └── main
        └── java
            └── com
                └── literalura
                    ├── Main.java
                    └── Catalogo.java
```

---

## Banco de Dados
- O banco **literalura.db** é criado automaticamente na raiz do projeto.
- Tabela `livros` contém os campos:
  - `id` (chave primária)
  - `titulo`
  - `autor`
  - `idioma`

---

## Exemplo de Uso
```
=== LiterAlura ===
1 - Buscar livro por título
2 - Listar todos os livros
3 - Listar todos os autores
4 - Listar livros por idioma
5 - Sair
Escolha uma opção: 1
Digite o título: Dom Casmurro
Livro encontrado e salvo: Dom Casmurro - Machado de Assis
```

---

✨ Projeto desenvolvido por **Amanda A. da Silva**
