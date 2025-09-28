# 📚 LITER ALURA

[![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)](https://www.oracle.com/java/)  
[![Maven](https://img.shields.io/badge/Maven-3.9.6-C71A36?logo=apachemaven&logoColor=white)](https://maven.apache.org/)  
[![SQLite](https://img.shields.io/badge/SQLite-3-003B57?logo=sqlite&logoColor=white)](https://www.sqlite.org/index.html)  
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen)  
![License](https://img.shields.io/badge/License-MIT-blue)  
![Contribuições](https://img.shields.io/badge/Contribuições-Bem--vindas-orange)  

Projeto desenvolvido como desafio de programação para construção de um Catálogo de Livros em Java, consumindo a API Gutendex.

### 📝 Descrição

* O LiterAlura é uma aplicação em Java que permite:
* Buscar livros pela API Gutendex
* Salvar resultados em um banco SQLite
* Interagir via console para explorar os dados

### ⚙️ Funcionalidades

* 🔍 Buscar livro por título → consulta a API e salva no banco
* 📖 Listar todos os livros cadastrados
* ✍️ Listar todos os autores
* 🌍 Filtrar livros por idioma
* 🚪 Sair da aplicação

### 🚀 Tecnologias Utilizadas

* Java 17+
* Maven
* SQLite (JDBC)
* Gson (para tratamento de JSON)

### ▶️ Como Executar

1. Clone este repositório:

   git clone https://github.com/SEU_USUARIO/literalura.git

2. Compile o projeto com Maven:

    mvn compile

3. Execute a aplicação:

    mvn exec:java -Dexec.mainClass="com.literalura.Main"

### 📂 Estrutura do Projeto

- LiterAlura/
-  ├── pom.xml
-  └── src/
    -  └── main/
        -  └── java/
             -  └── com/
                -  └── literalura/
                    -  ├── Main.java
                     - └── Catalogo.java

### 🗄️ Banco de Dados

📌 O arquivo literalura.db é criado automaticamente na raiz do projeto.

Tabela livros contém os campos:

* id (chave primária)
* titulo
* autor
* idioma

### 💻 Exemplo de Uso 

=== LiterAlura ===
- 1 - Buscar livro por título
- 2 - Listar todos os livros
- 3 - Listar todos os autores
- 4 - Listar livros por idioma
- 5 - Sair

Escolha uma opção: 1
Digite o título: Dom Casmurro

Livro encontrado e salvo: Dom Casmurro - Machado de Assis

---
## 📜 Licença

Este projeto está sob a licença MIT.
Você pode usá-lo, modificá-lo e distribuí-lo livremente.

---

✨ Créditos

Projeto desenvolvido por Amanda A. da Silva
