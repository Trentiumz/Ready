package ics3.Single.DanielYe6;

/*
* Daniel Ye
* September 30, 2021
* Ms. Basaraba
* This program displays asterisk art. We display 5 asterisks in a row at the right of the screen, and display them in a
*   downward and leftward diagonal for 20 lines until it reaches the middle. This program then displays my name
 */

// imports
import hsa.Console;

// Main (ForLoopsB) class
public class ForLoopsB {

    // Main Console
    Console c;

    // draws the Asterisk Art
    public void drawAsterisks(){
        // for loop for the first 20 lines
        for(int line = 1; line <= 20; line++){
            // add an appropriate number of spaces, before printing the 5 asterisks
            c.print(' ', 76 - 2 * line);
            c.println("*****");
        }
        // print 4 lines to get to the 25th line
        c.print("\n\n\n\n");

        // print my name (Daniel Ye) after centering it relative to the asterisk art
        c.print(' ', 35);
        c.print("Daniel Ye");
    }

    // Main (ForLoopsB) class constructor
    public ForLoopsB(){
        // initialize the console
        c = new Console("For Loop Asterisk Art");
    } // ForLoopsB class constructor

    // main method
    public static void main(String[] args){
        // initialize the program
        ForLoopsB program = new ForLoopsB();

        // draw the asterisk art
        program.drawAsterisks();
    } // main method
} // ForLoopsB constructor
