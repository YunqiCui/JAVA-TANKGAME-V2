package com.tankgamev2;/*
 * Class PlayerTank
 * @author Yunqi Cui
 * 27/02/2018
 */


public class PlayerTank extends Tank{

    //up:0 right:1 down:2 left:3



    public PlayerTank(int x, int y) {
        super(x, y);
        this.setDirect(0);
        this.setSpeed(5);
        this.setType(1);
    }


    public void moveUp(){
        this.y-=this.getSpeed();
    }

    public void moveRight(){
        this.x+=this.getSpeed();
    }

    public void moveDown(){
        this.y+=this.getSpeed();
    }

    public void moveLeft(){
        this.x-=this.getSpeed();
    }

}
