// ETAPA 3 - A Linguagem Java (aula de 04/09)
// String.format controla como o numero aparece. %.2f forca duas casas.
// ATENCAO: repare na ultima linha da saida. O objeto aceitou um valor NEGATIVO.

public class Aluno {

    String nome;
    double mensalidade;

    public Aluno(String nome, double mensalidade) {
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    public String exibir() {
        return String.format("%s | mensalidade: R$ %.2f", nome, mensalidade);
    }

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Ana Beatriz", 310.00);
        System.out.println(a1.exibir());

        Aluno a2 = new Aluno("Teste", -50.00);
        System.out.println(a2.exibir());
    }
}
