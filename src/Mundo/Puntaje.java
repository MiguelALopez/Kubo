package Mundo;

import javax.swing.*;
import java.awt.*;

// ContadorBalons.java

public class Puntaje extends JPanel{
    private int numBalons;
    protected Label labelNumBalons;
    BorderLayout esquema;
    public Puntaje(int numBalons)
    {
     this.numBalons = numBalons;
     esquema = new BorderLayout(5, 5);
     setLayout(esquema);
     labelNumBalons = new Label("Total rebotes: " + numBalons );
     add(labelNumBalons);
    }

    public int getNumBalons() {
      return numBalons;
     }

    public void setNumBalons(int numBalons) {
      this.numBalons = numBalons;
     }

    public void refrescarBalons(int numBalons){
     labelNumBalons.setText("Total rebotes: " + numBalons);
    }
}
