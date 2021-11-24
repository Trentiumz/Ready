package MyCreation;
/* Ryan Atlas, Daniel Ye and Judah Brill
   November 9th, 2021
   Ms. Basaraba
   This program will create the parachute and person that
   ejects from the plane after it is hit with a missile.
   This program will use implements Runnable to run on its
   own Thread. */

import hsa.Console;  // Gives access to the Console class in the hsa package
import java.awt.*; // Gives access to the Java command libraries
import java.lang.*; // Gives acces to the Thread class

public class Parachute implements Runnable
{
    private Console c; // Allows for the use of Console commands
    public void parachute ()  // parachute() method
    {
        Color coat = new Color (34, 189, 34);
        Color parachuteCloth = new Color (255, 255, 255);
        Color skyBlue = new Color (135, 206, 235);
        for (int i = 250 ; i < 420 ; i++)
        {
            // Parachute cloth and pack
            c.setColor (parachuteCloth);
            c.fillRoundRect (102, i + 2, 18, 28, 10, 10);
            c.setColor (parachuteCloth);
            c.fillArc (82, i - 41, 58, 49, 0, 180);

            // Parachute and pack outlines
            c.setColor (Color.BLACK); // Sets colour to black
            c.drawRoundRect (100, i, 20, 30, 10, 10);
            c.drawArc (80, i - 42, 60, 50, 0, 180);
            c.setColor (Color.BLACK);
            c.drawArc (82, i - 20, 9, 10, 0, 180);
            c.setColor (Color.BLACK);
            c.drawArc (132, i - 20, 9, 10, 0, 180);
            c.setColor (Color.BLACK);
            c.drawArc (92, i - 20, 9, 10, 0, 180);
            c.setColor (Color.BLACK);
            c.drawArc (102, i - 20, 9, 10, 0, 180);
            c.setColor (Color.BLACK);
            c.drawArc (112, i - 20, 9, 10, 0, 180);
            c.setColor (Color.BLACK);
            c.drawArc (122, i - 20, 9, 10, 0, 180);

            c.setColor (coat);
            for (int j = 108 ; j < 113 ; j++) // For loop that draws the coat with lines (can't rotate rectangles)
            {
                c.drawLine (j, i, j, i + 27);
                c.drawLine (j - 15, i + 10, j - 5, i + 10);
                c.drawLine (j - 15, i + 9, j - 5, i + 9);
                c.drawLine (j - 15, i + 11, j - 5, i + 11);
                c.drawLine (j + 15, i + 10, j - 5, i + 10);
                c.drawLine (j + 15, i + 9, j - 5, i + 9);
                c.drawLine (j + 15, i + 11, j - 5, i + 11);
                c.drawLine (j, i + 27, j + 9, i + 37);
                c.drawLine (j, i + 27, j - 9, i + 37);
            }
            // Helmet
            c.setColor (Color.black);
            c.fillOval (103, i - 7, 15, 15);

            // Hands
            c.setColor (Color.black);
            c.fillOval (93, i + 9, 4, 4);
            c.setColor (Color.black);
            c.fillOval (123, i + 9, 4, 4);

            // Ropes
            c.setColor (Color.black);
            c.drawLine (103, i + 9, 90, i - 15);
            c.setColor (Color.black);
            c.drawLine (118, i + 9, 131, i - 15);
            c.setColor (Color.black);
            c.drawLine (103, i + 9, 80, i - 17);
            c.setColor (Color.black);
            c.drawLine (118, i + 9, 141, i - 17);

            // Lines on parachute
            c.setColor (Color.black);
            c.drawLine (95, i - 25, 102, i - 35);
            c.setColor (Color.black);
            c.drawLine (117, i - 35, 124, i - 25);
            c.setColor (Color.black);
            c.drawLine (109, i - 25, 109, i - 35);

            // Visor
            c.setColor (Color.GRAY);
            c.fillOval (107, i - 3, 8, 5);

            // Bottom of the parachute
            c.setColor (skyBlue);
            c.fillArc (82, i - 19, 9, 10, 0, 180);
            c.setColor (skyBlue);
            c.fillArc (132, i - 19, 9, 10, 0, 180);
            c.setColor (skyBlue);
            c.fillArc (92, i - 19, 9, 10, 0, 180);
            c.setColor (skyBlue);
            c.fillArc (102, i - 19, 9, 10, 0, 180);
            c.setColor (skyBlue);
            c.fillArc (112, i - 19, 9, 10, 0, 180);
            c.setColor (skyBlue);
            c.fillArc (122, i - 19, 9, 10, 0, 180);
            try
            {
                Thread.sleep (50); // Delays each repeat to create animation
            }
            catch (Exception e)
            {
            }



            // Erases the pilot + parachute
            c.setColor (skyBlue);
            c.fillRect (80, i - 42, 65, 81);
        }
        drawPerson();
    }


