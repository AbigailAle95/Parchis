/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author abiga
 */
public class Ficha {
    private int color;
    private String colorNombre;
    private int salida,totalCasillas, indice;
    private boolean poseInicial;
    private boolean caminoWin;
    private int pasWin;

    public Ficha(int pColor, int salida, int totalCasillas) {
        color = pColor;
        colorNombre = new Colores().nombre(pColor)
        salida = salida;
        totalCasillas = totalCasillas;
        indice = -1;// representa la casa
        poseInicial = true;
        caminoWin = true;
    }//Fin de constructor

    public int getColor() {
        return color;
    }//Fin de get
    
    public boolean home(){
        return poseInicial;
    }//Fin de house
    
    public void fichaFuera(){
        poseInicial=false;
    }//fin del void
}
