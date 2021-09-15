package ics3.Single.days;
/* Daniel Ye
* September 14, 2021
* Ms. Basaraba
* This program prints a string and acts as the testing class for the in class lesson */

import hsa.Console;

public class SepFourteenOne // program heading & gives the program its name public can be accessed by other programs
{
    Console c;
    public void output(){
	c.println("wow so cool"); // prints a string
	c.print("7 chars", 8); // reserves 8 spaces, fills the first few with "7 chars"
	c.print("There is one space between this and the last print");
    }
    
    public SepFourteenOne(){
	c = new Console (); // creates a new object (called c) of type Console
    }
    
    public static void main (String[] args) // main method is the starting point
    { // brackets indicate the beginning and end of a block of code
	SepFourteenOne current = new SepFourteenOne();
	current.output();
    } // main method
} // SepFourteenOne class
