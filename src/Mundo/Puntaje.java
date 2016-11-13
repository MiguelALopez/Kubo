package Mundo;

public class Puntaje {
    private int numPelotas;
    protected Label labelNumPelotas;
    BorderLayout esquema;
    public ContadorPelotas(int numPelotas)
    {
     this.numPelotas = numPelotas;
     esquema = new BorderLayout(5, 5);
     setLayout(esquema);
     labelNumPelotas = new Label("El numero de pelotas es: " + numPelotas );
     add(labelNumPelotas);
    }

    public int getNumPelotas() {
      return numPelotas;
     }

    public void setNumPelotas(int numPelotas) {
      this.numPelotas = numPelotas;
     }

    public void refrescarPelotas(int numPelotas){
     labelNumPelotas.setText("El numero de pelotas es: " + numPelotas);
    }
}
