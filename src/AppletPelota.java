/***********************************************
 Autor: Miguel Angel Lopez Fernandez
 Código: 1326691
 Plan: Ingeniería de sistemas - 3743
 Nombre del archivo: AppletPelota.java
 Fecha: 03-nov-2014
 *************************************************/
package Punto3;

import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;

public class AppletPelota extends JApplet{

    private EspacioPelotas espacioPelotas;
    private FisicaPelota fisicaPelota;
    AudioClip sonidoRebote;
    AudioClip sonidoColor;

    public  void init()
    {
        setSize(500, 400);
        getContentPane().setLayout(new BorderLayout());

        sonidoRebote = getAudioClip(getDocumentBase(), "boing.aif");
        sonidoColor = getAudioClip(getCodeBase(), "hi.au");
        fisicaPelota = new FisicaPelota(sonidoRebote, sonidoColor);
        espacioPelotas = new EspacioPelotas(20);
        ContadorPelotas contadorPelotas = new ContadorPelotas(1);
        new MovimientoPelota(espacioPelotas, fisicaPelota, this,  contadorPelotas);
        add(espacioPelotas, BorderLayout.CENTER);
        add(contadorPelotas, BorderLayout.SOUTH);
    }
    public void start(){}
    public void stop(){}
}
