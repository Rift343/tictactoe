package com.morpion.jeu;

import java.util.ArrayList;

public class Plateau {  
        private Matrice plateau;
        private Player_value value_player_one = Player_value.playerOne;//J1
        private Player_value value_player_two = Player_value.playerTwo;//J2
        //private boolean is_IA_player_one;
        //private boolean is_IA_player_two;
        private int taille_jeu;
        Player_value gagnant = Player_value.noPlayer;//Gagant

        public Plateau(int taille, boolean IA1, boolean IA2){
            this.taille_jeu = taille;
            plateau = new Matrice(taille);
            //is_IA_player_one = IA1;
            //is_IA_player_two = IA2;
        }

        public int getTaille(){
            return this.taille_jeu;
        }

        public boolean nouveau_coup(int x, int y, Player_value joueur){
            if (plateau.get(x, y) == Player_value.noPlayer){
                plateau.set(x, y, joueur);
                isWin();
                return true;
            }
            return false;
            
        }

    private void isWin() {
        int taille = this.taille_jeu;
        check_ligne(taille);
        check_colonne(taille);
        check_diagonale(taille);
    }

    private void check_ligne(int taille) {
        for(int x =0; x < taille; x++){
            ArrayList<Player_value> ligne = this.plateau.matrice.get(x);//On recupère la ligne
            Player_value joueur = ligne.get(0);//On recupère le premier joueur
            if(joueur != Player_value.noPlayer){//On regarde si il y a un joueur qui à joueur
                int temp_size = 1;
                for(int i = 1; i<taille && ligne.get(i) == joueur;i++){//On verifier si on a tj le même joeur
                    temp_size++;//On compte le nombre d'occurance d'un j
                }
                if(temp_size == taille){//si le nb de j = taille alors gagné
                    gagnant = joueur;
                    return;//Return pour coupé le cacule car on a trouvé un gagant.
                }
            }
        }
    }

    private void check_colonne(int taille) {
        for(int x = 0; x<taille;x++){//On a une colonne
            ArrayList<Player_value> ligne = this.plateau.matrice.get(0);//On recupère la ligne
            Player_value joueur = ligne.get(x);//On recupère le premier joueur
            if(joueur != Player_value.noPlayer){
                int temp_size = 1;
                for(int y = 1; y<taille;y++){
                    ligne = this.plateau.matrice.get(y);
                    if(ligne.get(x)==joueur){
                        temp_size++;
                    }
                }
                if(temp_size == taille){//si le nb de j = taille alors gagné
                    gagnant = joueur;
                    return;//Return pour coupé le cacule car on a trouvé un gagant.
                }
            }
        }
    }

    private void check_diagonale(int taille){
        
          
    }



}
