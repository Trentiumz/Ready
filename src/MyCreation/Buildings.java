package MyCreation;

/*
 * Ryan Atlas, Judah Brill, Daniel Ye
 * November 21, 2021
 * Ms. Basaraba
 * This class draws the buildings of the MyCreation background, and makes them disappear after [delay] milliseconds
 */

// imports

import hsa.Console;

import java.awt.*;

// Buildings class
public class Buildings implements Runnable {

    private Console c; // interface for drawing onto the screen
    private int delay; // number of milliseconds before disappearing

    // the various colors that the buildings class will use
    private Color firebrickRed;
    private Color houseBody;
    private Color windowBlue;
    private Color doorBrown;
    private Color skyBlue;

    // the font that the shop uses to display "SHOP"
    private Font shopFont;

    // Buildings constructor
    public Buildings(Console con, int millisToGone) {
        // set the instance variables to their corresponding parameters
        c = con;
        delay = millisToGone;

        // initialize the colors
        firebrickRed = new Color(178, 34, 34);
        houseBody = new Color(128, 128, 128);
        windowBlue = new Color(0, 255, 255);
        doorBrown = new Color(51, 25, 0);
        skyBlue = new Color(135, 206, 235);

        // initialize the shop font
        shopFont = new Font("SansSerif", Font.BOLD, 30);
    } // Buildings constructor

	// fills a rectangle
	void fillRect(int x, int y, int width, int height) {
    	int iters = Math.max(width / 2, height / 2);
		// draws width / 2 rectangles, filling an entire rectangle
		for (int i = 0; i < iters; i++) {
			c.drawRect(x + i * width / iters / 2, y + height * i / iters / 2, width - i * width / iters, height - height * i / iters);
		} // for loop for filling a rectangle
	} // fillRect method

    // fills a rectangle
    void fillRect(int x, int y, int width, int height, Color col) {
        int iters = Math.max(width / 2, height / 2);
        // draws width / 2 rectangles, filling an entire rectangle
        for (int i = 0; i < iters; i++) {
            c.setColor(col);
            c.drawRect(x + i * width / iters / 2, y + height * i / iters / 2, width - i * width / iters, height - height * i / iters);
        } // for loop for filling a rectangle
    } // fillRect method

