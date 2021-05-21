package tado;
import java.io.*;

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
    }
}
