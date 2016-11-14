package Interfaz;

import Mundo.*;
import java.awt.*;
import java.util.*;

// FisicaPelota.java

public class PanelCancha {
    Color colores[] = {Color.black, Color.blue, Color.yellow, Color.red, Color.green, Color.orange, Color.cyan,
    Color.gray, Color.magenta, Color.pink};
    // public int rebotes;

    public PanelCancha() {
    }

    

    public Dimension movimiento(Balon pelota, Dimension dimFrame, Balon[] pelotas)
    {
        // Contar rebote
        if ((pelota.getPosicionAct().getWidth() > (dimFrame.getWidth() - pelota.getRadio())) ||
                (pelota.getPosicionAct().getWidth() <= 0)){
            pelota.setDesplazamientoX(-1 * pelota.getDesplazamientoX());
            pelota.setRebotes(pelota.getRebotes()+1);
            //this.rebotes++;
        }
        if ((pelota.getPosicionAct().getHeight() > (dimFrame.getHeight() - pelota.getRadio() - 40)) ||
                (pelota.getPosicionAct().getHeight() <= 0)){
            pelota.setDesplazamientoY(-1 * pelota.getDesplazamientoY());
            pelota.setRebotes(pelota.getRebotes()+1);
            // this.rebotes++;
        }
        if (chocanBalons(pelota, pelotas))
        {
            pelota.setDesplazamientoX(-1 * pelota.getDesplazamientoX());
            pelota.setDesplazamientoY(-1 * pelota.getDesplazamientoY());
//            extremo();
//            if ()
        }
        Dimension dimension = new Dimension();
        dimension.setSize(pelota.getPosicionAct().getWidth() + pelota.getDesplazamientoX(),
                pelota.getPosicionAct().getHeight() + pelota.getDesplazamientoY());
        // System.out.println("Rebotes: "+rebotes);
        return dimension;
    }

    public double calcularDistancia(Balon pelota1, Balon pelota2)
    {
        double distancia;
        distancia = Math.sqrt(Math.pow((pelota2.getPosicionAct().getWidth() - pelota1.getPosicionAct().getWidth()), 2) +
        Math.pow((pelota2.getPosicionAct().getHeight() - pelota1.getPosicionAct().getHeight()), 2));
        return distancia;
    }

    public boolean chocanBalons(Balon pelota, Balon[] pelotas)
    {
        boolean chocan = false;

        for (int i = 0; i < pelotas.length; i++)
        {
            if (pelota != pelotas[i] && pelotas[i] != null)
            {
                if (pelota.getRadio() > calcularDistancia(pelota, pelotas[i]))
                {
                    chocan = true;
                    /*
                    if (pelota.getColor() == pelotas[i].getColor())
                    {

                    }
                    */
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
