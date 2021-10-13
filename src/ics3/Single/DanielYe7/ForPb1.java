package ics3.Single.DanielYe7;
/*
* Daniel Ye
* October 13, 2021
* Ms. Basaraba
* This program displays 12 consecutive powers of 3 in a table, where the user can enter the starting exponent
 */

// imports
import hsa.Console;

// Main Class
public class ForPb1 {
    Console c; // the interface to display the output
    int startExp; // the starting exponent for our program

    // draws the title
    public void drawTitle(){
        // 3 lines as a buffer to center our program
        c.print("\n\n");

        // print the title, "Power Table of 3" and center it
        c.print(' ', 32);
        c.println("Power Table of 3");

        // draw an extra blank line
        c.println();
    } // drawTitle method

    // draws the introduction for the program
    public void drawIntro(){
        // draw the title
        drawTitle();

        // print out a short description, centering it and also adding a blank line under
        c.print(' ', 1);
        c.println("This program displays powers of 3, where you can choose the starting exponent");
        c.print(' ', 8);
        c.println("The starting exponent must be a nonnegative integer less than 29");

        c.println();
    } // drawIntro method

    // prompt the user for data and store it in startExp
    public void askData(){
        // ask the user for input, and continue to do so until the input is valid.
        do {
            // center the prompt asking the user to enter the starting exponent
            c.print(' ', 12);
            c.print("Please enter your starting exponent and press <ENTER>: ");

            // read the integer entered by the user and store it in startExp
            startExp = c.readInt();
        } while(startExp < 0 || startExp >= 29);

        // add an extra blank line for the table
        c.println();
    } // askData method

    // displays the table
    public void displayTable(){
        // draws the 3 column titles: Base, Exponent, and Result; centering the columns
        c.print(' ', 18);
        c.print("Base", 17);
        c.print("Exponent", 22);
        c.println("Result");

        // Loop through each row, where current is the current exponent that we wish to calculate and display
        for(int current = startExp; current < startExp + 12; current++){
            // initialize the result to 3^0, using a long to handle larger values
            long result = 1;

            // multiply our result by 3 [current] number of times
            for(int resExp = 1; resExp <= current; resExp++){
                result *= 3;
            } // for loop for calculating the result

            // print out the base, exponent, and our result; evenly spaced and centered in our columns
            c.print(3, 20);
            c.print(' ', 9);
            c.print('^');
            c.print(current, 10);
            c.print(' ', 9);
            c.print('=');
            c.print(' ', 7);
            c.println(result);
        } // for loop for each row
    } // displayTable method

    // ForPb1 class constructor
    public ForPb1(){
        // initialize the console
        c = new Console("Power Table");
    } // ForPb1 class constructor

    // main method
    public static void main(String[] args){
        // initialize our main program
        ForPb1 program = new ForPb1();

        // draw the introduction, prompt the user for the starting exponent, and display the table
        program.drawIntro();
        program.askData();
        program.displayTable();
    } // main method
} // ForPb1 class
