package tado;  //tado folderis

import java.io.*;   //importinam javos bibliotekas
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;

public class SudokuSpresk {     //sukuriam klase SudokuSpresk

  public Integer [][] sudoku_skaiciai;  //sukuriam masyvu masyva - matrica

  public ArrayList<Integer>[] truksta_eilutese; //masyvas eilutese trukstamu elementu sarasu

  public ArrayList<Integer>[] truksta_stulpeliuose; //masyvas stulpeliuose trukstamu elementu sarasu

  public ArrayList<Integer>[] truksta_kvadratuose; //masyvas kvadratuose trukstamu elementu sarasu

  public Kvadratas [] kvadratai;

  public Pozicija [] zingsniai;

  public SudokuSpresk () {    //konstruktorius

    truksta_eilutese = new ArrayList[9]; //sukuria masyva is 9 sararsu objektu
    truksta_stulpeliuose = new ArrayList[9];
    truksta_kvadratuose = new ArrayList[9];

    kvadratai = new Kvadratas[9];
    kvadratai[0] = new Kvadratas( new Pozicija(0,0) ); //pozicija virsutinio kairio kampo kiekviename kvardrate
    kvadratai[1] = new Kvadratas( new Pozicija(0,3) );
    kvadratai[2] = new Kvadratas( new Pozicija(0,6) );
    kvadratai[3] = new Kvadratas( new Pozicija(3,0) );
    kvadratai[4] = new Kvadratas( new Pozicija(3,3) );
    kvadratai[5] = new Kvadratas( new Pozicija(3,6) );
    kvadratai[6] = new Kvadratas( new Pozicija(6,0) );
    kvadratai[7] = new Kvadratas( new Pozicija(6,3) );
    kvadratai[8] = new Kvadratas( new Pozicija(6,6) );
  }

  public void skaityti() throws IOException {     //naujas metodas klases viduj

    sudoku_skaiciai = new Integer [9][9];     //duodam sudoku_skaiciai forma 9x9

       BufferedReader r = new BufferedReader( new InputStreamReader (System.in ) ); //skaitymas

       System.out.println("iveskite sudoku varianto failo varda [ Enter - sudoku_var1.csv]"); //israsas kad tinka failas su situ pavadinimu

       String sudoku_var1 = r.readLine(); //perskaito failo pavadinima

       if (sudoku_var1.length()==0) {   //jei sudoku_var1 length lygus nuliui tai imam faila is direktorijos

         sudoku_var1= "/Users/tadas/Desktop/mvnhello/sudoku/src/main/java/tado/sudoku_var1.csv"; //vieta failo
       }

       File sudoku_failas = new File(sudoku_var1); //sukuriam failo tipo kintamaji

       BufferedReader br = new BufferedReader( new FileReader( sudoku_failas ) ); //isskiriama atmintis failo skaitymui

       String skaitom_po_viena_eilute;    //eilute nuskaitytai eilutej saugoti

       int k = 0; //duodam k reiksme lygia 0

       while ((skaitom_po_viena_eilute = br.readLine()) !=null) { //ciklas skaito eilutes kol ju yra

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

      truksta_eilutese [i] = new ArrayList<Integer>();

      for (Integer x_skaicius=1; x_skaicius<10; x_skaicius++){ //ciklas sukti naujam nezinomajam x_skaicius duota reiksme1 maziau nei 10, ++ kad ima sekanti nezinomaji

        //System.out.print(java.util.Arrays.asList(sudoku_skaiciai[i]).indexOf(x_skaicius));

        if (Arrays.asList(sudoku_skaiciai[i]).indexOf(x_skaicius)== -1){ //????

          System.out.print(x_skaicius+" "); //israso nezinomas reiksmes

          truksta_eilutese[i].add(x_skaicius);
        }
      }
      System.out.println(); //???
    }
  }

  public void trukstaStulpeliuose() {

    for (int i=0; i<9; i+=1) {

      System.out.print(i+" : ");

      truksta_stulpeliuose [i] = new ArrayList<Integer>();

      ArrayList<Integer>stulpelis = new ArrayList<Integer>();

      for (int j=0; j<9; j++) {

        stulpelis.add(sudoku_skaiciai[j][i]);
      }

      for (Integer x_skaicius=1; x_skaicius<10; x_skaicius++) {

        if (stulpelis.indexOf(x_skaicius)==-1){

          System.out.print(x_skaicius+" ");

          truksta_stulpeliuose[i].add(x_skaicius);
        }
      }
      System.out.println();
    }
  }

  public void trukstaKvadratuose() {

    for (int i=0; i<9; i++) {

      System.out.print(i+" : ");

      truksta_kvadratuose [i] = new ArrayList<Integer>();

      ArrayList<Integer>kvadratas = new ArrayList<Integer>();

      do {

        kvadratas.add( sudoku_skaiciai [kvadratai[i].poz.eil][kvadratai[i].poz.stulp] );

      } while (kvadratai[i].padarytiZingsni());

      for (Integer x_skaicius=1; x_skaicius<10; x_skaicius++) {

        if (kvadratas.indexOf(x_skaicius)==-1){

          System.out.print(x_skaicius+" ");

          truksta_kvadratuose[i].add(x_skaicius);
        }
      }
      System.out.println();
    }
  }

  public ArrayList<Integer> trukstaLangelyje (int eil, int stulp, int kvadr) {

    ArrayList<Integer> truksta_langelyje = new ArrayList<Integer>();
    for (Integer i=1; i<10; i++) {

      if (
          (truksta_eilutese[eil].indexOf(i)!=-1)
        &&
          (truksta_stulpeliuose[stulp].indexOf(i)!=-1)
        &&
          (truksta_kvadratuose[kvadr].indexOf(i)!=-1)
      ) {
        truksta_langelyje.add(i);
      }
    }
    return truksta_langelyje;
  }

  public boolean uzpildytiVienareiksmiskaiNustatyta1() {

    boolean isspresta = false; //isspresta surado ir uzpilde arba nesurado kur truksta tik vienos reiksmes

    for ( int i = 0; ((i < kvadratai.length) && !isspresta); i++ ) {

      kvadratai[i].griztiIPradzia();

      do {

        if ( sudoku_skaiciai[kvadratai[i].poz.eil][kvadratai[i].poz.stulp]==0) {

          ArrayList<Integer> truksta_langelyje = trukstaLangelyje(kvadratai[i].poz.eil,kvadratai[i].poz.stulp,i);

          System.out.println(kvadratai[i].poz.eil + " , " + kvadratai[i].poz.stulp + " , " + i + " , " + truksta_langelyje.size());

          if (truksta_langelyje.size()==1) {

            sudoku_skaiciai[kvadratai[i].poz.eil][kvadratai[i].poz.stulp] = truksta_langelyje.get(0);

            //ismest skaiciu is truksta eilutese, is truksta stulpeliuose, ir truksta kvadratuose tos eilutes, stulpelio, ir kvadrato kuriame irasyta skaiciu
            isspresta = true;
            break;
          }
        }
      } while (kvadratai[i].padarytiZingsni());
    }
    return isspresta;
  }

  public void sprestiPoViena () {

    while (uzpildytiVienareiksmiskaiNustatyta1()) {

    }
  }
}
