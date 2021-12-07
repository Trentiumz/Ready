package ics3.Single.DanielYe9;

/*
* Daniel Ye
* December 5, 2021
* Ms. Basaraba
* This program prompts the user for a decimal, and will calculate the resulting fractional part (the "decimal" part) of the number
 */

// imports
import hsa.Console;
import hsa.Message;
import java.awt.*;

// Fractional Separator Main class
public class FractionalSeparator {
    Console c; // main interface for input and display
    double num; // the number the user queries for
    boolean running; // whether or not the program is running
    char choice; // the choice the user took when in the main menu

    Font splashNumber; // the numbers on the splash screen
    Font headerFont; // the font for the header
    Font normal; // the font for displaying normal text
    Color background; // the background color

    // constructor
    public FractionalSeparator(){
        // initialize the console
        c = new Console("Fractional Component Separator");

        // initialize fonts and colors
        splashNumber = new Font("Serif", Font.BOLD, 100);
        headerFont = new Font("Monospaced", Font.BOLD, 50);
        normal = new Font("SansSerif", Font.PLAIN, 26);
        background = new Color(88, 186, 58);

        // start off running the program
        running = true;
    } // FractionalSeparator constructor

    // draws the background of the program
    private void drawBackground(){
        // set the color to the background and fill the screen
        c.setColor(background);
        c.fillRect(0, 0, 640, 500);

        // draw the name of the program at the top
        c.setColor(Color.BLACK);
        c.setFont(headerFont);
        c.drawString("Fractional Separator", 12, 60);
    } // drawBackground method

    // draws the title screen
    public void title(){
        // draw the background
        drawBackground();

        // draw 5 numbers of varying colors to cover the majority of the screen
        c.setFont(splashNumber);
        c.drawString("123.546.231", 100, 200);
        c.setColor(Color.RED);
        c.drawString("342.879.23", 25, 260);
        c.setColor(Color.BLUE);
        c.drawString("423.675.21", 150, 320);
        c.setColor(Color.YELLOW);
        c.drawString("567.243.12", 10, 380);
        c.setColor(Color.MAGENTA);
        c.drawString("43.890.52", 175, 440);

        // draw the prompt for the user to press a key
        c.setColor(Color.BLACK);
        c.setFont(normal);
        c.drawString("Press any key to continue", 200, 480);
        c.getChar();
    } // title method

    // draws the splash screen
    public void splashScreen(){
        // draw teh background
        drawBackground();

        // have then numbers first fade in
        c.setFont(splashNumber);
        for(int i = 0; i <= 100; i += 10){
            // calculate the color such that it starts off as the background color, and slowly interpolates to the various colors of the numbers
            c.setColor(new Color(88 - 88 * i / 100, 186 - 186 * i / 100, 58 - 58 * i / 100));
            c.drawString("-123.05", 150, 220);
            c.setColor(new Color(88 + 167 * i / 100, 186 - 186 * i / 100, 58 - 58 * i / 100));
            c.drawString("823.421", 100, 320);
            c.setColor(new Color(88 - 88 * i / 100, 186 - 186 * i / 100, 58 + 197 * i / 100));
            c.drawString("82.12", 300, 420);

            // pause the program for 50 milliseconds
            pauseProgram(50);
        } // for loop for fading in numbers

        // for loop for making the whole number part of various numbers turn into 0's (extracting the fractional part)
        for(int i = 0; i < 50; i++){
            // draw over the previous whole number parts of the numbers we draw
            c.setColor(background);
            c.fillRect(150, 120, 186, 101);
            c.fillRect(100, 220, 151, 101);
            c.fillRect(300, 320, 101, 101);

            c.setColor(Color.BLACK);
            // alternate between drawing the whole number part, and removing the whole number part
            if(i % 2 == 0){
                // draw the whole number part of all three numbers in their respective colors
                c.drawString("-123", 150, 220);
                c.setColor(Color.RED);
                c.drawString("823", 100, 320);
                c.setColor(Color.BLUE);
                c.drawString("82", 300, 420);
            } else {
                // draw 0's in all three numbers, when drawing this, only the fractional part of the number will be drawn
                c.drawString("0", 290, 220);
                c.setColor(Color.RED);
                c.drawString("0", 200, 320);
                c.setColor(Color.BLUE);
                c.drawString("0", 350, 420);
            } // else block to alternate between drawing the whole number part or not

            // slowly speed up the alternating as we progress through the animation, with a minimum delay of 80 milliseconds
            int interval;
            if(i < 21) interval = 500 - 20 * i;
            else interval = 80;
            pauseProgram(interval);
        } // for loop to alternate between displaying the whole number and only the fractional part

        // have the numbers move off screen to the right
        for(int i = 0; i < 500; i += 10){
            // erase the previous frame
            c.setColor(background);
            c.fillRect(175 + i, 120, 350, 320);

            // draw the numbers at their new position
            c.setColor(Color.BLACK);
            c.drawString("0.05", 290 + i, 220);
            c.setColor(Color.RED);
            c.drawString("0.421", 200 + i, 320);
            c.setColor(Color.BLUE);
            c.drawString("0.12", 350 + i, 420);

            // delay so that the animation is visible
            pauseProgram(100);
        } // for loop to move numbers offscreen

        // wait for 400 milliseconds before continuing
        pauseProgram(400);
    } // splashScreen method

