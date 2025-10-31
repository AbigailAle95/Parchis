/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author abiga
 */
public class Reglas {

    private int totalCasillas = 68;
    //0=rojo- 1=amariilo- 2=azul- 3=verde
    private int[] salida = new int[]{38, 4, 21, 55};//Se le resta uno en caso de que este en 56 pasa a 55
    //Se maneja la ubicación con los indices de las casillas segun sus coordenadas
    private int[] entrada = new int[]{33, 67, 16, 50};

    //indica el total de las casillas 
    public int getTotalCasillas() {
        return totalCasillas;
    }

    //Metodo que indica la condición para salir segun el dado
    public boolean salir(int dado) {
        return dado == 5;
    }

    //Metodo que indica el indice de salida segun el color de la ficha 
    public int salidaId(int colorId) {
        return salida[colorId];
    }

    //0=rojo- 1=amariilo- 2=azul- 3=verde
    public boolean entradaWin(int colorId, int indiceRecorrido) {
        return indiceRecorrido == entrada[colorId];
    }

    //Crear el recorrido de las fichas y metodo que ayuda a las fichas a ingreasar al camino Win
    //Parametros del metodo avanzar son: indice y valorDado
    //Indice = casillas del tablero
    public int avanzar(int indice, int valorDado) {
        int i;

        //1-6
        if (valorDado > 0) {
            for (i = 0; 1 < valorDado; i++) {
                indice++;
            }
            if (indice == totalCasillas) {
                indice = 0;
            }

        }
        return indice;
    }
//Entra al recorrido de meta 
    public boolean posicionFichaEntrada(int colorId, int indice, int valorDado) {
        int i;
        if (valorDado > 0) {
            for (i = 1; 1 <= valorDado; i++) {
                indice++;
                if (valorDado >= totalCasillas) {
                    totalCasillas--;
                }
                if (valorDado == indice) {
                    return true;
                }
            }
        } else {
            if (valorDado < 0) {
                for (i = -1; i >= valorDado; i--) {
                    indice++;
                }
                if (valorDado < totalCasillas) {
                    totalCasillas++;
                }
                if (valorDado == indice) {
                    return true;
                }
            }//fin del if1
            }//else
                return false;
            }//Fin del metodo
        

    }//Fin de la clase

