package Hilos;

import Interfaz.*;
import Mundo.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// MovimientoBalon.java

public class HiloBalon implements Runnable{
    Thread hilo;

    private Cancha espacioBalons;
    private PanelCancha fisicaBalon;
    private InterfazJuegoBalones appletBalon; // Main class
    private Puntaje contadorBalons;
    public HiloBalon(final Cancha espacioBalons, PanelCancha fisicaBalon, InterfazJuegoBalones appletBalon, final Puntaje contadorBalons) {
        this.espacioBalons = espacioBalons;
        this.fisicaBalon = fisicaBalon;
        this.appletBalon = appletBalon;
        this.contadorBalons = contadorBalons;

        crearBalon();
        hilo = new Thread(this);
        espacioBalons.addMouseListener(
            new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent event) {
                    if (!hilo.isAlive()){
                        hilo.start();
                    }else {
                        crearBalon();
                        contadorBalons.refrescarBalons(espacioBalons.numBalons);
                    }
                }
            }
        );
    }


    /*Aquí se define el movimiento que tendrá la pelota después de el primer click invocando al método
    * movimiento de la clase fisicaBalon */
    @Override
    public void run() {
        while (hilo != null)
        {
            try {
                hilo.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < espacioBalons.pelotas.length; i++)
            {
                if (espacioBalons.pelotas[i] != null)
                {
                    Dimension dimensionFrame = new Dimension();
                    dimensionFrame.setSize(appletBalon.getWidth(), appletBalon.getHeight() - 21);
                    espacioBalons.pelotas[i].setPosicionAct(
                            fisicaBalon.movimiento(espacioBalons.pelotas[i],dimensionFrame, espacioBalons.pelotas));
                }
            }
            espacioBalons.repaint();
        }
     }
    /*Método encargado de crear pelotas y llamar al método crear pelotas para almacenarlas*/
    public void crearBalon()
    {
        // Crear balones en posiciones aleatorias
        double t_posx = Math.random() * (appletBalon.getWidth() - 30);
        double t_posy = Math.random() * (appletBalon.getHeight() - 30);
        int posx = (int) t_posx;
        int posy = (int) t_posy;
        if (posx < 0)
            posx= 0 ;
        if (posy < 0)
            posy = 0;
        double t_radio = 0;
        while (t_radio < 30)
            t_radio = Math.random() * 70;
        int radio = (int) t_radio;
        Dimension posicionInicial = new Dimension(posx, posy);
        Balon pelota = new Balon(posicionInicial,
                radio, fisicaBalon.colorAleatorio(),
                fisicaBalon.desplazamientoAleatorio(),
                fisicaBalon.desplazamientoAleatorio());

        espacioBalons.crearBalon(pelota);
    }
 }