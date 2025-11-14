/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Random;

/**
 *
 * @author abiga
 */
public class Dado {

    private Random random;

    public Dado() {
        random = new Random();
    }

    public int lanzar() {
        return random.nextInt(6) + 1;

    }

}
