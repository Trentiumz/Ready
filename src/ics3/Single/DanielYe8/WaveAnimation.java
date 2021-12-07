package ics3.Single.DanielYe8;

/*
* Daniel Ye
* November 25, 2021
* Ms. Basaraba
* This class is used to in the WaveCalculator.java class to display the animations and background for the wave, which is the main aesthetic in the WaveCalculator program
 */

// imports
import hsa.Console;
import java.awt.*;

// WaveAnimation class
public class WaveAnimation extends Thread {
    // the console for drawing the animation
    Console c;

    // the dimensions and position of the wave
    int waveHeight, height, x, waveWidth;
    // the speed of the wave animation
    int speed;
    // colors of the wave and the sky
    Color waveBlue, skyBlue;

    // WaveAnimation constructor
    public WaveAnimation(Console con, int animationHeight, int heightOfWave, int waveSpeed) {
        // set c to con
        c = con;

        // assign the parameters to their respective instance variables
        waveHeight = heightOfWave;
        height = animationHeight;
        speed = waveSpeed;

        // initialize the constants that the other methods will use
        waveWidth = 100;
        waveBlue = new Color(0, 0, 255);
        skyBlue = new Color(0, 255, 255);
        x = 0;
    } // WaveAnimation class

    // draws the environment (background) for the wave
    public void drawEnvironment(){
        // fill the sky
        c.setColor(skyBlue);
        c.fillRect(0, 0, 640, 500 - height);

        // fill the area below the wave
        c.setColor(waveBlue);
        c.fillRect(0, 500 - height + waveHeight, 640, height - waveHeight);
    } // drawEnvironment class

    // draws the wave at the current x coordinate
    public void drawWave() {
        // sets the backdrop of the wave
        c.setColor(skyBlue);
        c.fillRect(0, 500 - height, 640, waveHeight);

        // fill in the area slightly below the wave
        c.setColor(waveBlue);
        c.fillRect(0, 500 - height + waveHeight, 640, waveHeight / 2);

        // draw waves evenly spaced throughout the console
        for (int i = x; i < 640; i += waveWidth * 3 / 2) {
            // draw a larger arc for the outline of the wave
            c.setColor(waveBlue);
            c.fillArc(i, 500 - height, waveWidth * 2, waveHeight * 2, 90, 90);

            // erase parts of the wave
            c.setColor(skyBlue);
            // erase the "inner arc" of the wave, so that it seems to tower over
            c.fillArc(i + waveWidth / 2, 500 - height + waveHeight / 2, waveWidth, waveHeight, 180, 180);

            // erase an arc in front of the wave, so that the water seems to "flow" over to the next wave
            c.fillArc(i + waveWidth / 2, 500 - height, waveWidth, waveHeight * 2, 90, 90);
        } // for loop for drawing waves
    } // drawWave method

    // run method
    public void run() {
        // continuously draw the wave
        while (true) {
            // draw the wave at the current position
            drawWave();

            // increment the x value by [speed]
            x += speed;
            // if the x value is too high, then move the wave animation back, so that it can continue playing
            if (x > 0) x -= waveWidth * 3 / 2;

            // try to sleep for 100 milliseconds before the next frame of the animation
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            } // catch for Thread.sleep
        } // while loop for the animation
    } // run method
} // WaveAnimation class
