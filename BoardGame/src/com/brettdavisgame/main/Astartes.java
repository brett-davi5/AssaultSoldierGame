package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 * Created by Family on 5/13/2017.
 */
public class Astartes extends Sprite{

    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    private ArrayList boltRounds;

    public Astartes(int x, int y){

        super(x, y);

        initAstartes();
    }

    private void initAstartes() {

        boltRounds = new ArrayList();
        //loadImage("C:\\Users\\Family\\Desktop\\Java Projects\\BoardGame\\src\\Resources\\images\\ImperialFistSmallest.png");
        //getImageDimensions();

        ImageIcon ii = new ImageIcon("C:\\Users\\Family\\Desktop\\Java Projects\\BoardGame\\src\\Resources\\images\\sternguardMK2.png");
        image = ii.getImage();
        x = 40;
        y = 60;
    }

    public void move(){ //changes coordinates of the sprite
        x += dx;
        y += dy;
    }

    public ArrayList getBoltRounds(){ //returns the ArrayList of boltRounds
        return boltRounds;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public Image getImage(){
        return image;
    }

    public void keyPressed(KeyEvent e){ //if we press a key, it moves accordingly
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_SPACE){ //space key = fire
            fire();
        }
        //wasd movement controls
        if(key == KeyEvent.VK_A){
            dx = -6;
        }
        if(key == KeyEvent.VK_D){
            dx = 6;
        }
        if(key == KeyEvent.VK_W){
            dy = -6;
        }
        if(key == KeyEvent.VK_S){
            dy = 6;
        }
    }

    public void fire(){ //creates a new BoltGunShot object and adds it to the boltRounds ArrayList
        boltRounds.add(new BoltGunShot(x + width, y + height /2));
    }

    public void keyReleased(KeyEvent e){ //if we release the key, the Astartes stops moving
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A){
            dx = 0;
        }
        if(key == KeyEvent.VK_D){
            dx = 0;
        }
        if(key == KeyEvent.VK_W){
            dy = 0;
        }
        if(key == KeyEvent.VK_S){
            dy = 0;
        }
    }


}
