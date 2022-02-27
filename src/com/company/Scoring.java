package com.company;

import java.awt.*;



public class Scoring extends Rectangle{
    static int SCORING_WIDTH;
    static int SCORING_HEIGHT;
    int player1;  //manterremo il punteggio del giocatore 1 e del giocatore 2//
    int player2;


    public Scoring(int SCORING_WIDTH, int SCORING_HEIGHT){
        Scoring.SCORING_HEIGHT=SCORING_HEIGHT;
        Scoring.SCORING_WIDTH=SCORING_WIDTH;

    }

    //metodo che disegna il punteggio//

    public void sketch(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g.setColor(Color.yellow);
        g.setFont(new Font("Consolas",Font.PLAIN,50));
        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);
        g2d.drawLine(SCORING_WIDTH/2, 0, SCORING_WIDTH/2, SCORING_HEIGHT);

        // g.drawLine(SCORING_WIDTH/2, 0, SCORING_WIDTH/2, SCORING_HEIGHT);//

        g.setColor(Color.white);
        g.drawString("PLAYER 1", (SCORING_WIDTH/4)-150,70);
        g.drawString("PLAYER 2", (SCORING_WIDTH/2)+200,70);

        g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (SCORING_WIDTH/4)-70, 600);
        g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (SCORING_WIDTH/2)+280, 600);



            }



    }

