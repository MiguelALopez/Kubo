/***********************************************
 Autor: Miguel Angel Lopez Fernandez
 Código: 1326691
 Plan: Ingeniería de sistemas - 3743
 Nombre del archivo: MovimientoPelota.java
 Fecha: 06-nov-2014
 *************************************************/

package Punto3;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MovimientoPelota implements Runnable{

 	Thread hilo;

 	private EspacioPelotas espacioPelotas;
 	private FisicaPelota fisicaPelota;
    private AppletPelota appletPelota;
    private ContadorPelotas contadorPelotas;

     public MovimientoPelota(final EspacioPelotas espacioPelotas, FisicaPelota fisicaPelota, AppletPelota appletPelota, final ContadorPelotas contadorPelotas) {
         this.espacioPelotas = espacioPelotas;
         this.fisicaPelota = fisicaPelota;
         this.appletPelota = appletPelota;
         this.contadorPelotas = contadorPelotas;

         crearPelota();
         hilo = new Thread(this);
         espacioPelotas.addMouseListener(
                 new MouseAdapter() {
                     @Override
                     public void mouseClicked(MouseEvent event) {
                         if (!hilo.isAlive()){
                             hilo.start();
                         }else {
                             crearPelota();
                             contadorPelotas.refrescarPelotas(espacioPelotas.numPelotas);

                         }
                     }
                 }
         );
     }


    /*Aquí se define el movimiento que tendrá la pelota después de el primer click invocando al método
    * movimiento de la clase fisicaPelota */
     @Override
     public void run() {
         while (hilo != null)
         {
             try {
                 hilo.sleep(3);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             for (int i = 0; i < espacioPelotas.pelotas.length; i++)
             {
                 if (espacioPelotas.pelotas[i] != null)
                 {
                     Dimension dimensionApplet = new Dimension();
                     dimensionApplet.setSize(appletPelota.getWidth(), appletPelota.getHeight() - 21);
                     espacioPelotas.pelotas[i].setPosicionAct(
                             fisicaPelota.movimiento(espacioPelotas.pelotas[i],dimensionApplet, espacioPelotas.pelotas));
                 }

             }
             espacioPelotas.repaint();
         }
     }
    /*Método encargado de crear pelotas y llamar al método crear pelotas para almacenarlas*/
    public void crearPelota()
    {
        Dimension posicionInicial = new Dimension(appletPelota.getWidth() / 2, appletPelota.getHeight() / 2);
        Pelota pelota = new Pelota(posicionInicial,
                30, fisicaPelota.colorAleatorio(),
                fisicaPelota.desplazamientoAleatorio(),
                fisicaPelota.desplazamientoAleatorio());

        espacioPelotas.crearPelota(pelota);
    }
 }