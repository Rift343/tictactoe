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
        if (sommet.gagnant == Player_value.noPlayer) {
            construction_arbre();
        }
    }

    public Plateau prochain_cout(){
            Arbre min = possibilite.get(0);
            int note_min = min.note();
            for (int i = 0; i < possibilite.size(); i++) {
                Arbre comparable = possibilite.get(i);
                int new_note = comparable.note();
                if (note_min > new_note) {
                    note_min = new_note;
                    min = comparable;
                }
            }
            this.sommet = min.sommet;
            construction_arbre();
            return min.sommet;
                    
        }
            
                
            
    private int note() {
        int note = this.sommet.note(this.joueur);
        for (int i = 1; i < possibilite.size(); i++) {
            note = note + possibilite.get(i).note();
        }
        return note;

    }
            
    private void construction_arbre(){
        this.possibilite = new ArrayList<>();
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

    public Plateau getSommet() {
        return this.sommet;
    }

    public void setSommet(Plateau p){
        this.sommet = p;
        this.construction_arbre();
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
