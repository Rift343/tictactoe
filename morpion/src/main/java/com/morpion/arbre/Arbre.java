package com.morpion.arbre;

import java.util.ArrayList;

import com.morpion.jeu.Plateau;
import com.morpion.jeu.Player_value;

public class Arbre {
    private Plateau sommet;
    private ArrayList<Arbre> possibilite = new ArrayList<>();
    private Player_value joueur;
    private Player_value prochain_joueur;

    public Arbre (Plateau base,Player_value j){
        this.joueur = j;

        if (j == Player_value.playerOne) {
            this.prochain_joueur = Player_value.playerTwo;
        }
        else{
            this.prochain_joueur = Player_value.playerOne;
        }

        this.sommet = base;
        construction_arbre();

        
        
    }

    private void construction_arbre(){
        int taille = this.sommet.getTaille();
        for (int x = 0; x < taille; x++) {
            for (int y = 0; y < taille; y++) {
                Plateau node;
                try {
                    node = this.sommet.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                    return;
                }
                boolean possible = node.nouveau_coup(x,y,this.joueur);
                if (possible) {
                    Arbre feuille = new Arbre(node, this.prochain_joueur);
                    //System.out.println(feuille.sommet.toString());
                    this.possibilite.add(feuille);
                }
            }
        }

    }

    public Object getSommet() {
        return this.sommet;
    }

    public ArrayList<Arbre> getPossibilite() {
            return possibilite;
        
    }

     @Override
    public String toString() {
        return "Arbre{" +
                "sommet=" + sommet +
                ", possibilite=" + possibilite +
                ", joueur=" + joueur +
                ", prochain_joueur=" + prochain_joueur +
                '}';
    }

}
