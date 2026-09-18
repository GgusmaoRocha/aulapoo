// ETAPA 2 - Membros de uma Classe (aula de 28/08)
// Construtor faz o objeto nascer completo. Metodo executa a acao.

public class Aluno { // classe: o molde do objeto

    String nome;        // atributo: o que o objeto tem
    double mensalidade; // atributo: ainda aberto (sem private)

    public Aluno(String nome, double mensalidade) { // construtor: roda no "new"
        this.nome = nome;
        this.mensalidade = mensalidade; // grava direto, sem validar
    }

    public String exibir() { // método: devolve os dados em texto
        return nome + " | R$ " + mensalidade;
    }

    public static void main(String[] args) { // método main: início do programa
        Aluno a1 = new Aluno("Ana Beatriz", 310.00); // cria o objeto completo
        System.out.println(a1.exibir()); // imprime na tela
    }
}
