package ics3.Single.DanielYe_Graphics;

import hsa.Console;

import java.awt.*;

public class WordArt {

    Console c;

    public WordArt(){
        c = new Console("Word Art Poster");
    }

    public void drawPoster(){
        drawImages();
        drawWords();
    }

    private void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle, int thickness, Color outer, Color inner){
        c.setColor(outer);
        c.fillArc(x, y, width, height, startAngle, arcAngle);
        c.setColor(inner);
        c.fillArc(x + thickness, y + thickness, width - 2 * thickness, height - 2 * thickness, startAngle, arcAngle);
    }

    private void downString(String str, int x, int y, Color col, int fontHeight){
        for(int i = 0; i < str.length(); i++){
            drawString(str.substring(i, i + 1), x, y + i * fontHeight, col);
        }
    }

    private void drawImages(){
        for(int offset = 200; offset > 0; offset--){
            c.setColor(new Color(255 - (100 * offset / 200), 0, 0));
            c.fillOval(-offset, -offset, 640 + 2 * offset, 500 + 2 * offset);
        }
        c.setColor(Color.WHITE);
        c.fillOval(0, 0, 640, 500);

        Color darkGreen = new Color(0, 189, 85);
        drawArc(80, 0, 500, 500, -45 + 10, 180 - 20, 5, darkGreen, Color.WHITE);
        drawArc(80, 0, 500, 500, 135 + 10, 180 - 20, 5, darkGreen, Color.WHITE);
        drawArc(100, 20, 460, 460, 45 + 10, 180 - 20, 5, Color.GREEN, Color.WHITE);
        drawArc(100, 20, 460, 460, 225 + 10, 180 - 20, 5, Color.GREEN, Color.WHITE);

        c.setColor(Color.RED);
        c.fillRect(320 - 130, 250 - 50, 260, 100);
        c.fillRect(320 - 50, 250 - 130, 100, 260);

        int[] manXPoints = {170, 200, 230, 200, 190};
        int[] manYPoints = {120, 140, 100, 190, 150};
        c.setColor(Color.CYAN);
        c.fillPolygon(manXPoints, manYPoints, 5);
        c.fillOval(185, 100, 20, 20);
    }

    private void drawString(String str, int x, int y, Color col){
        c.setColor(col);
        c.drawString(str, x, y);
    }

    private void drawWords(){
        c.setFont(new Font("SansSerif", Font.BOLD, 36));
        drawString("HEALTHCARE", 320 - 120, 250 + 9, Color.WHITE);
        c.setFont(new Font("MonoSpaced", Font.BOLD, 28));
        drawString("Sickness", 320 + 50, 250 - 50, Color.BLUE);
        drawString("Treatment", 320 - 205, 250 + 70, Color.MAGENTA);
        drawString("Diagnosis", 320 + 50, 250 - 78, Color.PINK);
        drawString("Hospital", 320 - 190, 250 + 98, new Color(255, 123, 0));
        c.setFont(new Font("SansSerif", Font.BOLD, 28));
        drawString("Doctor", 320 + 50, 144, new Color(0, 255, 242));
        drawString("Lifesaving", 320 + 50, 250 + 70, new Color(255, 50, 190));
        drawString("Surgery", 320 + 50, 250 + 98, new Color(127, 255, 50));
        drawString("Care", 320 + 50, 250 + 126, new Color(69, 187, 255));
        c.setFont(new Font("Serif", Font.BOLD, 28));
        drawString("Shape", 320 - 40, 115, new Color(112, 0, 162));
        drawString("Health", 320 - 38, 400, new Color(0, 12, 155));

        c.setFont(new Font("MonoSpaced", Font.BOLD, 28));
        downString("Free", 320 - 68, 130, Color.GREEN, 20);
        downString("Sickness", 160, 150, Color.BLUE, 20);
        downString("Doctor", 140, 190, new Color(140, 0, 140), 20);
        downString("Care", 320 - 68, 370, Color.BLUE, 20);
        downString("Health", 510, 200, Color.ORANGE, 20);
        downString("Surgery", 233, 70, Color.ORANGE, 20);

        downString("Shape", 275, 290, Color.YELLOW, 20);
        drawString("Free", 295, 250 + 78, Color.ORANGE);
        downString("Nurse", 350, 140, Color.GREEN, 20);
        drawString("Doctor", 245, 220, Color.CYAN);
    }

    public static void main(String[] args){
        WordArt program = new WordArt();
        program.drawPoster();
    }

}
