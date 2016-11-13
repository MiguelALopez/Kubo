package old; /***********************************************
 Autor: Miguel Angel Lopez Fernandez
 Código: 1326691
 Plan: Ingeniería de sistemas - 3743
 Nombre del archivo: EspacioPelotas.java
 Fecha: 03-nov-2014
 *************************************************/
//package Punto3;

import javax.swing.*;
import java.awt.*;

public class EspacioPelotas extends JPanel{

    protected Pelota pelotas[];
    protected int numPelotas;


    // Creo un buffer para eliminar el parpadeo
    Image imageBuffer;
    Graphics graphicsBuffer;

    // Defino el Constructor asignando los tamaños iniciales del applet y inicializando el arreglo de pelotas en 20
    public EspacioPelotas(int numPelotas)
    {
        pelotas = new Pelota[numPelotas];
        numPelotas = 1;
    }
    /*Método encargado de almacenar las pelotas que se ingresan en un arreglo de pelotas para se
    * pintado en pantalla*/
    public void crearPelota(Pelota pelota)
    {
        boolean creado = true;
        for (int i = 0; (creado) && (i < pelotas.length); i++)
        {
            if (pelotas[i] == null)
            {
                pelotas[i] = pelota;
                creado = false;
                numPelotas++;
            }
        }
    }
    /*Método encargado de pintar las pelotas una vez a sido modificado su posición anterior*/
    public void pintarPelota(Graphics g)
    {
        for (int i = 0; i < pelotas.length; i++)
        {
            if (pelotas[i] != null)
            {
                g.setColor(pelotas[i].getColor());
                int x = (int) pelotas[i].getPosicionAct().getWidth();
                int y = (int) pelotas[i].getPosicionAct().getHeight();
                int r = pelotas[i].getRadio();
                g.fillOval(x, y, r, r);
            }
        }

    }
    // Encargado de refrescar la imagen de la posición de las pelotas
    public void paint(Graphics g) {
        // Técnica del doble buffer para eliminar el flickering
        imageBuffer =createImage(getWidth(), getHeight());
        graphicsBuffer = imageBuffer.getGraphics();

        pintarPelota(graphicsBuffer);


        g.drawImage(imageBuffer, 0, 0, null);
    }
}
