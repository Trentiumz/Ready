/* Ryan Atlas, Judah Brill & Daniel Ye
   November 9th, 2021
   Ms. Basaraba
   This class will display the bomb that is dropped from the plane, onto the city */

package MyCreation;

import hsa.Console;

import java.awt.*;

public class Bomb extends Thread {

    private Console c;

    public void bomb() { //bomb method

        Color silver = new Color(192, 192, 192); // create a silver colour
        Color gold = new Color(255, 215, 0); // create a gold colour
        Color skyBlue = new Color(135, 206, 235); // colour variable for sky blue colour, the background colour

        for (int i = 30; i < 210; i += 5) { // for loop to animate shapes
            c.setColor(silver); // set colour to silver
            c.fillOval(425, 125 + i, 50, 75); // draw main part of the bomb
            c.setColor(silver); // set colour to silver
            c.fillRoundRect(425, 110 + i, 50, 25, 25, 25); // draw tail of bomb


            c.setColor(Color.BLACK); // set colour to black
            c.drawLine(430, 175 + i, 470, 175 + i); // draw stripe on bomb
            c.setColor(Color.BLACK); // set colour to black
            c.fillArc(430, 125 + i, 40, 10, 180, 180); // create arc on bomb tail

            c.setColor(gold); // set colour to gold
            c.fillStar(442, 145 + i, 15, 15); // draw star on bomb

            try {
                sleep(50); // set the speed of the bomb animation
            } catch (Exception e) {
            }

            c.setColor(skyBlue); // set colour to sky blue to create 'erasing' shapes

            // erasing shapes
            c.fillRect(425, 110+i, 50, 100);
        }
    }

    public Bomb(Console con) { // bomb class constructor
        c = con;
    }

    public void run() { // run the thread
        bomb();
    }
}