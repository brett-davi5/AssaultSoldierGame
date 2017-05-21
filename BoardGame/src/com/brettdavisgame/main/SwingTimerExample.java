package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Family on 4/15/2017.
 */
public class SwingTimerExample extends JFrame {

    public SwingTimerExample(){
        initUI();
    }

    private void initUI(){

        add(new swingTimerExampleBoard());

        setResizable(true); //sets whether or not the frame can be resized
        pack();//causes the window to be sized to fit the preferred size and layouts
        //of its children

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run(){
                JFrame ex = new SwingTimerExample();
                ex.setVisible(true);
            }

        });

    }



}
