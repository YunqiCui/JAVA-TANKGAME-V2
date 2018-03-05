package com.tankgamev2;/*
 * Class MyGraph to draw Tank
 * @author Yunqi Cui
 * 27/02/2018
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyTank extends JPanel implements KeyListener,Runnable
{

    private PlayerTank pt;
    private Vector<EnemyTank> etv = new Vector<EnemyTank>();
    int enemySize =3;
    public int x=0;
    public int y=0;

    public MyTank() {
        pt = new PlayerTank(100, 100);

        for (int i = 0; i < enemySize; i++) {
            EnemyTank et = new EnemyTank((i+1)*50,0);
            et.setType(0);
            etv.add(et);
        }

        x=pt.getX();
        y=pt.getY();
    }

    public void paint(Graphics g) {

        super.paint(g);
        this.drawGameField(g);
        //draw Player Tank
        this.drawTank(pt.getX(), pt.getY(), g, pt.getDirect(), pt.getType());

        //Draw Player Player Bullet
        if(pt.b!=null && pt.b.isAlive == true){
            g.draw3DRect(pt.b.x,pt.b.y,1,1,false);
        }


        //draw Enemy Tank
        for (int i = 0; i <enemySize ; i++) {
            this.drawTank(etv.get(i).getX(),etv.get(i).getY(),g,etv.get(i).getDirect(),etv.get(i).getType());
        }
    }

    public void drawGameField(Graphics g) {
        g.fillRect(0, 0, 400, 300);
    }

    //Draw Tank Function
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //Tpye of Tank
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;

            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch (direct) {
            case 0:
                //Left Rectangular
                g.fill3DRect(x, y, 5, 30, false);
                //Middle Rectangular
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                //Right Rectangular
                g.fill3DRect(x + 15, y, 5, 30, false);
                //Circle
                g.fillOval(x + 7, y + 10, 6, 10);
                //UpLine
                g.drawLine(x + 10, y + 15, x+10, y);
                break;

            case 1:
                //Up Rectangular
                g.fill3DRect(x, y, 30, 5, false);
                //Middle Rectangular
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                //Down Rectangular
                g.fill3DRect(x, y+15, 30, 5, false);
                //Circle
                g.fillOval(x + 10, y + 7, 10, 6);
                //RightLine
                g.drawLine(x + 15, y + 10, x+30, y+10);
                break;

            case 2:
                //Left Rectangular
                g.fill3DRect(x, y, 5, 30, false);
                //Middle Rectangular
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                //Right Rectangular
                g.fill3DRect(x + 15, y, 5, 30, false);
                //Circle
                g.fillOval(x + 7, y + 10, 6, 10);
                //DownLine
                g.drawLine(x + 10, y + 15, x+10, y+30);
                break;

            case 3:
                //Up Rectangular
                g.fill3DRect(x, y, 30, 5, false);
                //Middle Rectangular
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                //Down Rectangular
                g.fill3DRect(x, y+15, 30, 5, false);
                //Circle
                g.fillOval(x + 10, y + 7, 10, 6);
                //LeftLine
                g.drawLine(x + 15, y + 10, x, y+10);
                break;
                }
    }


    public void keyTyped(KeyEvent e) {

    }
    //Move Tank by Keyboard
    public void keyPressed(KeyEvent e) {


        if(e.getKeyCode()==KeyEvent.VK_UP
                ){

            pt.setDirect(0);
            pt.moveUp();

            }else if(e.getKeyCode()==KeyEvent.VK_RIGHT){

            pt.setDirect(1);
            pt.moveRight();

        }else if(e.getKeyCode()==KeyEvent.VK_DOWN){

            pt.setDirect(2);
            pt.moveDown();

        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){

            pt.setDirect(3);
            pt.moveLeft();

        }else{
            System.out.println("Not a direction key");
        }
        if(e.getKeyCode()== KeyEvent.VK_SPACE){
            pt.shot();
        }
        this.repaint();
        }

    public void keyReleased(KeyEvent e) {

    }

    public void run() {

        //Every 100ms repaint the Bullet
        while(true){
            try{
                Thread.sleep(30);
            }catch (Exception e){
                e.printStackTrace();
            }
            this.repaint();
        }

    }
}
