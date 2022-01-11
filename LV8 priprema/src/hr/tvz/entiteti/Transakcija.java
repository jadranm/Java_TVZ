package hr.tvz.entiteti;

import java.math.BigDecimal;

public abstract class Transakcija {

    private Racun polazni;
    private Racun dolazni;
    private BigDecimal iznos;

    public Transakcija(Racun polazni, Racun dolazni, BigDecimal iznos) {
        this.polazni = polazni;
        this.dolazni = dolazni;
        this.iznos = iznos;
    }

    public Racun getPolazni() {
        return polazni;
    }

    public void setPolazni(Racun polazni) {
        this.polazni = polazni;
    }

    public Racun getDolazni() {
        return dolazni;
    }

    public void setDolazni(Racun dolazni) {
        this.dolazni = dolazni;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public abstract void izvrsi();
}
