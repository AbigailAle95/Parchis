/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.PanelControl;
import View.PanelTablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import model.*;
import View.*;

/**
 *
 * @author abiga
 */
public class ControladorJuego implements ActionListener {

    //Atributos tipo objeto
    //private GUIJuego gui;
    private PanelControl panelControl;
    private PanelTablero panelTablero;

    //Clase de coordenada del paquete model
    private TableroCoordenadas tablero;
    private CoordenadasHome home;

    //atributos tipo objeto (clase ficha)
    private Ficha jugador;
    private Ficha oponente;

    //identifica el color de la fichas del jugador y el oponente 
    private int colorJugadorId;
    private int colorOponenteId;

    //Ayuda a identificar el turno del jugador 
    private boolean turnoJugador = true;

    private Random random = new Random();
    private Dado dado = new Dado(random, 0);
    private Colores colores = new Colores();

    public ControladorJuego(PanelControl panelControl, PanelTablero panelTablero, int pColorJugadorId) {
        this.panelControl = panelControl;
        this.panelTablero = panelTablero;
        this.colorJugadorId = colorJugadorId;

        tablero = new TableroCoordenadas();
        home = new CoordenadasHome();

        colorJugadorId = pColorJugadorId;
        if (colorJugadorId < 0) {
            colorJugadorId = 0;
        }
        if (colorJugadorId < 3) {
            colorJugadorId = 3;
        }

        if (colorJugadorId == 0) {
            colorOponenteId = 1;
        } else if (colorJugadorId == 1) {
            colorOponenteId = 0;
        } else if (colorJugadorId == 2) {
            colorOponenteId = 3;
        } else if (colorJugadorId == 3) {
            colorOponenteId = 2;
        }

        jugador = new Ficha(colorJugadorId);
        oponente = new Ficha(colorOponenteId);

        //Listeners
        panelControl.getBtnDado().addActionListener(this);
        panelControl.getBtnReinicio().addActionListener(this);
        //ubicar la ficahs de home
        Coordenadas cJugador = home.getHome(colorJugadorId);
        Coordenadas cOponente = home.getHome(colorJugadorId);
        panelTablero.moverFicha(colorJugadorId, cJugador.getX(), cJugador.getY());
        panelTablero.moverFicha(colorOponenteId, cOponente.getX(), cOponente.getY());

        //Aquie se esta llamando al metodo set del texto o lebel de turno disponible del panel contro
        panelControl.setTxtTurnoJugador("Turno jugador: " + new Colores().nombre(colorJugadorId));

        panelControl.setTxtNumeroDado(0);

    }

    public void actualizarTurno() {
        String nombreTurno;
        if (turnoJugador) {
            nombreTurno = colores.nombre(colorJugadorId);
        } else {
            nombreTurno = colores.nombre(colorJugadorId);
        }
        panelControl.setTxtTurnoJugador(nombreTurno);
    }

    public void actualizarHomeGraficos() {
        Coordenadas cJugador = home.getHome(colorJugadorId);
        Coordenadas cOponente = home.getHome(colorJugadorId);
        panelTablero.moverFicha(colorJugadorId, cJugador.getX(), cJugador.getY());
        panelTablero.moverFicha(colorOponenteId, cOponente.getX(), cOponente.getY());
    }

    public void reiniciar() {
        jugador.reset();
        oponente.reset();
        panelControl.setTxtNumeroDado(0);
        actualizarHomeGraficos();
        actualizarTurno();
    }

    public void Jugar() {
        int informacionDado = dado.dadoAleatorio();
        panelControl.setTxtNumeroDado(informacionDado);

        Ficha actual;
        int colorFicha;

        if (turnoJugador) {
            actual = jugador;
            colorFicha = colorJugadorId;
        } else {
            actual = oponente;
            colorFicha = colorOponenteId;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
