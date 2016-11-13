package Mundo;

import javax.swing.*;
import java.awt.*;

// ContadorPelotas.java

public class Puntaje {
    private int numPelotas;
    protected Label labelNumPelotas;
    BorderLayout esquema;
    public Puntaje(int numPelotas)
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
