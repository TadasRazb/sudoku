package tado;

public class Langelis {

  Integer reiksme;
  Integer zingsnio_nr;

  public Langelis () {

    reiksme = 0;
    zingsnio_nr = -1;
  }

  public boolean equals(Object kitas) {

    Langelis dar_kitas = (Langelis) kitas;
    return dar_kitas.reiksme==reiksme;
  }
}
