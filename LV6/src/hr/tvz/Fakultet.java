package hr.tvz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fakultet {
    List<String> smjerovi=new ArrayList<String>();
    List<String> nazivFaksa;
    String adresa;

    public Fakultet(String smjerovi, List<String> nazivFaksa, String adresa) {
        this.smjerovi = Collections.singletonList(smjerovi);
        this.nazivFaksa = nazivFaksa;
        this.adresa = adresa;
    }

    public List<String> getSmjerovi() {
        return smjerovi;
    }

    public void setSmjerovi(String smjerovi) {
        this.smjerovi = Collections.singletonList(smjerovi);
    }

    public List<String> getNazivFaksa() {
        return nazivFaksa;
    }

    public void setNazivFaksa(String nazivFaksa) {
        this.nazivFaksa = Collections.singletonList(nazivFaksa);
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }


}

