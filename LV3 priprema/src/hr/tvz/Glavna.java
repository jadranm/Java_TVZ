package hr.tvz;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/*
Napisati program koji će od korisnika zatražiti unos količine vrijednosti koje je potrebno unijeti u program.
Nakon toga zatražiti unos svih tih vrijednosti te na kraju programa ispisati koliko je uneseno cijelih, koliko decimalnih,
koliko tekstualnih i koliko svih ostalih tipova podataka. Ako korisnik unese prazan unos, ispisati mu poruku o pogrešci
i zatražiti unos novog podatka.
 */

public class Glavna {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int odabir, brojacInt=0,brojacDouble=0,brojacStr=0,brojacOstalo=0;

        do {
            System.out.print("upisi kolicinu vrijednosti: ");
            odabir = input.nextInt();
        } while (odabir < 0);

        ArrayList<Object> objekti = new ArrayList<Object>();

        String a;
        for (int i=0;i<odabir;i++){
            do {
                System.out.println("upisi "+ (i+1) +". objekt");

                a=input.next();
                objekti.add(a);
                if (Objects.equals(a, ""))
                    System.out.println("greska, unesi ponovno");

            }while (Objects.equals(a, ""));

            if (Objects.equals(a,"true") || Objects.equals(a,"false")){
                objekti.add(i,Boolean.parseBoolean(a));
            }else try {
                double broj=Double.parseDouble(a);
                if (broj%1==0)
                    objekti.add(i,Integer.parseInt(a));
                else
                    objekti.add(i,broj);
            }catch (NumberFormatException ex) {
                objekti.add(i, a);
            }
        }
        for (int i=0;i<odabir;i++){
            if (objekti.get(i) instanceof String)
                brojacStr++;
            else if (objekti.get(i) instanceof Double)
                brojacDouble++;
            else if (objekti.get(i) instanceof Integer)
                brojacInt++;
            else
                brojacOstalo++;
        }

        System.out.println("\nInteger: "+brojacInt);
        System.out.println("Decimal: "+brojacDouble);
        System.out.println("String: "+brojacStr);
        System.out.println("Ostalo: "+brojacOstalo);
    }
}