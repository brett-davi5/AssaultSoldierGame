package com.brettdavisgame.main;

/**
 * Created by Family on 5/14/2017.
 */
public class BoltGunShot extends Sprite {

    private final int BOARD_WIDTH = 1200;
    private final int BOLT_SPEED = 48;

    public BoltGunShot(int x, int y){
        super(x, y + 40);
        initBoltGunShot();
    }

    private void initBoltGunShot(){
        loadImage("C:\\Users\\Family\\Desktop\\Java Projects\\BoardGame\\src\\Resources\\images\\bolterRound2.png");
        getBolterDimensions();
    }

    public void move(){ //moves at constant speed
        x += BOLT_SPEED;

        if(x > BOARD_WIDTH){ //when it hits the right border fo the Board(), it becomes invisible. It is then removed from the list of missiles.
            vis = false;
        }
    }



}
