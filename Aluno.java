// =====================================================================
// CLASSE: Aluno
// ---------------------------------------------------------------------
// Uma CLASSE é o "molde" (a planta) que descreve como os objetos serão.
// Ela define:
//   - ATRIBUTOS  -> o que o objeto TEM (dados/características)
//   - MÉTODOS    -> o que o objeto FAZ (comportamentos/ações)
//
// A partir desta classe podemos criar vários OBJETOS (instâncias),
// por exemplo: new Aluno("Ana Beatriz", 310.00).
//
// "public" = a classe pode ser usada por qualquer outra classe
//            (como a classe Teste).
// =====================================================================
public class Aluno {

    // =================================================================
    // ATRIBUTOS (também chamados de campos ou variáveis de instância)
    // -----------------------------------------------------------------
    // ENCAPSULAMENTO: os atributos são "private".
    // "private" significa que SÓ o código dentro da classe Aluno pode
    // ler ou alterar esses valores diretamente.
    //
    // Fora daqui (ex.: na classe Teste), escrever
    //     x.mensalidade = -50.00;
    // gera ERRO DE COMPILAÇÃO. Quem está fora é obrigado a passar
    // pelos métodos públicos (getters e setters), que controlam o acesso.
    // =================================================================
    private String nome;          // nome do aluno
    private double mensalidade;   // valor da mensalidade em reais

    // =================================================================
    // CONSTRUTOR
    // -----------------------------------------------------------------
    // Método especial chamado automaticamente quando usamos "new".
    // Tem o MESMO nome da classe e NÃO tem tipo de retorno.
    // Serve para dar os valores iniciais ao objeto.
    //
    // "this" se refere ao próprio objeto que está sendo criado.
    // "this.nome = nome" -> o atributo recebe o valor do parâmetro.
    // =================================================================
    public Aluno(String nome, double mensalidade) {
        this.nome = nome;

        // ENCAPSULAMENTO: em vez de atribuir direto
        // (this.mensalidade = mensalidade), usamos o setter.
        // Assim, a validação vale TAMBÉM na criação do objeto.
        setMensalidade(mensalidade);
    }

    // =================================================================
    // MÉTODO GETTER: getNome()
    // -----------------------------------------------------------------
    // "get" = obter. Permite LER o valor do atributo privado "nome"
    // sem dar acesso direto a ele.
    // "public" -> pode ser chamado de fora da classe.
    // "String" -> tipo do valor que o método devolve (retorno).
    //
    // Repare: NÃO existe setNome(). Então, depois de criado,
    // o nome não pode ser alterado por fora. Isso também é
    // encapsulamento: a classe decide o que pode ou não mudar.
    // =================================================================
    public String getNome() {
        return nome;
    }

    // =================================================================
    // MÉTODO GETTER: getMensalidade()
    // -----------------------------------------------------------------
    // Permite LER o valor da mensalidade.
    // "double" -> o método devolve um número com casas decimais.
    // =================================================================
    public double getMensalidade() {
        return mensalidade;
    }

    // =================================================================
    // MÉTODO SETTER: setMensalidade()
    // -----------------------------------------------------------------
    // "set" = definir. Permite ALTERAR o atributo privado "mensalidade",
    // mas COM REGRAS (validação). Este é o coração do encapsulamento:
    // o objeto se protege de valores inválidos.
    //
    // "void" -> o método não devolve nenhum valor.
    // "double valor" -> PARÂMETRO: o valor que quem chama envia.
    // =================================================================
    public void setMensalidade(double valor) {

        // VALIDAÇÃO: mensalidade zero ou negativa não faz sentido.
        if (valor <= 0) {
            System.out.println("  ERRO: valor invalido. Nada foi alterado.");
            return; // sai do método SEM alterar o atributo
        }

        // Só chega aqui se o valor for válido.
        this.mensalidade = valor;
    }

    // =================================================================
    // MÉTODO: exibir()
    // -----------------------------------------------------------------
    // Método comum (comportamento do objeto).
    // Monta e devolve um texto com os dados do aluno.
    //
    // String.format -> formata o texto:
    //   %s   = lugar de um texto (o nome)
    //   %.2f = lugar de um número com 2 casas decimais (a mensalidade)
    // =================================================================
    public String exibir() {
        return String.format("%s | mensalidade: R$ %.2f", nome, mensalidade);
    }
}
