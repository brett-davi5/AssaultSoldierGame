package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Family on 4/15/2017.
 */
public class swingTimerExampleBoard extends JPanel implements ActionListener{

    private final int B_WIDTH = 350; //board width
    private final int B_HEIGHT = 350;//board height
    private final int INITIAL_X = -40; //initial coordinates of the star
    private final int INITIAL_Y = -40; //initial coordinates of the star
    private final int DELAY = 25; //speed of the animation

    private Image star;
    private Timer timer;
    private int x, y;

    public swingTimerExampleBoard(){

        initBoard();
    }

    private void loadImage(){ //create our image icon of the star itself

        ImageIcon ii = new ImageIcon("C:\\Users\\Family\\Desktop\\Java Projects\\BoardGame\\src\\Resources\\images\\star1.png");
        star = ii.getImage();
    }

    private void initBoard(){

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true); //uses a buffer to paint
        //this means the drawing will be done in memory first
        //later the off-screen buffer will be copied to the screen
        //you might not notice any differences in this example

        loadImage();

        x = INITIAL_X;
        y = INITIAL_Y;

        timer = new Timer(DELAY, this); //create the timer object
        //the DELAY ms the timer will call the actionPerformed() method
        //in order to implement the ActionListener interface
        timer.start();//start that timer!

    }

    public void paintComponent(Graphics g){ //custom painting of the paintComponent() method

        super.paintComponent(g); //call the parent method
        drawStar(g); //the actual painting is done here

    }

    private void  drawStar(Graphics g){ //draw the image of the star onto the window

        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync(); //this synchronises the painting on systems that
        //buffer graphics events
        //without this, it'll not be smooth
    }

    @Override
    public void actionPerformed(ActionEvent e){ //called the timer

        x += 1;
        y += 1;

        if(y> B_HEIGHT){
            y = INITIAL_Y; //increasing the values of y
            x = INITIAL_X; //increasing the values of x
        }

        repaint(); //this calls the paintComponent() method
        //this regularly repaitns the Board thus making the animation

    }



}
