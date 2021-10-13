package ics3.Single.sep17.DanielYe4;
/*
 * Daniel Ye
 * September 17, 2021
 * Ms. Basaraba
 * This program displays my name. One line will contain my first name in lowercase, and last in in uppercase, and it will then display my last name, one character per line
 */

// imports
import hsa.Console;

public class StringClass {
    Console c; // the console used to print to the screen

    // my first and last name
    final String myFirstName;
    final String myLastName;

    // draw the title
    public void drawTitle() {
        // to center, we have 9 lines above the title
        c.print("\n\n\n\n\n\n\n\n\n");

        c.print("", 35);
        c.println("My Name");
        c.println();
    } // drawTitle method

    // displays my name
    public void displayData() {
        // display my first name in lowercase and my last name in uppercase, making sure to format and center my program
        c.print("", 34);
        c.print(myFirstName.toLowerCase());
        c.print(" ");
        c.println(myLastName.toUpperCase());
        c.println();
    } // displayData method

    // displays my last name, one character per line
    public void displayName() {
        // center my last name, and print one character of my last name per line
        c.print("", 38);
        c.println(myLastName.charAt(0));
        c.print("", 38);
        c.println(myLastName.charAt(1));
    } // displayName method

    // class constructor
    public StringClass() {
        c = new Console("My Name");
        myFirstName = "Daniel";
        myLastName = "Ye";
    } // StringClass class constructor

    // main method
    public static void main(String[] args) {
        // create a new instance of our StringClass class
        StringClass instance = new StringClass();

        // draw the title, display my name, then display my last name one character per line
        instance.drawTitle();
        instance.displayData();
        instance.displayName();
    } // main method
} // StringClass class
