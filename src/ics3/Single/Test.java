package ics3.Single;

import hsa.*;

import java.awt.*;

public class Test {

    public static void main(String[] args) {
        Console c = new Console();
        c.println("hi");
        c.fillRect(200, 200, 100, 100);
        char k = c.getChar();
        c.println(k == '\n');
        c.println("asdf");
    }
}
