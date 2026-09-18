public class Teste {

    public static void main(String[] args) {

        Aluno x = new Aluno("Ana Beatriz", 310.00);
        System.out.println(x.exibir());

        x.setMensalidade(-50.00);
        System.out.println(x.exibir());

        x.setMensalidade(330.00);
        System.out.println(x.exibir());
    }
}