/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.net.URL;
import javax.sound.sampled.*;

/**
 *
 * @author abiga
 */
public class Sonidos {

    private Clip musica;

    private Clip cargar(String ruta) {
        try {
            URL u = getClass().getResource(ruta);
            AudioInputStream ais = AudioSystem.getAudioInputStream(u);
            Clip c = AudioSystem.getClip();
            c.open(ais);
            return c;
        } catch (Exception e) {
            return null;
        }
    }//fin

    public void musicaFondo() {
        musica = cargar("/sonidos/");
        if (musica != null) {
            musica.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void musicaFondoPrincipal() {
        musica = cargar("/sonidos/");
        if (musica != null) {
            musica.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void detenerFondo() {
        if (musica != null) {
            musica.stop();
        }
    }

    public void click() {
        Clip c = cargar("/sonidos/");
        if (c != null) {
            c.start();
        }
    }

    public void ganar() {
        Clip c = cargar("/sonidos/");
        if (c != null) {
            c.start();
        }
    }
    
    
//INCLUIR SONIDOS Y LAS DIRECCIONES URL}
    
}
