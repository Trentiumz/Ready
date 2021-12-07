package ics3.Single.DanielYe8;

/*
* Daniel Ye
* November 24, 2021
* Ms. Basaraba
* This program calculates missing values for the Wave function (C=sqrt(GH)) when given the other value. G is the gravitational constant, 9.8 metres per second squared
 */

// imports
import hsa.Console;
import hsa.Message;
import java.awt.*;

// WaveCalculator (Main) class
public class WaveCalculator {

    private Console c; // the main interface for gathering user input and printing graphics & prompts

    private double given; // the given value
    private char toCalculate; // the value we wish to calculate
    public boolean continueRunning; // whether or not we wish to continue running
    WaveAnimation animation; // running the animation of the program

    // class constructor
    public WaveCalculator() {
        // initialize the console
        c = new Console("Wave Calculator");
        // initialize continueRunning to true, as the program has started
        continueRunning = true;

        // initialize the wave animation
        animation = new WaveAnimation(c, 200, 75, 10);
    } // class constructor

    // displays the title
    public void title() {
        // draw the environment, clearing the screen
        animation.drawEnvironment();

        // start the animation at the title
        animation.start();

        // draws the header: "Wave Calculator"
        c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
        c.setColor(Color.BLACK);
        c.drawString("Wave Calculator", 50, 100);

        // prompt the user to press a key to continue
        c.setFont(new Font("Serif", Font.PLAIN, 18));
        c.setColor(Color.WHITE);
        c.drawString("Press any key to continue", 250, 450);

        // wait until the user presses a key to continue
        c.getChar();
    } // title method

    private double getSpeed(double height){
        double speed = Math.sqrt(9.8 * height);
        return Math.round(speed * 1000) / 1000.0;
    }

    private double getHeight(double speed){
        double height = speed * speed / 9.8;
        return Math.round(height * 1000) / 1000.0;
    }

    // displays an introduction to the program
    public void intro() {
        // "clears" the screen by redrawing the environment
        animation.drawEnvironment();

        // draws the heading
        c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
        c.setColor(Color.BLACK);
        c.drawString("Wave Calculator", 50, 100);

        // gives the users instructions on what this program does, and the formula it uses
        c.setFont(new Font("Serif", Font.PLAIN, 18));
        c.setColor(Color.BLACK);
        c.drawString("Given the wave speed or water depth, this program will calculate the", 50, 200);
        c.drawString("missing value. This program does so using the equation C= GH,", 50, 230);

        // gives details on what each variable means
        c.setColor(Color.BLACK);
        c.drawString("where C is the wave speed, G is the gravitational constant, and H is the", 50, 260);
        c.drawString("water depth", 50, 290);

        // draws the square root sign
        c.setColor(Color.BLACK);
        c.drawLine(475, 225, 480, 230);
        c.drawLine(480, 230, 480, 215);
        c.drawLine(480, 215, 500, 215);

        // prompts the user to exit or to continue
        c.setColor(Color.WHITE);
        c.drawString("Press 'e' to exit. Press any other key to continue", 150, 450);

        // if the user presses 'e', then we stop running
        if (c.getChar() == 'e') continueRunning = false;
    } // intro method

