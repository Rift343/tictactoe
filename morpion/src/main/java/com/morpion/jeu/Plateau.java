package com.morpion.jeu;

import java.util.ArrayList;

public class Plateau implements Cloneable {  
        private Matrice plateau;
        private Player_value value_player_one = Player_value.playerOne;//J1
        private Player_value value_player_two = Player_value.playerTwo;//J2
        //private boolean is_IA_player_one;
        //private boolean is_IA_player_two;
        private int taille_jeu;
        public Player_value gagnant = Player_value.noPlayer;//Gagant

        public Plateau(int taille, boolean IA1, boolean IA2){
            this.taille_jeu = taille;
            plateau = new Matrice(taille);
            //is_IA_player_one = IA1;
            //is_IA_player_two = IA2;
        }

        private Plateau(Matrice mat,int taille, boolean IA1, boolean IA2){
            this.taille_jeu = taille;
            try {
                this.plateau = mat.clone();
            } catch (CloneNotSupportedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                throw new RuntimeException(e.toString());
            }
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

    public void isWin() {
        int taille = this.taille_jeu;
        check_ligne(taille);
        //Si on a trouver un gagnant, on économise du temps
        if (this.gagnant != Player_value.noPlayer) {
            System.out.println("ligne");
            System.out.println(this.gagnant);
            System.out.println(this.toString());
            
            return;
        }
        check_colonne(taille);
        //même chose que précedement
        if (this.gagnant != Player_value.noPlayer) {
            System.out.println("colonne");
            System.out.println(this.gagnant);
            System.out.println(this.toString());
            return;
        }
        check_diagonale(taille);
        if (this.gagnant != Player_value.noPlayer) {
            System.out.println("diag");
            System.out.println(this.gagnant);
            System.out.println(this.toString());
            return;
        }    
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
        ArrayList<Player_value> ligne = this.plateau.matrice.get(0);
        Player_value joueur = ligne.get(0);
        boolean conflit =false;
        if (joueur != Player_value.noPlayer) {

            for (int i = 1; i < taille && conflit == false; i++) {
                ArrayList<Player_value> ligneSuivante = this.plateau.matrice.get(i);
                Player_value joueurCase = ligneSuivante.get(i);
                if (joueurCase != Player_value.noPlayer && joueurCase == joueur) {
                    continue;
                }
                else{
                    conflit = true;
                }
            }    
        }
        if (conflit==false) {
            this.gagnant = joueur;
            return;//On a touver une victoire, pas beson de continuer
        }

        joueur = ligne.get(taille-1);
        conflit =false;
        if (joueur != Player_value.noPlayer) {

            for (int i = 1; i < taille && conflit == false; i++) {
                ArrayList<Player_value> ligneSuivante = this.plateau.matrice.get(i);
                Player_value joueurCase = ligneSuivante.get((taille-1)-i);
                if (joueurCase != Player_value.noPlayer && joueurCase == joueur) {
                    continue;
                }
                else{
                    conflit = true;
                }
        }

        if (conflit==false) {
            this.gagnant = joueur;
            return;//On a touver une victoire, pas beson de continuer
        }
        
        
          
        }
    }

    @Override
    public Plateau clone() throws CloneNotSupportedException {
        return new Plateau(this.getPlateau(), this.getTaille(), false, false);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < taille_jeu; i++) {
            for (int j = 0; j < taille_jeu; j++) {
                sb.append(plateau.get(i, j)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }




    /**
     * @return Matrice return the plateau
     */
    public Matrice getPlateau() {
        return plateau;
    }

    /**
     * @param plateau the plateau to set
     */
    public void setPlateau(Matrice plateau) {
        this.plateau = plateau;
    }

    /**
     * @return int return the taille_jeu
     */
    public int getTaille_jeu() {
        return taille_jeu;
    }

    /**
     * @param taille_jeu the taille_jeu to set
     */
    public void setTaille_jeu(int taille_jeu) {
        this.taille_jeu = taille_jeu;
    }

}