    // pauses the program for [millis] milliseconds
    private void pauseProgram(int millis){
        // try to pause for [millis] milliseconds, information the user of an error if there is an InterruptedException
        try{
            Thread.sleep(millis);
        } catch(InterruptedException e){
            new Message("Something unexpected happened. This program will now exit, please try again!");
        }
    } // pauseProgram method

    // displays the instructions
    public void instructions(){
        // draws the background and a second header informing the user that this page displays the instructions
        drawBackground();
        c.setFont(headerFont);
        c.setColor(Color.BLACK);
        c.drawString("Instructions", 80, 100);

        // display the paragraph detailing the purpose of the program
        c.setFont(normal);
        c.setColor(Color.BLACK);
        c.drawString("This program will calculate the fractional", 100, 150);
        c.drawString("part of any decimal (the part after the", 100, 180);
        c.drawString("decimal).", 100, 210);

        // display the paragraph detailing instructions on how to use the program
        c.drawString("In the main menu, to use the program, press", 100, 240);
        c.drawString("'i'. Then, enter the decimal you wish to", 100, 270);
        c.drawString("calculate the fractional part for, then press", 100, 300);
        c.drawString("<ENTER>. You will then see the results.", 100, 330);
        c.drawString("Note that each number will be rounded", 100, 360);
        c.drawString("to the nearest millionth", 100, 390);

        // prompt the user to return to the main menu
        c.drawString("<Press any key to return", 200, 450);
        c.drawString("to the main menu>", 200, 480);

        // pause until the user presses a key
        c.getChar();
    } // instructions method

    // displays the manin menu
    public void mainMenu(){
        // draws the background
        drawBackground();

        // informs the user that the current page is the main menu
        c.setFont(headerFont);
        c.setColor(Color.BLACK);
        c.drawString("Main Menu", 80, 100);

        // draw 4 large numbers of varying colors in the middle of the screen as graphics
        c.setFont(splashNumber);
        c.setColor(Color.RED);
        c.drawString("536.26", 350, 250);
        c.setColor(Color.BLUE);
        c.drawString("-123.11", 10, 200);
        c.setColor(Color.MAGENTA);
        c.drawString("32.52", 400, 370);
        c.setColor(Color.CYAN);
        c.drawString("576.2133", 40, 340);

        // prompt the user to enter respective keys to exit, continue, or to go to the instructions page
        c.setFont(normal);
        c.setColor(Color.BLACK);
        c.drawString("<Press 'e' to exit>", 240, 450);
        c.drawString("<Press 'c' to continue>", 220, 470);
        c.drawString("<Press 'i' for instructions>", 200, 490);

        // get the current choice
        choice = c.getChar();

        // while the choice is not valid, inform the user of such and get the choice again
        while(choice != 'e' && choice != 'c' && choice != 'i'){
            new Message("Please enter 'c', 'e', or 'i'");
            choice = c.getChar();
        } // while loop for invalid choice
    } // mainMenu method

