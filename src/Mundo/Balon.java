package Mundo;
import java.awt.*;
public class Balon {

    private Dimension posicionAct;
    private int radio;
    private Color color;
    private int desplazamientoX=0;
    private int desplazamientoY=0;
    private int rebotes=0;

    public Balon(Dimension posicionAct, int radio, Color color, int desplazamientoX, int desplazamientoY) {
        this.posicionAct = posicionAct;
        this.radio = radio;
        this.color = color;
        double rand = Math.random()*2;
        
        // Configurar movimiento de manera aleatoria
        if (rand < 1)
            this.desplazamientoX = desplazamientoX;
        else
            this.desplazamientoY = desplazamientoY;
    }

    public Dimension getPosicionAct() {
        return posicionAct;
    }

    public void setPosicionAct(Dimension posicionAct) {
        this.posicionAct = posicionAct;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDesplazamientoX() {
        return desplazamientoX;
    }

    public void setDesplazamientoX(int desplazamientoX) {
        this.desplazamientoX = desplazamientoX;
    }

    public int getDesplazamientoY() {
        return desplazamientoY;
    }

    public void setDesplazamientoY(int desplazamientoY) {
        this.desplazamientoY = desplazamientoY;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }
    
}
