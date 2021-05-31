package tado;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;


import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{

  public Integer [][] sudoku_skaiciai = {

    {
      0, 0, 0, 5, 6, 0, 9, 1, 3
    }
    , {
      1, 0, 0, 3, 0, 0, 6, 0, 0
    }
    , {
      8, 0, 0, 0, 0, 0, 2, 5, 4
    }
    , {
      0, 2, 1, 6, 0, 0, 0, 0, 0
    }
    , {
      9, 0, 0, 0, 0, 4, 0, 6, 0
    }
    , {
      0, 4, 7, 0, 1, 9, 5, 3, 0
    }
    , {
      0, 0, 8, 9, 0, 6, 3, 0, 5
    }
    , {
      0, 6, 2, 0, 7, 0, 0, 9, 0
    }
    , {
      4, 0, 3, 0, 0, 1, 7, 2, 0
    }
  };
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    @Test
    public void sudokuSprendimas() {

      SudokuSpresk sudoku_spresk = new SudokuSpresk();

      Langelis[][] langeliai = new Langelis[9][9];

      for ( int i = 0; i < 9; i++) {

        for ( int j = 0; j < 9; j++) {

          langeliai[i][j] = new Langelis(sudoku_skaiciai[i][j]);
        }
      }

      sudoku_spresk.sudoku_skaiciai = langeliai;

      sudoku_spresk.trukstaEilutese (); //te = truksta eiluteje

      for ( int i = 0; i < sudoku_spresk.truksta_eilutese[0].size(); i++) {

        System.out.println(sudoku_spresk.truksta_eilutese[0].get(i));
      }
        Integer[] te0 = { 2, 4, 7, 8 };
        Integer[] te1 = { 2, 4, 5, 7, 8, 9 };
        Integer[] te2 = { 1, 3, 6, 7, 9 };
        Integer[] te3 = { 3, 4, 5, 7, 8, 9};
        Integer[] te4 = { 1, 2, 3, 5, 7, 8 };
        Integer[] te5 = { 2, 6, 8};
        Integer[] te6 = { 1, 2, 4, 7 };
        Integer[] te7 = { 1, 3, 4, 5, 8 };
        Integer[] te8 = { 5, 6, 8, 9 };
        assertArrayEquals ( "truksta eilutese sprendimas 0", te0, sudoku_spresk.truksta_eilutese[0].toArray() );
        assertArrayEquals ( "truksta eilutese sprendimas 1", te1, sudoku_spresk.truksta_eilutese[1].toArray() );
        assertArrayEquals ( "truksta eilutese sprendimas 2", te2, sudoku_spresk.truksta_eilutese[2].toArray() );
        assertArrayEquals ( "truksta eilutese sprendimas 3", te3, sudoku_spresk.truksta_eilutese[3].toArray() );
        assertArrayEquals ( "truksta eilutese sprendimas 4", te4, sudoku_spresk.truksta_eilutese[4].toArray() );
        assertArrayEquals ( "truksta eilutese sprendimas 5", te5, sudoku_spresk.truksta_eilutese[5].toArray() );
        assertArrayEquals ( "truksta eilutese sprendimas 6", te6, sudoku_spresk.truksta_eilutese[6].toArray() );
        assertArrayEquals ( "truksta eilutese sprendimas 7", te7, sudoku_spresk.truksta_eilutese[7].toArray() );
        assertArrayEquals ( "truksta eilutese sprendimas 8", te8, sudoku_spresk.truksta_eilutese[8].toArray() );

      sudoku_spresk.trukstaStulpeliuose ();
        Integer[] ts0 = { 2, 3, 5, 6, 7 };
        Integer[] ts1 = { 1, 3, 5, 7, 8, 9 };
        Integer[] ts2 = { 4, 5, 6, 9 };
        Integer[] ts3 = { 1, 2, 4, 7, 8 };
        Integer[] ts4 = { 2, 3, 4, 5, 8, 9 };
        Integer[] ts5 = { 2, 3, 5, 7, 8 };
        Integer[] ts6 = { 1, 4, 8 };
        Integer[] ts7 = { 4, 7, 8 };
        Integer[] ts8 = { 1, 2, 6, 7, 8, 9 };
        assertArrayEquals ( "truksta stulpeliuose sprendimas 0", ts0,  sudoku_spresk.truksta_stulpeliuose[0].toArray() );
        assertArrayEquals ( "truksta stulpeliuose sprendimas 1", ts1,  sudoku_spresk.truksta_stulpeliuose[1].toArray() );
        assertArrayEquals ( "truksta stulpeliuose sprendimas 2", ts2,  sudoku_spresk.truksta_stulpeliuose[2].toArray() );
        assertArrayEquals ( "truksta stulpeliuose sprendimas 3", ts3,  sudoku_spresk.truksta_stulpeliuose[3].toArray() );
        assertArrayEquals ( "truksta stulpeliuose sprendimas 4", ts4,  sudoku_spresk.truksta_stulpeliuose[4].toArray() );
        assertArrayEquals ( "truksta stulpeliuose sprendimas 5", ts5,  sudoku_spresk.truksta_stulpeliuose[5].toArray() );
        assertArrayEquals ( "truksta stulpeliuose sprendimas 6", ts6,  sudoku_spresk.truksta_stulpeliuose[6].toArray() );
        assertArrayEquals ( "truksta stulpeliuose sprendimas 7", ts7,  sudoku_spresk.truksta_stulpeliuose[7].toArray() );
        assertArrayEquals ( "truksta stulpeliuose sprendimas 8", ts8,  sudoku_spresk.truksta_stulpeliuose[8].toArray() );

      sudoku_spresk.trukstaKvadratuose ();
        Integer[] tk0 = { 2, 3, 4, 5, 6, 7, 9 };
        Integer[] tk1 = { 1, 2, 4, 7, 8, 9 };
        Integer[] tk2 = { 7, 8 };
        Integer[] tk3 = { 3, 5, 6, 8 };
        Integer[] tk4 = { 2, 3, 5, 7, 8 };
        Integer[] tk5 = { 1, 2, 4, 7, 8, 9 };
        Integer[] tk6 = { 1, 5, 7, 9 };
        Integer[] tk7 = { 2, 3, 4, 5, 8 };
        Integer[] tk8 = { 1, 4, 6, 8 };
        assertArrayEquals ( "truksta kvadratuose sprendimas 0", tk0,  sudoku_spresk.truksta_kvadratuose[0].toArray() );
        assertArrayEquals ( "truksta kvadratuose sprendimas 1", tk1,  sudoku_spresk.truksta_kvadratuose[1].toArray() );
        assertArrayEquals ( "truksta kvadratuose sprendimas 2", tk2,  sudoku_spresk.truksta_kvadratuose[2].toArray() );
        assertArrayEquals ( "truksta kvadratuose sprendimas 3", tk3,  sudoku_spresk.truksta_kvadratuose[3].toArray() );
        assertArrayEquals ( "truksta kvadratuose sprendimas 4", tk4,  sudoku_spresk.truksta_kvadratuose[4].toArray() );
        assertArrayEquals ( "truksta kvadratuose sprendimas 5", tk5,  sudoku_spresk.truksta_kvadratuose[5].toArray() );
        assertArrayEquals ( "truksta kvadratuose sprendimas 6", tk6,  sudoku_spresk.truksta_kvadratuose[6].toArray() );
        assertArrayEquals ( "truksta kvadratuose sprendimas 7", tk7,  sudoku_spresk.truksta_kvadratuose[7].toArray() );
        assertArrayEquals ( "truksta kvadratuose sprendimas 8", tk8,  sudoku_spresk.truksta_kvadratuose[8].toArray() );

        Integer[] tl0 = { 2, 7 };
        assertArrayEquals ( "truksta langelyje sprendimas",tl0 , sudoku_spresk.trukstaLangelyje(0, 0, 0).toArray() );
    }
}
