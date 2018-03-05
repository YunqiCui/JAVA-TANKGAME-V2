package com.tankgamev2;

public class EnemyTank extends Tank{

    public EnemyTank(int x, int y){
        super(x,y);
        this.setDirect(2);
        this.setType(0);

    }
}
