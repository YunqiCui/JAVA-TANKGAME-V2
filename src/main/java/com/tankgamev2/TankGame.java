package com.tankgamev2;
/*
 * TankGame Version1
 * @author Yunqi Cui
 * 27/02/2018
 * @version 1.0
 */

import javax.swing.*;

public class TankGame extends JFrame {

    MyTank mtk = new MyTank();

    public static void main(String[] args) {

        TankGame tg1 = new TankGame();

    }

    public TankGame() {

        this.add(mtk);
        this.setTitle("Tank Game");
        this.setSize(400, 300);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.addKeyListener(mtk);
    }


}
