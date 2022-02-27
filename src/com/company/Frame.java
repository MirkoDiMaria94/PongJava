package com.company;

import java.awt.*;

import javax.swing.*;





public class Frame extends JFrame {
    Panel panel;



    public Frame(){
        panel=new Panel();  //creiamo una nuova istanza di pannello//
        this.add(panel);
        this.setTitle("Pong");
        this.setResizable(false); //non permette di ridimendionare la finestra//
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //per far uscire alla  premendo X//
        this.pack(); //metodo della classe JFrame la finestra si adattera' al pannello di gioco//
        this.setVisible(true); //per fare vedere effettivament la finestra//
        this.setLocationRelativeTo(null); //per far apparire al centro dello schermo//


    }
}
