// ETAPA 1 - Classes e Objetos (aula de 21/08)
// A classe e o molde. O objeto e o que existe na memoria, criado com new.

public class Aluno { // classe: o molde do objeto

    String nome; // atributo aberto (sem private): qualquer um altera

    public static void main(String[] args) { // método main: início do programa

        Aluno a1 = new Aluno(); // cria o primeiro objeto
        a1.nome = "Ana Beatriz"; // preenche o atributo de fora

        Aluno a2 = new Aluno(); // cria o segundo objeto
        a2.nome = "Carlos Henrique";

        System.out.println("Aluno: " + a1.nome); // imprime na tela
        System.out.println("Aluno: " + a2.nome);
    }
}
