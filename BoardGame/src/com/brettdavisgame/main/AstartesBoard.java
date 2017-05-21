package com.brettdavisgame.main;

import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.util.ArrayList;

/**
 * Created by Family on 5/13/2017.
 */
public class AstartesBoard extends JPanel implements ActionListener {

    private Timer timer;
    private Astartes astartes;
    private final int DELAY = 10;
    private final int IASTARTES_X = 40;
    private final int IASTARTES_Y = 60;

    public AstartesBoard(){
        initBoard();
    }

    public void initBoard(){
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(java.awt.Color.BLACK);
        setDoubleBuffered(true);

        astartes = new Astartes(IASTARTES_X, IASTARTES_Y);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g){ //draw the astartes, we get the image of the astartes, and the coordinates of the sprite class for it
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(astartes.getImage(), astartes.getX(), astartes.getY(), this);

        ArrayList br = astartes.getBoltRounds(); //draw an ArrayList of available bolter shots

        for( Object o1: br){ //for every object in the arrayList of bolter shots, draw the image onto the board
            BoltGunShot b = (BoltGunShot) o1;
            g2d.drawImage(b.getImage(), b.getX(), b.getY(), this);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e){ //this method is called every DELAY ms. We move the sprite then repaint the board.

        updateBoltRounds();
        updateAstartes();

        //astartes.move();
        repaint();
    }

    private void updateBoltRounds(){
        ArrayList br = astartes.getBoltRounds();

        for(int i = 0; i < br.size(); i++){
            BoltGunShot b = (BoltGunShot) br.get(i); //parse all bolter rounds from the ArrayList.

            //now, depending upon what the isVisible() returns (true/false), we either move it or remove it
            if(b.isVisible()){ //we fired the shot, so isVisible() = true
                b.move();
            }else{
                br.remove(i); //once it goes off screen (BoltGunShot isVisible() = false), we remove it
            }
        }
    }

    private void updateAstartes(){
        astartes.move();
    }

    private class TAdapter extends KeyAdapter { //In this board class, we listen for key events. The overridden methods of the KeyAdapter class delegate
        //the processing to the methods of the Craft class
        @Override
        public void keyReleased(KeyEvent e){
            astartes.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e){
            astartes.keyPressed(e);
        }
    }



}
