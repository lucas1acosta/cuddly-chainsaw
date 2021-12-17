package modelo;

import java.text.NumberFormat;
import java.util.Locale;

 public class Dinheiro implements Comparable<Dinheiro>{

  private int centavos;

  public Dinheiro(int reais, int centavos) {
    this.centavos = reais * 100 + centavos;
  }


  public Dinheiro() {
    this.centavos = 0;
  }


  public Dinheiro(Dinheiro dinheiro) {
    this.centavos = (dinheiro.getReais() * 100) + dinheiro.getCentavos();
  }


  public Dinheiro(int i) {
    if(i > 100000000){
      throw new IllegalStateException("Dinheiro maior que 7 digitos.");
    }
    this.centavos = i * 100;
  }


  public Dinheiro(String string) {
    String temp3 = string.replaceAll("[^-?0-9]+", "");
    if(temp3.length() > 9){
      throw new IllegalStateException("Dinheiro maior que 7 digitos.");
    }
    this.centavos = Integer.parseInt(temp3);
  }


  public Dinheiro(double d) {
    String temp1 = String.format("%.2f", d);
    String temp3 = temp1.replaceAll("[^-?0-9]+", "");
    if(temp3.length() > 9){
      throw new IllegalStateException("Dinheiro maior que 7 digitos.");
    }
    this.centavos = Integer.parseInt(temp3);
  }


  public int getReais() {
    return this.centavos / 100;
  }

  public int getCentavos() {
    return this.centavos % 100;
  }

  public void somar(Dinheiro d) {
    this.centavos += d.centavos;
  }

  private static NumberFormat moeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

  public String toString() {
    return moeda.format(this.centavos / 100 + (this.centavos % 100) / 100.0);
  }

  public void imprimir() { // Não é ilegal imprimir Dinheiro? 😏
    System.out.println(this.toString());
  }


  public void somar(int i) {
    this.centavos += i * 100;
  }


  public void somar(double d) {
    String temp1 = String.format("%.2f", d);
    for (int i = 0; i < temp1.length(); i++) {
      if(temp1.charAt(i) == ','){
        temp1.replace(',', '.');
      }
    }
    double temp2 = Double.parseDouble(temp1.replace(',', '.'));
    this.centavos += temp2 * 100;
  }


  public void somar(String string) {
    String temp3 = string.replaceAll("[^-?0-9]+", "");
    this.centavos += Integer.parseInt(temp3);
  }

  @Override
  public boolean equals(Object obj){
    if(this == obj) return true;
    if(null == obj) return false;
    if(obj instanceof Dinheiro){
      Dinheiro d = (Dinheiro) obj;
      if(this.getReais() == d.getReais() && this.getCentavos() == d.getCentavos()){
        return true;
      } 
    }
    return false;
  }

  @Override
  public int compareTo(Dinheiro d) {
    int temp1 = this.centavos;
    int temp2 = d.centavos;
    if(temp1 > temp2) return 1;
    if(temp1 < temp2) return -1;
    return 0;
  }




}
