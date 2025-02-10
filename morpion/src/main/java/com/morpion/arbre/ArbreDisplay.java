package com.morpion.arbre;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ArbreDisplay extends JPanel {
    private Arbre arbre;

    public ArbreDisplay(Arbre arbre) {
        this.arbre = arbre;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawArbre(g, arbre, getWidth() / 2, 30, getWidth() / 4);
    }

    private void drawArbre(Graphics g, Arbre arbre, int x, int y, int xOffset) {
        if (arbre == null) return;

        g.drawString(arbre.getSommet().toString(), x, y);

        ArrayList<Arbre> possibilites = arbre.getPossibilite();
        int childY = y + 50;
        int childXOffset = xOffset / 2;

        for (int i = 0; i < possibilites.size(); i++) {
            int childX = x - xOffset + i * (xOffset * 2 / possibilites.size());
            g.drawLine(x, y, childX, childY);
            drawArbre(g, possibilites.get(i), childX, childY, childXOffset);
        }
    }

   
}