    // askData method
    public void askData() {
        // make sure the the program is supposed to run
        if (continueRunning) {
            // "clear" the screen by redrawing the environment
            animation.drawEnvironment();

            // draws the header
            c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
            c.setColor(Color.BLACK);
            c.drawString("Wave Calculator", 50, 100);

            // prompts the user to specify if they want to calculate the water depth or wave speed
            c.setFont(new Font("Serif", Font.PLAIN, 18));
            c.setColor(Color.BLACK);
            c.drawString("Are you calculating wave speed or water depth (press 'c' for water speed,", 50, 200);
            c.drawString("press 'h' for water depth)? ", 50, 230);

            // gets the user input for what they want to calculate
            toCalculate = c.getChar();

            // while the input is invalid, prompt the user to enter the "correct" input
            while (toCalculate != 'c' && toCalculate != 'h') {
                new Message("Please enter 'c' or 'h'");
                toCalculate = c.getChar();
            } // while loop for invalid input

            // whether or not the [given] variable has been calculated
            boolean givenCalculated = false;

            // if we're planning on calculating the wave speed
            if (toCalculate == 'c') {
                // while the given variable hasn't been entered correctly yet
                while (!givenCalculated) {
                    // draw the environment to clear the screen
                    animation.drawEnvironment();

                    // display the header
                    c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
                    c.setColor(Color.BLACK);
                    c.drawString("Wave Calculator", 50, 100);

                    // tell the user what they are calculating for
                    c.setFont(new Font("Serif", Font.PLAIN, 18));
                    c.setColor(Color.BLACK);
                    c.drawString("You are calculating for wave speed (C)", 200, 200);

                    // a temporary variable to see if there was an error
                    boolean error = false;

                    // a try catch for parsing input
                    try {
                        // set the cursor to the bottom of the screen
                        c.setCursor(25, 10);

                        // set the text to white, and the background to match the wave
                        c.setTextColor(Color.WHITE);
                        c.setTextBackgroundColor(animation.waveBlue);

                        // prompt the user for the water depth
                        c.print("Please enter the water depth in metres: ");

                        // read the input
                        String input = c.readString();

                        // parse the input, and make sure it's within the proper range
                        given = Double.parseDouble(input);
                        givenCalculated = given >= 0 && given < Math.pow(10, 30);
                    } catch (NumberFormatException e) {
                        // prompt the user to enter a valid real decimal
                        new Message("Please enter a valid real decimal");
                        error = true;
                    } // catch for user decimal prompt

                    // if there was no error, but we didn't calculate the number properly, then prompt the user to enter a decimal in range
                    if (!givenCalculated && !error) {
                        new Message("Please enter a non-negative real decimal less than 10^30 (1E30)");
                    } // if no error but number wasn't calculated properly
                } // while givenCalculated is false
            } else {
                // while givenCalculated is false, prompt the user for input
                while (!givenCalculated) {
                    // redraw the environment to clear the screen
                    animation.drawEnvironment();

                    // draw the header
                    c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
                    c.setColor(Color.BLACK);
                    c.drawString("Wave Calculator", 50, 100);

                    // inform the user of what they're currently calculating
                    c.setFont(new Font("Serif", Font.PLAIN, 18));
                    c.setColor(Color.BLACK);
                    c.drawString("You are calculating for water depth (H)", 200, 200);

                    // a temporary variable for whether or not there was an error
                    boolean error = false;

                    // try to prompt the user for input
                    try {
                        // set the cursor to the bottom of the screen and roughly centered
                        c.setCursor(25, 10);

                        // set the text color to white and match the background with the wave color
                        c.setTextColor(Color.WHITE);
                        c.setTextBackgroundColor(animation.waveBlue);

                        // prompt the user for the wave speed
                        c.print("Please enter the wave speed in metres per second: ");

                        // read the input, parse it, and see if it's in range
                        String input = c.readString();
                        given = Double.parseDouble(input);
                        givenCalculated = given >= 0 && given < Math.pow(10, 30);
                    } catch (NumberFormatException e) {
                        // prompt the user to enter an actual number
                        new Message("Please enter a valid real decimal");
                        error = true;
                    } // catch for the try block

                    // if we don't have a satisfactory result, but there was no error
                    if (!givenCalculated && !error) {
                        // prompt the user to enter a decimal in range
                        new Message("Please enter a non-negative real decimal less than 10^30 (1E30)");
                    } // if for when there is no error but we want them to re-enter the number
                } // while givenCalculated is false
            } // calculating for when the user wants to calculate for h
        } // if statement for continueRunning
    } // askData method

    // displays the answer to the user
    public void display() {
        // only run this method if the user has not decided to exit
        if(continueRunning){
            // draw the environment to clear the screen
            animation.drawEnvironment();

            // draw the header
            c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
            c.setColor(Color.BLACK);
            c.drawString("Wave Calculator", 50, 100);

            // set the font to a plain serif font
            c.setFont(new Font("Serif", Font.PLAIN, 18));

            // if we are calculating for wave speed
            if(toCalculate == 'c'){
                // set the color to black
                c.setColor(Color.BLACK);

                // draw the information onto the screen
                c.drawString("Given the water depth of " + given + " metres", 200, 200);
                c.drawString("The resulting wave speed is:", 50, 260);
                c.drawString("C= GH=sqrt(9.8*" + given + ")=" + getSpeed(given) + " metres per second", 50, 290);

                // draw the square root sign
                c.drawLine(70, 285, 75, 290);
                c.drawLine(75, 290, 75, 275);
                c.drawLine(75, 275, 100, 275);
            }else{
                // set the color to black, and display the information and answer
                c.setColor(Color.BLACK);
                c.drawString("Given the wave speed of " + given, 200, 200);
                c.drawString("The resulting water depth is:", 50, 260);
                c.drawString("H=C^2/G=(" + given + ")^2/9.8=" + getHeight(given) + " metres", 50, 290);
            } // else block for when you're calculating for 'h'

            // prompt the user to enter a key to continue
            c.setColor(Color.WHITE);
            c.drawString("Press any key to continue", 150, 450);
            c.getChar();
        } // if statement for if the user wants to continue running
    } // display method

    // displays a goodbye screen
    public void goodbye() {
        // redraw the environment
        animation.drawEnvironment();

        // draw the header "Goodbye!"
        c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
        c.setColor(Color.BLACK);
        c.drawString("Goodbye!", 150, 100);

        // give a description of the program, and thank the user for using it
        c.setFont(new Font("Serif", Font.PLAIN, 18));
        c.setColor(Color.BLACK);
        c.drawString("Wave Calculator was developed by Daniel Ye on November 24th, 2021", 50, 200);
        c.drawString("Thank you for using Wave Calculator!", 50, 230);

        // pause for 3 seconds before exiting
        pauseProgram(3000);
        System.exit(0);
    } // goodbye method

    // pauses the program for [millis] milliseconds
    public void pauseProgram(int millis) {
        // try to sleep for [millis] milliseconds
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        } // catch block
    } // pauseProgram method

    // main method
    public static void main(String[] args) {
        // initialize the WaveCalculator
        WaveCalculator program = new WaveCalculator();

        // display the title
        program.title();

        // while the user wants the program to continue running
        while (program.continueRunning) {
            // display the intro, allowing them to exit if they want to
            program.intro();

            // ask the user for data and display the answer
            program.askData();
            program.display();
        } // while loop for while the user wants the program to continue running

        // display the exit screen
        program.goodbye();
    } // main method
} // WaveCalculator class
