package MyCreation;
/* Ryan Atlas, Daniel Ye and Judah Brill
   November 9th, 2021
   Ms. Basaraba
   This program will display and animate a small story about fighter planes
   that makes use of Threads and Runnables to simulate movement and animate
   the program. This file acts as the main file where the Threads from all the
   others will be displayed. */

import hsa.Console;

import java.awt.*;

public class MyCreation {
    Console c; // The output console

    public MyCreation()  // MyCreation class constructor
    {
        c = new Console("My Creation: Fighter Planes"); // Creates a new Console object named c with a window title
    } // MyCreation constructor

    // draws the background
    public void background() {
        // initialize the background
        Background backgroundOf = new Background(c);
        // draw the background
        backgroundOf.drawBackground();
        // initialize the buildings
        Buildings buildings = new Buildings(c, 6500);
        // start the buildings thread
        Thread t = new Thread(buildings);
        t.start();
    } // background method

    // method for the first plane
    public void firstPlane(){
        // initialize the plane & start its thread
		Plane first = new Plane(c, -100, 160);
		Thread t = new Thread(first);
		t.start();
	} // firstPlane method

    // method for the bomb
	public void bomb(){
        // initialize the bomb
        Bomb bomb = new Bomb(c);
        bomb.start();
    } // bomb method

    // draws an explosion for the city
    public void buildingExplosion(){
        // initialize and start the explosion
        Explosion e = new Explosion(c, 400, 220, 200, 240);
        e.start();
    } // buildingExplosion method

    // draws the second plane that appears
    public void secondPlane(){
        // initialize and start the toDestroy method
        Plane toDestroy = new Plane(c, 150, 210, Color.GRAY, 490);
        Thread t = new Thread(toDestroy);
        t.start();
    } // secondPlane method

    // draws the plane that attacks the other plane
    public void attackPlane(){
        // initialize and start the attackingPlane plane
        Plane attackPlane = new Plane(c, -100, 170, Color.RED);
        Thread t = new Thread(attackPlane);
        t.start();
    } // attackPlane

    // draws the missile
    public void missile(){
        // initialize and start the missile
        Missile m = new Missile(c);
        m.start();
    } // missile method

    // damagedPlane method
    public void damagedPlane() {
        // initialize and start the damagedPlane plane
        DamagedPlane damagedPlane = new DamagedPlane(c, -120, 450);
        Thread t = new Thread(damagedPlane);
        t.start();
    } // damagedPlane method

    // method for the parachute
    public void parachute() {
        // initialize and start the parachute
        Parachute p = new Parachute(c);
        Thread thread4 = new Thread(p);
        thread4.start();
    } // parachute method

    // method for the explosion from the missile
    public void missileExplosion(){
        // initialize and start the missile explosion
        Explosion e = new Explosion(c, 200, 180, 50, 60);
        e.start();
    } // missileExplosion method

    // method for the explosion after the plane crashes into the ground
    public void planeExplosion(){
        // initialize and start the plane explosion
        Explosion e = new Explosion(c, -90, 330, 250, 130);
        e.start();
    } // planeExplosion method

    public static void main(String[] args)  // main method
    {
        try{
            // initialize MyCreation
            MyCreation m = new MyCreation();

            // draw the background and the first plane
            m.background();

            Thread.sleep(150);
            m.firstPlane();

            // after 4.5 seconds, start the bomb dropping
            Thread.sleep(4500);
            m.bomb();
            // after the bomb hits the city, start the explosion
            Thread.sleep(1900);
            m.buildingExplosion();

            // after 7 seconds, draw the second plane
            Thread.sleep(7000);
            m.secondPlane();
            // after 6 seconds, draw the attacking plane
            Thread.sleep(6000);
            m.attackPlane();

            // after a second, shoot the missile
            Thread.sleep(1000);
            m.missile();
            // when the missile hits the plane, explode them and add the damaged plane
            Thread.sleep(900);
            m.missileExplosion();
            m.damagedPlane();

            // have the pilot eject
            Thread.sleep(200);
            m.parachute();
            // after 3 seconds, draw the plane explosion
            Thread.sleep(3000);
            m.planeExplosion();
        } catch(Exception e){
        } // try/catch for Thread.sleep in main
    } // main method
} // MyCreation class
