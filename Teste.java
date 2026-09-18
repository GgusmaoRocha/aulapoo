// =====================================================================
// CLASSE: Teste
// ---------------------------------------------------------------------
// Esta classe USA a classe Aluno. Ela está "do lado de fora" da Aluno,
// por isso só enxerga o que é "public" (construtor, getters, setters
// e exibir). É ela que PROVA que o encapsulamento funciona.
// =====================================================================
public class Teste {

    // =================================================================
    // MÉTODO main
    // -----------------------------------------------------------------
    // É o PONTO DE PARTIDA do programa: quando rodamos "java Teste",
    // o Java procura e executa este método.
    //
    // "static" -> pertence à classe, não a um objeto; por isso o Java
    //             consegue chamá-lo sem criar um "new Teste()".
    // "String[] args" -> argumentos que podem vir da linha de comando.
    // =================================================================
    public static void main(String[] args) {

        // -------------------------------------------------------------
        // CRIANDO UM OBJETO (instanciação)
        // "Aluno x"  -> declara uma variável do tipo Aluno
        // "new Aluno(...)" -> cria o objeto e chama o CONSTRUTOR
        // -------------------------------------------------------------
        Aluno x = new Aluno("Ana Beatriz", 310.00);
        System.out.println(x.exibir());      // R$ 310.00

        // -------------------------------------------------------------
        // TENTATIVA INVÁLIDA pelo SETTER
        // O setter valida o valor e RECUSA o -50.00.
        // O objeto continua com R$ 310.00 -> foi protegido.
        // -------------------------------------------------------------
        x.setMensalidade(-50.00);
        System.out.println(x.exibir());      // continua R$ 310.00

        // -------------------------------------------------------------
        // ALTERAÇÃO VÁLIDA pelo SETTER
        // Valor positivo -> passa na validação e é alterado.
        // -------------------------------------------------------------
        x.setMensalidade(330.00);
        System.out.println(x.exibir());      // agora R$ 330.00

        // -------------------------------------------------------------
        // TESTE DECISIVO DO ENCAPSULAMENTO
        // Tire o "//" da linha abaixo e compile de novo:
        //
        // x.mensalidade = -50.00;
        //
        // Resultado: "error: mensalidade has private access in Aluno"
        // É um erro de COMPILAÇÃO: como o atributo é "private",
        // não existe como burlar o setter.
        // -------------------------------------------------------------
    }
}
