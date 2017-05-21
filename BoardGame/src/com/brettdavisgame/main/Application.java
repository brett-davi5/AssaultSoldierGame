package com.brettdavisgame.main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Family on 4/9/2017.
 */
public class Application extends JFrame {

    public Application(){

        initUI();
    }

    private void initUI(){

        add(new Board()); //create a board to the JFrame window

        setSize(1000,850); //set the size to 1000x850

        setTitle("Adella's Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes application when clicked close
        setLocationRelativeTo(null); //centers the window on the screen

    }

    public static void main(String[] args){

        EventQueue.invokeLater(new Runnable(){

            @Override
                    public void run(){
                        Application ex = new Application();
                        ex.setVisible(true);

            }

        });
    }
}
