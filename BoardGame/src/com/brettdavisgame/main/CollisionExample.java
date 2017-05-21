package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Created by Family on 5/20/2017.
 */
public class CollisionExample extends JFrame {

    public CollisionExample(){
        initUI();
    }

    private void initUI(){

        add(new CollisionBoard());

        setSize(1200, 300);
        setResizable(false);
        pack();

        setTitle("For the Emperor!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CollisionExample ex = new CollisionExample();
                ex.setVisible(true);
            }
        });
    }
}
