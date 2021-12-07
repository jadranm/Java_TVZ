package hr.tvz;
import java.util.Date;

public class Osoba {

    private String ime;
    private String prezime;
    private String datumRodjenja;

    public Osoba(String ime, String prezime, String datumRodjenja) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
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

    public String getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = String.valueOf(datumRodjenja);
    }
}
