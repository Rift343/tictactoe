package com.morpion.arbre;

import java.util.ArrayList;

import com.morpion.jeu.Plateau;
import com.morpion.jeu.Player_value;

public class Arbre {
    private Plateau sommet;
    private ArrayList<Plateau> possibilite;
    private Player_value joueur;

    public Arbre (Plateau base,Player_value j){
        this.joueur = j;
        this.sommet = base;
        
    }

    private void construction_arbre(){
        int taille = this.sommet.getTaille();
        for (int x = 0; x < taille; x++) {
            for (int y = 0; y < taille; y++) {
                Plateau node = this.sommet;
                boolean possible = node.nouveau_coup(x,y,this.joueur);
            }
            
        }

    }

}
