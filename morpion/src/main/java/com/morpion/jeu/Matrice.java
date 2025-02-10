package com.morpion.jeu;

import java.util.ArrayList;

public class Matrice implements Cloneable {
    
    public ArrayList<ArrayList<Player_value>> matrice = new ArrayList<>(); 

    public Matrice(int taille){
        for (int i = 0; i < taille; i++) {
            ArrayList<Player_value> newTab = new ArrayList<>();
            for (int t = 0; t < taille; t++) {
                newTab.add(Player_value.noPlayer);
            }
            matrice.add(newTab);
        }
        
    }

    public Player_value get(int x, int y){
        ArrayList<Player_value> vecteur = matrice.get(x);
        return vecteur.get(y);
    }

    public void set(int x, int y, Player_value joueur) {
        ArrayList<Player_value> vecteur = matrice.get(x);
        vecteur.set(y, joueur);
        matrice.set(x, vecteur);
    }

    @Override
    public Matrice clone() throws CloneNotSupportedException {
        try {
            Matrice cloned = (Matrice) super.clone();
            cloned.matrice = new ArrayList<>();
            for (ArrayList<Player_value> row : this.matrice) {
                ArrayList<Player_value> clonedRow = new ArrayList<>(row);
                cloned.matrice.add(clonedRow);
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
