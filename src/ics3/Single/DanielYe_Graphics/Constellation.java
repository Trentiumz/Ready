package ics3.Single.DanielYe_Graphics;

/*
* Daniel Ye & Shane Chen
* October 27, 2021
* Ms. Basaraba
* This program displays a trading card of the constellation Cancer, complete with a paragraph with a description of what the cancer constellation entails
 */

import hsa.Console;

import java.awt.*;

public class Constellation {

    Console c;

    public Constellation() {
        c = new Console("The Cancer Constellation");
    }

    public void display(){
        drawFront();
        c.getChar();
        drawConstellation();
    }

    private void drawFront(){
        c.setColor(new Color(255, 0, 0));
        c.drawRect(0, 0, 10, 10);
    }

    private void drawConstellation(){
        c.drawRect(0, 0, 100, 100);
    }

    public static void main(String[] args){
        Constellation program = new Constellation();
        program.display();
    }

}
