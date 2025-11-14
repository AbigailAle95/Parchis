/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import View.PanelControl;
import javax.swing.SwingUtilities;

/**
 *
 * @author abiga
 */
public class Temporizador extends Thread {
    
    private PanelControl panel;
    private boolean activo;
    private int segundos;

    public Temporizador(PanelControl panel) {
        this.panel = panel;
        this.activo = true;
        this.segundos = 0;
    }
    
    //Metodo run 
    public void run (){
        while (activo){
            try {
                Thread.sleep(1000);//un segundo
            } catch(InterruptedException e) {
                activo = false;
                break;
            }
            segundos++;               
            SwingUtilities.invokeLater(new Runnable(){
                
            
            public void run (){
                panel.setTxtTiempo(segundos);
            }
        });
        
    }
    }

        public void detener(){
            activo = false;
            interrupt();
        }
        public void reiniciar (){
            segundos = 0;
            SwingUtilities.invokeLater(new Runnable(){
                
            
            public void run (){
                panel.setTxtTiempo(segundos);
                
            }
        });
            
        }
    }
