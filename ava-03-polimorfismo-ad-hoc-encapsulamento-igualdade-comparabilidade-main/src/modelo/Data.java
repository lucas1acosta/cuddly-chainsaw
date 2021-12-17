package modelo;

public class Data implements Comparable<Data> {
    
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        if(dia > 31){
            throw new IllegalArgumentException("Não existe mês com mais de 31 dias!");
        }
        if(mes == 2 && !(ano%4 == 0) && dia >= 29){
            throw new IllegalArgumentException("Fevereiro não tem 29 ou mais dias, ano não bissexto");
        }
        if(mes == 2 && (ano%4 == 0) && dia > 29){
            throw new IllegalArgumentException("Ano bissexto, fevereiro não tem mais de 29 dias");
        }
        if(mes <=7 && (mes%2 == 0) && dia >30){
            throw new IllegalArgumentException("Esse mes não tem mais de 30 dias!");
        }
        if(mes >=7 && (mes%2 == 1) && dia >30){
            throw new IllegalArgumentException("Esse mes não tem mais de 30 dias!");
        }
        this.mes = mes;
        if(mes > 12){
            throw new IllegalArgumentException("Não existe mês 13 ou maior");
        }
        this.ano = ano;
        if(ano <= -1){
            throw new IllegalArgumentException("Data fora do alcance");
        }
    }

    public Data(String dia, String mes, String ano){
        this.dia = Integer.parseInt(dia);
        this.mes = Integer.parseInt(mes);
        this.ano = Integer.parseInt(ano);
        if(this.dia > 31){
            throw new IllegalArgumentException("Não existe mês com mais de 31 dias!");
        }
        if(this.mes == 2 && !(this.ano%4 == 0) && this.dia >= 29){
            throw new IllegalArgumentException("Fevereiro não tem 29 ou mais dias, ano não bissexto");
        }
        if(this.mes == 2 && (this.ano%4 == 0) && this.dia > 29){
            throw new IllegalArgumentException("Ano bissexto, fevereiro não tem mais de 29 dias");
        }
        if(this.mes <=7 && (this.mes%2 == 0) && this.dia >30){
            throw new IllegalArgumentException("Esse mes não tem mais de 30 dias!");
        }
        if(this.mes >=7 && (this.mes%2 == 1) && this.dia >30){
            throw new IllegalArgumentException("Esse mes não tem mais de 30 dias!");
        }
        if(this.mes > 12){
            throw new IllegalArgumentException("Não existe mês 13 ou maior");
        }
        if(this.ano <= -1){
            throw new IllegalArgumentException("Data fora do alcance");
        }

    }

    public Data(Data data) {
        this.ano = data.ano;
        this.mes = data.mes;
        this.dia = data.dia;
    }

    @Override
  public boolean equals(Object obj){
    if(this == obj) return true;
    if(null == obj) return false;
    if(obj instanceof Data){
      Data dat = (Data) obj;
      if(this.getAno() == dat.getAno() && 
      this.getMes() == dat.getMes() && this.getDia() == dat.getDia()){
        return true;
      } 
    }
    return false;
  }

  @Override
  public int compareTo(Data d) {
    int temp1 = this.getDia() + this.getMes() + this.getAno();
    int temp2 = d.getDia() + d.getMes() + d.getAno();
    if(temp1 > temp2) return 1;
    if(temp1 < temp2) return -1;
    return 0;
  }
   
    public int getDia() {
        return dia;
    }
    
    public int getMes() {
        return mes;
    }

    public int getAno() {    
        return ano;
    }

}
