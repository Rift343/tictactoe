package com.morpion.arbre;
import org.junit.Test;

import com.morpion.jeu.Plateau;
import com.morpion.jeu.Player_value;


public class TestArbre {


    @Test
    public void test(){
        Plateau plateau_test = new Plateau(3, true, true);
        Arbre arbre_test = new Arbre(plateau_test, Player_value.playerOne);        
    }
}
