package tado;

public class Langelis {

  Integer reiksme;
  Integer zingsnio_nr; //kur buvo duotos reiksmes ten yra 0, kur veliau rastos reiksmes priskirta 1

  public Langelis () {

    nustatyti(0);
  }

  public Langelis (Integer skaicius) {

    nustatyti(skaicius);
  }

  public void nustatyti(Integer skaicius) {

    reiksme = skaicius;
    zingsnio_nr = -1;

    if (reiksme > 0 ) {

      zingsnio_nr = 0;
    }
  }

  public void nustatyti(Integer skaicius, Integer zingsnio_nr) {

    reiksme = skaicius;
    this.zingsnio_nr = zingsnio_nr;

  }

  public boolean equals(Object kitas) {

    Langelis dar_kitas = (Langelis) kitas;
    return dar_kitas.reiksme==reiksme;
  }
}
