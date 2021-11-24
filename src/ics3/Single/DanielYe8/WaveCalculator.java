package ics3.Single.DanielYe8;

import hsa.Console;
import hsa.Message;

import java.awt.*;

public class WaveCalculator {

    private Console c;
    private double given;
    private char toCalculate;
    public boolean continueRunning;

    public WaveCalculator() {
        c = new Console("Wave Calculator");
        continueRunning = true;
    }

    public void title() {
        Color waveBlue = new Color(0, 0, 100);
        Color skyBlue = new Color(0, 255, 255);
        c.setColor(skyBlue);
        c.fillRect(0, 0, 640, 500);
        c.setColor(waveBlue);
        c.fillRect(0, 300, 640, 200);
        c.fillOval(-80, 200, 160, 200);
        c.fillOval(240, 200, 160, 200);
        c.fillOval(560, 200, 160, 200);

        c.setColor(skyBlue);
        c.fillOval(80, 200, 160, 200);
        c.fillOval(400, 200, 160, 200);

        c.setColor(Color.BLACK);
        c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
        c.drawString("Wave Calculator", 50, 100);

        c.setColor(Color.WHITE);
        c.setFont(new Font("Serif", Font.PLAIN, 18));
        c.drawString("Press any key to continue", 250, 450);

        c.getChar();
    }

    public void intro() {
        c.clear();
        Color skyBlue = new Color(0, 255, 255);
        c.setColor(skyBlue);
        c.fillRect(0, 0, 640, 500);

        c.setColor(Color.BLACK);
        c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
        c.drawString("Wave Calculator", 50, 100);

        c.setFont(new Font("Serif", Font.PLAIN, 18));
        c.drawString("Given the wave speed or water depth, this program will calculate the", 50, 200);
        c.drawString("missing value. This program does so using the equation C= GH,", 50, 230);

        c.drawLine(475, 225, 480, 230);
        c.drawLine(480, 230, 480, 215);
        c.drawLine(480, 215, 500, 215);
        c.drawString("where C is the wave speed, G is the gravitational constant, and H is the", 50, 260);
        c.drawString("water depth", 50, 290);

        c.drawString("Press 'e' to exit. Press any other key to continue", 150, 450);

        if (c.getChar() == 'e') continueRunning = false;
    }

    public void askData() {
        if (continueRunning) {
            c.clear();
            Color skyBlue = new Color(0, 255, 255);
            c.setColor(skyBlue);
            c.fillRect(0, 0, 640, 500);

            c.setColor(Color.BLACK);
            c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
            c.drawString("Wave Calculator", 50, 100);

            c.setFont(new Font("Serif", Font.PLAIN, 18));
            c.drawString("Are you calculating wave speed or water depth (press 'c' for water speed,", 50, 200);
            c.drawString("press 'h' for water depth)? ", 50, 230);

            while (toCalculate != 'c' && toCalculate != 'h') {
                toCalculate = c.getChar();
                if (toCalculate != 'c' && toCalculate != 'h') {
                    new Message("Please enter 'c' or 'h'");
                }
            }

            if (toCalculate == 'c') {
                boolean givenCalculated = false;
                while (!givenCalculated) {
                    c.clear();
                    c.setColor(skyBlue);
                    c.fillRect(0, 0, 640, 500);

                    c.setColor(Color.BLACK);
                    c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
                    c.drawString("Wave Calculator", 50, 100);

                    c.setFont(new Font("Serif", Font.PLAIN, 18));
                    c.drawString("You are calculating for wave speed (C)", 200, 200);

                    try {
                        c.setCursor(25, 10);
                        c.setTextColor(Color.RED);
                        c.setTextBackgroundColor(skyBlue);
                        c.print("Please enter the water depth in metres: ");
                        String input = c.readString();
                        given = Double.parseDouble(input);
                        givenCalculated = given >= 0 && given < Math.pow(10, 30);
                    } catch (NumberFormatException e) {
                        new Message("Please enter a valid real decimal");
                        continue;
                    }

                    if (!givenCalculated) {
                        new Message("Please enter a non-negative real decimal less than 10^30 (1E30)");
                    }
                }
            } else {
                boolean givenCalculated = false;
                while (!givenCalculated) {
                    c.clear();
                    c.setColor(skyBlue);
                    c.fillRect(0, 0, 640, 500);

                    c.setColor(Color.BLACK);
                    c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
                    c.drawString("Wave Calculator", 50, 100);

                    c.setFont(new Font("Serif", Font.PLAIN, 18));
                    c.drawString("You are calculating for water depth (H)", 200, 200);

                    try {
                        c.setCursor(25, 10);
                        c.setTextColor(Color.RED);
                        c.setTextBackgroundColor(skyBlue);
                        c.print("Please enter the wave speed in metres per second: ");
                        String input = c.readString();
                        given = Double.parseDouble(input);
                        givenCalculated = given >= 0 && given < Math.pow(10, 30);
                    } catch (NumberFormatException e) {
                        new Message("Please enter a valid real decimal");
                        continue;
                    }

                    if (!givenCalculated) {
                        new Message("Please enter a non-negative real decimal less than 10^30 (1E30)");
                    }
                }
            }
        }
    }

    public void display() {
        if(continueRunning){
            c.clear();
            Color skyBlue = new Color(0, 255, 255);
            c.setColor(skyBlue);
            c.fillRect(0, 0, 640, 500);

            c.setColor(Color.BLACK);
            c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
            c.drawString("Wave Calculator", 50, 100);

            c.setFont(new Font("Serif", Font.PLAIN, 18));

            if(toCalculate == 'c'){
                double speed = Math.sqrt(9.8 * given);
                c.drawString("Given the water depth of " + given, 200, 200);
                c.drawString("The resulting wave speed is:", 50, 260);
                c.drawString("C= GH=sqrt(9.8*" + given + ")=" + speed + " metres per second", 50, 290);
                c.drawLine(70, 285, 75, 290);
                c.drawLine(75, 290, 75, 275);
                c.drawLine(75, 275, 100, 275);
            }else{
                double depth = given * given / 9.8;
                c.drawString("Given the wave speed of " + given, 200, 200);
                c.drawString("The resulting water depth is:", 50, 260);
                c.drawString("H=C^2/G=(" + given + ")^2/9.8=" + depth + " metres", 50, 290);
            }

            c.drawString("Press any key to continue", 150, 450);
            c.getChar();
        }
    }

    public void goodbye() {
        c.clear();
        Color skyBlue = new Color(0, 255, 255);
        c.setColor(skyBlue);
        c.fillRect(0, 0, 640, 500);

        c.setColor(Color.BLACK);
        c.setFont(new Font("MonoSpaced", Font.BOLD, 60));
        c.drawString("Goodbye!", 200, 100);

        c.setFont(new Font("Serif", Font.PLAIN, 18));
        c.drawString("Wave Calculator was developed by Daniel Ye on November 24th, 2021", 50, 300);
        c.drawString("Thank you for using Wave Calculator!", 50, 330);
        pauseProgram(3000);
        System.exit(0);
    }

    public void pauseProgram(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) {
        WaveCalculator program = new WaveCalculator();
        program.title();
        while (program.continueRunning) {
            program.intro();
            program.askData();
            program.display();
        }
        program.goodbye();
    }
}
