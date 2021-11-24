package MyCreation;

/*
 * Ryan Atlas, Judah Brill, Daniel Ye
 * November 21, 2021
 * Ms. Basaraba
 * This class displays the background for the MyCreation program, and is used as a component of MyCreation.java
 */

// imports

import hsa.Console;

import java.awt.*;

// Background class
public class Background {

    // The interface for drawing onto the screen
    private Console c;

    // colors for the various objects in the background
    private Color forestGreen;
    private Color lawnGreen;
    private Color skyBlue;
    private Color sunYellow;
    private Color trunkBrown;

    // fills an oval
    void fillOval(int x, int y, int width, int height) {
        // draws width/2 ovals, which together fill an entire oval
        for (int i = 0; i <= width / 2; i++) {
            c.drawOval(x + i, y + i, width - 2 * i * height / width, height - 2 * i * height / width);
        } // for loop for filling an oval
    } // fillOval method


    // fills a rectangle
    void fillRect(int x, int y, int width, int height) {
        // draws width / 2 rectangles, filling an entire rectangle
        for (int i = 0; i <= width / 2; i++) {
            c.drawRect(x + i, y + height * i / width, width - 2 * i, height - 2 * height * i / width);
        } // for loop for filling a rectangle
    } // fillRect method


    // class constructor, where con is the console that the background should draw on
    public Background(Console con) {
        // set the instance variable as the parameter so it can be accessed in other methods
        c = con;

        // initialize the colors of the background
        forestGreen = new Color(81, 139, 34);
        lawnGreen = new Color(124, 252, 0);
        skyBlue = new Color(135, 206, 235);
        sunYellow = new Color(255, 255, 0);
        trunkBrown = new Color(51, 25, 0);
    } // class constructor


    // draws a circular ring with color [outside] with dimensions (x, y, width, height) and a thickness of [thickness]
    private void drawRing(Color outside, Color inside, int x, int y, int width, int height, int thickness) {
        // draws an oval of the ring
        c.setColor(outside);
        fillOval(x, y, width, height);

        // sets the color to the background color
        c.setColor(inside);

        // erases the overflow of the ring, leaving [thickness] extra pixels on each side
        fillOval(x + thickness, y + thickness, width - 2 * thickness, height - 2 * thickness);
    } // drawRing method


    // drawSun method
    private void drawSun() {
        // draws 3 rings for the rays of the sun
        for (int i = 3; i > 0; i--) {
            // interpolates the ring color from the sky to the yellow of the sun
            Color ringColor = new Color(255 - 40 * i, 255 - 10 * i, 70 * i);
            // draws a ring for the i-th ray, positioning it so that there is space between the current ray and the previous
            drawRing(ringColor, skyBlue, 30 - 10 * i, 30 - 10 * i, 100 + 20 * i, 100 + 20 * i, 3);
        }
        // sets the color to the yellow of the sun
        c.setColor(sunYellow);
        // draws the sun
        fillOval(30, 30, 100, 100);
    } // drawSun method


    // draws a cloud, note that cloud is simply the shape of a cloud, and does not necessarily need to be the cloud in the sky
    private void drawCloud(int leftX, int topY, int width, int height, Color col, boolean drawOutline) {
        // draws 3 circles for the top section of the cloud
        for (int i = 0; i < 3; i++) {
            // sets the color to the color of the cloud
            c.setColor(col);
            // fills the oval at the current position, such that it is equally distributed through the width
            fillOval(leftX + width * i * 2 / 7, topY, width * 3 / 7, height * 2 / 3);

            // if we draw an outline, outline the circle as well
            if (drawOutline) {
                c.setColor(Color.BLACK);
                c.drawOval(leftX + width * i * 2 / 7, topY, width * 3 / 7, height * 2 / 3);
            } // drawOutline if statement
        } // for loop for drawing the circles

        // draws 2 circles for the bottom section of the cloud
        for (int i = 0; i < 2; i++) {
            // sets the color to the color of the cloud
            c.setColor(col);
            // fills an oval at the current position, such that it is equally distributed through the width, but with some margins to each side
            fillOval(leftX + (width) * (1 + 2 * i) / 7, topY + height / 3, width * 3 / 7, height * 2 / 3);
            // if we draw an outline, then outline the circle as well
            if (drawOutline) {
                c.setColor(Color.BLACK);
                c.drawOval(leftX + (width) * (1 + 2 * i) / 7, topY + height / 3, width * 3 / 7, height * 2 / 3);
            } // drawOutline if statement
        } // for loop for drawing the circles in the bottom section
    } // drawCloud method


