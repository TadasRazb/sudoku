package tado;
import java.io.*;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) throws IOException {

        System.out.println( "Hello World!" );
        System.out.println( "sudoku");

        SudokuSpresk sudokuspresk = new SudokuSpresk ();
        sudokuspresk.skaityti ();
        sudokuspresk.surasystiReiksmes();
        System.out.println("eilutese truksta : ");
        sudokuspresk.trukstaEilutese();
        System.out.println("stulpeliuose truksta : ");
        sudokuspresk.trukstaStulpeliuose();
        System.out.println("kvadratuose truksta : ");
        sudokuspresk.trukstaKvadratuose();
        System.out.println("truksta langelyje :");
        ArrayList<Integer> truksta_langelyje = sudokuspresk.trukstaLangelyje(2,2,0);


        for (Integer num : truksta_langelyje) {
           System.out.println(num);
        }

        sudokuspresk.sprestiPoViena();
        sudokuspresk.surasystiReiksmes();
    }
}
