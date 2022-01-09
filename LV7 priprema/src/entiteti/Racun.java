package entiteti;

public class Racun {
    private double stanje;
    private String brojRacuna;

    public Racun(double stanje, String brojRacuna){
        this.stanje = stanje;
        this.brojRacuna = brojRacuna;
    }

    public double getStanje() {
        return stanje;
    }

    public void setStanje(double stanje) {
        this.stanje = stanje;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public void setBrojRacuna(String brojRacuna) {
        this.brojRacuna = brojRacuna;
    }

    @Override
    public String toString() {
        return "Stanje iznosi = "+stanje+"\nbroj racuna = " + brojRacuna;
    }
}
