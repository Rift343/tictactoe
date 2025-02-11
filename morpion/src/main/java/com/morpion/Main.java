package com.morpion;

import com.morpion.arbre.Arbre;
import com.morpion.jeu.Plateau;
import com.morpion.jeu.Player_value;

public class Main {
    public static void main(String[] args) {
         Plateau plateau_test = new Plateau(3, true, true);
        Arbre arbre_test = new Arbre(plateau_test, Player_value.playerOne);
        Arbre arbre_test2 = new Arbre(plateau_test, Player_value.playerTwo);
        System.out.println("ok");
/* 
        JFrame frame = new JFrame("Affichage de l'Arbre");
        ArbreDisplay arbreDisplay = new ArbreDisplay(arbre_test);
        frame.add(arbreDisplay);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
*/
        
        arbre_test2.setSommet(arbre_test.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");

        arbre_test.setSommet(arbre_test2.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");

        arbre_test2.setSommet(arbre_test.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");

        arbre_test.setSommet(arbre_test2.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");
 
        arbre_test2.setSommet(arbre_test.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");

        arbre_test.setSommet(arbre_test2.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");
        
        arbre_test2.setSommet(arbre_test.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");

        arbre_test.setSommet(arbre_test2.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");

        arbre_test2.setSommet(arbre_test.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");
    }
}