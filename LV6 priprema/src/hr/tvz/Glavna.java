package hr.tvz;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/*
Kreirati klasu "Osoba" koja ima tri varijable: ime, prezime i datum rođenja. Napisati metodu koja vraća starost osobe,
temeljenu na datumu rođenja. U glavnom programu zatražiti unos podataka o tri osobe te odrediti najstariju osobu.
 */

public class Glavna {

    static final Integer BROJ_OSOBA = 3;

    public static <Intager> void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Osoba[] osobe = new Osoba[BROJ_OSOBA];

        for (int i = 0; i < BROJ_OSOBA; i++) {
            System.out.println("Upisi " + (i + 1) + ". osobu: ");

            System.out.print("ime: ");
            String ime = input.next();

            System.out.print("prezime: ");
            String prezime = input.next();

            System.out.print("datum rođenja (dd-mm-yyyy): ");
            String datumRodjenja = input.next();

            Osoba novaOsoba = new Osoba(ime, prezime, datumRodjenja);
            osobe[i] = novaOsoba;
        }

        Long[] starost = new Long[BROJ_OSOBA];
        int i = vracaNajstariji(osobe, starost);

        System.out.println("\nNajstariji je: ");

        System.out.println(osobe[i].getIme());
        System.out.println(osobe[i].getPrezime());
        System.out.println(osobe[i].getDatumRodjenja());
    }


    private static int vracaNajstariji(Osoba[] osobe, Long[] starost) {
        for (int i = 0; i < BROJ_OSOBA; i++) {

            StringTokenizer tokenizer = new StringTokenizer(osobe[i].getDatumRodjenja(), " -./,");
            String[] razbijeniDatum = new String[tokenizer.countTokens()];
            int brojRazmaka = 0;

            while (tokenizer.hasMoreTokens()) {
                razbijeniDatum[brojRazmaka] = tokenizer.nextToken();
                ++brojRazmaka;
            }

            LocalDate trazeniDatum = LocalDate.of(  Integer.parseInt(razbijeniDatum[2]),
                                                    Integer.parseInt(razbijeniDatum[1]),
                                                    Integer.parseInt(razbijeniDatum[0]));

            LocalDate danasnjiDatum = LocalDate.of(2021, 12, 7);  //danasnji datum

            starost[i] = ChronoUnit.DAYS.between(trazeniDatum, danasnjiDatum);
        }

        long max=0;
        int indexNajstarijeg=0;

        for (int i = 0; i < BROJ_OSOBA; i++) {
            if (starost[i]>max){
                max=starost[i];
                indexNajstarijeg=i;

            }
        }

        return indexNajstarijeg;
    }
}

