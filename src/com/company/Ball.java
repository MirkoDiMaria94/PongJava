package com.company;

import java.awt.*;

import java.util.*;




public class Ball extends Rectangle {

    Random random;
    int ySpeed;
    int xSpeed;
    int speed=3;

    public Ball(int x, int y, int width,int height){
        super(x,y,width,height);
        random=new Random();
        int randomXAxisDirection=random.nextInt(2); //se e' 0 la ball andra' a sinistra altrimenti a destra sull'asse x//
        if(randomXAxisDirection==0) {
            randomXAxisDirection--;
        }else {
            randomXAxisDirection++;
        }
        setXAxisDirection(randomXAxisDirection*speed); //


        int randomYAxisDirection = random.nextInt(2);

        if(randomYAxisDirection == 0) {  //se e' 0 la ball andra' in su altrimenti in giu' sull' asse y//

            randomYAxisDirection--;
        }else{
            randomYAxisDirection++;
        }

        setYAxisDirection(randomYAxisDirection*speed);




    }

    //metodo che setta la speed//

    public void setXAxisDirection(int randomXAxisDirection){
        xSpeed = randomXAxisDirection;


    }
    public void setYAxisDirection(int randomYAxisDirection){
        ySpeed = randomYAxisDirection;


    }
    // metodo di movimento ball incrementando x e y//

    public void move(){
        x += xSpeed;

        y += ySpeed;


    }
    //metodo che disegna la ball//

    public void sketch(Graphics g){
        g.setColor(Color.white);

        g.fillOval(x, y, height, width);


    }
}
