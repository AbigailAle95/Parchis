/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author abiga
 */
public class CoordenadasHome {

    private Coordenadas[] home = new Coordenadas []{

        new Coordenadas(77,64),//Rojo
        new Coordenadas(401,63),//Azul
        new Coordenadas(78,388),//Verde
        new Coordenadas(401,388)//Amarillo
    };
    
    public Coordenadas getHome (int colorId){
        if(colorId < 0){
            colorId = 0;
        }
        if(colorId > 3){
            colorId = 3;
        }
        return home[colorId];
    }
}//fin de clase 
