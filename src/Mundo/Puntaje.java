package Mundo;

import javax.swing.*;
import java.awt.*;

// ContadorBalons.java

public class Puntaje extends JPanel{
    private int numBalons;
    private Balon[] balones;
    protected Label labelNumBalons;
    BorderLayout esquema;
    public Puntaje(int numBalons, Balon[] balones)
    {
     this.numBalons = numBalons;
     this.balones=balones;
     esquema = new BorderLayout(5, 5);
     setLayout(esquema);
     
     labelNumBalons = new Label("Total rebotes: " + 0 );
     add(labelNumBalons);
    }

    public int contarRebotes()
    {
        int total=0;
        for(int i=0; i<this.balones.length; i++)
        {
            total += this.balones[i].getRebotes();
        }
        return total;
    }
    public Balon[] getBalones() {
        return balones;
    }

    public void setBalones(Balon[] balones) {
        this.balones = balones;
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
