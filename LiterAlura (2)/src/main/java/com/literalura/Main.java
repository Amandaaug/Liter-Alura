package com.literalura;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        int opcao;
        do {
            System.out.println("\n=== LiterAlura ===");
            System.out.println("1 - Buscar livro por título");
            System.out.println("2 - Listar todos os livros");
            System.out.println("3 - Listar todos os autores");
            System.out.println("4 - Listar livros por idioma");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o título: ");
                    String titulo = sc.nextLine();
                    catalogo.buscarLivro(titulo);
                }
                case 2 -> catalogo.listarLivros();
                case 3 -> catalogo.listarAutores();
                case 4 -> {
                    System.out.print("Digite o idioma (en, pt, es...): ");
                    String idioma = sc.nextLine();
                    catalogo.listarPorIdioma(idioma);
                }
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }
}