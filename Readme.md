# Aula 06 — Encapsulamento em Java

Projeto da aula de Programação Orientada a Objetos — UNDB, turma ES04AN.
Caso: **Semeando Digital**.

---

## Como abrir

1. Clique no botão verde **Code**
2. Aba **Codespaces**
3. **Create codespace on main**

Aguarde cerca de um minuto. O ambiente já vem com o Java instalado.

---

## Como compilar e rodar

No terminal do Codespaces (menu **Terminal → New Terminal**):

```bash
javac Aluno.java Teste.java
java Teste
```

### Saída esperada

```
Ana Beatriz | mensalidade: R$ 310.00
  ERRO: valor invalido. Nada foi alterado.
Ana Beatriz | mensalidade: R$ 310.00
Ana Beatriz | mensalidade: R$ 330.00
```

---

## Os arquivos

| Arquivo | O que é |
|---|---|
| `Aluno.java` | a classe encapsulada: atributos `private`, getters, setter com validação |
| `Teste.java` | a classe que USA a `Aluno` — é ela que prova o encapsulamento |

---

## O teste decisivo

Abra o `Teste.java` e acrescente esta linha dentro do `main`:

```java
x.mensalidade = -50.00;
```

Salve e compile de novo:

```bash
javac Aluno.java Teste.java
```

O compilador vai recusar:

```
Teste.java:12: error: mensalidade has private access in Aluno
        x.mensalidade = -50.00;
         ^
1 error
```

**O erro é de COMPILAÇÃO, não de execução.** O programa nem chega a rodar.
É isso que o `private` garante: não existe como burlar o setter.

Apague a linha e compile novamente para voltar a funcionar.

---

## Desafio da aula

Acrescente à classe `Aluno`:

1. Atributo `matricula` (String) — `private`, **com getter, sem setter**
2. Atributo `pago` (boolean) — `private`, com getter e setter; começa `false`
3. Método `registrarPagamento()` — marca `pago` como `true` e imprime a confirmação
4. Validação no `setNome` — recusa nome vazio ou com menos de 3 caracteres
5. Teste no `Teste.java`: crie dois alunos, registre o pagamento de apenas um

Poste o `Aluno.java` no Classroom até domingo.