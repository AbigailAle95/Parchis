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
    private int salida, totalCasillas, indice;
    private boolean poseInicial;
    private boolean caminoWin;
    private int pasoWin;
    private int puntos;

    public Ficha(int pColor) {
        color = pColor;
        colorNombre = new Colores().nombre(pColor);
        salida = salida;
        totalCasillas = totalCasillas;
        indice = -1;// representa la casa
        poseInicial = true;
        caminoWin = true;
        pasoWin = 0;
        
    }//Fin de constructor

    //get y set
    
    
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getColorNombre() {
        return colorNombre;
    }

    public void setColorNombre(String colorNombre) {
        this.colorNombre = colorNombre;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public int getTotalCasillas() {
        return totalCasillas;
    }

    public void setTotalCasillas(int totalCasillas) {
        this.totalCasillas = totalCasillas;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public boolean isPoseInicial() {
        return poseInicial;
    }

    public void setPoseInicial(boolean poseInicial) {
        this.poseInicial = poseInicial;
    }

    public boolean isCaminoWin() {
        return caminoWin;
    }

    public void setCaminoWin(boolean caminoWin) {
        this.caminoWin = caminoWin;
    }

    public int getPasoWin() {
        return pasoWin;
    }

    public void setPasoWin(int pasoWin) {
        this.pasoWin = pasoWin;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int valor) {
        if (puntos > 0){
            puntos = puntos + valor;
        }
    }
    public void restarpuntos (int valor){
        
    }

    public void reset() {
        indice = -1;
        pasoWin = 0;
        poseInicial = true;// en casa
        caminoWin = false;//
    }

}
