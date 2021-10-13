package ics3.Single.DanielYe5;
/*
 * Daniel Ye
 * September 29, 2021
 * Ms. Basaraba
 * This program asks the user for their First Name, Last Name, and Grade. It will then redisplay the information in the form of a confirmation.
 */

// imports
import hsa.Console;

// Class Declaration
public class UserInput {

    // store first name, last name, and grade as instance variables
    String myFirstName;
    String myLastName;
    int myGrade;

    // the console used to read input and display output
    Console c;

    // ask the user for the data
    public void askData(){
        // Prompt the user for their first name
        c.println("Please enter your first name and press <ENTER>");
        myFirstName = c.readLine();

        // prompt the user for their last name
        c.println("Please enter your last name and press <ENTER>");
        myLastName = c.readLine();

        // prompt the user for their grade
        c.println("Please enter your grade and press <ENTER>");
        myGrade = c.readInt();
    } // askData method

    // Redisplay the data entered in the form of a confirmation
    public void displayData(){
        // displays "So, <first name> <last name>, are you really in grade <grade>?"
        c.println("So, " + myFirstName + " " + myLastName + ", are you really in grade " + myGrade + "?");
    } // displayData method

    // class constructor
    public UserInput(){
        // initialize the console
        c = new Console("Name and Grade Confirmation");
    } // UserInput class constructor

    // main method
    public static void main(String[] args){
        // initialize our main program
        UserInput mainProgram = new UserInput();

        // ask the user for their first name, last name, and grade
        mainProgram.askData();

        // redisplay their first name, last name, and grade in the form of a confirmation
        mainProgram.displayData();
    } // main method

} // UserInput class
