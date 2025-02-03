package Livraria;

import java.util.Date;

public class Emprestimo {
    private Livro livro; // O livro agora é um atributo do tipo Livro
    private String nomeCliente;
    private Date dataEmprestimo;

    // Construtor modificado
    public Emprestimo(Livro livro, String nomeCliente, Date dataEmprestimo) {
        this.livro = livro;
        this.nomeCliente = nomeCliente;
        this.dataEmprestimo = dataEmprestimo;
    }

    // Métodos getters
    public Livro getLivro() {
        return livro;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    // Método toString modificado
    @Override
    public String toString() {
        return "Emprestimo{Livro=" + livro.getTitulo() + ", cliente='" + nomeCliente + "', dataEmprestimo=" + dataEmprestimo + "}";
    }
}
