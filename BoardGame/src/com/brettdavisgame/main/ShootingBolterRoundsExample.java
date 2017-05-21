package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 * Created by Family on 5/14/2017.
 */
public class ShootingBolterRoundsExample extends JFrame {

    public ShootingBolterRoundsExample(){
        initUI();
    }

    private void initUI(){

        add(new AstartesBoard());

        setSize(1200, 900);
        setResizable(false);

        setTitle("Enemy sighted. Neutralizing!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run(){
                ShootingBolterRoundsExample ex = new ShootingBolterRoundsExample();
                ex.setVisible(true);
            }

        });
    }
}
