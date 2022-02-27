package com.company;

import java.awt.*;
import java.awt.event.*;




public class Rackets extends Rectangle { //estendiamo con la classe rettangolo in modo da ereditare le specifiche del rettangolo//

    int id;
    int ySpeed;
    int speed = 11;


    public Rackets(int x, int y, int RACKET_WIDTH, int RACKET_HEIGHT, int id) {
        super(x, y, RACKET_WIDTH, RACKET_HEIGHT);
        this.id = id;

    }
    //metodo che attraverso l'id capisce quali racchette si  devono muovere con i rispettivi tasti//

    public void keyPressed(KeyEvent e) {
        switch (id) {

            case 1:

                if (e.getKeyCode() == KeyEvent.VK_W) {

                    setYDirection(-speed);


                }

                if (e.getKeyCode() == KeyEvent.VK_S) {

                    setYDirection(speed);


                }

                break;

            case 2:

                if (e.getKeyCode() == KeyEvent.VK_UP) {

                    setYDirection(-speed);


                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                    setYDirection(speed);


                }

                break;

        }


    }

    public void keyReleased(KeyEvent e) {
        switch (id) {

            case 1:

                if (e.getKeyCode() == KeyEvent.VK_W) {

                    setYDirection(0);


                }

                if (e.getKeyCode() == KeyEvent.VK_S) {

                    setYDirection(0);


                }

                break;

            case 2:

                if (e.getKeyCode() == KeyEvent.VK_UP) {

                    setYDirection(0);


                }

                if (e.getKeyCode() == KeyEvent.VK_DOWN) {

                    setYDirection(0);


                }

                break;

        }


    }

    //metodo che setta la speed//

    public void setYDirection(int yDirection) {
        ySpeed = yDirection;

    }

    //metodo di movimento racchette//
    public void move() {
        y = y + ySpeed;

    }

    //metodo che disegna le racchette con id 1 e id 2//

    public void sketch(Graphics g) {
        if (id == 1)
            g.setColor(Color.yellow);
        else
            g.setColor(Color.yellow);
        g.fillRect(x, y, width, height);

    }
}