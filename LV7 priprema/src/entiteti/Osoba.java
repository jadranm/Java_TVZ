package entiteti;

import java.util.ArrayList;

public class Osoba {
    private String ime;
    private String prezime;
    private ArrayList<Racun> racune;

    public Osoba(String ime, String prezime,ArrayList<Racun> racune ){
        this.ime = ime;
        this.prezime = prezime;
        this.racune = racune;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public ArrayList<Racun> getRacune() {
        return racune;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    public void addAccount(Racun racun){
        racune.add(racun);
    }
}
