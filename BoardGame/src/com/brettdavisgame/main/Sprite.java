package com.brettdavisgame.main;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.Image;

/**
 * Created by Family on 5/14/2017.
 */
public class Sprite {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean vis;
    protected Image image;

    public Sprite(int x, int y){ // this constructor initiates the x and y coordinates and the vis variable

        this.x = x;
        this.y = y;
        vis = true;
    }

    protected  void loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    protected void getImageDimensions(){
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void getBolterDimensions(){

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public Image getImage(){
        return image;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public boolean isVisible(){
        return vis;
    }

    public void setVisible(Boolean visible){
        vis = visible;
    }

    public Rectangle getBounds(){ //this returns the bounds for collision detection
        return new Rectangle (x, y, width, height);
    }
}
