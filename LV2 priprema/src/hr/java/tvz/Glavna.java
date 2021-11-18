package hr.java.tvz;
import java.util.Scanner;

public class Glavna {

    /*
    Napisati Java program koji ima tri metode koje implementiraju sljedeću logiku:

    1. Metoda za unos podataka i rješavanje kvadratne jednadžbe.
    2. Metoda za unos deset brojeva te vraćanje najvećeg broja.
    3. Metoda za unos pet prezimena studenata te vratiti najduže.

    Na početku programa od korisnika zatražiti unos akcije koju želi obaviti, pozvati odgovarajuću metodi i ispisati rezultate.
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("odaberi metodu: ");
        int Metoda = input.nextInt();

        if (Metoda == 1) {
            kvadratna(input);
        } else if (Metoda == 2) {
            System.out.println(brojevi(input));
        } else if (Metoda == 3) {
            System.out.println(prezime(input));
        }
    }


    private static void kvadratna(Scanner input) {
        double A = input.nextDouble();
        double B = input.nextDouble();
        double C = input.nextDouble();

        double D = B * B - 4.0 * A * C;

        if (D > 0.0) {
            double Rezultat1 = (-B + Math.pow(D, 0.5)) / (2.0 * A);
            double Rezultat2 = (-B - Math.pow(D, 0.5)) / (2.0 * A);

            System.out.println(Rezultat1);
            System.out.println(Rezultat2);
        }
        else if (D == 0.0) {
            double R1 = -B / (2.0 * A);
            System.out.println(R1);
        }
        else {
            System.out.println("Korijen nije realan broj");
        }
    }


    private static Integer brojevi(Scanner input) {
        Integer[] Brojevi = new Integer[10];

        System.out.println("Unesi brojeve: ");
        int Max;
        for (int Brojac = 0; Brojac < 10; Brojac++)
            Brojevi[Brojac] = input.nextInt();

        int Max2 = Brojevi[0];

        for (int Brojac = 0; Brojac < 10; Brojac++) {
            if (Max2 < Brojevi[Brojac])
                Max2 = Brojevi[Brojac];
        }
        return Max2;
    }


    private static String prezime(Scanner input) {

        String[] Prezimena = new String[5];

        System.out.println("Unesi prezimena: ");

        for (int Brojac = 0; Brojac < 5; Brojac++)
            Prezimena[Brojac] = input.next();

        String Max3 = Prezimena[0];

        for (int Brojac = 0; Brojac < 5; Brojac++) {
            if (Max3.length() < Prezimena[Brojac].length())
                Max3 = Prezimena[Brojac];
        }
        return Max3;
    }
}

