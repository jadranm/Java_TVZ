package hr.tvz.entiteti;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class Racun implements Devizni{

    private String naziv;
    private BigDecimal stanje;
    private BigDecimal vrijednostValute;

    @Override
    public BigDecimal konvertirajUKune(BigDecimal pocetniIznos, BigDecimal vrijednostValute) {

        pocetniIznos.multiply(vrijednostValute);
        return pocetniIznos;
    }

    @Override
    public BigDecimal konvertirajUDevize(BigDecimal pocetniIznos, BigDecimal vrijednostValute) {
        return null;
    }

    public Racun(String naziv, BigDecimal stanje, String sifraValute) {
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
