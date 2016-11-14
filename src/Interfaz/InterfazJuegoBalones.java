package Interfaz;

import Mundo.*;
import Hilos.*;
import javax.swing.*;
import java.awt.*;

// AppletPelota.java

public class InterfazJuegoBalones extends JFrame{
    private Cancha espacioPelotas;
    private PanelCancha fisicaPelota;

    public InterfazJuegoBalones()
    {
        setSize(500, 400);
        Container panel = getContentPane();
        panel.setLayout(new BorderLayout());
        fisicaPelota = new PanelCancha();
        espacioPelotas = new Cancha(20);
        Puntaje contadorPelotas = new Puntaje(1);
        new HiloBalon(espacioPelotas, fisicaPelota, this,  contadorPelotas);
        add(espacioPelotas, BorderLayout.CENTER);
        add(contadorPelotas, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void start(){}
    public void stop(){}
}

