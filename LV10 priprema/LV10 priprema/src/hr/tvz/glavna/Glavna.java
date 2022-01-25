package hr.tvz.glavna;

import hr.tvz.entiteti.*;
import hr.tvz.exceptions.NedozvoljenoStanjeStednogException;
import hr.tvz.exceptions.RacunVecPostojiException;

import java.math.BigDecimal;
import java.util.*;

public class Glavna {

    static final Integer BROJ_OSOBA = 1;    //svaka osoba izvrsi dvije transakcije

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        //mapa tecaja sa odgovarajucim vrijednostima
        HashMap<String, BigDecimal> mapaTecaja = new HashMap<>();
        mapaTecaja.put("HRK", BigDecimal.valueOf(1));
        mapaTecaja.put("EUR", BigDecimal.valueOf(7.5));
        mapaTecaja.put("USD", BigDecimal.valueOf(6));
        mapaTecaja.put("GPD", BigDecimal.valueOf(9));


        ArrayList<Osoba> listaOsoba = new ArrayList<>();
        ArrayList<String> listaRacuna = new ArrayList<>();

        for (int i = 0; i < BROJ_OSOBA; i++) {

            listaOsoba.add(unosOsobe(input,i+1));
            listaOsoba.add(unosOsobe(input,i+2));

            Racun prviRacun = unosRacuna(input, i + 1, mapaTecaja,listaRacuna);
            Racun drugiRacun = unosRacuna(input, i + 2, mapaTecaja,listaRacuna);
            isplataPlace(input, prviRacun, drugiRacun);

            Racun prviStedniRacun = unosStednihRacuna(input, i + 1, mapaTecaja);
            Racun drugiStedniRacun = unosStednihRacuna(input, i + 2, mapaTecaja);
            usplataStednje(input, prviStedniRacun, drugiStedniRacun);
        }
    }


    //metode
    private static Racun unosStednihRacuna(Scanner input, Integer index, HashMap mapaTecaja) {

        Boolean imaGreske = false;
        do {
            try {
                imaGreske = false;
                System.out.print("Unesite stanje " + index + ". stednog racuna: ");
                BigDecimal stanjeStednog = input.nextBigDecimal();

                provjeraNedozvoljenogStanja(stanjeStednog);                         //exception

                String sifraValute = odabirValute(input);

                Racun noviStedniRacun = new Racun(index + ". stedni ", stanjeStednog, sifraValute);

                if (sifraValute != "HRK") {
                    BigDecimal vrijednostValute = (BigDecimal) mapaTecaja.get(sifraValute);

                    //pretvorba funkcionira
                    System.out.println(noviStedniRacun.konvertirajUKune(stanjeStednog, vrijednostValute));
                }

                return noviStedniRacun;

            } catch (InputMismatchException ex) {
                imaGreske = true;
                System.out.print("unesena je neispravna vrijednost za stedni racun\n");
                input.nextLine();

            }catch (NedozvoljenoStanjeStednogException ex){
                System.out.println(ex.getMessage());
            }

        } while (imaGreske);

        return null;
    }


    private static Racun unosRacuna(Scanner input, Integer index, HashMap<String, BigDecimal> mapaTecaja,ArrayList listaRacuna) {

        Boolean imaGreske = false;
        do {
            try {
                imaGreske = false;

                System.out.print("Unesi broj " + index + ". racuna : ");
                String brojRacuna = input.next();


                listaRacuna.add(brojRacuna);

                provjeraPostojanjaRacuna(listaRacuna);

                System.out.print("Unesite stanje " + index + ". racuna: ");
                BigDecimal stanjeRacuna = input.nextBigDecimal();


                String sifraValute = null;
                Racun noviRacun = new Racun(brojRacuna, stanjeRacuna, sifraValute);

                return noviRacun;

            } catch (InputMismatchException ex) {
                System.out.print("Unesena je neispravna vrijednost\n");
                input.nextLine();
                imaGreske = true;

            }catch (RacunVecPostojiException ex){
                System.out.println(ex.getMessage());
                imaGreske = true;
            }
        } while (imaGreske);

        return null;
    }

    private static String odabirValute(Scanner input) {

        System.out.print("Upisi sifru valute (npr. EUR): ");
        String sifraValute = input.next();

        return sifraValute;
    }


    private static Osoba unosOsobe(Scanner input, Integer index) {
        System.out.print("Unesi ime " + index + ". osobe: ");
        String ime = input.next();
        System.out.print("Unesi prezime " + index + ". osobe: ");
        String prezime = input.next();

        Osoba novaOsoba = new Osoba(ime, prezime);
        return novaOsoba;
    }


    private static void isplataPlace(Scanner input, Racun prviRacun, Racun drugiRacun) {
        Boolean imaGreske = false;
        do {
            try {
                imaGreske = false;

                System.out.print("Unesi iznos place: ");
                BigDecimal iznosPlace = input.nextBigDecimal();

                IsplataPlace novaIsplataPlace = new IsplataPlace(prviRacun, drugiRacun, iznosPlace);
                novaIsplataPlace.izvrsi();

                System.out.println("1. racun nakon isplate " + novaIsplataPlace.getPolazni().getStanje());
                System.out.println("2. racun nakon isplate " + novaIsplataPlace.getDolazni().getStanje());
                break;

            } catch (InputMismatchException ex) {
                imaGreske = true;
                input.nextLine();
                System.out.print("Unesena je neispravna vrijednost place\n");
            }
        } while (imaGreske);
    }


    private static void usplataStednje(Scanner input, Racun prviStedniracun, Racun drugiStedniRacun) {

        Boolean imaGreske = false;
        do {
            try {
                imaGreske = false;
                System.out.print("Unesi iznos uplate stednje: ");
                BigDecimal iznosStednje = input.nextBigDecimal();

                UplataStednje novaUplataStednje = new UplataStednje(prviStedniracun, drugiStedniRacun, iznosStednje);
                novaUplataStednje.izvrsi();

                BigDecimal uvecanaUplata = novaUplataStednje.uvecajZaKamatu(drugiStedniRacun.getStanje());

                System.out.println("1. stedni racun nakon isplate " + novaUplataStednje.getPolazni().getStanje());
                System.out.println("2. stedni racun nakon isplate i dodatka kamate " + uvecanaUplata);
                break;

            } catch (InputMismatchException ex) {
                imaGreske = true;
                System.out.print("Unesen je krivi iznos uplate stednje\n");
                input.nextLine();
            }
        } while (imaGreske);
    }



    //exceptions
    private static void provjeraNedozvoljenogStanja(BigDecimal uneseniBroj){

        if (uneseniBroj.compareTo(BigDecimal.valueOf(0)) == -1){
            throw new NedozvoljenoStanjeStednogException("Unesen je negativan broj");
        }
    }


    private static void provjeraPostojanjaRacuna(ArrayList listaRacuna) throws RacunVecPostojiException {

        Integer indexZadnjeg = listaRacuna.size()-1;
        Integer frekvencija = Collections.frequency(listaRacuna, listaRacuna.get(indexZadnjeg));
        if (frekvencija>1){
            throw new RacunVecPostojiException("Upisan je broj racuna koji vec postoji. Pokusaj ponovno.");
        }

    }


}