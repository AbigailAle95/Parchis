/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author abiga
 */
public class Preguntas {

    private Random random = new Random();

    //Son al reddedor de 15 preguntas entre los 3 niveles (Recordar cambiar las preguntas de los arreglos)
    private String[][] facil = {{"¿Ghost es una banda sueca formada en 2006", "V"}
            , {"Ghost gano un Grammy por la canción Cirice en 2016","V"}
            ,{"", ""}};
    //Hacer mas preguntas puede ser temas variados

    private String[][] medias = {{"El vocalista de la banda cambia de personaje entre Papa Emeritus y Cardinal Copia?", "V"}};
    //Hacer mas preguntas puede ser temas variados

    private String[][] dificiles = {{"System.out.println(''Texto'') imprime en pantalla?", "V"}};
    //Hacer mas preguntas puede ser temas variados

    public boolean preguntasVF(int dificultad) {
        String[][] banco;
        if (dificultad == 1) {
            banco = facil;
        } else if (dificultad == 2) {
            banco = medias;
        } else {
            banco = dificiles;
        }
        //
        int indice = random.nextInt(banco.length);
        String pregunta = banco[indice][0];
        String respuesta = banco[indice][1];

        String titulo = "Pregunta";

        int opcion = JOptionPane.showConfirmDialog(
                null, pregunta + "\n\n Seleccione: Si = verdadero, No = Falso",
                titulo, JOptionPane.YES_NO_OPTION);

        String respuestaJugador;
        if (opcion == JOptionPane.YES_OPTION) {
            respuestaJugador = "V";
        } else {
            respuestaJugador = "F";
        }
        boolean correcta;
        if (respuestaJugador.equalsIgnoreCase(respuesta)) {
            correcta = true;
        } else {
            correcta = false;
        }

        String mensaje = null;
        if (correcta) {
            if (dificultad == 1) {
                mensaje = "Correcto ganaste 1 punto";
            } else if (dificultad == 2) {
                mensaje = "Correcto ganaste 2 puntos";
            } else {
                mensaje = "Correcto ganaste 3 puntos";
            }
        }

        if (correcta) {
            if (dificultad == 1) {
                mensaje = "Incorrecto perdiste 1 punto";
            } else if (dificultad == 2) {
                mensaje = "Incorrecto perdiste 2 puntos";
            } else {
                mensaje = "Incorrecto perdiste 3 puntos";
            }
        }

        JOptionPane.showMessageDialog(null, mensaje);

        return correcta;
    }//Fin el metodo

}
