package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Family on 4/9/2017.
 */
public class Image extends JFrame {

    public Image(){
        initUI();
    }

    private void initUI(){
        add(new Board());

        pack();

        setTitle("Plasma Marine Test!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
                public void run(){
                    Image ex = new Image();
                    ex.setVisible(true);
            }
        });
    }
}
