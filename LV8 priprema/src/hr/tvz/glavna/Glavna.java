package hr.tvz.glavna;

import hr.tvz.entiteti.IsplataPlace;
import hr.tvz.entiteti.Osoba;
import hr.tvz.entiteti.Racun;
import hr.tvz.entiteti.UplataStednje;

import java.math.BigDecimal;
import java.util.Scanner;

public class Glavna {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Osoba prvaOsoba = unosOsobe(input,1);
        Osoba drugaOsoba = unosOsobe(input,2);

        System.out.print("unesite stanje 1. racuna ");
        BigDecimal stanjePrvogRacuna = input.nextBigDecimal();

        Racun prviRacun = new Racun("1. racun ",stanjePrvogRacuna);


        System.out.print("unesite stanje 2. racuna ");
        BigDecimal stanjeDrugogRacuna = input.nextBigDecimal();

        Racun drugiRacun = new Racun("2. racun ",stanjeDrugogRacuna);


        prvaOsoba.getRacuni().add(prviRacun);
        drugaOsoba.getRacuni().add(drugiRacun);

        isplataPlace(input,prviRacun,drugiRacun);


        System.out.println("stedni racuni");

        System.out.print("unesite stanje 1. racuna ");
        BigDecimal stanjePrvogStednog = input.nextBigDecimal();

        Racun prviStedniRacun = new Racun("1. racun ",stanjePrvogStednog);


        System.out.print("unesite stanje 2. racuna ");
        BigDecimal stanjeDrugogStednog = input.nextBigDecimal();

        Racun drugiStedniRacun = new Racun("2. racun ",stanjeDrugogStednog);

        prvaOsoba.getRacuni().add(prviStedniRacun);
        drugaOsoba.getRacuni().add(drugiStedniRacun);

        usplataStednje(input,prviStedniRacun,drugiStedniRacun);



        BigDecimal lovaPrveOsobe = prvaOsoba.getRacuni().get(0).getStanje().add(prvaOsoba.getRacuni().get(1).getStanje());
        BigDecimal lovaDrugeOsobe = drugaOsoba.getRacuni().get(0).getStanje().add(drugaOsoba.getRacuni().get(1).getStanje());

        if (lovaPrveOsobe.compareTo(lovaDrugeOsobe)>0) {
            System.out.println("Prva osoba je bogatija " + lovaPrveOsobe);

        }else if (lovaPrveOsobe.compareTo(lovaDrugeOsobe)<0){
            System.out.println("Druga osoba je bogatija " + lovaDrugeOsobe);

        }else {
            System.out.println("prva i druga osoba imaju isti iznos na racunu");
        }

    }


//metode
    private static Osoba unosOsobe(Scanner input,Integer index) {
        System.out.print("unesi ime "+index+". osobe ");
        String ime = input.next();

        System.out.print("unesi prezime "+index+". osobe ");
        String prezime = input.next();

        Osoba novaOsoba = new Osoba(ime,prezime);
        return novaOsoba;
    }


    private static void isplataPlace(Scanner input,Racun prviRacun, Racun drugiRacun) {

        System.out.print("Unesi iznos place: ");
        BigDecimal iznosPlace = input.nextBigDecimal();

        IsplataPlace novaIsplataPlace = new IsplataPlace(prviRacun,drugiRacun,iznosPlace);
        novaIsplataPlace.izvrsi();

        System.out.println("1. racun nakon isplate " + novaIsplataPlace.getPolazni().getStanje());
        System.out.println("2. racun nakon isplate " + novaIsplataPlace.getDolazni().getStanje());
    }


    private static void usplataStednje(Scanner input,Racun prviStedniracun,Racun drugiStedniRacun) {

        System.out.print("Unesi iznos uplate: ");
        BigDecimal iznosPlace = input.nextBigDecimal();

        UplataStednje novaUplataStednje = new UplataStednje(prviStedniracun,drugiStedniRacun,iznosPlace);
        novaUplataStednje.izvrsi();

        System.out.println("1. stedni racun nakon isplate " + novaUplataStednje.getPolazni().getStanje());
        System.out.println("2. stedni racun nakon isplate " + novaUplataStednje.getDolazni().getStanje());
    }
}