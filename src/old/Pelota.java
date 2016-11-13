package old; /***********************************************
 Autor: Miguel Angel Lopez Fernandez
 Código: 1326691
 Plan: Ingeniería de sistemas - 3743
 Nombre del archivo: Pelota.java
 Fecha: 03-nov-2014
 *************************************************/

import java.awt.*;

public class Pelota {

    private Dimension posicionAct;
    private int radio;
    private Color color;
    private int desplazamientoX;
    private int desplazamientoY;

    public Pelota(Dimension posicionAct, int radio, Color color, int desplazamientoX, int desplazamientoY) {
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
