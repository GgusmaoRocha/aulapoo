#!/bin/bash
# Monta a estrutura da Aula 06 - Encapsulamento
# Uso:  bash setup-aula.sh

set -e
echo "Criando as pastas da aula..."

mkdir -p 01-classes-objetos 02-membros-classe 03-linguagem-java 04-encapsulamento

cat > 01-classes-objetos/Aluno.java << 'JAVAEOF'
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
JAVAEOF

cat > 02-membros-classe/Aluno.java << 'JAVAEOF'
// ETAPA 2 - Membros de uma Classe (aula de 28/08)
// Construtor faz o objeto nascer completo. Metodo executa a acao.

public class Aluno {

    String nome;
    double mensalidade;

    public Aluno(String nome, double mensalidade) {
        this.nome = nome;
        this.mensalidade = mensalidade;
    }

    public String exibir() {
        return nome + " | R$ " + mensalidade;
    }

    public static void main(String[] args) {
        Aluno a1 = new Aluno("Ana Beatriz", 310.00);
        System.out.println(a1.exibir());
    }
}
JAVAEOF

cat > 03-linguagem-java/Aluno.java << 'JAVAEOF'
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
JAVAEOF

cat > 04-encapsulamento/Aluno.java << 'JAVAEOF'
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
JAVAEOF

cat > 04-encapsulamento/Teste.java << 'JAVAEOF'
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
JAVAEOF

echo ""
echo "Pronto. Estrutura criada:"
echo ""
ls -R 01-classes-objetos 02-membros-classe 03-linguagem-java 04-encapsulamento
echo ""
echo "Para rodar cada etapa:"
echo "  cd 01-classes-objetos && javac Aluno.java && java Aluno"
echo "  cd 02-membros-classe  && javac Aluno.java && java Aluno"
echo "  cd 03-linguagem-java  && javac Aluno.java && java Aluno"
echo "  cd 04-encapsulamento  && javac Aluno.java Teste.java && java Teste"
