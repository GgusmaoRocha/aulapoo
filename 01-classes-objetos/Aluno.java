// ETAPA 1 - Classes e Objetos (aula de 21/08)
// A classe e o molde. O objeto e o que existe na memoria, criado com new.

public class Aluno {

    String nome;

    public static void main(String[] args) {

        Aluno a1 = new Aluno();
        a1.nome = "Ana Beatriz";

        Aluno a2 = new Aluno();
        a2.nome = "Carlos Henrique";

        System.out.println("Aluno: " + a1.nome);
        System.out.println("Aluno: " + a2.nome);
    }
}
