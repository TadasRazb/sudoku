package tado;  //tado folderis

import java.io.*;   //importinam javos bibliotekas
import java.lang.*;
import java.util.*;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;

public class SudokuSpresk {     //sukuriam klase SudokuSpresk

  public Langelis [][] sudoku_skaiciai;  //sukuriam masyvu masyva - matrica

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

    sudoku_skaiciai = new Langelis [9][9];     //duodam sudoku_skaiciai forma 9x9

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

       System.out.println ("╔═══════════╦═══════════╦═══════════╗");

       while ((skaitom_po_viena_eilute = br.readLine()) !=null) { //ciklas skaito eilutes kol ju yra

         if ((k==3)||(k==6)) {
     			System.out.print("╠═══════════╬═══════════╬═══════════╣\n");
     		 } if ( ( k==1 )||( k==2) ||( k==4 )||( k==5 )||( k==7 )||( k==8 ) ) {
     			System.out.print("║ ─   ─   ─ ║ ─   ─   ─ ║ ─   ─   ─ ║\n║");
     		 } else {
     			System.out.print("║");
     		 }

         String[] duoti_skaiciai = skaitom_po_viena_eilute.split(","); //paima is masyvo eilutes ir atskyrimo reiksmes lygios kableliui

         for (int i=0; i<duoti_skaiciai.length; i+=1) {  //for ciklas kad i negali buti daugiau nei duoda skaiciu eiluteje i+=1 reiskia kad kieviena kart ima kita eilutes demeny??

            String bruksniukas = " │";

            if ((i==2)||(i==5)||(i==8)){
      				bruksniukas=" ║";
      			}
            System.out.print(" "+ duoti_skaiciai [i]+bruksniukas);
            sudoku_skaiciai [k][i] = new Langelis(Integer.parseInt(duoti_skaiciai[i]));  //sudoku skaiciai [k] stuplepiai [i] eilutes. parseint atskiria visus skaicius nuo eilutes?

          } //uzdaro for
         System.out.println("");
         k++; //sekantis stulpelis?
       }
       System.out.println ("╚═══════════╩═══════════╩═══════════╝");
  }

  public void surasystiReiksmes(){  //nauja klase kuria liepia israsyti reiksmes esamas?

    System.out.println ("╔═══════════╦═══════════╦═══════════╗");

    for ( int i = 0; i < 9; i++){   //eilutes israso?

      if ((i==3)||(i==6)) {
       System.out.print("╠═══════════╬═══════════╬═══════════╣\n");
      } if ( ( i==1 )||( i==2) ||( i==4 )||( i==5 )||( i==7 )||( i==8 ) ) {
       System.out.print("║ ─   ─   ─ ║ ─   ─   ─ ║ ─   ─   ─ ║\n║");
      } else {
       System.out.print("║");
      }

      for (int j = 0; j < 9; j++){  //stulpelius israso?

        String bruksniukas = " │";

        if ((j==2)||(j==5)||(j==8)){
          bruksniukas=" ║";
        }

        if (sudoku_skaiciai[i][j].zingsnio_nr==0){
          System.out.println("\033[36m"+ sudoku_skaiciai[i][j].reiksme +"\033[0m");
        }

        System.out.print(" " + sudoku_skaiciai [i][j].reiksme + bruksniukas); //israso koonsolej visa uzduoti
      }
      System.out.println(); //???
    }
     System.out.println ("╚═══════════╩═══════════╩═══════════╝");
  }

  public void trukstaEilutese(){  //nauja klase israso ko truksta eilutese

    for (int i=0; i<9; i++) { //skaito eilutes

      System.out.print(i+" : "); //skaito kiekviena skaiciu is eiles

      truksta_eilutese [i] = new ArrayList<Integer>();

      Langelis langelis = new Langelis();

      for (Integer x_skaicius=1; x_skaicius<10; x_skaicius++){ //ciklas sukti naujam nezinomajam x_skaicius duota reiksme1 maziau nei 10, ++ kad ima sekanti nezinomaji

        //System.out.print(java.util.Arrays.asList(sudoku_skaiciai[i]).indexOf(x_skaicius));

        langelis.nustatyti(x_skaicius);

        if (Arrays.asList(sudoku_skaiciai[i]).indexOf(langelis)== -1){ //????

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

        stulpelis.add(sudoku_skaiciai[j][i].reiksme);
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

        kvadratas.add( sudoku_skaiciai [kvadratai[i].poz.eil][kvadratai[i].poz.stulp].reiksme );

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

        if ( sudoku_skaiciai[kvadratai[i].poz.eil][kvadratai[i].poz.stulp].reiksme==0) {

          ArrayList<Integer> truksta_langelyje = trukstaLangelyje(kvadratai[i].poz.eil,kvadratai[i].poz.stulp,i);

          System.out.println(kvadratai[i].poz.eil + " , " + kvadratai[i].poz.stulp + " , " + i + " , " + truksta_langelyje.size());

          if (truksta_langelyje.size()==1) {

            sudoku_skaiciai[kvadratai[i].poz.eil][kvadratai[i].poz.stulp].nustatyti( truksta_langelyje.get(0),1 ); //kur buvo duotos reiksmes 0, kur surastos veliau reiksme duodama 1

            //ismest skaiciu is truksta eilutese, is truksta stulpeliuose, ir truksta kvadratuose tos eilutes, stulpelio, ir kvadrato kuriame irasyta skaiciu
            truksta_eilutese[kvadratai[i].poz.eil].remove(truksta_eilutese[kvadratai[i].poz.eil].indexOf(truksta_langelyje.get(0)));
            truksta_stulpeliuose[kvadratai[i].poz.stulp].remove(truksta_stulpeliuose[kvadratai[i].poz.stulp].indexOf(truksta_langelyje.get(0)));
            truksta_kvadratuose[i].remove(truksta_kvadratuose[i].indexOf(truksta_langelyje.get(0)));
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

      //sustabdyti sioje vietoje programa ir parodyti esama sudoku. toliau testi jei vartotjas parenka testi.
      System.out.println("testi?");
    }
  }
}
