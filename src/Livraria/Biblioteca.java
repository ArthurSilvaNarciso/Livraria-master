package Livraria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca() {
        // Inicialização dos atributos
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivrosDisponiveis() {
        System.out.println("Livros Disponíveis:");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
            }
        }
    }

    public void emprestarLivro(int idLivro, String nomeCliente) {
        for (Livro livro : livros) {
            if (livro.getId() == idLivro && livro.isDisponivel()) {
                livro.emprestar();
                emprestimos.add(new Emprestimo(livro, nomeCliente, new Date()));
                System.out.println("Empréstimo realizado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não disponível para empréstimo.");
    }

    public void exibirEmprestimos() {
        System.out.println("Histórico de empréstimos:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Deseja ver os livros disponíveis? (sim/não)");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                listarLivrosDisponiveis();
                System.out.println("Escolha o ID do livro que deseja pegar:");
                int idLivro = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Informe seu nome:");
                String nomeCliente = scanner.nextLine();
                emprestarLivro(idLivro, nomeCliente);
            } else {
                System.out.println("Sistema encerrado");
                break;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {

        Autor autor1 = new Autor(1, "J.K. Rowling", new Date());
        Autor autor2 = new Autor(2, "George R.R. Martin", new Date());
        Autor autor3 = new Autor(3, "J.R.R. Tolkien", new Date());
        Autor autor4 = new Autor(4, "Isaac Asimov", new Date());
        Autor autor5 = new Autor(5, "Agatha Christie", new Date());


        Livro livro1 = new Livro(1, "ID 1 : Harry Potter e a Pedra Filosofal", autor1, new Date(), new Date(System.currentTimeMillis() + 86400000L), "Fantasia");
        Livro livro2 = new Livro(2, "ID 2 : Game of Thrones", autor2, new Date(), new Date(System.currentTimeMillis() + 86400000L), "Fantasia");
        Livro livro3 = new Livro(3, "ID 3 : O Senhor dos Anéis", autor3, new Date(), new Date(System.currentTimeMillis() + 86400000L), "Fantasia");
        Livro livro4 = new Livro(4, "ID 4 : Fundação", autor4, new Date(), new Date(System.currentTimeMillis() + 86400000L), "Ficção Científica");
        Livro livro5 = new Livro(5, "ID 5 : Assassinatol no Expresso do Oriente", autor5, new Date(), new Date(System.currentTimeMillis() + 86400000L), "Mistério");


        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(livro3);
        biblioteca.adicionarLivro(livro4);
        biblioteca.adicionarLivro(livro5);


        biblioteca.iniciar();
    }
}