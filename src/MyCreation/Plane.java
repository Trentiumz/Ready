package MyCreation;
/* Ryan Atlas, Daniel Ye and Judah Brill
   November 9th, 2021
   Ms. Basaraba
   This program will create the overloaded Plane class that appears in the
   main MyCreation.java file. This program creates and animates the planes.
   This program will use implements Runnable to run on its own Thread. */

import hsa.Console;  // Gives access to the Console class in the hsa package
import java.awt.*; // Gives access to the Java command libraries
import java.lang.*; // Gives acces to the Thread class

public class Plane implements Runnable
{
    private Console c; // Allows for the use of Console commands
    private Color planeBody; // Color of the plane body
    private int dist; // Distance the plane travels
    private int x; // X Coordinate of the plane
    private int y; // Y Coordinate of the plane

    public void plane ()  // plane() method
    {
        Color lightBlue = new Color (42, 191, 245); // Makes a new light blue colour
        Color skyBlue = new Color (135, 206, 235); // Makes a new sky blue colour
        for (int i = dist ; i > 0 ; i-=7) // For loop controls animation
        {
            c.setColor(lightBlue); // Sets the cockpit colour to light blue
            c.fillArc((x+20)+i, y-5, 40, 15, 205, -200);
            c.setColor (planeBody); // Sets the plane body colour
            c.fillArc (x + i, y, 110, 40, 0, 180);
            c.setColor (planeBody);
            c.fillArc (x + i, y+15, 110, 10, 0, -180);
            c.setColor(Color.BLACK); // Sets colour to black
            c.fillRoundRect((x+95)+i, y, 20, 18, 10, 10);
            c.setColor (planeBody);
            int[] xPoints = {(x + 45) + i, (x + 52) + i, (x + 72) + i, (x + 68) + i};
            int[] yPoints = {y + 15, y + 40, y + 40, y + 15};
            c.fillPolygon (xPoints, yPoints, 4);
            c.setColor (planeBody);
            c.fillArc((x+52)+i, y+35, 20, 10, 0, -180);
            int[] xPoints2 = {(x+90)+i, (x+110)+i, (x+110)+i, (x+80)+i};
            int[] yPoints2 = {y-5, y-5, y+20, y+20};
            c.setColor (planeBody);
            c.fillPolygon (xPoints2, yPoints2, 4);
            c.setColor (planeBody);
            c.fillArc((x+90)+i, y-10, 20, 10, 0, 180);
            c.setColor(Color.RED); // Sets colour to red
            c.fillOval((x+95)+i, y-5, 12, 12);
            c.setColor(Color.YELLOW); // Sets colour to yellow
            c.fillStar((x+96)+i, y-5, 10, 10); // Finishes the drawing of the plane

            try
            {
                Thread.sleep (112); // Waits for 80 milliseconds before continuing
            }
            catch (Exception e)
            {
            }

            // Erases drawing
            c.setColor(skyBlue); // Sets the colour to same colour as the sky to erase the plane as it goes
            c.fillRect(x+i, y-10, 140, 55);
            // c.fillArc((x+20)+i, y-5, 40, 15, 205, -200);
            // c.fillArc (x + i, y, 110, 40, 0, 180);
            // c.fillArc (x + i, y+15, 110, 10, 0, -180);
            // c.fillPolygon (xPoints, yPoints, 4);
            // c.fillArc((x+52)+i, y+35, 20, 10, 0, -180);
            // c.fillPolygon (xPoints2, yPoints2, 4);
            // c.fillArc((x+91)+i, y-10, 19, 10, 0, 180);
            // c.fillRoundRect((x+95)+i, y, 20, 18, 10, 10); // Erases the plane as it moves
        }
    }


    public Plane (Console con, int locX, int locY)  // First Plane class constructor
    {
        c = con;
        x = locX;
        y = locY;
        planeBody = new Color (128, 128, 128); // Makes the plane's default colour grey
        dist = 700; // Makes distance's default distance 700
    }


    public Plane (Console con, int locX, int locY, Color col)  // Second Plane class constructor
    {
        c = con;
        x = locX;
        y = locY;
        planeBody = col; // Sets the plane's colour to what is defined in the parameter
        dist = 700; // Makes distance's default distance 700
    }


    public Plane (Console con, int locX, int locY, Color col, int distance)  // Third Plane class constructor
    {
        c = con;
        x = locX;
        y = locY;
        planeBody = col; // Sets the plane's colour to what is defined in the parameter
        dist = distance; // Makes distance's whatever is set in the parameter
    }


    public void run () // Run method for the Thread
    {
        plane (); // Calls the plane method
    }
}
