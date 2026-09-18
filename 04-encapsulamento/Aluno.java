public class Aluno { // classe: o molde do objeto

    private String nome;         // atributo privado (encapsulamento)
    private double mensalidade;  // atributo privado: só a classe altera

    public Aluno(String nome, double mensalidade) { // construtor: roda no "new"
        this.nome = nome;
        setMensalidade(mensalidade); // usa o setter para já validar
    }

    public String getNome() { // getter: lê o nome (não há setter)
        return nome;
    }

    public double getMensalidade() { // getter: lê a mensalidade
        return mensalidade;
    }

    public void setMensalidade(double valor) { // setter: altera com validação
        if (valor <= 0) { // recusa valor inválido
            System.out.println("  ERRO: valor invalido. Nada foi alterado.");
            return;
        }
        this.mensalidade = valor;
    }

    public String exibir() { // método: devolve os dados em texto
        return String.format("%s | mensalidade: R$ %.2f", nome, mensalidade);
    }
}
