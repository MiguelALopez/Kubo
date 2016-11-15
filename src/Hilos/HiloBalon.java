package Hilos;

import Interfaz.*;
import Mundo.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

// MovimientoBalon.java

public class HiloBalon implements Runnable{
    Thread hilo;

    private Cancha cancha;
    private PanelCancha panelCancha;
    private InterfazJuegoBalones appletBalon; // Main class
    private Puntaje contadorRebotes;
    private MenuVer menuVer;
    public HiloBalon(final Cancha cancha, PanelCancha panelCancha, InterfazJuegoBalones appletBalon, final Puntaje contadorRebotes, final MenuVer menuVer) {
        this.cancha = cancha;
        this.panelCancha = panelCancha;
        this.appletBalon = appletBalon;
        this.contadorRebotes = contadorRebotes;
        this.menuVer = menuVer;

        crearBalon();
        hilo = new Thread(this);
        if (!hilo.isAlive())
        {
            hilo.start();
        }
        for (int i = 0; i < (contadorRebotes.getNumBalons()-1); i++) 
        {
            crearBalon();
        }
        cancha.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        int total = cancha.pelotas.length;
                        int rebotes = 0;
                        for (int i = 0; i < cancha.pelotas.length; i++) {
                            cancha.pelotas[i].checkAcierto(e.getX(), e.getY());
                            if(!cancha.pelotas[i].isRunning())
                                total -= 1;
                            rebotes += cancha.pelotas[i].getRebotes();
                        }
                        if ( total == 0 )
                        {
                            JOptionPane.showMessageDialog(null, "Ganaste con " + (rebotes - 1) + " rebotes");
                            if ( (rebotes-1) < menuVer.getFullScore() )
                            {
                                String player = JOptionPane.showInputDialog(null, "Digita tu nombre:");
                                menuVer.addPlayer(player, rebotes - 1);
                            }
                            
                        }
                            
//                        System.out.println(e.getX()+ " " + e.getY());
                    }
                }
        );
//        cancha.addMouseListener(
//            new MouseAdapter() {
//                @Override
//                public void mouseClicked(MouseEvent event) {
//                    if (!hilo.isAlive()){
//                        hilo.start();
//                    }else {
//                        crearBalon();
//                        contadorRebotes.refrescarBalons(cancha.numBalons);
//                    }
//                }
//            }
//        );
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
            for (int i = 0; i < cancha.pelotas.length; i++)
            {
                if (cancha.pelotas[i] != null)
                {
                    // contadorRebotes.contarRebotes();
                    Dimension dimensionFrame = new Dimension();
                    dimensionFrame.setSize(appletBalon.getWidth(), appletBalon.getHeight() - 21);
                    cancha.pelotas[i].setPosicionAct(
                            panelCancha.movimiento(cancha.pelotas[i],dimensionFrame, cancha.pelotas));
                }
            }
            cancha.repaint();
        }
     }
    /*Método encargado de crear pelotas y llamar al método crear pelotas para almacenarlas*/
    public void crearBalon()
    {
        // Crear balones en posiciones aleatorias sin salirse de la pantalla
        double t_posx = Math.random() * (appletBalon.getWidth() - 150);
        double t_posy = Math.random() * (appletBalon.getHeight() - 150);
        int posx = (int) t_posx;
        int posy = (int) t_posy;
        if (posx < 30)
            posx= 30 ;
        if (posy < 30)
            posy = 30;
        double t_radio = 0;
        while (t_radio < 30 )
        {
            t_radio = Math.random() * 70;
        }
        /*
        if ( posx - t_radio < 0 )
            t_radio=posx-5;
        if ( posy - t_radio < 0 )
            t_radio=posy-5;
        if (posx+t_radio>appletBalon.getWidth()-30)
            t_radio= appletBalon.getWidth()-posx-5;
        if (posy+t_radio>appletBalon.getHeight()-30)
            t_radio = appletBalon.getHeight()-posy-5;
        */ 
        int radio = (int) t_radio;
        Dimension posicionInicial = new Dimension(posx, posy);
        Balon pelota = new Balon(posicionInicial,
                radio, panelCancha.colorAleatorio(),
                panelCancha.desplazamientoAleatorio(),
                panelCancha.desplazamientoAleatorio());

        cancha.crearBalon(pelota);
    }


 }