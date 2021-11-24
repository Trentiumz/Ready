package MyCreation;

/*
* Ryan Atlas, Judah Brill, Daniel Ye
* November 19, 2021
* Ms. Basaraba
* This class animates an explosion blowing up and fading out that appears in the MyCreation.java file.
* This class extends Thread and will utilize its parallel running capabilities to run in tandem with
* other components of the MyCreation program
 */

// imports
import hsa.Console;
import java.awt.*;

// Explosion class
public class Explosion extends Thread {

    // the interface for drawing
    final Console c;

    // the x and y coordinates for the position of the explosion
    int exX, exY;
    // the width and height of the explosion
    int exWidth, exHeight;
    // the color of the sky
    Color skyBlue;

    // Explosion class constructor
    public Explosion(Console con, int finalX, int finalY, int finalWidth, int finalHeight) {
        // set the instance variable for the console
        c = con;

        // initialize the color of the sky
        skyBlue = new Color(135, 206, 235);

        // set the position and size instance variables to their parameter counterpars
        exX = finalX;
        exY = finalY;
        exWidth = finalWidth;
        exHeight = finalHeight;
    } // Explosion constructor

    // draws a ring, where squishY is the "thickness" of the ring, outer is the color of the ring, inner is the background color
    private void drawRing(Color outer, Color inner, int leftX, int topY, int width, int height, int squishY) {
        c.setColor(outer);
        // fill an oval with the color of the ring
        c.fillOval(leftX, topY, width, height);
        c.setColor(inner);
        // "erase" the bottom part of the ring, leaving the shape at the top
        c.fillOval(leftX, topY + squishY, width, height - squishY);
    } // drawRing method

    // draws an explosion cloud, where color is the cloud of the explosion, ringColor is the color of the particles on the cloud, and cloudSize is the size of the individual circles
    private void drawCloud(Color color, Color ringColor, int leftX, int topY, int width, int height, int cloudSize) {
        // calculate the cloud size, making sure it fits within the dimensions of the entire cloud
        cloudSize = Math.min(cloudSize, Math.min(width, height));

        // calculate the size of the rings (particles) of the cloud
        int ringSize = cloudSize / 6;

        // the intervals at which to draw the individual circles
        int yIncrease = (height - cloudSize) / 2;

        // set the color for the background of the cloud
        c.setColor(color);
        c.fillOval(leftX + (width - cloudSize) / 2, topY, cloudSize, cloudSize); // draw the top circle

        // draw 3 circles making up the middle layer of the cloud
        for (int i = 0; i < 3; i++) {
            // increase x at equal intervals, such that we calculate the positions for 3 circles evenly spaced within [width] (though the circles should overlap)
            int x = leftX + (width - cloudSize) * (2 * i + 1) / 6;
            // fill a circle at the desired position
            c.setColor(color);
            c.fillOval(x, topY + yIncrease, cloudSize, cloudSize);
        } // for loop for drawing the cloud circles in the middle layer

        // draw 5 circles making up the bottom layer of the cloud
        for (int i = 0; i < 5; i++) {
            // calculate the x coordinate so that the 5 circles are equally spaced apart
            int x = leftX + (width - cloudSize) * i / 4;
            // fill a circle at the desired position
            c.setColor(color);
            c.fillOval(x, topY + yIncrease * 2, cloudSize, cloudSize);
        } // for loop for drawing the cloud circles in the bottom layer

        // draw a ring in the middle of the top circle
        drawRing(ringColor, color, leftX + width / 2 - ringSize, topY + cloudSize / 2 - ringSize, 2 * ringSize, 2 * ringSize, ringSize * 2 / 3);

        // draw 3 rings at the middle of each circle
        for (int i = 0; i < 3; i++) {
            // calculate the coordinate of the middle of the corresponding circle
            int x = leftX + (width - cloudSize) * (2 * i + 1) / 6 - ringSize + cloudSize / 2;
            // draw a ring at the corresponding position
            drawRing(ringColor, color, x, topY + yIncrease + cloudSize / 2 - ringSize, 2 * ringSize, 2 * ringSize, ringSize * 2 / 3);
        } // for loop for drawing the cloud particles in the middle layer

        // draw 5 rings at the center of each circle in the bottom layer
        for (int i = 0; i < 5; i += 2) {
            // calculate the middle of each circle at the bottom layer
            int x = leftX + (width - cloudSize) * i / 4 + cloudSize / 2 - ringSize;
            // draw a ring at the corresponding position
            drawRing(ringColor, color, x, topY + 2 * yIncrease + cloudSize * 2 / 3 - ringSize, 2 * ringSize, 2 * ringSize, ringSize * 2 / 3);
        } // for loop for drawing the cloud particles in the bottom layer
    } // drawCloud method

