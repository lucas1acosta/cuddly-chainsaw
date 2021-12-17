package modelo;

public class Veiculo {

  final String placa;
  final String marca;
  final String modelo;
  final int   cilindrada;

public Veiculo(String placa, String marca, String modelo, int cilindrada) {
    this.placa      = placa.toUpperCase();
    this.marca      = marca.toUpperCase();
    this.modelo     = modelo.toUpperCase();
    this.cilindrada = cilindrada;
  }

  @Override
  public boolean equals(Object obj){
    if(this == obj) return true;
    if(null == obj) return false;
    if(obj instanceof Veiculo){
      Veiculo v = (Veiculo) obj;
      if(
      comparar(this.marca, v.marca) == true && 
      comparar(this.modelo, v.modelo) == true &&
      this.cilindrada == v.cilindrada){
        return true;
      } 
    }
    return false;
  }

  private boolean comparar(String x, String y){
    boolean flag = true;
    if(x.length() == y.length()){
      for (int i = 0; i < x.length(); i++) {
        if(x.charAt(i) != y.charAt(i)){
          flag = false;
        }
      }
      return flag;
    }
    return false;
  }

}
