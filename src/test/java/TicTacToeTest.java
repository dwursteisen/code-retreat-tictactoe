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
* Time: 23:57
*/

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class TicTacToeTest {

    private TicTacToe ticTacToe;

    @Before
    public void setUp() throws Exception {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void lignes_gagnantes() {
        assertThat(ticTacToe.ligneGagnante(0b111_000_000)).isTrue();
        assertThat(ticTacToe.ligneGagnante(0b000_111_000)).isTrue();
        assertThat(ticTacToe.ligneGagnante(0b000_000_111)).isTrue();
    }

    @Test
    public void lignes_pas_gagnantes() {
        assertThat(ticTacToe.ligneGagnante(0b101_000_000)).isFalse();
        assertThat(ticTacToe.ligneGagnante(0b010_110_000)).isFalse();
        assertThat(ticTacToe.ligneGagnante(0b000_000_011)).isFalse();
    }

    @Test
    public void colones_gagnantes() {
        assertThat(ticTacToe.colonneGagnante(0b100_100_100)).isTrue();
        assertThat(ticTacToe.colonneGagnante(0b010_010_010)).isTrue();
        assertThat(ticTacToe.colonneGagnante(0b001_001_001)).isTrue();
    }

    @Test
    public void colonnes_pas_gagnantes() {
        assertThat(ticTacToe.colonneGagnante(0b101_000_000)).isFalse();
        assertThat(ticTacToe.colonneGagnante(0b010_110_000)).isFalse();
        assertThat(ticTacToe.colonneGagnante(0b000_000_011)).isFalse();
    }

    @Test
    public void diagonales_gagnantes() {
        assertThat(ticTacToe.diagonaleGagnante(0b100_010_001)).isTrue();
        assertThat(ticTacToe.diagonaleGagnante(0b001_010_100)).isTrue();
    }

    @Test
    public void diagonales_pas_gagnantes() {
        assertThat(ticTacToe.diagonaleGagnante(0b100_000_001)).isFalse();
        assertThat(ticTacToe.diagonaleGagnante(0b001_010_000)).isFalse();

    }

    @Test
    public void grille_gagnante() {
        assertThat(ticTacToe.grilleGagnante(0b100_111_001)).isTrue();
        assertThat(ticTacToe.grilleGagnante(0b100_101_101)).isTrue();
        assertThat(ticTacToe.grilleGagnante(0b100_110_011)).isTrue();
    }

    @Test
    public void grille_pas_gagnante() {
        assertThat(ticTacToe.grilleGagnante(0b100_001_001)).isFalse();
        assertThat(ticTacToe.grilleGagnante(0b100_100_001)).isFalse();
        assertThat(ticTacToe.grilleGagnante(0b100_110_000)).isFalse();
    }

    @Test
    public void partie_complete() {
        assertThat(ticTacToe.partieComplete(0b101_001_110, 0b010_110_001)).isTrue();
    }

    @Test
    public void joue() {
        ticTacToe.joue(0, 0b100_000_000);
        assertThat(ticTacToe.grilles[0]).isEqualTo(0b100_000_000);
        ticTacToe.joue(0, 0b001_000_000);
        assertThat(ticTacToe.grilles[0]).isEqualTo(0b101_000_000);
        ticTacToe.joue(0, 0b010_000_000);
        assertThat(ticTacToe.grilles[0]).isEqualTo(0b111_000_000);
    }

    @Test
    public void partie() {
        ticTacToe.joue(0b100_000_000);
        assertThat(ticTacToe.gagnant()).isEqualTo(-1);
        ticTacToe.joue(0b000_100_000);
        assertThat(ticTacToe.gagnant()).isEqualTo(-1);
        ticTacToe.joue(0b010_000_000);
        assertThat(ticTacToe.gagnant()).isEqualTo(-1);
        ticTacToe.joue(0b001_000_000);
        assertThat(ticTacToe.gagnant()).isEqualTo(-1);
        ticTacToe.joue(0b000_010_100);
        assertThat(ticTacToe.gagnant()).isEqualTo(-1);
        ticTacToe.joue(0b000_001_000);
        assertThat(ticTacToe.gagnant()).isEqualTo(-1);
        ticTacToe.joue(0b000_000_100);
        assertThat(ticTacToe.gagnant()).isEqualTo(-1);
        ticTacToe.joue(0b000_000_001);
        assertThat(ticTacToe.gagnant()).isEqualTo(1);

    }
}
