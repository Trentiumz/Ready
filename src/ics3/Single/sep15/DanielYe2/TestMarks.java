package ics3.Single.sep15.DanielYe2;

/*
* Daniel Ye
* September 15, 2021
* Ms. Basaraba
* This program displays test marks as well as the average for various students
*/

// imports
import hsa.Console;

public class TestMarks {
    Console c; // Main Console used to display test marks

    public void drawTitle(){
        c.print("\n\n\n\n\n\n\n\n\n\n"); // center the content by adding 10 lines above it
        c.print("", 10); // horizontally center by adding 10 spaces before the content

        // reserve 15 spaces for the Student, Test 1, Test 2, and Test Average columns
        c.print("Student", 15);
        c.print("Test 1", 15);
        c.print("Test 2", 15);
        c.println("Test Average", 15);

        // add an extra line before displaying marks
        c.println();
    } // drawTitle method

    public void displayMarks(){
        // display the test marks for each person
        // for each person, we follow the format of the above, reserving 15 spaces for each column

        c.print("", 10);
        c.print("Donald", 15);
        c.print("" + 45, 15);
        c.print("" + 80, 15);
        c.println((45.0 + 80.0) / 2, 5, 2);

        c.print("", 10);
        c.print("Mickey", 15);
        c.print("" + 33, 15);
        c.print("" + 39, 15);
        c.println((33.0 + 39.0) / 2, 5, 2);

        c.print("", 10);
        c.print("Bugs", 15);
        c.print("" + 79, 15);
        c.print("" + 92, 15);
        c.println((79.0 + 92.0) / 2, 5, 2);
    } // displayMarks method


    // constructor
    public TestMarks(){
        c = new Console("Average Test Marks"); // initialize the console
    } // TestMarks constructor

    // main method
    public static void main(String[] args){
        // initialize the display
        TestMarks display;
        display = new TestMarks();

        // draw the title and display the marks
        display.drawTitle();
        display.displayMarks();
    } // main method
} // TestMarks class
