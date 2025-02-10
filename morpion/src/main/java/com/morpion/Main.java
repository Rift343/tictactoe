package com.morpion;

import javax.swing.JFrame;

import com.morpion.arbre.Arbre;
import com.morpion.arbre.ArbreDisplay;
import com.morpion.jeu.Plateau;
import com.morpion.jeu.Player_value;

public class Main {
    public static void main(String[] args) {
         Plateau plateau_test = new Plateau(3, true, true);
        Arbre arbre_test = new Arbre(plateau_test, Player_value.playerOne);
        System.out.println("ok");

        JFrame frame = new JFrame("Affichage de l'Arbre");
        ArbreDisplay arbreDisplay = new ArbreDisplay(arbre_test);
        frame.add(arbreDisplay);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}