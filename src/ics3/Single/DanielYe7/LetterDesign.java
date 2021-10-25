package ics3.Single.DanielYe7;

/*
 * Daniel Ye
 * October 25, 2021
 * Ms. Basaraba
 * This program displays a giant ampersand (&) made up using smaller characters, which the user can choose
 */

// imports
import hsa.Console;

// LetterDesign class
public class LetterDesign {
    Console c; // main Console used as our interface
    char myChar; // the character used to display the giant ampersand

    // LetterDesign constructor
    public LetterDesign() {
        // initialize the Console
        c = new Console("Character Display");
    } // LetterDesign constructor

    // displays a title
    public void title() {
        // print out 10 empty lines to center the prompt
        c.print("\n\n\n\n\n\n\n\n\n\n");

        // print out 31 spaces to center the title horizontally
        c.print(' ', 31);
        c.println("Character Display");

        // add an extra space below to seperate the title from the content
        c.println();
    } // title method

    // displays an introduction to the program
    public void intro() {
        // print out and horizontally center the first line of the description
        c.print(' ', 10);
        c.println("This program will output a large \"&\" made up of any character");

        // print out and horizontally center the second line of the description
        c.print(' ', 35);
        c.println("you choose");
    } // intro method

    // asks the user for data
    public void askData() {
        // centers the prompt to enter a character
        c.print(' ', 27);
        c.print("Please enter a character: ");

        // read a character
        myChar = c.readChar();

        // after reading the character, clear the console to allow the program to display the giant ampersand (&)
        c.clear();
    } // askData method

    // a custom command to output a block of the user-defined characters.
    // It will first print out [leftSpaces] spaces before printing out a block of [chars] characters
    private void output(int leftSpaces, int chars) {
        // "reserve" and print out [leftSpaces] spaces
        c.print("", leftSpaces);

        // print out [chars] characters
        for (int i = 1; i <= chars; i++) {
            c.print(myChar);
        } // for loop for printing out [chars] characters
    } // output method

    // prints out [leftSpaces] spaces before printing out a block of [chars] characters and a new line
    private void output(int leftSpaces, int chars, boolean newLine) {
        // print out the block of characters
        output(leftSpaces, chars);

        // add a new line
        c.println();
    } // output method with a newline

    // display method - displays the giant ampersand
    public void display() {
        // line 1
        output(30, 9, true);

        // line 2
        output(28, 12, true);

        // line 3
        output(26, 4);
        output(8, 4, true);

        // line 4
        output(24, 6);
        output(8, 4, true);

        // line 5
        output(24, 6);
        output(6, 6, true);

        // line 6
        output(25, 5);
        output(4, 4, true);

        // line 7
        output(26, 10);
        output(32, 1, true);

        // line 8
        output(26, 8);
        output(34, 3, true);

        // line 9
        output(24, 10);
        output(10, 18);
        output(4, 6, true);

        // line 10
        output(22, 6);
        output(2, 6);
        output(6, 30, true);

        // line 11
        output(20, 6);
        output(6, 6);
        output(2, 8);
        output(8, 14, true);

        // line 12
        output(18, 6);
        output(8, 12);
        output(10, 6, true);

        // line 13
        output(16, 4);
        output(12, 6);
        output(14, 6, true);

        // line 14
        output(14, 6);
        output(14, 6);
        output(10, 6, true);

        // line 15
        output(14, 6);
        output(15, 6);
        output(8, 6, true);

        // line 16
        output(14, 6);
        output(16, 6);
        output(6, 6);
        output(12, 4, true);

        // line 17
        output(14, 6);
        output(17, 6);
        output(4, 6);
        output(14, 4, true);

        // line 18
        output(14, 6);
        output(18, 6);
        output(2, 4);
        output(16, 6, true);

        // line 19
        output(14, 6);
        output(20, 10);
        output(16, 6, true);

        // line 20
        output(16, 4);
        output(22, 6);
        output(16, 6, true);

        // line 21
        output(18, 6);
        output(18, 10);
        output(12, 6, true);

        // line 22
        output(22, 4);
        output(14, 14);
        output(8, 6, true);

        // line 23
        output(24, 20);
        output(4, 18, true);

        // line 24
        output(26, 16);
        output(10, 12);
    } // display method

    // main method
    public static void main(String[] args) {
        // initialize our program
        LetterDesign program = new LetterDesign();
        program.title(); // draw the title
        program.intro(); // draw the introduction
        program.askData(); // ask the user for data (to input the desired character)
        program.display(); // draw a giant ampersand
    } // main method
} // LetterDesign class
