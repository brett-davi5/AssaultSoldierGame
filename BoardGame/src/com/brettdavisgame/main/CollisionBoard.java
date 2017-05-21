package com.brettdavisgame.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Created by Family on 5/20/2017.
 */
public class CollisionBoard extends JPanel implements ActionListener {

    private Timer timer;
    private Astartes astartes;
    private ArrayList<Enemy> enemies;
    private boolean ingame;
    private final int IASTARTES_X = 40;
    private final int IASTARTES_Y = 60;
    private final int B_WIDTH = 1200;
    private final int B_HEIGHT = 300;
    private final int DELAY = 15;

    private final int[][] pos = {
            {2380, 29}, {2500, 59}, {1380, 89},
            {780, 109}, {580, 139}, {680, 239},
            {790, 259}, {760, 50}, {790, 150},
            {980, 209}, {560, 45}, {510, 70},
            {930, 159}, {590, 80}, {530, 60},
            {940, 59}, {990, 30}, {920, 200},
            {900, 259}, {660, 50}, {540, 90},
            {810, 220}, {860, 20}, {740, 180},
            {820, 128}, {490, 170}, {700, 30}
    };

    public CollisionBoard(){
        initBoard();
    }

    private void initBoard(){

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.LIGHT_GRAY);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        astartes = new Astartes(IASTARTES_X, IASTARTES_Y);

        initEnemies();

        timer = new Timer(DELAY, this);
        timer.start();

    }

    public void initEnemies(){

        enemies = new ArrayList<Enemy>();

        for(int[] p : pos){
            enemies.add(new Enemy(p[0], p[1]));
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(ingame){
            drawObjects(g);
        }else{
            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g){

        if(astartes.isVisible()){
            g.drawImage(astartes.getImage(), astartes.getX(), astartes.getY(), this);
        }

        ArrayList<BoltGunShot> b = astartes.getBoltRounds();

        for(BoltGunShot bolts : b){
            if(bolts.isVisible()){
                g.drawImage(bolts.getImage(), bolts.getX(), bolts.getY(), this);
            }
        }

        for(Enemy e : enemies){
            if(e.isVisible()){
                g.drawImage(e.getImage(), e.getX(), e.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
        g.drawString("Enemies left: " + enemies.size(), 5, 15);

    }

    private void drawGameOver(Graphics g){
        String message = "ONLY IN DEATH DOES DUTY END.";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.red);
        g.setFont(small);
        g.drawString(message, (B_WIDTH - fm.stringWidth(message)) / 2, B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e){


        inGame();

        updateAstartes();
        updateBolterShots();
        updateEnemies();

        checkCollision();

        repaint();
    }

    private void inGame(){
        if(!ingame){
            timer.stop();
        }
    }

    private void updateAstartes(){
        if(astartes.isVisible()){
            astartes.move();
        }
    }

    private void updateBolterShots(){

        ArrayList<BoltGunShot> bolts = astartes.getBoltRounds();

        for(int i = 0; i < bolts.size(); i++){

            BoltGunShot b = bolts.get(i);

            if(b.isVisible()){
                b.move();
            }else{
                bolts.remove(i);
            }

        }

    }

    private void updateEnemies(){
        if(enemies.isEmpty()){
            ingame = false;
            return;
        }

        for(int i = 0; i < enemies.size(); i++){
            Enemy alpha = enemies.get(i);
            if(alpha.isVisible()){
                alpha.move();
            }else{
                enemies.remove(i);
            }
        }
    }

    public void checkCollision(){

        Rectangle r3 = astartes.getBounds();

        for(Enemy enemy : enemies){
            Rectangle r2 = enemy.getBounds();

            if(r3.intersects(r2)){
                astartes.setVisible(false);
                enemy.setVisible(false);
                ingame = false;
            }
        }

        ArrayList<BoltGunShot> bolts = astartes.getBoltRounds();

        for(BoltGunShot b : bolts){
            Rectangle r1 = b.getBounds();

            for(Enemy enemy : enemies){

                Rectangle r2 = enemy.getBounds();
                if(r1.intersects(r2)){
                    b.setVisible(false);
                    enemy.setVisible(false);
                }

            }
        }


    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e){
            astartes.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e){
            astartes.keyPressed(e);
        }


    }









}