    // draws the "pipe" of the explosion, where the stripes alternate in color between [outer] and [inner]
    private void drawPipe(Color outer, Color inner, int leftX, int topY, int width, int height) {
        // calculate the x coordinate of the middle stripe
        int midX = leftX + width * 2 / 5;
        // the width of the middle stripe
        int midWidth = width / 5;

        // set the color to [outer]
        c.setColor(outer);
        // fill in a rectangle for the outer part of the top half of the pipe
        c.fillRect(leftX, topY + height / 2, width, height / 2);
        // fill in the bottom half of the pipe with the color of the middle stripe
        c.setColor(outer);
        c.fillRect(midX, topY, midWidth, height / 2);

        // set the color to [inner], erase the unwanted parts when drawing the outer stripes, and draw the inner stripes
        c.setColor(inner);
        c.fillRect(midX + midWidth / 5, topY, midWidth * 3 / 5, height / 2);

        // set the color to [outer], erase the unwanted parts when drawing the inner stripes, and draw the middle stripe
        c.setColor(outer);
        c.fillRect(midX + midWidth * 2 / 5, topY, midWidth / 5, height);

        // calculate the arc width for drawing the bottom half of the inner stripe
        int arcWidth = midX - leftX + midWidth * 2 / 5;
        // calculate how far the bottom the inner stripe should be from the edges of the pipe
        int offset = width * 5 / 7;

        // fill a 90-degree arc to erase the overflow from drawing the middle stripe and draw the inner stripe on the left side
        c.setColor(inner);
        c.fillArc(leftX - arcWidth + offset, topY, 2 * arcWidth - offset, height, 0, -90);
        // fill the outer edges of the inner stripe
        c.setColor(inner);
        c.fillRect(leftX, topY + height / 2, offset / 2, height / 2);
        // fill a 90 degree arc to erase the overflow from drawing the middle stripe and draw the inner stripe on the right side
        c.setColor(inner);
        c.fillArc(midX + midWidth * 3 / 5, topY, 2 * arcWidth - offset, height, 180, 90);
        // fill the outer edges of the inner stripe
        c.setColor(inner);
        c.fillRect(leftX + width - offset / 2, topY + height / 2, offset / 2, height / 2);

        // calculate the arc width from drawing the bottom half of the outer stripe
        arcWidth = midX - leftX + midWidth / 5;
        // calculate the distance of the bottom of the outer stripe from the edges of the pipe
        offset = width * 2 / 7;

        // fill a 90 degree arc to erase the overflow from drawing the inner stripe on the left
        c.setColor(outer);
        c.fillArc(leftX - arcWidth + offset, topY, 2 * arcWidth - offset, height, 0, -90);
        // fill the outer edges of the outer stripe
        c.setColor(outer);
        c.fillRect(leftX, topY + height / 2, offset / 2, height / 2);
        // fill a 90 degree arc to erase the overflow from drawing the inner stripe on the right
        c.setColor(outer);
        c.fillArc(midX + midWidth * 4 / 5, topY, 2 * arcWidth - offset, height, 180, 90);
        // fill the outer edges of the outer stripe
        c.setColor(outer);
        c.fillRect(leftX + width - offset / 2, topY + height / 2, offset / 2, height / 2);

        // get the width of the arc for drawing the background color, erasing the overflow from the outer stripe
        arcWidth = midX - leftX;
        // fill an arc on the left and right side to erase the overflow from drawing the outer stripe
        c.setColor(skyBlue);
        c.fillArc(leftX - arcWidth, topY, 2 * arcWidth, height, 0, -90);
        c.setColor(skyBlue);
        c.fillArc(midX + midWidth, topY, 2 * arcWidth, height, 180, 90);
    } // drawPipe method