    void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
        // draws width / 2 rectangles, filling an entire rectangle
        for (int i = 0; i <= width / 2; i++) {
            c.drawRoundRect(x + i, y + i, width - 2 * i, height - 2 * i, arcWidth, arcHeight);
        } // for loop for filling a rectangle
    }

    // draws a house
    private void drawHouse(int leftX, int topY, int width, int height) {
        // calculate the coordinates that make up the triangle of the roof
        int[] roofX = {leftX, leftX + width / 2, leftX + width};
        int[] roofY = {topY + height / 3, topY, topY + height / 3};
        // fill in a roof
        c.setColor(firebrickRed);
        // for loop for filling in the roof
        for (int i = 0; i < 100; i++) {
            // calculate the coordinates of the triangle for the house, shrunken by i%
            int[] curX = {leftX + i * width / 200, leftX + width / 2, leftX + width - i * width / 200};
            int[] curY = {topY + height / 3 - height * i / 600, topY + height * i / 600, topY + height / 3 - height * i / 600};
            // draw in the polygon
            c.drawPolygon(curX, curY, 3);
        } // for loop for filling in the roof

        // outline the roof
        c.setColor(Color.BLACK);
        c.drawPolygon(roofX, roofY, 3);

        // set the color to the body of the house
        c.setColor(houseBody);

        // fill in the body of the house and outline it
        fillRect(leftX, topY + height / 3, width, height * 2 / 3);
        c.setColor(Color.BLACK);
        c.drawRect(leftX, topY + height / 3, width, height * 2 / 3);

        // set the color to the windows
        c.setColor(windowBlue);
        // fill in the two windows with the windows color
        fillRect(leftX + width / 5 - 3, topY + height / 2, width / 5, height / 5);
        fillRect(leftX + width * 3 / 5 + 3, topY + height / 2, width / 5, height / 5);
        // outline the two windows
        c.setColor(Color.BLACK);
        c.drawRect(leftX + width / 5 - 3, topY + height / 2, width / 5, height / 5);
        c.drawRect(leftX + width * 3 / 5 + 3, topY + height / 2, width / 5, height / 5);

        // set the color to the door and fill in a brown for the door
        c.setColor(doorBrown);
        fillRect(leftX + width * 2 / 5, topY + height * 2 / 3, width / 5, height / 3);
    } // drawHouse method

    // draws a skyscraper
    private void drawSkyscraper(int leftX, int topY, int width, int height) {
        // fill in the body of the skyscraper
        c.setColor(houseBody);
        fillRect(leftX, topY + height / 6, width, height * 5 / 6);

        // draw the antenna for the skyscraper
        c.setColor(Color.BLACK);
        c.drawRect(leftX, topY + height / 6, width, height * 5 / 6);
        c.drawLine(leftX + width / 2, topY, leftX + width / 2, topY + height / 6);

        // draw evenly spaced out windows along the height of the skyscraper
        for (int i = topY + height / 6 + width / 2; i < topY + height; i += width) {
            // fill in a round rectangle for the window
            c.setColor(windowBlue);
            fillRoundRect(leftX + width / 4, i, width / 2, width / 2, 4, 4);

            // outline the current window
            c.setColor(Color.BLACK);
            c.drawRoundRect(leftX + width / 4, i, width / 2, width / 2, 4, 4);
        } // for loop for drawing windows
    } // drawSkyscraper method

    // draws the shop, which is 100 pixels by 90 pixels
    private void drawShop(int leftX, int topY) {
        // fill and outline the body of the shop
        c.setColor(Color.WHITE);
        fillRect(leftX, topY, 100, 90);
        c.setColor(Color.BLACK);
        c.drawRect(leftX, topY, 100, 90);

        // display the SHOP sign at the front of the shop
        c.setFont(shopFont);
        c.setColor(firebrickRed);
        c.drawString("SHOP", leftX + 10, topY + 30);

        // draw evenly spaced out windows
        for (int i = 3; i < 90; i += 25) {
            // fill in a round rect for the window, and outlines it
            c.setColor(windowBlue);
            fillRoundRect(leftX + i, topY + 40, 19, 19, 4, 4);
            c.setColor(Color.BLACK);
            c.drawRoundRect(leftX + i, topY + 40, 19, 19, 4, 4);
        } // for loop for drawing windows

        // fill in a grey rectangle for the two doors
        c.setColor(Color.GRAY);
        fillRect(leftX + 33, topY + 65, 33, 25);
        // outline the two doors
        c.setColor(Color.BLACK);
        c.drawRect(leftX + 33, topY + 65, 16, 25);
        c.drawRect(leftX + 49, topY + 65, 17, 25);
    } // drawShop method

    // draws the entire city
    private void drawCity() {
        // draw three houses on the left
        drawHouse(320, 400, 60, 60);
        drawHouse(290, 400, 60, 60);
        drawHouse(365, 400, 70, 60);

        // draw a shop to the right of the houses
        drawShop(450, 370);

        // draws 4 skyscrapers at the right of the city
        drawSkyscraper(560, 310, 20, 150);
        drawSkyscraper(585, 310, 20, 150);
        drawSkyscraper(610, 310, 20, 150);
        drawSkyscraper(635, 310, 20, 150);
    } // drawCity method

    // erases the city
    private void eraseCity() {
        // sets the color to the sky blue color, and fills in the city
        fillRect(280, 310, 360, 151, skyBlue);
    } // eraseCity method

    // default run method
    public void run() {
        // draws the city
        drawCity();
        try {
            // after [delay] milliseconds, erase the city
            Thread.sleep(delay);
            eraseCity();
        } catch (Exception e) {
        } // try/catch for Thread.sleep
    } // run method

	public static void main(String[] args){
		new Thread(new Buildings(new Console(), 10000)).start();
	}
} // Buildings class
