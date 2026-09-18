// ETAPA 2 - Membros de uma Classe (aula de 28/08)
// Construtor faz o objeto nascer completo. Metodo executa a acao.

public class Aluno {

    String nome;
    double mensalidade;

    public Aluno(String nome, double mensalidade) {
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    public String exibir() {
        return nome + " | R$ " + mensalidade;
    }

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Ana Beatriz", 310.00);
        System.out.println(a1.exibir());
    }
}
