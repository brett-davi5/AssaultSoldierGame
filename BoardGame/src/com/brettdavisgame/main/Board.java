package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;

/**
 * Created by Family on 4/9/2017.
 */
public class Board extends JPanel {

    //set up the board for the game

    private Image marineTest; //Test object for our first pic, the plasmaMarineGif!

    public Board(){
        initBoard();
    }

    private void initBoard(){

        loadImage();

        int width =  marineTest.getWidth(this);
        int height =  marineTest.getHeight(this);
        setPreferredSize(new Dimension(width, height));
        //image width and height is set to the default size of the image

    }

    private void loadImage(){

        ImageIcon ii = new ImageIcon("C:\\Users\\Family\\Desktop\\Java Projects\\BoardGame\\src\\Resources\\images\\ImperialFistSmallest.png"); //this creates an image Icon

        marineTest = ii.getImage(); //we go get the image!
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(marineTest, 0, 0, null); //draw the image on the window
    }





//    @Override
//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//        drawDonut(g);
//    }

//    private void drawDonut(Graphics g){
//
//        Graphics2D g2d = (Graphics2D) g; //extends graphics class
//        //this provides more control over gemoetry, coordinate transformtations, color management, and text layout
//
//        //-----------------------------------------------------------------------------
//        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//
//        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//
//        g2d.setRenderingHints(rh);
//
//        //rendering hints are used to make the drawing smooth
//
//        //-----------------------------------------------------------------------------
//        Dimension size = getSize(); //used to get the width and heigh of the window
//        double w = size.getWidth(); //we need these to center the donut on teh shape of the window
//        double h = size.getHeight();
//
//        //-----------------------------------------------------------------------------
//        //let's creat the ellipse
//        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
//        g2d.setStroke(new BasicStroke(1));
//        g2d.setColor(Color.gray);
//
//        //-----------------------------------------------------------------------------
//        //ellipse is rotated 72 times to create a donut shape
//        for(double deg = 0; deg < 360; deg += 5){
//            AffineTransform at = AffineTransform.getTranslateInstance(w/2, h/2);
//            at.rotate(Math.toRadians(deg));
//            g2d.draw(at.createTransformedShape(e));
//        }
//
//    }
}
