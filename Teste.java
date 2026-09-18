public class Teste { // classe que usa a Aluno

    public static void main(String[] args) { // método main: início do programa

        Aluno x = new Aluno("Ana Beatriz", 310.00); // cria o objeto
        System.out.println(x.exibir());

        x.setMensalidade(-50.00); // inválido: o setter recusa
        System.out.println(x.exibir());

        x.setMensalidade(330.00); // válido: o setter altera
        System.out.println(x.exibir());
    }
}
