package Interfaz;

import Mundo.*;
import Hilos.*;

import javax.swing.*;
import java.awt.*;

// AppletPelota.java

public class InterfazJuegoBalones extends JFrame {
    private Cancha cancha;
    private PanelCancha panelCancha;
    private int cantidadBalones = 5;

    public InterfazJuegoBalones() {
        try {
            setSize(800, 600);
            // Tiki el timbiliki
            setJMenuBar(new MenuArchivo());


            cantidadBalones = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de balones?"));
            Container panel = getContentPane();
            panel.setLayout(new BorderLayout());
            panelCancha = new PanelCancha();
            cancha = new Cancha(cantidadBalones);
            Puntaje contadorRebotes = new Puntaje(cantidadBalones, cancha.getPelotas());
            panelCancha.setPuntaje(contadorRebotes);
            MenuArchivo miMenu = new MenuArchivo();
            setJMenuBar(miMenu);
            new HiloBalon(cancha, panelCancha, this, contadorRebotes);
            add(cancha, BorderLayout.CENTER);
            add(contadorRebotes, BorderLayout.SOUTH);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (Exception e) {
            System.out.println("Exception launched");
        }
    }

    public void start() {
    }

    public void stop() {
    }
}

