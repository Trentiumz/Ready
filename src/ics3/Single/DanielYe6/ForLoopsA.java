package ics3.Single.DanielYe6;
/*
* Daniel Ye
* September 30, 2021
* Ms. Basaraba
* This program displays the first 5 multiples of 12, the first 5 integers larger than 16, the first 5 integers
*   less than 53, the first 5 integers larger than 2, and the first 5 integers larger than 6
 */

// imports
import hsa.Console;

// Main Class (ForLoopsA)
public class ForLoopsA {

    // the main console
    Console c;

    // draws the title
    void drawTitle(){
        // print 9 lines to center the output
        c.print("\n\n\n\n\n\n\n\n\n");

        // roughly horizontally center the title and add an extra blank line
        c.println("\t\t  For Loops Multiplier, Adder, and Subtractor");
        c.println();
    } // drawTitle method

    // displays the loop
    void displayLoop(){
        // draw 5 lines, with i = 1, 2, ... 5
        for(int i = 1; i <= 5; i++){
            c.print(i, 10); // print out i (the first column)
            c.print(12 * i, 10); // print the second column
            c.print(-16 + i, 15); // print the third column
            c.print(53 - i, 10); // print the fourth column
            c.print(2 + i, 12); // print the fifth column

            // print the sixth column after adding a left margin from the fifth column
            c.print(' ', 12);
            c.println(6 + i);
        } // for loop
    } // displayLoop method

    // ForLoopsA constructor
    public ForLoopsA(){
        c = new Console("For Loops Multiplier, Adder, and Subtractor");
    } // ForLoopsA constructor

    // main method
    public static void main(String[] args){
        // initialize our program
        ForLoopsA program = new ForLoopsA();

        // draw the Title and display the Loop
        program.drawTitle();
        program.displayLoop();
    } // main method
} // ForLoopsA class
