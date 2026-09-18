// ETAPA 3 - A Linguagem Java (aula de 04/09)
// String.format controla como o numero aparece. %.2f forca duas casas.
// ATENCAO: repare na ultima linha da saida. O objeto aceitou um valor NEGATIVO.

public class Aluno { // classe: o molde do objeto

    String nome;        // atributo aberto (sem private)
    double mensalidade; // atributo aberto: aceita qualquer valor

    public Aluno(String nome, double mensalidade) { // construtor: roda no "new"
        this.nome = nome;
        this.mensalidade = mensalidade; // grava direto, sem validar
    }

    public String exibir() { // método: devolve os dados em texto
        return String.format("%s | mensalidade: R$ %.2f", nome, mensalidade); // %.2f = 2 casas
    }

    public static void main(String[] args) { // método main: início do programa
        Aluno a1 = new Aluno("Ana Beatriz", 310.00); // valor válido
        System.out.println(a1.exibir());

        Aluno a2 = new Aluno("Teste", -50.00); // valor negativo: foi aceito!
        System.out.println(a2.exibir());
    }
}
