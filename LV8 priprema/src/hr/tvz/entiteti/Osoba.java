package hr.tvz.entiteti;
import java.util.ArrayList;
import java.util.List;

public class Osoba {

    private String ime;
    private String prezime;
    private List<Racun> racuni;

    public Osoba(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
        this.racuni = new ArrayList<>();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public List<Racun> getRacuni() {
        return racuni;
    }

    public void setRacuni(List<Racun> racuni) {
        this.racuni = (ArrayList<Racun>) racuni;
    }
}
