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
        int metoda = input.nextInt();

        if (metoda == 1) {
            kvadratna(input);
        } else if (metoda == 2) {
            System.out.println(brojevi(input));
        } else if (metoda == 3) {
            System.out.println(prezime(input));
        }
    }


    private static void kvadratna(Scanner input) {
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        double d = b * b - 4.0 * a * c;

        if (d > 0.0) {
            double Rezultat1 = (-b + Math.pow(d, 0.5)) / (2.0 * a);
            double rezultat2 = (-b - Math.pow(d, 0.5)) / (2.0 * a);

            System.out.println(Rezultat1);
            System.out.println(rezultat2);
        }
        else if (d == 0.0) {
            double r1 = -b / (2.0 * a);
            System.out.println(r1);
        }
        else {
            System.out.println("Korijen nije realan broj");
        }
    }


    private static Integer brojevi(Scanner input) {
        Integer[] brojevi = new Integer[10];

        System.out.println("Unesi brojeve: ");
        int max;
        for (int brojac = 0; brojac < 10; brojac++)
            brojevi[brojac] = input.nextInt();

        int max2 = brojevi[0];

        for (int i = 0; i < 10; i++) {
            if (max2 < brojevi[i])
                max2 = brojevi[i];
        }
        return max2;
    }


    private static String prezime(Scanner input) {

        String[] prezimena = new String[5];

        System.out.println("Unesi prezimena: ");

        for (int i = 0; i < 5; i++)
            prezimena[i] = input.next();

        String max3 = prezimena[0];

        for (int i = 0; i < 5; i++) {
            if (max3.length() < prezimena[i].length())
                max3 = prezimena[i];
        }
        return max3;
    }
}

