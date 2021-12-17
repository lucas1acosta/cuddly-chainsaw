# Avaliação 03 Polimorfismo ad-hoc, Encapsulamento, Igualdade e Comparabilidade

Link do Classroom <https://classroom.github.com/a/PovpY92Y>

## Implementar e testar segundo as especificações

- Esta atividade é avaliada com esforço estimado entre 4 e 8h.
- Copie os casos de teste para o método `main` em [App.java](src/App.java), conforme o exemplo que já está no arquivo. Comente com `//` ou `/*` e `*/` as linhas que ainda não foram implementadas.
- Os Casos de Teste podem ser corrigidos se estiverem mal escritos, mas **a especificação dos objetos não pode ser alterada**.
- Não esqueça de ajustar a visibilidade das classes [Dinheiro](src/modelo/Dinheiro.java) e [Veiculo](src/modelo/Veiculo.java), **elas não devem ser removidas da pasta `modelo`**.
- E, por fim, assegure-se de **assistir as videoaulas antes de começar**, pois lá estão explicados todos os conceitos e práticas.



### Tornar Dinheiro polimórfico

Sobrecarregue o método `somar` na classe [Dinheiro](src/modelo/Dinheiro.java) para aceitar parâmetros `int`, `double`, `String` e outro `Dinheiro`. No caso de `double`, considerar apenas duas casas decimais.

Sobrecarregar o construtor de [Dinheiro](src/modelo/Dinheiro.java) para aceitar um `int` representando _Reais_ (não os centavos), `double` (com apenas duas casas decimais), outro Dinheiro, e `String` no formato de `"R$ 1.234,56"` com centavos de duas casas e reais de até 7 casas, por exemplo `"R$ 1.234.567,89"`. Formatos inválidos devem ser rejeitados.

**Casos de Teste:**

```java
Dinheiro d1 = new Dinheiro(); // construtor vazio significa R$ 0,00
System.out.println(d1.getReais() == 0);
System.out.println(d1.getCentavos() == 0);

Dinheiro d3 = new Dinheiro(3, 45); // três reais e 45 centavos
System.out.println(d3.getReais() == 3);
System.out.println(d3.getCentavos() == 45);

Dinheiro d2 = new Dinheiro(d3); // d2 recebe os valores de d3, R$ 3,45
System.out.println(d2.getReais() == 3);
System.out.println(d2.getCentavos() == 45);

Dinheiro d4 = new Dinheiro(200); // duzentos reais
System.out.println(d4.getReais() == 200);
System.out.println(d4.getCentavos() == 0);

Dinheiro d5 = new Dinheiro("R$ 345,75"); // trezentos e quarenta e cinco reais e setenta e cinco centavos
System.out.println(d5.getReais() == 345);
System.out.println(d5.getCentavos() == 75);

Dinheiro d6 = new Dinheiro("R$ 1.000.000,11"); // um milhão de reais com onze centavos
System.out.println(d6.getReais() == 1000000);
System.out.println(d6.getCentavos() == 11);

Dinheiro d7 = new Dinheiro("R$ 2.567,89");
System.out.println(d7.getReais() == 2567);
System.out.println(d7.getCentavos() == 89);

Dinheiro d8 = new Dinheiro(9.75);
System.out.println(d8.getReais() == 9);
System.out.println(d8.getCentavos() == 75);

Dinheiro d9 = new Dinheiro(17.569); // dezessete reais e cinquenta e seis centavos -- é truncado nas duas casas, não arredondado!
System.out.println(d9.getReais() == 17);
System.out.println(d9.getCentavos() == 56);

d3.somar(d4); // somar o valor de d4 em d3
System.out.println(d3.getReais() == 203);
System.out.println(d3.getCentavos() == 45);

d5.somar(100);
System.out.println(d5.getReais() == 445);
System.out.println(d5.getCentavos() == 75);

d6.somar(1.90);
System.out.println(d6.getReais() == 1000002);
System.out.println(d6.getCentavos() == 01);
d6.imprimir(); // R$ 1.000.002,01

d7.somar("R$ 998.817,86");
System.out.println(d7.getReais() == 1001385);
System.out.println(d7.getCentavos() == 75);
d7.imprimir(); // R$ 1.001.385,75
```



