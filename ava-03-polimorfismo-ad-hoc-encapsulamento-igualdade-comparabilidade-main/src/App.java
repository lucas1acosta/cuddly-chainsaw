import java.util.Arrays;

import modelo.*;

public class App {
  public static void main(String[] args) {

    //FALTA VER AS VERIFICAÇÕES;
    
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

    //Dinheiro d8 = new Dinheiro(9.75);
    //System.out.println(d8.getReais() == 9);
    //System.out.println(d8.getCentavos() == 75);

    //Dinheiro d9 = new Dinheiro(17.569); // dezessete reais e cinquenta e seis centavos -- é truncado nas duas casas, não arredondado!
    //System.out.println(d9.getReais() == 17);
    //System.out.println(d9.getCentavos() == 56);

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
    


    Dinheiro d8  = new Dinheiro(8, 98); // oito reais com noventa e oito centavos
    Dinheiro d9  = new Dinheiro(8, 99); // oito reais com noventa e nove centavos
    Dinheiro d10 = null; // nulo
    Dinheiro d11 = new Dinheiro(8, 98); // oito reais com noventa e oito centavos
    //Dinheiro d12 = d8; // mesma identidade de d8 
    //LINHA COMENTADA POIS É FEITO UM NOVO d12 ABAIXO
    //EXATAMENTE COMO ESTÁ NO CÓDIGO EM README.md

    System.out.println(d8.equals(d9)  == false);
    System.out.println(d8.equals(d10) == false);
    System.out.println(d8.equals(d11) == true);
    //System.out.println(d8.equals(d12) == true);

    System.out.println(new Dinheiro(3.43).equals(new Dinheiro(3, 43)));
    System.out.println(new Dinheiro("R$ 8,97").equals(new Dinheiro(8, 97)));
    System.out.println( ! new Dinheiro("R$ 5,43").equals(null)); // nunca é igual a null

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
    Arrays.sort(dinheiros);// 👈 código para classificar em ordem crescente através de java.util.Arrays
    

    System.out.println(dinheiros[0].equals(d14));
    System.out.println(dinheiros[1].equals(d12));
    System.out.println(dinheiros[2].equals(d12));
    System.out.println(dinheiros[3].equals(d15));
    System.out.println(dinheiros[4].equals(d13));

    System.out.println(Arrays.toString(dinheiros)); // "stringuifica" o array de dinheiros

    Data data1 = new Data(19, 12, 1970); //IMPORTANTE: entrada é DIA/MES/ANO;
    Data data2 = new Data("12", "9", "1985");
    
    try {
      Data data3 = new Data(32, 10, 1980); 
    } catch (IllegalArgumentException e) {
      System.out.println("Erro: " + e); //Lança exception
    }

    try {
      Data data4 = new Data("12", "22", "1999");//Lança exception
    } catch (IllegalArgumentException e) {
      System.out.println("Erro: " + e);
    }

    try {
      Data data4 = new Data("29", "2", "1999");//Lança exception, ano não bissexto com 29 dias
    } catch (IllegalArgumentException e) {
      System.out.println("Erro: " + e);
    }

    try {
      Data data4 = new Data("30", "2", "1996");//Lança exception ano bissexto com 30 dias
    } catch (IllegalArgumentException e) {
      System.out.println("Erro: " + e);
    }

    Data data3 = new Data(29, 2, 1996);
    Data data5 = new Data(28, 2, 1999);
    Data data6 = new Data(data1);
    System.out.println(data1.equals(data2) == false);
    System.out.println(data1.compareTo(data2) < 0);
    System.out.println(data2.compareTo(data1) > 0);
    System.out.println(data2.compareTo(data3) < 0);
    System.out.println(data5.compareTo(data3) > 0);
    System.out.println(data1.compareTo(data6) == 0);

    Veiculo v1 = new Veiculo ("12341ra", "Hyundai", "Hb20", 4000);
    Veiculo v2 = new Veiculo ("12341Ra", "hYundai", "hb20", 4000);
    System.out.println(v1.equals(v2) == true); // Todos os parâmetros iguais.

    Veiculo v3 = new Veiculo("12312zd", "Ford", "Ford Toro", 5000);
    Veiculo v4 = new Veiculo("12314da", "Nissan", "Skyline 2003", 7000);
    System.out.println(v3.equals(v4) == false); // Todos os parâmetros diferentes.

    Veiculo v5 = new Veiculo("23456nd", "Toyota", "Trueno AE-86", 3000);
    Veiculo v6 = new Veiculo("23456ow", "Renault", "Sandero", 3000);
    System.out.println(v5.equals(v6) == false); // Apenas um parâmetro igual.

    Veiculo v7 = new Veiculo ("23456sl", "Citröen", "C20", 4000);
    Veiculo v8 = new Veiculo ("23456ak", "Citröen", "C20", 3000);
    System.out.println(v7.equals(v8) == false); // Dois parâmetros iguas.
    
  }
}
