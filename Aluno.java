public class Aluno {

    private String nome;
    private double mensalidade;

    public Aluno(String nome, double mensalidade) {
        this.nome = nome;
        setMensalidade(mensalidade);
    }

    public String getNome() {
        return nome;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double valor) {
        if (valor <= 0) {
            System.out.println("  ERRO: valor invalido. Nada foi alterado.");
            return;
        }
        this.mensalidade = valor;
    }

    public String exibir() {
        return String.format("%s | mensalidade: R$ %.2f", nome, mensalidade);
    }
}