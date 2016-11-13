/***********************************************
 Autor: Miguel Angel Lopez Fernandez
 Código: 1326691
 Plan: Ingeniería de sistemas - 3743
 Nombre del archivo: FisicaPelota.java
 Fecha: 03-nov-2014
 *************************************************/
package Punto3;

import java.applet.AudioClip;
import java.awt.*;
import java.util.Random;

public class FisicaPelota {

    AudioClip audioRebote;
    AudioClip audioColor;

    Color colores[] = {Color.black, Color.blue, Color.yellow, Color.red, Color.green, Color.orange, Color.cyan,
    Color.gray, Color.magenta, Color.pink};

    public FisicaPelota(AudioClip sonidoRebote, AudioClip sonidoColor) {
        audioRebote = sonidoRebote;
        audioColor = sonidoColor;
    }

    /*Método encargado de parar la reproducción de audioRebote (si se esta Reproduciendo)
        * y después de esto reproducirla*/
    public void extremo(){
        audioRebote.stop();
        audioRebote.play();
    }

    public Dimension movimiento(Pelota pelota, Dimension dimApplet, Pelota[] pelotas)
    {
        if ((pelota.getPosicionAct().getWidth() > (dimApplet.getWidth() - pelota.getRadio())) ||
                (pelota.getPosicionAct().getWidth() <= 0)){
            pelota.setDesplazamientoX(-1 * pelota.getDesplazamientoX());
            extremo();
        }
        if ((pelota.getPosicionAct().getHeight() > (dimApplet.getHeight() - pelota.getRadio())) ||
                (pelota.getPosicionAct().getHeight() <= 0)){
            pelota.setDesplazamientoY(-1 * pelota.getDesplazamientoY());
            extremo();
        }
        if (chocanPelotas(pelota, pelotas))
        {
            pelota.setDesplazamientoX(-1 * pelota.getDesplazamientoX());
            pelota.setDesplazamientoY(-1 * pelota.getDesplazamientoY());
//            extremo();
//            if ()
        }
        Dimension dimension = new Dimension();
        dimension.setSize(pelota.getPosicionAct().getWidth() + pelota.getDesplazamientoX(),
                pelota.getPosicionAct().getHeight() + pelota.getDesplazamientoY());

        return dimension;
    }

    public double calcularDistancia(Pelota pelota1, Pelota pelota2)
    {
        double distancia;
        distancia = Math.sqrt(Math.pow((pelota2.getPosicionAct().getWidth() - pelota1.getPosicionAct().getWidth()), 2) +
        Math.pow((pelota2.getPosicionAct().getHeight() - pelota1.getPosicionAct().getHeight()), 2));
        return distancia;
    }

    public boolean chocanPelotas(Pelota pelota, Pelota[] pelotas)
    {
        boolean chocan = false;

        for (int i = 0; i < pelotas.length; i++)
        {
            if (pelota != pelotas[i] && pelotas[i] != null)
            {
                if (pelota.getRadio() > calcularDistancia(pelota, pelotas[i]))
                {
                    chocan = true;
                    if (pelota.getColor() == pelotas[i].getColor())
                    {
                        audioColor.stop();
                        audioColor.play();
                    }
                }
            }
        }
        return chocan;
    }

    /*Método encargado de generar una posición aleatoria para ser adicionado después en la variable posicionAnt en
    * los puntos*/
    public int desplazamientoAleatorio()
    {
        Random random = new Random();
        int potencia = (int) (random.nextDouble() * 2);
        int rand = (int) Math.pow(-1, potencia);

        return rand;
    }

    // Método que genera colores aleatorios de el arreglo de colores
    public Color colorAleatorio()
    {
        Color colorTemp = Color.black;
        try {
            Random random = new Random();
            int color = (int) (random.nextDouble() * colores.length);
            colorTemp = colores[color];
        }catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Fallo al cargar el color de el arreglo");
            e.printStackTrace();
        }
        finally {
            return colorTemp;
        }
    }
}
