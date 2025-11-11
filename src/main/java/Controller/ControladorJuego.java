/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import model.*;//Se importan todas las clses del paquete
import View.*;//Se importan todas las clses del paquete

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

    private Reglas reglas;

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

    //Constructor
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
    }//fin de metodo
    
    public void alternarTurno(){
        if (turnoJugador){
            turnoJugador = false;
        }else{
            turnoJugador = ;
        }
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
        //Variable que viene de la clase dado para llamar el metodo
        int step = dado.dadoAleatorio();
        //usamos el set del número que viene del panel
        panelControl.setTxtNumeroDado(step);

        //Es un variable tipo objeto
        Ficha actual;
        int colorFicha;

        if (turnoJugador) {
            actual = jugador;
            colorFicha = colorJugadorId;
        } else {
            actual = oponente;
            colorFicha = colorOponenteId;
        }

        if (actual.isPoseInicial()) {
            if (reglas.salir(step)) {
                //actual es la clase ficha. Los metodos que aplicamos son:
                //indice, setPosicionInicial, caminoWin, pasoWin.
                int exit = reglas.salidaId(colorFicha);
                actual.setIndice(exit);
                actual.setPoseInicial(false);
                actual.setCaminoWin(false);
                actual.setPasoWin(0);
                pintarRecorrido(actual, colorFicha);

            } else {
                //Metodos que existen en esta clase (ControladosJuego)
                actualizarTurno();
                alternarTurno();
                return;
            }}else if (!actual.isCaminoWin()) {
                        //Cruza la entrada a camino win?
                        int d = actual.getIndice();
                        if (reglas.entradaWin(colorFicha, d)) {
                            actual.setCaminoWin(true);
                            actual.setPasoWin(0);
                        }//termina el primer if del else if
                        actualizarTurno();
                        alternarTurno();
                        return;
                    }//Cierre del else if
        //step es la variable de información
        //Ya la ficha avanza por el camino Win
        int newStep = actual.getPasoWin()+step;
        actual.setPasoWin(newStep);
        pintarCaminoWin(actual, colorFicha,step);
        //Nosotros tenemos que hacer esto
        //Aqui se pone una verificación de que la ficha esta en la meta y mandar un mansaje con el JOpane
        //Ya llego a la meta
        actualizarTurno();
        alternarTurno();
        }//Metodo jugar

    

    public void pintarRecorrido(Ficha ficha, int colorId) {
        Coordenadas c = tablero.getPosicion(ficha.getIndice());
        panelTablero.moverFicha(colorId, c.getX(), c.getY());
    }

    private void pintarCaminoWin(Ficha ficha, int colorId, int steps) {
        Coordenadas c = tablero.getCaminoWin(colorId, steps);
        panelTablero.moverFicha(colorId, c.getX(), c.getY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object r = e.getSource();
        if(r == panelControl.getBtnDado()){
            Jugar();
        }else if (r == panelControl.getBtnDado()){
            
        }
    }
}