    // draws the image, where time is the percentage of how far we are in the animation, and opacity is the opacity of the image
    private void drawImage(int time, int opacity) {
        // calculate the dimensions for the clouds of the explosion
        int cloudWidth = exWidth * time / 99;
        int cloudY = exY + exHeight * (99 - time) / 99;
        int cloudX = exX + (exWidth - cloudWidth) / 2;
        int cloudHeight = exHeight * 4 * time / 7 / 99;

        // calculate the dimensions for the black oval under the cloud
        int underWidth = cloudWidth * 3 / 4;
        int underHeight = cloudHeight / 3;
        int underX = cloudX + (cloudWidth - underWidth) / 2;
        int underY = cloudY + cloudHeight * 3 / 4;

        // calculate the dimensions of the pipe of the explosion
        int pipeY = cloudY + cloudHeight * 3 / 4;
        int pipeWidth = exWidth * 4 / 5;
        int pipeX = exX + (exWidth - pipeWidth) / 2;
        int pipeHeight = exY + exHeight - pipeY;

        // calculate the various colors of the explosion, taking into account the opacity, where 0 is perfectly blue and 100 is a solid color
        Color under = new Color(135 - 135 * opacity / 100, 206 - 206 * opacity / 100, 235 - 235 * opacity / 100);
        Color pipeInner = new Color(135 + 36 * opacity / 100, 206 + 20 * opacity / 100, 235 - 235 * opacity / 100);
        Color pipeOuter = new Color(135 + 35 * opacity / 100, 206 - 206 * opacity / 100, 235 - 235 * opacity / 100);
        Color cloud = new Color(135 + 120 * opacity / 100, 206 + 49 * opacity / 100, 235 - 235 * opacity / 100);
        Color cloudRing = new Color(135 + 120 * opacity / 100, 206 - 120 * opacity / 100, 235 - 235 * opacity / 100);

        // fill the black oval under the cloud of the explosion
        c.setColor(under);
        c.fillOval(underX, underY, underWidth, underHeight);
        // draw the pipe
        drawPipe(pipeOuter, pipeInner, pipeX, pipeY, pipeWidth, pipeHeight);
        // draw the cloud
        drawCloud(cloud, cloudRing, cloudX, cloudY, cloudWidth, cloudHeight, exWidth / 3);

        // sleep for 50 milliseconds before proceeding with the next step of the animation
        try {
            Thread.sleep(50);
        } catch (Exception e) {
        } // Thread sleep catch clause

        // erase the oval under the cloud, the pipe, and the cloud itself, to "clear" the image for the next frame
        c.setColor(skyBlue);
        c.fillRect(cloudX, cloudY, exWidth * time / 99, exHeight * time / 99);
    } // drawImage method

    // animates the explosion fading away
    private void explodeOut() {
        // from an opacity of 100 to an opacity of 0 (current opacity tracked by [i]), slowly animate the explosion fading away
        for (int i = 100; i >= 0; i -= 10) {
            drawImage(100, i);
        } // for loop for fading the animation out
    } // explodeOut method

    // animates the explosion blowing up
    private void explodeIn() {
        // loop i from 0 to 100, which is how far along the animation should be
        for (int i = 0; i < 101; i += 10) {
            // draw the image at the i-th time, and at an opacity of i so that the explosion fades in as it moves
            drawImage(i, i);
        } // for loop for going through the animation
    } // explodeIn method

    // overloaded start method
    public void run() {
        // bring the explosion into the frame
        explodeIn();
        // fade the explosion out
        explodeOut();
    } // start method

} // Explosion class