    public void drawPerson () // drawPerson method, draws person at the end
    {
        Color coat = new Color (34, 189, 34);
        Color parachuteCloth = new Color (255, 255, 255);
        Color skyBlue = new Color (135, 206, 235);
        int i = 420;
        // Parachute cloth and pack
        c.setColor (parachuteCloth);
        c.fillRoundRect (102, i + 2, 18, 28, 10, 10);
        c.setColor (parachuteCloth);
        c.fillArc (82, i - 41, 58, 49, 0, 180);

        // Parachute and pack outlines
        c.setColor (Color.BLACK); // Sets colour to black
        c.drawRoundRect (100, i, 20, 30, 10, 10);
        c.drawArc (80, i - 42, 60, 50, 0, 180);
        c.setColor (Color.BLACK);
        c.drawArc (82, i - 20, 9, 10, 0, 180);
        c.setColor (Color.BLACK);
        c.drawArc (132, i - 20, 9, 10, 0, 180);
        c.setColor (Color.BLACK);
        c.drawArc (92, i - 20, 9, 10, 0, 180);
        c.setColor (Color.BLACK);
        c.drawArc (102, i - 20, 9, 10, 0, 180);
        c.setColor (Color.BLACK);
        c.drawArc (112, i - 20, 9, 10, 0, 180);
        c.setColor (Color.BLACK);
        c.drawArc (122, i - 20, 9, 10, 0, 180);

        c.setColor (coat);
        for (int j = 108 ; j < 113 ; j++) // For loop that draws the coat with lines (can't rotate rectangles)
        {
            c.drawLine (j, i, j, i + 27);
            c.drawLine (j - 15, i + 10, j - 5, i + 10);
            c.drawLine (j - 15, i + 9, j - 5, i + 9);
            c.drawLine (j - 15, i + 11, j - 5, i + 11);
            c.drawLine (j + 15, i + 10, j - 5, i + 10);
            c.drawLine (j + 15, i + 9, j - 5, i + 9);
            c.drawLine (j + 15, i + 11, j - 5, i + 11);
            c.drawLine (j, i + 27, j + 9, i + 37);
            c.drawLine (j, i + 27, j - 9, i + 37);
        }
        // Helmet
        c.setColor (Color.black);
        c.fillOval (103, i - 7, 15, 15);

        // Hands
        c.setColor (Color.black);
        c.fillOval (93, i + 9, 4, 4);
        c.setColor (Color.black);
        c.fillOval (123, i + 9, 4, 4);

        // Ropes
        c.setColor (Color.black);
        c.drawLine (103, i + 9, 90, i - 15);
        c.setColor (Color.black);
        c.drawLine (118, i + 9, 131, i - 15);
        c.setColor (Color.black);
        c.drawLine (103, i + 9, 80, i - 17);
        c.setColor (Color.black);
        c.drawLine (118, i + 9, 141, i - 17);

        // Lines on parachute
        c.setColor (Color.black);
        c.drawLine (95, i - 25, 102, i - 35);
        c.setColor (Color.black);
        c.drawLine (117, i - 35, 124, i - 25);
        c.setColor (Color.black);
        c.drawLine (109, i - 25, 109, i - 35);

        // Visor
        c.setColor (Color.GRAY);
        c.fillOval (107, i - 3, 8, 5);

        // Bottom of the parachute
        c.setColor (skyBlue);
        c.fillArc (82, i - 19, 9, 10, 0, 180);
        c.setColor (skyBlue);
        c.fillArc (132, i - 19, 9, 10, 0, 180);
        c.setColor (skyBlue);
        c.fillArc (92, i - 19, 9, 10, 0, 180);
        c.setColor (skyBlue);
        c.fillArc (102, i - 19, 9, 10, 0, 180);
        c.setColor (skyBlue);
        c.fillArc (112, i - 19, 9, 10, 0, 180);
        c.setColor (skyBlue);
        c.fillArc (122, i - 19, 9, 10, 0, 180);
    }


    public void run ()  // Run method for the Thread
    {
        parachute ();
    }


    public Parachute (Console con)  // Parachute class constructor
    {
        c = con;
    }
}