    // draw a default cloud (one that you would typically see in the sky)
    private void drawCloud(int leftX, int topY, int width, int height) {
        drawCloud(leftX, topY, width, height, Color.WHITE, false);
    } // drawCloud method


    // draws the clouds in the sky
    private void drawClouds() {
        // draw two clouds
        drawCloud(200, 40, 200, 100);
        drawCloud(450, 20, 150, 80);
    } // drawClouds method


    // draws the ground
    private void drawGround() {
        // set the color to the color of the ground, and fill a rectangle for the ground
        c.setColor(lawnGreen);
        fillRect(0, 460, 640, 40);
        c.setColor(Color.BLACK);
        c.setFont(new Font("Serif", Font.PLAIN, 14));
        c.drawString("By Ryan Atlas, Judah Brill, Daniel Ye", 420, 485);
    } // drawGround method


    // draws a pine tree
    private void drawPineTree(int leftX, int topY, int width, int height) {
        // draws a trunk first
        c.setColor(trunkBrown);
        fillRect(leftX + width / 3, topY + height * 3 / 4, width / 3, height / 4);

        // draws 3 trapezoids for the "leaves" of the pine tree
        for (int i = 0; i < 3; i++) {
            // calculate the width at the top and bottom of this section
            int upWidth = width * i / 5;
            int botWidth = width * (i + 1) / 3;
            // calculate the coordinates of the section
            int[] x = {leftX + (width - upWidth) / 2, leftX + (width + upWidth) / 2, leftX + (width + botWidth) / 2, leftX + (width - botWidth) / 2};
            int[] y = {topY + height * i / 4, topY + height * i / 4, topY + height * (i + 1) / 4, topY + height * (i + 1) / 4};

            c.setColor(forestGreen);
            // fill in the trapezoid for the background
            for (int j = 0; j < 100; j++) {
                // calculate the current coordinates of the trapezoid shrunken by j%
                int[] curX = {leftX + (width - upWidth) / 2 + upWidth * j / 200, leftX + (width + upWidth) / 2 - upWidth * j / 200, leftX + (width + botWidth) / 2 - botWidth * j / 200, leftX + (width - botWidth) / 2 + botWidth * j / 200};
                int[] curY = {topY + height * i / 4 + height * j / 800, topY + height * i / 4 + height * j / 800, topY + height * (i + 1) / 4 - height * j / 800, topY + height * (i + 1) / 4 - height * j / 800};
                // draw the current trapezoid
                c.drawPolygon(curX, curY, 4);
            } // for loop for filling in a polygon

            // outline this section
            c.setColor(Color.BLACK);
            c.drawPolygon(x, y, 4);
        } // for loop for drawing the "leaves" of the pine tree
    } // drawPineTree method


    // draws a maple tree
    private void drawMapleTree(int leftX, int topY, int width, int height) {
        // draws the trunk
        c.setColor(trunkBrown);
        fillRect(leftX + width * 3 / 8, topY + height / 2, width / 4, height / 2);

        // draws the cloud-shaped leaves for the maple tree
        drawCloud(leftX, topY, width, height * 2 / 3, forestGreen, true);
    } // drawMapleTree method


    // draws the forest
    private void drawForest() {
        // draw a pine tree and 2 maples trees, 3 times, spaced apart
        for (int i = 0; i < 3; i++) {
            drawPineTree(40 + 100 * i, 380, 40, 80);
            drawMapleTree(100 * i - 25, 420, 40, 40);
            drawMapleTree(10 + 100 * i, 430, 30, 30);
        } // for loop for drawing the trees
    } // drawForest method


    // draws the sky
    private void drawSky() {
        // fills the console with the sky color
        c.setColor(skyBlue);
        fillRect(0, 0, 640, 500);
    } // drawSky method


    // draws the entire background
    public void drawBackground() {
        drawSky(); // draw the sky
        drawGround(); // draw the ground
        drawClouds(); // draw the clouds
        drawSun(); // draw the sun
        drawForest(); // draw the forest
    } // drawBackground method
} // Background class
