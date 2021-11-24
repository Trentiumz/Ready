/* Ryan Atlas, Judah Brill & Daniel Ye
   November 9th, 2021
   Ms. Basaraba
   This class will display the missile that is shot from one plane to another. It will use Extends Thread */

package MyCreation;
import hsa.Console;
import java.awt.*;
import java.lang.*;


public class Missile extends Thread {

    private Console c;

    public void missile(){
        Color silver = new Color(192, 192, 192); // create a silver colour
        Color skyBlue = new Color(135, 206, 235); // colour variable for sky blue colour, the background

        for (int i =1; i <= 140; i += 8){ // for loop to animate missile
            c.setColor(Color.red); // set colour to red
            c.fillArc(500-i, 210, 75, 15, 90, -180 ); // draw the back end of the missile

            c.fillArc(525-i, 195, 35, 35, 90, 90); //draw the top fin
            c.fillArc(525-i, 205, 35, 35, 180, 90); //draw the bottom fin

            c.setColor(silver); // set colour to silver
            c.fillRect(450-i, 210, 100, 15); // draw body/main part of missile

            c.setColor(Color.black); // set colour to black
            c.drawLine(475-i, 217, 525-i, 217); //draw line on missile body

            int [] topTriangleX = {500-i, 525-i, 475-i}; // x points for top triangle of missile
            int [] topTriangleY = {210, 195, 210}; // y points for top triangle of missile

            int [] bottomTriangleX = {500-i, 525-i, 475-i}; // x points for bottom triangle of missile
            int [] bottomTriangleY = {225, 240, 225}; // y points for bottom triangle of missile
            c.setColor(Color.red); // set colour to red
            c.fillPolygon(topTriangleX, topTriangleY, 3); // draw top triangle
            c.setColor(Color.red); // set colour to red
            c.fillPolygon(bottomTriangleX, bottomTriangleY, 3); // draw bottom triangle

            int [] tipTriangleX = {450-i, 450-i, 400-i}; // x points for triangle on the tip of the missile
            int [] tipTriangleY = {210, 225, 217}; // y points for triangle on the tip of the missile
            c.setColor(Color.red); // set colour to red
            c.fillPolygon(tipTriangleX, tipTriangleY, 3); // draw triangle on tip of missile

            c.setColor(Color.red); // set colour to red
            c.fillArc(425-i, 210, 50, 15, 90, 180); // draw arc on tip of missile

            try {
                sleep(50); // delay the thread speed
            }
            catch(Exception e)
            {
            }

            // shapes to erase missile
            c.setColor(skyBlue); // Set color to sky blue
            c.fillArc(500-i, 210, 75, 15, 90, -180 );
            c.setColor(skyBlue); // Set color to sky blue
            c.fillRect(450-i, 210, 100, 15);
            c.setColor(skyBlue); // Set color to sky blue
            c.fillArc(525-i, 195, 35, 35, 90, 90);
            c.setColor(skyBlue); // Set color to sky blue
            c.fillArc(525-i, 205, 35, 35, 180, 90);
            c.setColor(skyBlue); // Set color to sky blue
            c.fillPolygon(topTriangleX, topTriangleY, 3);
            c.setColor(skyBlue); // Set color to sky blue
            c.fillPolygon(bottomTriangleX, bottomTriangleY, 3);
            c.setColor(skyBlue); // Set color to sky blue
            c.fillArc(400-i, 210, 50, 25, 90, 180);
            c.setColor(skyBlue); // Set color to sky blue
            c.fillPolygon(tipTriangleX, tipTriangleY, 3);
        }
    }

    public Missile(Console con){ // missile class constructor
        c = con;
    }

    public void run(){ // run the thread
        missile();
    }

}