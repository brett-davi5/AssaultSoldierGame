package com.brettdavisgame.main;

import java.util.Random;

/**
 * Created by Family on 5/20/2017.
 */
public class Enemy extends Sprite {

    private final int INITAL_X = 1200;



    public Enemy(int x, int y){
        super(x, y);
        initEnemy();
    }

    private void initEnemy(){
        loadImage("C:\\Users\\Family\\Desktop\\Java Projects\\BoardGame\\src\\Resources\\images\\OrkSlugga2.png");
        getImageDimensions();
    }

    public void move(){

        if( x < 0){
            x = INITAL_X;
        }

        x -= 3;
    }


}
