
package tado;

public class Kvadratas {

  public Pozicija prad_poz;
  public Pozicija poz;
  public Pozicija [] zingsniai;
  public int zingsnio_nr = 0;

  public Kvadratas() {

  }

  public Kvadratas ( Pozicija pradine_pozicija ) {

    zingsniai = new Pozicija[8];  //zingsniu masyvas
    zingsniai[0] = new Pozicija(0,1);
    zingsniai[1] = new Pozicija(0,1);
    zingsniai[2] = new Pozicija(1,-2);
    zingsniai[3] = new Pozicija(0,1);
    zingsniai[4] = new Pozicija(0,1);
    zingsniai[5] = new Pozicija(1,-2);
    zingsniai[6] = new Pozicija(0,1);
    zingsniai[7] = new Pozicija(0,1);

    prad_poz = pradine_pozicija;
    poz = new Pozicija ( prad_poz.eil, prad_poz.stulp );
  }

  public boolean padarytiZingsni() {

    boolean padarytas_zingsnis = false;

    if (zingsnio_nr<=7) {

      poz.eil += zingsniai[zingsnio_nr].eil;
      poz.stulp += zingsniai[zingsnio_nr].stulp;
      //System.out.println("z: e: s: " + zingsnio_nr + " " + poz.eil + " " + poz.stulp);
      zingsnio_nr++;
      padarytas_zingsnis = true;
    }
    return padarytas_zingsnis;
  }

  public void griztiIPradzia() {

    poz.eil = prad_poz.eil;
    poz.stulp = prad_poz.stulp; 
  }
}
