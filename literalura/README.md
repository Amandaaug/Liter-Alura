# 📖 LiterAlura - Configuração do Ambiente (Fase 1)

Nesta primeira fase, vamos configurar o ambiente de desenvolvimento Java para iniciar o desafio de construção do **LiterAlura**.
Aqui estão as ferramentas necessárias, versões recomendadas e os passos para criar o projeto inicial.

## 🔧 Requisitos de Ambiente
- **Java JDK 17+**
- **Maven 4+**
- **Spring Boot 3.2.3**
- **PostgreSQL 16+**
- **IntelliJ IDEA (opcional)**

## ⚙️ Configuração do Projeto com Spring Initializr
- Project: **Maven**
- Language: **Java**
- Spring Boot: **3.2.3**
- Packaging: **JAR**
- Java: **17**
- Group: `br.com.literalura`
- Artifact: `literalura`
- Dependencies:
  - Spring Data JPA
  - PostgreSQL Driver

## ▶️ Como rodar o projeto
1. Configure seu banco de dados PostgreSQL e crie a base:
   ```sql
   CREATE DATABASE literalura;
   ```
2. Ajuste as credenciais no arquivo `application.properties`.
3. Rode o projeto:
   ```bash
   mvn spring-boot:run
   ```

## 👨‍💻 Autor
Projeto desenvolvido por **Amanda. A da Silva** para estudos de **Spring Boot + PostgreSQL**.
