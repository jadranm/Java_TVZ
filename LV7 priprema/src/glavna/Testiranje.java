package glavna;
import entiteti.Osoba;
import entiteti.Racun;
import entiteti.StedniRacun;
import entiteti.TekuciRacun;
import java.util.ArrayList;
import java.util.Scanner;

public class Testiranje {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Racun> listaRacuna = new ArrayList<>();
        Osoba osoba = new Osoba("","",listaRacuna);

        System.out.print("Upisi ime: ");
        String tempIme = input.next();
        osoba.setIme(tempIme);

        System.out.print("Upisi prezime: ");
        String tempPrezime = input.next();
        osoba.setPrezime(tempPrezime);

        //osnovni
        System.out.print("Upisi stanje na osnovnom racunu: ");
        Double stanjeRacuna = input.nextDouble();

        String brojRacuna = null;
        if (stanjeRacuna>0) {

            System.out.print("Upisi broj osnovnog racuna: ");
            brojRacuna = input.next();
            osoba.addAccount(new Racun(stanjeRacuna,brojRacuna));
        }

        //tekuci
        System.out.print("Upisi stanje na tekucem racunu: ");
        Double stanjeTekuceg = input.nextDouble();

        if (stanjeTekuceg>0) {

            System.out.print("Upisi broj tekuceg racuna: ");
            String brojTekuceg = input.next();

            System.out.print("Upisi dozvoljeni minus na tekucem racunu: ");
            Double dozvoljeniMinus = input.nextDouble();
            osoba.addAccount(new TekuciRacun(stanjeTekuceg, brojTekuceg, dozvoljeniMinus));
        }

        //stedni
        System.out.print("Upisi stanje stednog racuna: ");
        Double stanjeStednog = input.nextDouble();

        if (stanjeStednog>0) {

            System.out.print("Upisi broj stednog racuna: ");
            String brojStednog = input.next();

            System.out.print("Koliko godina osoba stedi: ");
            int brojGodina = input.nextInt();

            System.out.print("Upisi kolika je kamatna stopa: ");
            double stopa = input.nextDouble();
            osoba.addAccount(new StedniRacun(stanjeStednog,brojStednog,stopa,brojGodina));
        }

        
        double suma = 0;
        for(int i=0;i<osoba.getRacune().size();i++){
            System.out.println(osoba.getRacune().get(i).toString());
            suma += osoba.getRacune().get(i).getStanje();
        }
        
        System.out.println("\n"+osoba.getIme()+" "+osoba.getPrezime()+" ima ukupno "+suma+" kn");
    }
}
