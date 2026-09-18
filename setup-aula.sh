#!/bin/bash
# Monta a estrutura da Aula 06 - Encapsulamento
# Uso:  bash setup-aula.sh

set -e
echo "Criando as pastas da aula..."

mkdir -p 01-classes-objetos 02-membros-classe 03-linguagem-java 04-encapsulamento

cat > 01-classes-objetos/Aluno.java << 'JAVAEOF'
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
JAVAEOF

cat > 02-membros-classe/Aluno.java << 'JAVAEOF'
// ETAPA 2 - Membros de uma Classe (aula de 28/08)
// Construtor faz o objeto nascer completo. Metodo executa a acao.

public class Aluno { // classe: o molde do objeto

    String nome;        // atributo: o que o objeto tem
    double mensalidade; // atributo: ainda aberto (sem private)

    public Aluno(String nome, double mensalidade) { // construtor: roda no "new"
        this.nome = nome;
        this.mensalidade = mensalidade; // grava direto, sem validar
    }

    public String exibir() { // método: devolve os dados em texto
        return nome + " | R$ " + mensalidade;
    }

    public static void main(String[] args) { // método main: início do programa
        Aluno a1 = new Aluno("Ana Beatriz", 310.00); // cria o objeto completo
        System.out.println(a1.exibir()); // imprime na tela
    }
}
JAVAEOF

cat > 03-linguagem-java/Aluno.java << 'JAVAEOF'
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
JAVAEOF

cat > 04-encapsulamento/Aluno.java << 'JAVAEOF'
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
JAVAEOF

cat > 04-encapsulamento/Teste.java << 'JAVAEOF'
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
