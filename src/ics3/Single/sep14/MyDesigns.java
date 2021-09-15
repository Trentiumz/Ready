package ics3.Single.sep14;
/* Daniel Ye
* September 14, 2021
* Ms. Basaraba
* This program displays the required text listed in the String Output assignment on brightspace 
* (Designs, a diamond, a parallelogram) using a template listed on the same assignment 
*/ 

import java.awt.*;
import hsa.Console;

public class MyDesigns
{
    Console c; // the console used to draw the shapes in text
    
    // draws the title & is taken from the template
    public void drawTitle()
    {
	c.print(' ', 36);
	c.println("Designs");
	c.println();
    } // drawTitle method
    
    // draws the parallelogram
    public void drawParallelogram()
    {
	// each block of code, seperated by one line, draws one ling of the parallelogram
	c.print(' ', 33);
	c.println("PARALLELO");
	
	c.print(' ', 34);
	c.print("A");
	c.print(' ', 7);
	c.println("G");
	
	c.print(' ', 35);
	c.print("R");
	c.print(' ', 7);
	c.println("R");
	
	c.print(' ', 36);
	c.print("A");
	c.print(' ', 7);
	c.println("A");
	
	c.print(' ', 37);
	c.println("LLELOGRAM");
    } // drawParallelogram method
    
    // draws the diamond
    public void drawDiamond()
    {
	// each block of code, seperated by one line, each print one line of the diamond
	c.print(' ', 39);
	c.println("D");
	
	c.print(' ', 38);
	c.println("III");
	
	c.print(' ', 37);
	c.println("AAAAA");
	
	c.print(' ', 36);
	c.println("MMMMMMM");
	
	c.print(' ', 37);
	c.println("OOOOO");
	
	c.print(' ', 38);
	c.println("NNN");
	
	c.print(' ', 39);
	c.println("D");
	
	c.println();
    } // drawDiamond method
    
    public MyDesigns()
    {
	c = new Console();
    } // MyDesigns constructor
    
    public static void main(String[] args)
    {
	MyDesigns d;
	d = new MyDesigns();

	d.drawTitle();
	d.drawDiamond();
	d.drawParallelogram();
    } // main method
	
} // MyDesigns class
