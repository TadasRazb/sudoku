package tado;  //tado folderis

import java.io.*;   //importinam javos bibliotekas
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;

public class SudokuSpresk {     //sukuriam klase SudokuSpresk

  public Integer [][] sudoku_skaiciai;  //sukuriam du masyvus viena eilutem kita stulpeliams

  public ArrayList<Integer> truksta_eilutese;

  public SudokuSpresk () {    //konstruktorius??

    truksta_eilutese = new ArrayList<Integer>();
  }

  public void skaityti() throws IOException {     //?????

    sudoku_skaiciai = new Integer [9][9];     //duodam sudoku_skaiciai forma 9x9???

       BufferedReader r = new BufferedReader( new InputStreamReader (System.in ) ); //skaitymas

       System.out.println("iveskite sudoku varianto failo varda [ Enter - sudoku_var1.csv]"); //israsas kad tinka failas su situ pavadinimu

       String sudoku_var1 = r.readLine(); //perskaito faila

       if (sudoku_var1.length()==0) {   //jei sudoku_var1 length lygus nuliui tai imam faila is direktorijos

         sudoku_var1= "/Users/tadas/Desktop/mvnhello/sudoku/src/main/java/tado/sudoku_var1.csv";
       }

       File sudoku_failas = new File(sudoku_var1); //duodam keiciam pavadinima is sudoku_var1 i sudoku_failas

       BufferedReader br = new BufferedReader( new FileReader( sudoku_failas ) ); //skaitom sudoku_faila

       String skaitom_po_viena_eilute;    //su string skaito kikviena eilute atskirai?

       int k = 0; //duodam k reiksme lygia 0

       while ((skaitom_po_viena_eilute = br.readLine()) !=null) { //ciklas skaito eilutes ir negali buti lygu 0

         String[] duoti_skaiciai = skaitom_po_viena_eilute.split(","); //paima is masyvo eilutes ir atskyrimo reiksmes lygios kableliui

         for (int i=0; i<duoti_skaiciai.length; i+=1) {  //for ciklas kad i negali buti daugiau nei duoda skaiciu eiluteje i+=1 reiskia kad kieviena kart ima kita eilutes demeny??

           sudoku_skaiciai [k][i] = Integer.parseInt(duoti_skaiciai[i]);  //sudoku skaiciai [k] stuplepiai [i] eilutes. parseint atskiria visus skaicius nuo eilutes?

         }
         k++; //sekantis stulpelis?
       }
  }

  public void surasystiReiksmes(){  //nauja klase kuria liepia israsyti reiksmes esamas?

    for ( int i = 0; i < 9; i++){   //eilutes israso?

      for (int j = 0; j < 9; j++){  //stulpelius israso?
        System.out.print(sudoku_skaiciai [i][j] + " "); //israso koonsolej visa uzduoti
      }
      System.out.println(); //???
    }
  }

  public void trukstaEilutese(){  //nauja klase israso ko truksta eilutese

    for (int i=0; i<9; i++) { //skaito eilutes

      System.out.print(i+" : "); //skaito kiekviena skaiciu is eiles

      for (Integer x_skaicius=1; x_skaicius<10; x_skaicius++){ //ciklas sukti naujam nezinomajam x_skaicius duota reiksme1 maziau nei 10, ++ kad ima sekanti nezinomaji

        //System.out.print(java.util.Arrays.asList(sudoku_skaiciai[i]).indexOf(x_skaicius));

        if (Arrays.asList(sudoku_skaiciai[i]).indexOf(x_skaicius)== -1){ //????

          System.out.print(x_skaicius+" "); //israso nezinomas reiksmes

          truksta_eilutese.add(x_skaicius);
        }
      }
      System.out.println(); //???
    }
  }
}
