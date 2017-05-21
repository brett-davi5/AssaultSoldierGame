package com.brettdavisgame.main;

import javax.swing.*;

/**
 * Created by Family on 4/9/2017.
 */
public class Donut extends JFrame {

    public Donut(){

        initUI();
    }

    private void initUI(){

        add(new Board());

        setSize(330, 330);

        setTitle("Donut");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

//    public static void main(String[] args){
//
//        EventQueue.invokeLater(new Runnable(){
//            @Override
//                    public void run(){
//                Donut ex = new Donut();
//                ex.setVisible(true);
//            }
//        });
//
//    }
}
