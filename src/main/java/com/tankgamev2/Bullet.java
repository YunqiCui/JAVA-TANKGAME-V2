package com.tankgamev2;

public class Bullet implements Runnable{

    int x;
    int y;
    int direct;
    int speed =3;
    boolean isAlive = true;

    public Bullet(int x, int y,int direct){
        this.x= x;
        this.y= y;
        this.direct = direct;
    }

    public void run() {

        while(true){
        try{
            Thread.sleep(20);
        }catch (Exception e){
            e.printStackTrace();
        }
            switch(direct){
                //Bullet ShotUp
                case 0:
                    y-=speed;
                    break;
                //Bullet ShotRight
                case 1:
                    x+=speed;
                    break;
                //Bullet ShotDown
                case 2:
                     y+=speed;
                     break;
                //Bullet ShotLeft
                case 3:
                    x-=speed;
                    break;
            }
            System.out.println("Bullet X = " +x + " Y = " +y);
            //when THE Bullet need to be killed
            if(x<0 || x > 400 || y < 0 || y> 300){
                isAlive = false;
                break;

            }

    }
    }
}
