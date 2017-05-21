package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Created by Family on 5/13/2017.
 */
public class threadBoard extends JPanel implements Runnable{

    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int DELAY = 25;

    private Image imperialFist;
    private Thread animator;
    private int x, y;

    public threadBoard(){
        initBoard();
    }

    private void loadImage(){
        ImageIcon ii = new ImageIcon("C:\\Users\\Family\\Desktop\\Java Projects\\BoardGame\\src\\Resources\\images\\ImperialFistSmallest.png");
        imperialFist = ii.getImage();

    }

    private void initBoard(){
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;
    }

    @Override
    public void addNotify(){
        super.addNotify();

        animator = new Thread();
        //animator.start();

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawImperialFist(g);

    }

    private void drawImperialFist(Graphics g){

        g.drawImage(imperialFist, x, y, this);
        Toolkit.getDefaultToolkit().sync();

    }

    private void cycle(){

        x += 1;
        y += 1;

        if(y > B_HEIGHT){
            y = INITIAL_Y;
            x = INITIAL_X;
        }
    }

    @Override
    public void run(){
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while(true){
            cycle();
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if(sleep <0){
                sleep = 2;
            }

            //try{
                //Thread.sleep(sleep);
            //}catch(InterruptedException e){
            //    System.out.println("Interrupted: " + e.getMessage());

            //}

            beforeTime = System.currentTimeMillis();
        }
    }

}
