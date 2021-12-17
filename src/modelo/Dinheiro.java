package modelo;

import java.text.NumberFormat;
import java.util.Locale;

class Dinheiro {

  public static void main(String[] args) {
    Dinheiro d = new Dinheiro(32323, 45);
    d.imprimir();
  }

  private int centavos;

  Dinheiro(int reais, int centavos) {
    this.centavos = reais * 100 + centavos;
  }


  int getReais() {
    return this.centavos / 100;
  }

  int getCentavos() {
    return this.centavos % 100;
  }

  void somar(Dinheiro d) {
    this.centavos += d.centavos;
  }



  private static NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

  public String toString() {
    return moeda.format(this.centavos / 100 + (this.centavos % 100) / 100.0);
  }

  void imprimir() { // Não é ilegal imprimir Dinheiro? 😏
    System.out.println(this.toString());
  }
}
