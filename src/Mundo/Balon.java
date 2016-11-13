package Mundo;
import java.awt.*;
public class Balon {

    private Dimension posicionAct;
    private int radio;
    private Color color;
    private int desplazamientoX;
    private int desplazamientoY;

    public Balon(Dimension posicionAct, int radio, Color color, int desplazamientoX, int desplazamientoY) {
        this.posicionAct = posicionAct;
        this.radio = radio;
        this.color = color;
        this.desplazamientoX = desplazamientoX;
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
}
