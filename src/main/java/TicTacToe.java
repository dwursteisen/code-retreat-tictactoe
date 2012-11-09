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
}
