package com.company;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;




public class Panel extends JPanel implements Runnable {
    //utilizziamo le classi statiche in modo da poter accedere con il nome della classe stessa e utilizziamo final per farlo diventare una costante//
    static final int PANEL_WIDTH=1300;
    static final int PANEL_HEIGHT=650;
    static final Dimension PANEL_SIZE =new Dimension(PANEL_WIDTH,PANEL_HEIGHT);
    static final int BALL_DIMENSION =25;
    static final int RACKETS_WIDTH=25;
    static final int RACKETS_HEIGHT=120;
    Thread thread;
    Image image;
    Graphics graphics;
    Random random;
    Rackets rackets1;
    Rackets rackets2;
    Ball ball;
    Scoring scoring;

    public Panel(){

        newRackets();
        newBall();

        scoring =new Scoring(PANEL_WIDTH,PANEL_HEIGHT);
        this.setFocusable(true);//serve per far capire al panel che stiamo realmente mandando input//
        this.addKeyListener(new ActionListener());
        this.setPreferredSize(PANEL_SIZE); //imposta la dimensione preferita//

        thread =new Thread(this);
        thread.start();



    }



    //metodo che crea una ball in una posizione random sull' asse y e al centro nell'asse x//

    public void newBall(){
        random=new Random();
        ball=new Ball((PANEL_WIDTH/2)-(BALL_DIMENSION/2),random.nextInt(PANEL_HEIGHT-BALL_DIMENSION),BALL_DIMENSION,BALL_DIMENSION);

    }
    //metodo che posizione le racchette all'inizio ed alla fine dell'asse x e al centro dell'asse y//

    public void newRackets(){
        rackets1=new Rackets(0,(PANEL_HEIGHT/2)-(RACKETS_HEIGHT/2),RACKETS_WIDTH,RACKETS_HEIGHT,1); //inseriamo il punto sull'asse x e y e la dimensione racchetta//
        rackets2=new Rackets(PANEL_WIDTH-RACKETS_WIDTH,(PANEL_HEIGHT/2)-(RACKETS_HEIGHT/2),RACKETS_WIDTH,RACKETS_HEIGHT,2);

    }

    //metodo di pittura componenti e che passa la grafica al metodo sketch//
    public void paint(Graphics g){
        image = createImage(getWidth(),getHeight());
        graphics= image.getGraphics();
        sketch(graphics); //passiamo al metodo sketch la grafica che abbiamo creato dalla nostra immagine//
        g.drawImage(image,0,0,this); //disegna l'oggetto image specificato nella specifica posizione indicata e con le dimensioni originali//


    }

    // metodo che disegna i componenti nel pannello//

    public void sketch(Graphics g){
        rackets1.sketch(g);
        rackets2.sketch(g);
        ball.sketch(g);
        scoring.sketch(g);
        Toolkit.getDefaultToolkit().sync();
    }
    //metodo movimento componenti//

    public void move(){
        rackets1.move();
        rackets2.move();
        ball.move();

    }

    //controllo collision bordi pannello//


    public void collisionMonitor() {
        //controllo collisione bordi ball//

        if(ball.y <=0) {

            ball.setYAxisDirection(-ball.ySpeed);

        }

        if(ball.y >= PANEL_HEIGHT-BALL_DIMENSION) {

            ball.setYAxisDirection(-ball.ySpeed);

        }


        //metodo che fa capire alla ball se tocca le racchette//


        if(ball.intersects(rackets1)) {  //utilizziamo il metodo intersects ereditato dalla classe Rectangle per confrontare due oggetti "ball e racchetta"//

            ball.xSpeed = Math.abs(ball.xSpeed); //il numero negativo viene trasformato in positivo//

            ball.xSpeed++;  //aumenta la velocita sull'asse x'//

            if(ball.ySpeed>0)

                ball.ySpeed++; //aumenta la velocita sull'asse y'//

            else

                ball.ySpeed--;

            ball.setXAxisDirection(ball.xSpeed);  //va nella direzione opposta//

            ball.setYAxisDirection(ball.ySpeed);

        }

        if(ball.intersects(rackets2)) {

            ball. xSpeed= Math.abs(ball.xSpeed);

            ball.xSpeed++;

            if(ball.ySpeed>0)

                ball.ySpeed++;
            else

                ball.ySpeed--;

            ball.setXAxisDirection(-ball.xSpeed);

            ball.setYAxisDirection(ball.ySpeed);

        }

        //controllo collisione bordi racchette//

        if(rackets1.y<=0)

            rackets1.y=0;

        if(rackets1.y >= (PANEL_HEIGHT-RACKETS_HEIGHT))

            rackets1.y = PANEL_HEIGHT-RACKETS_HEIGHT;

        if(rackets2.y<=0)

            rackets2.y=0;

        if(rackets2.y >= (PANEL_HEIGHT-RACKETS_HEIGHT))

            rackets2.y = PANEL_HEIGHT-RACKETS_HEIGHT;

        //diamo un punto al giocatore 1 o 2 e creiamo una nuova ball e una nuova racchetta//

        if(ball.x <=0) {

            scoring.player2++;

            newRackets();

            newBall();

            System.out.println("Player 2: "+scoring.player2);

        }

        if(ball.x >= PANEL_WIDTH-BALL_DIMENSION) {

            scoring.player1++;

            newRackets();

            newBall();

            System.out.println("Player 1: "+scoring.player1);

        }


    }

    public void run(){

        // loop di gioco//


        long lastTime =System.nanoTime(); //restituisce il valore corrente del timer di sistema più preciso disponibile, in nanosecondi//
        double amountOfFps=60.0;
        double ns = 1000000000/amountOfFps; //1 nanosecondo fratto fps//
        double delta=0;
        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            if (delta >= 1) {

                move();

                collisionMonitor();

                repaint();

                delta--;

            }
        }


    }  //metodo che utilizza l'action listener ed attende la pressione o il rilascio di un tasto//

    public class ActionListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){

            rackets1.keyPressed(e);
            rackets2.keyPressed(e);

        }
        public void keyReleased(KeyEvent e){
            rackets1.keyReleased(e);
            rackets2.keyReleased(e);

        }

    }





}
