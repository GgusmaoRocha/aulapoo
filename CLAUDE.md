# Contexto do projeto

Repositório de apoio à **Aula 06 de Programação Orientada a Objetos**, do Centro
Universitário UNDB. Turma ES04AN, 4º módulo, sexta-feira, sala 603.
Professor: Gustavo Gusmão Rocha.

O tema da aula é **encapsulamento**: atributos `private`, getters, setters e
validação. É a primeira aula da UA II, e vem depois de Classes e Objetos,
Membros de uma Classe e A Linguagem Java.

---

## Quem vai usar este repositório

Alunos do 4º módulo, **iniciantes em Java**. Muitos nunca compilaram nada pelo
terminal. As explicações precisam ser diretas, sem jargão, e sempre dizendo em
qual arquivo mexer e qual comando rodar.

---

## O caso do projeto

O PjBL da turma é o **Semeando Digital**, uma escola parceira. O sistema dela
registra a mensalidade dos alunos, e apareceu uma divergência de R$ 310,00 no
fechamento do mês.

A causa: o valor da mensalidade era um dado aberto — qualquer rotina podia
gravar nele, inclusive um valor negativo. Ninguém validava.

**É esse problema que o encapsulamento resolve nesta aula.**

---

## Os arquivos

| Arquivo | Papel |
|---|---|
| `Aluno.java` | a classe encapsulada — atributos `private`, getters, setter com validação |
| `Teste.java` | a classe que USA a `Aluno`; é ela que prova o encapsulamento funcionando |

O `main` fica no `Teste.java`, **de propósito**. Enquanto ele estava dentro do
`Aluno`, o `private` não bloqueava nada — uma classe sempre enxerga os próprios
atributos. Separar em duas classes é o que torna o teste conclusivo.

---

## Como compilar e rodar

```bash
javac Aluno.java Teste.java
java Teste
```

Saída esperada:

```
Ana Beatriz | mensalidade: R$ 310.00
  ERRO: valor invalido. Nada foi alterado.
Ana Beatriz | mensalidade: R$ 310.00
Ana Beatriz | mensalidade: R$ 330.00
```

A terceira linha é o ponto: o valor **continuou 310.00** depois da tentativa de
gravar −50. O setter recusou.

---

## O teste decisivo da aula

Acrescentar no `main` do `Teste.java`:

```java
x.mensalidade = -50.00;
```

Resultado esperado — **erro de compilação**, não de execução:

```
Teste.java:12: error: mensalidade has private access in Aluno
```

O programa nem chega a rodar. É isso que o `private` garante: não existe como
burlar o setter.

---

## Convenções deste repositório

- Nome de arquivo **igual** ao nome da classe, com maiúscula: `Aluno.java`.
  O Codespaces roda Linux, que diferencia maiúsculas de minúsculas.
- Sem `Locale` no `String.format`. A saída sai com **ponto** (`310.00`), e está
  correto. Usar `Locale("pt","BR")` traria vírgula, mas gera aviso de API
  depreciada no Java 21 e confunde iniciantes.
- Atributo é **sempre** `private`. Método é `public` só quando alguém de fora
  precisa chamá-lo.
- Nem todo atributo tem setter. Dados que não mudam depois de criados —
  matrícula, CPF, data de cadastro — têm apenas getter.

---

## O que NÃO entra nesta aula

**Herança (`extends`), `protected`, classes abstratas e polimorfismo.**
São conteúdo das aulas de 18/09 e 02/10. Se a conversa derivar para isso,
avise que é assunto das próximas aulas e volte ao escopo.

---

## Desafio proposto aos alunos

Acrescentar à classe `Aluno`:

1. Atributo `matricula` (String) — `private`, **com getter, sem setter**
2. Atributo `pago` (boolean) — `private`, com getter e setter; começa `false`
3. Método `registrarPagamento()` — marca `pago` como `true` e confirma
4. Validação no `setNome` — recusa nome vazio ou com menos de 3 caracteres
5. Teste no `Teste.java`: dois alunos, pagamento registrado em apenas um

O item 1 tem pegadinha proposital: matrícula não muda depois de emitida, então
**não leva setter**. Quem aplicar a receita mecânica vai criar os dois.

---

## Como ajudar aqui

- Explique o **porquê** antes do código; a turma é iniciante.
- Sempre diga **em qual arquivo** mexer e **qual comando** rodar.
- Se o aluno pedir a resposta do desafio, prefira conduzir com perguntas a
  entregar o código pronto.
- Ao corrigir um erro de compilação, mostre a mensagem real do `javac` e
  explique o que ela significa.
