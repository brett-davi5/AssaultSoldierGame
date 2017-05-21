package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Created by Family on 5/13/2017.
 */
public class newBoard extends JPanel {

    private final int B_WIDTH = 350;
    private final int B_HEIGHT = 350;
    private final int INITIAL_X = -40;
    private final int INITIAL_Y = -40;
    private final int INITIAL_DELAY = 100;
    private final int PERIOD_INTERVAL = 25;

    private Image imperialFist;
    private Timer timer;
    private int x, y;

    public newBoard(){
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

        timer = new Timer(); //The timer will regularly call the run() method of the ScheduleTask class
        timer.scheduleAtFixedRate(new ScheduleTask(), INITIAL_DELAY, PERIOD_INTERVAL);

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

    private class ScheduleTask extends TimerTask {
        @Override
        public void run(){ //here we create a timer and schedule a task with a specific interval. There is an initial delay of 1
            x += 1;
            y += 1;
            //each 10ms calls the run() method
            if(y > B_HEIGHT){
                y = INITIAL_Y;
                x = INITIAL_X;
            }
            repaint();
        }
    }

}
