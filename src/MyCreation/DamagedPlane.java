package MyCreation;
/* Ryan Atlas, Daniel Ye and Judah Brill
   November 9th, 2021
   Ms. Basaraba
   This program will create the DamagedPlane class that controls the damaged
   version of the plane that appears after the explosion and has both a different
   model and behaviour. This program will use implements Runnable to run on its
   own Thread. */

import hsa.Console;  // Gives access to the Console class in the hsa package
import java.awt.*; // Gives access to the Java command libraries
import java.lang.*; // Gives acces to the Thread class

public class DamagedPlane implements Runnable
{
	private Console c; // Allows for the use of Console commands
	private int dist; // Distance the plane travels
	private int x; // X Coordinate of the plane
	private int y; // Y Coordinate of the plane
	public void damagedPlane ()  // damagedPlane() method
	{
		Color lightBlue = new Color (42, 191, 245); // Makes a new light blue colour
		Color skyBlue = new Color (135, 206, 235); // Makes a new sky blue colour
		Color planeBody = new Color(80,80,80); // Color of the plane body
		for (int i = dist ; i > 0 ; i -= 2) // For loop controls animation
		{
			x--;
			c.setColor (lightBlue); // Sets the cockpit colour to light blue
			c.fillArc ((x + 20) + i, (y - 5)-i, 40, 15, 205, -200);
			c.setColor (planeBody); // Sets the plane body colour
			c.fillArc (x + i, y-i, 110, 40, 0, 180);
			c.setColor (planeBody);
			c.fillArc (x + i, (y + 15)-i, 110, 10, 0, -180);
			c.setColor (Color.BLACK); // Sets colour to black
			c.fillRoundRect ((x + 95) + i, y-i, 20, 18, 10, 10);
			c.setColor (planeBody);
			int[] xPoints = {(x + 45) + i, (x + 52) + i, (x + 72) + i, (x+71)+i, (x+69)+i, (x+67)+ i, (x + 67) + i};
			int[] yPoints = {(y + 15)-i, (y + 40)-i, (y + 40)-i, (y+30)-i, (y+25)-i, (y + 20)-i, (y+15)-i};
			c.fillPolygon (xPoints, yPoints, 7);
			c.setColor (planeBody);
			c.fillArc ((x + 52) + i, (y + 35)-i, 20, 10, 0, -180);
			int[] xPoints2 = { (x + 90) + i, (x + 110) + i, (x + 110) + i, (x + 80) + i};
			int[] yPoints2 = {(y - 5)-i, (y - 5)-i, (y + 20)-i, (y + 20)-i};
			c.setColor (planeBody);
			c.fillPolygon (xPoints2, yPoints2, 4);
			c.setColor (planeBody);
			c.fillArc ((x + 90) + i, (y - 10)-i, 20, 10, 0, 180);
			c.setColor (Color.RED); // Sets colour to red
			c.fillOval ((x + 95) + i, (y - 5)-i, 12, 12);
			c.setColor (Color.YELLOW); // Sets colour to yellow
			c.fillStar ((x + 96) + i, (y - 5)-i, 10, 10); // Finishes the drawing of the plane

			// Draws lines that indicate damage
			c.setColor(Color.BLACK); // Sets the colour to black again on top of the rest of the plane
			c.drawLine((x+20)+i, (y+5)-i, (x+32)+i, (y+15)-i);
			c.setColor(Color.BLACK);
			c.drawLine((x+60)+i, (y+2)-i, (x+65)+i, (y+20)-i);
			c.setColor(Color.BLACK);
			c.drawLine((x+30)+i, (y-4)-i, (x+40)+i, (y)-i);
			c.setColor(Color.BLACK);
			c.drawLine((x+110)+i, (y+20)-i, (x+90)+i, (y+10)-i);
			c.setColor(Color.BLACK);
			c.drawLine((x+40)+i, (y+20)-i, (x+50)+i, (y+15)-i);

			//Draw smoke
			c.setColor(Color.BLACK);
			c.fillOval((x+110)+i, (y)-i, 30, 20);
			c.setColor(Color.BLACK);
			c.fillOval((x+120)+i, (y-10)-i, 30, 20);
			c.setColor(Color.BLACK);
			c.fillOval((x+55)+i, (y-15)-i, 30, 20);
			c.setColor(Color.BLACK);
			c.fillOval((x+65)+i, (y-25)-i, 30, 20);
			c.setColor(Color.BLACK);
			c.fillOval((x+60)+i, (y+20)-i, 30, 20);
			c.setColor(Color.BLACK);
			c.fillOval((x+70)+i, (y+10)-i, 30, 20);
			// c.setColor(new Color(255, 128, 0));
			// c.fillOval((x+110)+i, (y)-i, 15, 10);
			try
			{
				Thread.sleep (40); // Waits for 80 milliseconds before continuing
			}
			catch (Exception e)
			{
			}
			c.setColor (skyBlue); // Sets the colour to same colour as the sky to erase the plane as it goes
			c.fillRect(x+i, (y-25)-i, 150, 85);
			// c.fillArc ((x + 20) + i, (y - 5)-i, 40, 15, 205, -200);
			// c.fillArc (x + i, y-i, 110, 40, 0, 180);
			// c.fillArc (x + i, (y + 15)-i, 110, 10, 0, -180);
			// c.fillPolygon (xPoints, yPoints, 7);
			// c.fillArc ((x + 52) + i, (y + 35)-i, 20, 10, 0, -180);
			// c.fillPolygon (xPoints2, yPoints2, 4);
			// c.fillArc ((x + 90) + i, (y - 10)-i, 20, 10, 0, 180);
			// c.fillRoundRect ((x + 95) + i, y-i, 20, 18, 10, 10); // Erases the plane as it moves
			// c.fillOval((x+110)+i, (y)-i, 30, 20);
			// c.fillOval((x+120)+i, (y-10)-i, 30, 20);
			// c.fillOval((x+55)+i, (y-15)-i, 30, 20);
			// c.fillOval((x+65)+i, (y-25)-i, 30, 20);
			// c.fillOval((x+60)+i, (y+20)-i, 30, 20);
			// c.fillOval((x+70)+i, (y+10)-i, 30, 20);
			// c.fillOval((x+110)+i, (y)-i, 15, 10);
		}
	}
	public DamagedPlane(Console con, int locX, int locY) // DamagedPlane class constructor
	{
		c = con;
		x = locX;
		y = locY;
		dist = 200;
	}
	public void run () // Run method for the Thread
	{
		damagedPlane (); // Calls the plane method
	}
}
