package com.morpion;

import java.util.Scanner;

import javax.swing.JFrame;

import com.morpion.arbre.Arbre;
import com.morpion.arbre.ArbreDisplay;
import com.morpion.jeu.Plateau;
import com.morpion.jeu.Player_value;

public class Main {
    public static void main(String[] args) throws InterruptedException {
         Plateau plateau_test = new Plateau(3, true, true);
        Arbre arbre_test = new Arbre(plateau_test, Player_value.playerOne);
        Arbre arbre_test2 = new Arbre(plateau_test, Player_value.playerTwo);
        System.out.println("ok");

        JFrame frame = new JFrame("Affichage de l'Arbre");
        ArbreDisplay arbreDisplay = new ArbreDisplay(arbre_test);
        frame.add(arbreDisplay);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        Scanner sc = new Scanner(System.in);
        boolean fini = false;
        
        while (!fini) {

            
            
            sc.next();
            

            arbre_test2.setSommet(arbre_test.prochain_cout());
            System.out.println(arbre_test.getSommet());
            System.out.println("________________________________");

            if (arbre_test.getSommet().fini) {
                if (arbre_test.getSommet().gagnant == Player_value.noPlayer) {
                    System.out.println("Match null");
                }
                else{
                    System.out.println("J1 a gagné");
                }
                sc.close();
                return;
                
            }


             
            arbre_test.setSommet(humainInput(arbre_test.getSommet()));
            System.out.println(arbre_test.getSommet());
            System.out.println("________________________________");
            
            
            if (arbre_test.getSommet().fini) {
                if (arbre_test.getSommet().gagnant == Player_value.noPlayer) {
                    System.out.println("Match null");
                }
                else{
                    System.out.println("J2 a gagné");
                }
                sc.close();
                return;
                
            }
            
        }
        
        
        
        /*
        arbre_test2.setSommet(arbre_test.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");
        
        System.out.println(arbre_test.getSommet().fini);
        

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
        
        Thread.sleep(1000);

        arbre_test2.setSommet(arbre_test.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");


        arbre_test.setSommet(arbre_test2.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");


        arbre_test2.setSommet(arbre_test.prochain_cout());
        System.out.println(arbre_test.getSommet());
        System.out.println("________________________________");
         */
        
    }

    public static Plateau humainInput(Plateau p) {
        boolean jouable = false;
        while (jouable==false) {
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.println("Enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            boolean ok  = p.makeMove(row, col, Player_value.playerTwo); // Assuming makeMove method exists
            if (ok){
                jouable = true;
            }
            
        }
        
        return p;
    }
}