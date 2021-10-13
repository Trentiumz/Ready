package ics3.Single.sep16.Danielye3;
/*
* Daniel Ye
* September 16, 2021
* Ms. Basaraba
* A program to display the Monthly Salary of three characters in the Star Wars trilogy, given their hourly rate and their number of hours per week
 */

// imports
import hsa.Console;

public class MonthlySalary {

    Console myConsole; // the main console

    // Instance Variables for the three rows to display
    static final String FIRST_NAME = "Luke";
    static final double FIRST_RATE = 59.5;
    static final int FIRST_WEEKLY_HOURS = 2;

    static final String SECOND_NAME = "R2D2";
    static final double SECOND_RATE = 4.25;
    static final int SECOND_WEEKLY_HOURS = 40;

    static final String THIRD_NAME = "C3P0";
    static final double THIRD_RATE = 92;
    static final int THIRD_WEEKLY_HOURS = 15;

    static final String TITLE = "Star Wars Limited"; // the title

    static final int LEFT_MARGIN = 4; // spaces to the left of the table
    static final int SPACES_BETWEEN = 5; // spaces in between each column

    public MonthlySalary(){
        // initialize our console
        myConsole = new Console(TITLE);
    } // MonthlySalary class constructor

    // draws the title of the table
    public void drawTitle(){
        // add 9 lines above to vertically center the table
        myConsole.print("\n\n\n\n\n\n\n\n\n");

        // center the title, and add an extra line below
        myConsole.print("", 30);
        myConsole.println(TITLE);
        myConsole.println();
    } // drawTitle method

    // displays the salary of the three characters
    public void displaySalary(){
        // display the column headings, adding an extra line to seperate it from the content
        myConsole.print("", LEFT_MARGIN);
        myConsole.print("Employee");
        myConsole.print("", SPACES_BETWEEN);
        myConsole.print("Hourly Rate");
        myConsole.print("", SPACES_BETWEEN);
        myConsole.print("Total Hours Per Week");
        myConsole.print("", SPACES_BETWEEN);
        myConsole.println("Gross Monthly Salary");
        myConsole.println();

        // calculate the gross monthly salary for the three characters
        double firstGross = 4 * FIRST_RATE * FIRST_WEEKLY_HOURS;
        double secondGross = 4 * SECOND_RATE * SECOND_WEEKLY_HOURS;
        double thirdGross = 4 * THIRD_RATE * THIRD_WEEKLY_HOURS;

        // for each character, we display their hourly rate, number of hours per week, and their gross monthly salary
        // note the use of tabs in order to achieve more consistent and flexible formatting
        myConsole.print("", LEFT_MARGIN);
        myConsole.print(FIRST_NAME);
        myConsole.print("\t   $");
        myConsole.print(FIRST_RATE, 0, 2);
        myConsole.print("\t\t ");
        myConsole.print(FIRST_WEEKLY_HOURS, 0);
        myConsole.print("\t\t\t$");
        myConsole.println(firstGross, 0, 2);

        myConsole.print("", LEFT_MARGIN);
        myConsole.print(SECOND_NAME);
        myConsole.print("\t   $");
        myConsole.print(SECOND_RATE, 0, 2);
        myConsole.print("\t\t ");
        myConsole.print(SECOND_WEEKLY_HOURS, 0);
        myConsole.print("\t\t\t$");
        myConsole.println(secondGross, 0, 2);

        myConsole.print("", LEFT_MARGIN);
        myConsole.print(THIRD_NAME);
        myConsole.print("\t   $");
        myConsole.print(THIRD_RATE, 0, 2);
        myConsole.print("\t\t ");
        myConsole.print(THIRD_WEEKLY_HOURS, 0);
        myConsole.print("\t\t\t$");
        myConsole.println(thirdGross, 0, 2);
    } // displaySalary method

    // main method
    public static void main(String[] args){
        // initialize our MonthlySalary class
        MonthlySalary monthly = new MonthlySalary();

        // draw the title and display the salaries
        monthly.drawTitle();
        monthly.displaySalary();
    } // main method
} // MonthlySalary class