    // prompts the user for and collects data
    public void askData(){
        // a boolean for whether or no the input is valid
        boolean inputValid = false;

        // while the input is not valid, ask the user for input
        while(!inputValid){
            // draws the background
            drawBackground();

            // draw a header so the user knows we are querying for data
            c.setFont(headerFont);
            c.setColor(Color.BLACK);
            c.drawString("Data Query", 80, 100);

            // make sure the background of the console text coincides with the background of the console
            c.setTextBackgroundColor(background);

            // move to the cursor to the middle of the screen and prompt the user for a number
            c.setCursor(15, 15);
            c.print("Please enter the decimal you wish to calculate");
            c.setCursor(16, 15);
            c.print("the fractional part for: ");

            // read the input from the user
            String input = c.readString();

            // stores if the input was successfully parsed
            boolean inputRead = false;

            // try to parse the input
            try{
                num = Double.parseDouble(input);
                // the absolute value of the input must be less than 10^7
                inputValid = Math.abs(num) < Math.pow(10, 7);
                inputRead = true;
            } catch(NumberFormatException e){
                // if the input could not be parsed, then prompt the user to enter a valid decimal
                new Message("Please enter a valid decimal");
            } // catch block for when there was a parsing error

            // if the input was successfully read but not valid, then the input must be too large, in which case we inform the user of such
            if(inputRead && !inputValid){
                new Message("Please enter a decimal with absolute value less than 10^7 (ten million)");
            } // if the input was read but not valid
        } // while input is not valid
    } // askData method

    // returns the fractional part of the number fullNum
    private double fractional(double fullNum){
        // makes sure that fullNum is positive
        if(fullNum < 0) fullNum *= -1;

        // find the largest number less than fullNum
        int largestLess = 0;
        for(int i = 0; i < fullNum; i++){
            largestLess = i;
        }

        // the fractional part is fullNum minus the largest integer less than it
        return fullNum - largestLess;
    } // fractional method

    // displays the answer to the query
    public void display(){
        // draws the background
        drawBackground();

        // draws a heading so the user knows that we are displaying the answer
        c.setFont(headerFont);
        c.setColor(Color.BLACK);
        c.drawString("Answer Display", 80, 100);

        // calculate the answer
        double answer = fractional(num);

        // round both the answer and number to the nearest millionth, so that we can display it on screen
        answer = Math.round(answer * 1000000) / 1000000.0;
        num = Math.round(num * 1000000) / 1000000.0;

        // display that the user entered [num], drawing the number in a big red font
        c.setColor(Color.BLACK);
        c.setFont(normal);
        c.drawString("You entered: ", 100, 150);
        c.setFont(splashNumber);
        c.setColor(Color.RED);
        c.drawString("" + num, 20, 250);

        // display the fractional part, drawing the number in a big blue font
        c.setFont(normal);
        c.setColor(Color.BLACK);
        c.drawString("It's fractional part is:", 100, 300);
        c.setFont(splashNumber);
        c.setColor(Color.BLUE);
        c.drawString("" + answer, 20, 400);

        // prompts the user to press any key to continue
        c.setFont(normal);
        c.setColor(Color.BLACK);
        c.drawString("<Press any key to continue>", 100, 480);
        c.getChar();
    } // display method

    // the exit screen
    public void goodbye(){
        // draws the background, displaying "Goodbye!" instead of the usual message
        c.setColor(background);
        c.fillRect(0, 0, 640, 500);
        c.setColor(Color.BLACK);
        c.setFont(headerFont);
        c.drawString("Goodbye!", 12, 60);

        // inform the user that Daniel Ye made the program, thanking them for using it
        c.setFont(normal);
        c.drawString("Fractional Separator was developed by Daniel", 100, 200);
        c.drawString("Ye. Thank you for using Fractional", 100, 230);
        c.drawString("Separator!", 100, 260);

        // wait 2 seconds, and then exit
        pauseProgram(2000);
        System.exit(0);
    } // goodbye method

    // main method
    public static void main(String[] args){
        // initialize the program
        FractionalSeparator program = new FractionalSeparator();

        // display the title and run the splashscreen animation
        program.title();
        program.splashScreen();

        // while the program is running
        while(program.running){
            // display the main menu
            program.mainMenu();

            if(program.choice == 'i'){
                // if the user pressed 'i', display the instructions
                program.instructions();
            } else if(program.choice == 'c') {
                // if the user pressed 'c', ask the user to enter a decimal and display the fractional part
                program.askData();
                program.display();
            } else {
                // if the user pressed 'e', exit the program
                program.running = false;
            } // if-else if-else chain to handle user choice in the main menu
        } // while loop the program when running

        // display the goodbye message
        program.goodbye();
    } // main method
} // FractionalSeparator class
