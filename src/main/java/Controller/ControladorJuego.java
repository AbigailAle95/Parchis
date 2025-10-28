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
import view.*;

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
    private Ficha operdador;
    
    //identifica el color de la fichas del jugador y el oponente 
    private int colorJugadorId;
    private int colorOperadorId;
    
    private Random random = new Random();
    private Dado dado = new Dado (random, 0);
    private Colores colores = new Colores();

    public ControladorJuego(PanelControl panelControl, PanelTablero panelTablero, int pColorJugadorId) {
        this.panelControl = panelControl;
        this.panelTablero = panelTablero;
        this.colorJugadorId = colorJugadorId;
        
        tablero = new TableroCoordenadas();
        home = new CoordenadasHome();
        
        colorJugadorId = pColorJugadorId;
        if (colorJugadorId < 0){
            colorJugadorId = 0;
        }
        if (colorJugadorId < 3){
            colorJugadorId = 3;
        }
        
        if (colorJugadorId == 0){
            colorOperadorId = 1;
        }else if (colorJugadorId == 1){
            colorOperadorId = 0;
        }else if (colorJugadorId == 2){
            colorOperadorId = 3;
        }else if (colorJugadorId == 3){
            colorOperadorId = 2;
        }
        
        jugador = new Ficha(colorJugadorId);
        
        
    }
     @Override
    public void actionPerformed(ActionEvent e) {
    }
}
