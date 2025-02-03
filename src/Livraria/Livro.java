package Livraria;

import java.util.Date;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private Date dataPublicacao;
    private Date dataDevolucao;
    private String categoria;

    public Livro(int id, String titulo, Autor autor, Date dataPublicacao, Date dataDevolucao, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.dataPublicacao = dataPublicacao;
        this.dataDevolucao = dataDevolucao;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }
    public String getTitulo(){
        return titulo;
    }
    public boolean isDisponivel() {
        return new Date().before(dataDevolucao);  // Verifica se o livro está disponível
    }

    public void emprestar() {
        // Marca o livro como não disponível
        this.dataDevolucao = new Date();  // Exemplo de como você pode controlar a devolução
    }

    @Override
    public String toString() {
        return "Livro: " + titulo + " | Autor: " + autor.getNome() + " | Categoria: " + categoria;
    }
}
