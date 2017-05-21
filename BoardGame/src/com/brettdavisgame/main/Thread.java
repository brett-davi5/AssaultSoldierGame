package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Family on 5/13/2017.
 */
public class Thread extends JFrame {

    public Thread(){
        initUI();
    }

    private void initUI(){
        add(new Board());

        setResizable(false);
        pack();

        setTitle("Imperial Fist!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame ex = new Thread();
                ex.setVisible(true);
            }
        });
    }

}
