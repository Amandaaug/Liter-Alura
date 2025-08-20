package com.literalura;

import com.google.gson.*;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;

public class Catalogo {
    private final String DB_URL = "jdbc:sqlite:literalura.db";

    public Catalogo() {
        criarTabela();
    }

    private void criarTabela() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS livros (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "titulo TEXT, autor TEXT, idioma TEXT)";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    public void buscarLivro(String titulo) {
        try {
            String url = "https://gutendex.com/books/?search=" + URLEncoder.encode(titulo, "UTF-8");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) response.append(line);
            in.close();

            JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonArray results = json.getAsJsonArray("results");
            if (results.size() > 0) {
                JsonObject livro = results.get(0).getAsJsonObject();
                String tituloLivro = livro.get("title").getAsString();
                String idioma = livro.getAsJsonArray("languages").get(0).getAsString();
                String autor = livro.getAsJsonArray("authors").size() > 0 ?
                        livro.getAsJsonArray("authors").get(0).getAsJsonObject().get("name").getAsString() : "Desconhecido";

                salvarLivro(tituloLivro, autor, idioma);
                System.out.println("Livro encontrado e salvo: " + tituloLivro + " - " + autor);
            } else {
                System.out.println("Nenhum livro encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void salvarLivro(String titulo, String autor, String idioma) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO livros (titulo, autor, idioma) VALUES (?, ?, ?)")) {
            stmt.setString(1, titulo);
            stmt.setString(2, autor);
            stmt.setString(3, idioma);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar livro: " + e.getMessage());
        }
    }

    public void listarLivros() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM livros")) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("titulo") + " (" + rs.getString("idioma") + ") - " + rs.getString("autor"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar livros: " + e.getMessage());
        }
    }

    public void listarAutores() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT DISTINCT autor FROM livros")) {
            while (rs.next()) {
                System.out.println(rs.getString("autor"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar autores: " + e.getMessage());
        }
    }

    public void listarPorIdioma(String idioma) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM livros WHERE idioma = ?")) {
            stmt.setString(1, idioma);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("titulo") + " - " + rs.getString("autor"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar por idioma: " + e.getMessage());
        }
    }
}