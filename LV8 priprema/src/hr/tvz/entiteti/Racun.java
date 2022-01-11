package hr.tvz.entiteti;

import java.math.BigDecimal;

public class Racun {

    private String naziv;
    private BigDecimal stanje;

    public Racun(String naziv, BigDecimal stanje) {
        this.naziv = naziv;
        this.stanje = stanje;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigDecimal getStanje() {
        return stanje;
    }

    public void setStanje(BigDecimal stanje) {
        this.stanje = stanje;
    }
}
