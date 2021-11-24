package ics3.Single.DanielYe_Graphics;

/*
 * Shane Chen & Daniel Ye
 * October 28, 2021
 * Ms. Basaraba
 * This program uses the graphical utility of hsa console to display a word art poster using words that are related to healthcare, along with visuals supporting the theme
 */

// imports

import hsa.Console;

import java.awt.*;

// WordArt class
public class WordArt {

    Console c; // console interface for drawing graphics

    // constructor
    public WordArt() {
        // initialize the console
        c = new Console("Word Art Poster");
    } // WordArt constructor

    // draws the word art poster
    public void drawPoster() {
        drawImages(); // draw the images
        drawWords(); // draw the words over the images
    } // drawPoster method

    // draws an arc in a ring, where you can set the thickness, arc color, and the color of the interior "ring"
    private void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle, int thickness, Color outer, Color inner) {
        // sets the color to the arc color
        c.setColor(outer);
        // fills the arc
        c.fillArc(x, y, width, height, startAngle, arcAngle);

        // sets the color to the user-specified background color
        c.setColor(inner);
        // fill an arc with the background color such that there is [thickness] pixels in between them
        c.fillArc(x + thickness, y + thickness, width - 2 * thickness, height - 2 * thickness, startAngle, arcAngle);
    } // custom drawArc method

    // draws a string downward
    private void downString(String str, int x, int y, Color col, int fontHeight) {
        // iterate through each character in the string
        for (int i = 0; i < str.length(); i++) { // i is the current character we wish to draw
            // draw the current character, going down by [fontHeight] pixels each consecutive character
            drawString(str.substring(i, i + 1), x, y + i * fontHeight, col);
        } // for loop
    } // downString method

    // draws the images
    private void drawImages() {
        // draws a gradient, uses fillOval because arcs often leave "gaps"
        for (int offset = 200; offset > 0; offset--) { // offset is the distance of the current gradient oval from the main background
            // sets the color, where "further" (higher offsets) will yield darker colors
            c.setColor(new Color(255 - (100 * offset / 200), 0, 0));
            // draw an oval that is [offset] pixels "outside" of the oval for the main background
            c.fillOval(-offset, -offset, 640 + 2 * offset, 500 + 2 * offset);
        } // gradient for loop

        // fill a white oval, which is our "main" background
        c.setColor(Color.WHITE);
        c.fillOval(0, 0, 640, 500);

        // set the dark green color which we will use for the outer ring
        Color darkGreen = new Color(0, 189, 85);
        // draw an incomplete "outer" dark-green ring
        drawArc(80, 0, 500, 500, -45 + 10, 180 - 20, 5, darkGreen, Color.WHITE);
        drawArc(80, 0, 500, 500, 135 + 10, 180 - 20, 5, darkGreen, Color.WHITE);

        // draw an incomplete "inner" light-green ring
        drawArc(100, 20, 460, 460, 45 + 10, 180 - 20, 5, Color.GREEN, Color.WHITE);
        drawArc(100, 20, 460, 460, 225 + 10, 180 - 20, 5, Color.GREEN, Color.WHITE);

        // fill a cross sign using two rectangles
        c.setColor(Color.RED);
        c.fillRect(320 - 130, 250 - 50, 260, 100);
        c.fillRect(320 - 50, 250 - 130, 100, 260);

        // define the points for the shape of a man
        int[] manXPoints = {170, 200, 230, 200, 190};
        int[] manYPoints = {120, 140, 100, 190, 150};

        // draw a person
        c.setColor(Color.CYAN);
        c.fillPolygon(manXPoints, manYPoints, 5); // draw the person's body
        c.fillOval(185, 100, 20, 20); // draw the person's head
    } // drawImages method

    // draws a string, where you can define a custom color
    private void drawString(String str, int x, int y, Color col) {
        c.setColor(col); // sets the color to the desired color
        c.drawString(str, x, y); // displays a string
    } // drawString method

    // draws the words on our poster
    private void drawWords() {
        // use a sans-serif font for "healthcare"
        c.setFont(new Font("SansSerif", Font.BOLD, 36));
        drawString("HEALTHCARE", 320 - 120, 250 + 9, Color.WHITE);

        // draw various words, switching fonts around at regular intervals
        c.setFont(new Font("MonoSpaced", Font.BOLD, 28));
        drawString("Sickness", 320 + 50, 250 - 50, Color.BLUE); // blue "sickness" word
        drawString("Treatment", 320 - 205, 250 + 70, Color.MAGENTA); // magenta "treatment" word
        drawString("PPO", 320 + 50, 250 - 78, Color.PINK); // pink "ppo" word
        drawString("Hospital", 320 - 190, 250 + 98, new Color(255, 123, 0)); // orange "hospital" word

        c.setFont(new Font("SansSerif", Font.BOLD, 28)); // change to sans-serif font
        drawString("Doctor", 320 + 50, 144, new Color(0, 255, 242)); // cyan "doctor" word
        drawString("Insurance", 320 + 50, 250 + 70, new Color(255, 50, 190)); // pink "insurance" word
        drawString("Surgery", 320 + 50, 250 + 98, new Color(127, 255, 50)); // green "surgery" word

        c.setFont(new Font("Serif", Font.BOLD, 28)); // change to serif font
        drawString("Taxes", 320 - 38, 400, new Color(0, 12, 155)); // blue "taxes" word

        c.setFont(new Font("MonoSpaced", Font.BOLD, 28)); // change to monospaced font
        drawString("Free", 295, 250 + 78, Color.ORANGE); // orange "free" word
        drawString("Doctor", 245, 220, Color.CYAN); // cyan "doctor" word

        // draw various vertical strings
        downString("Free", 320 - 68, 130, Color.GREEN, 20); // green "free" word
        downString("Sickness", 160, 150, Color.BLUE, 20); // blue "sickness" word
        downString("PPO", 320 - 68, 370, Color.BLUE, 20); // blue "ppo" word
        downString("Taxes", 510, 200, Color.ORANGE, 20); // orange "taxes" word
        downString("Surgery", 233, 70, Color.ORANGE, 20); // orange "surgery" word
        downString("Nurse", 275, 290, Color.YELLOW, 20); // yellow "nurse" word
        downString("Nurse", 350, 140, Color.GREEN, 20); // green "nurse" word
    } // drawWords method

    // main method
    public static void main(String[] args) {
        // initialize our program
        WordArt program = new WordArt();
        // draw the poster
        program.drawPoster();
    } // main method
} // WordArt class
