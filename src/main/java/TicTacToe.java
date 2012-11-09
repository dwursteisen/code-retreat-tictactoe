/*
* Copyright (c) 2012 Wursteisen David
* All rights reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions
* are met:
* 1. Redistributions of source code must retain the above copyright
*    notice, this list of conditions and the following disclaimer.
* 2. The name of the author may not be used to endorse or promote products
*    derived from this software without specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
* IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
* OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
* IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
* INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
* NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
* DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
* THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
* THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*
* Date: 09/11/12
* Time: 23:55
*/

public class TicTacToe {


    private static final int MASQUE_LIGNE1 = 0b111_000_000;
    private static final int MASQUE_LIGNE2 = 0b000_111_000;
    private static final int MASQUE_LIGNE3 = 0b000_000_111;

    private static final int MASQUE_COLONNE1 = 0b100_100_100;
    private static final int MASQUE_COLONNE3 = 0b001_001_001;
    private static final int MASQUE_COLONNE2 = 0b010_010_010;

    private static final int MASQUE_DIAGONALE1 = 0b100_010_001;
    private static final int MASQUE_DIAGONALE2 = 0b001_010_100;
    private static final int MASQUE_GRILLE_COMPLETE = 0b111_111_111;

    final int[] grilles = {0b000_000_000, 0b000_000_000};

    private int joueurCourant = 0;
    private int gagnant = -1;

    private boolean correspontAuMasque(final int grid, final int masque) {
        return (grid & masque) == masque;
    }

    boolean ligneGagnante(int grille) {
        return correspontAuMasque(grille, MASQUE_LIGNE1) ||
                correspontAuMasque(grille, MASQUE_LIGNE2) ||
                correspontAuMasque(grille, MASQUE_LIGNE3);
    }


    boolean colonneGagnante(final int grille) {
        return correspontAuMasque(grille, MASQUE_COLONNE1) ||
                correspontAuMasque(grille, MASQUE_COLONNE2) ||
                correspontAuMasque(grille, MASQUE_COLONNE3);
    }


    boolean diagonaleGagnante(final int grille) {
        return correspontAuMasque(grille, MASQUE_DIAGONALE1) ||
                correspontAuMasque(grille, MASQUE_DIAGONALE2);
    }

    boolean grilleGagnante(final int grille) {
        return ligneGagnante(grille) || colonneGagnante(grille) || diagonaleGagnante(grille);
    }

    boolean partieComplete(final int grilleJoueur1, final int grilleJoueur2) {
        return (grilleJoueur1 | grilleJoueur2) == MASQUE_GRILLE_COMPLETE;
    }

    void joue(final int joueur, final int coup) {
        grilles[joueur] = grilles[joueur] | coup;
    }

    public void joue(final int coup) {
        joue(joueurCourant, coup);
        if (grilleGagnante(grilles[joueurCourant])) {
            gagnant = joueurCourant;
        }
        int joueurSuivant = joueurSuivant();
        if (partieComplete(grilles[joueurCourant], grilles[joueurSuivant])) {
            gagnant = -2;
        }
        joueurCourant = joueurSuivant;
    }

    private int joueurSuivant() {
        return (joueurCourant + 1) % 2;
    }

    public int gagnant() {
        return gagnant;
    }
}
