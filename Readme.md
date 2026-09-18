# Aula 06 — Encapsulamento em Java

Programação Orientada a Objetos · UNDB · Turma ES04AN
Caso: **Semeando Digital**

---

## Montando a estrutura

No terminal do Codespaces, rode uma única vez:

```bash
bash setup-aula.sh
```

Ele cria as quatro pastas da aula, cada uma com o código da etapa correspondente.

---

## As quatro etapas

Cada pasta roda sozinha. Faça na ordem — a seguinte só faz sentido depois da anterior.

### 1. Classes e Objetos — revisão da aula de 21/08

```bash
cd 01-classes-objetos
javac Aluno.java
java Aluno
```

```
Aluno: Ana Beatriz
Aluno: Carlos Henrique
```

Dois objetos da mesma classe, com valores diferentes. Repare que o atributo foi
preenchido **de fora**, linha por linha.

---

### 2. Membros da Classe — revisão da aula de 28/08

```bash
cd ../02-membros-classe
javac Aluno.java
java Aluno
```

```
Ana Beatriz | R$ 310.0
```

Agora o objeto nasce completo, em uma linha só. Mas o valor saiu como `310.0` —
falta formatação.

---

### 3. A Linguagem Java — revisão da aula de 04/09

```bash
cd ../03-linguagem-java
javac Aluno.java
java Aluno
```

```
Ana Beatriz | mensalidade: R$ 310.00
Teste | mensalidade: R$ -50.00
```

O valor está formatado. **Mas repare na segunda linha:** o objeto aceitou uma
mensalidade NEGATIVA sem reclamar.

É esse o problema que a aula de hoje resolve.

---

### 4. Encapsulamento — a aula de hoje

```bash
cd ../04-encapsulamento
javac Aluno.java Teste.java
java Teste
```

```
Ana Beatriz | mensalidade: R$ 310.00
  ERRO: valor invalido. Nada foi alterado.
Ana Beatriz | mensalidade: R$ 310.00
Ana Beatriz | mensalidade: R$ 330.00
```

A terceira linha é o ponto: o valor **continuou 310.00** depois da tentativa de
gravar −50. O setter recusou.

---

## O teste decisivo

Só nesta etapa existem **duas classes**. Isso é proposital: enquanto o `main`
estava dentro do `Aluno`, o `private` não bloqueava nada — uma classe sempre
enxerga os próprios atributos.

Abra o `Teste.java` e acrescente esta linha dentro do `main`:

```java
x.mensalidade = -50.00;
```

Compile de novo:

```bash
javac Aluno.java Teste.java
```

O compilador recusa:

```
Teste.java:12: error: mensalidade has private access in Aluno
        x.mensalidade = -50.00;
         ^
1 error
```

**O erro é de COMPILAÇÃO, não de execução.** O programa nem chega a rodar.
Não existe como burlar o setter.

Apague a linha e compile novamente para voltar a funcionar.

---

## Desafio

Acrescente à classe `Aluno` da etapa 4:

1. Atributo `matricula` (String) — `private`, **com getter, sem setter**
2. Atributo `pago` (boolean) — `private`, com getter e setter; começa `false`
3. Método `registrarPagamento()` — marca `pago` como `true` e confirma
4. Validação no `setNome` — recusa nome vazio ou com menos de 3 caracteres
5. Teste no `Teste.java`: dois alunos, pagamento registrado em apenas um

Poste o `Aluno.java` no Classroom até domingo.

---

## Se der erro

| Mensagem | O que fazer |
|---|---|
| `class Aluno is public, should be declared in a file named Aluno.java` | o arquivo está com letra minúscula; renomeie com `mv` |
| `cannot find symbol` | compile os dois juntos: `javac Aluno.java Teste.java` |
| `javac: command not found` | rode `java -version` para conferir se o Java está instalado |

O Codespaces roda Linux, que **diferencia maiúsculas de minúsculas**.
`aluno.java` e `Aluno.java` são arquivos diferentes.