### Avaliar a equivalência de Dinheiro com `equals`

Dadas instâncias de `Dinheiro` devem ser consideradas iguais se possuem o mesmo valor monetário.

**Casos de Teste:**

```java
Dinheiro d8  = new Dinheiro(8, 98); // oito reais com noventa e oito centavos
Dinheiro d9  = new Dinheiro(8, 99); // oito reais com noventa e nove centavos
Dinheiro d10 = null; // nulo
Dinheiro d11 = new Dinheiro(8, 98); // oito reais com noventa e oito centavos
Dinheiro d12 = d8; // mesma identidade de d8

System.out.println(d8.equals(d9)  == false);
System.out.println(d8.equals(d10) == false);
System.out.println(d8.equals(d11) == true);
System.out.println(d8.equals(d12) == true);

System.out.println(new Dinheiro(3.43).equals(new Dinheiro(3, 43)));
System.out.println(new Dinheiro("R$ 8,97").equals(new Dinheiro(8, 97)));
System.out.println( ! new Dinheiro("R$ 5,43").equals(null)); // nunca é igual a null
```



### Tornar Dinheiro comparável

Tornar Dinheiro comparável através da implementação da interface `Comparable`.

**Casos de Teste:**

```java
Dinheiro d12 = new Dinheiro(4, 30);
Dinheiro d13 = new Dinheiro(987, 14);
Dinheiro d14 = new Dinheiro(0, 1);
Dinheiro d15 = new Dinheiro(17, 9);
Dinheiro d16 = new Dinheiro(4, 30);

// Todas estas assertivas devem imprimir true, claramente.
System.out.println(d12.compareTo(d13) < 0);
System.out.println(d12.compareTo(d14) > 0);
System.out.println(d12.compareTo(d15) < 0);
System.out.println(d12.compareTo(d16) == 0);

Comparable d17 = new Dinheiro(8);
Comparable d18 = new Dinheiro(9);
Comparable d19 = new Dinheiro(8);
System.out.println(d17.compareTo(d18) < 0);
System.out.println(d17.compareTo(d19) == 0);
System.out.println(d18.compareTo(d17) > 0);

Dinheiro[] dinheiros = {d12, d13, d14, d15, d16};

// 👈 código para classificar em ordem crescente através de java.util.Arrays

System.out.println(dinheiros[0].equals(d14));
System.out.println(dinheiros[1].equals(d12));
System.out.println(dinheiros[2].equals(d12));
System.out.println(dinheiros[3].equals(d15));
System.out.println(dinheiros[4].equals(d13));

System.out.println(Arrays.toString(dinheiros)); // "stringuifica" o array de dinheiros
```



### Implemente Data

Implemente `Data` (ex.: _28/10/2021_) de forma que possa ser instanciada de pelo menos duas maneiras diferentes (sobrecarga de construtor), com validação e totalmente encapsulada (atributos invisíveis) com acesso intermediado por acessores (getters), permitindo a verificação da equivalência (equals) e comparabilidade (compareTo).

**Importante**: a classe `Data` deve ser colocada no diretório/pacote [modelo](src/modelo/) e ser declarada como `package modelo;` (ver os exemplos de `Dinheiro` e `Veiculo`).

Escreva os Casos de Teste, conforme aprendeu nas atividades anteriores, os quais devem cobrir o comportamento normal e os casos especiais.



### Implementar `equals` em Veiculo

A classe [Veiculo](src/modelo/Veiculo.java) precisa de um método _equals_. Decida qual será o critério de equivalência, no qual duas instâncias de _veículo_ seriam consideradas representantes do mesmo objeto, e escreva testes para apresentar o comportamento esperado, por favor 😉. Obs.: nesta parte é só isso mesmo, nada mais, o que está em exame é teu julgamento do critério para a igualdade e é livre, não é esperado um modo único de fazê-lo.
