package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Family on 5/13/2017.
 */
public class MovingSpriteEx extends JFrame {

    public MovingSpriteEx(){
        initUI();
    }

    private void initUI(){
        add(new AstartesBoard());

        setSize(400, 300);
        setResizable(false);

        setTitle("Astartes!");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                MovingSpriteEx ex = new MovingSpriteEx();
                ex.setVisible(true);
            }
        });
    }
}
