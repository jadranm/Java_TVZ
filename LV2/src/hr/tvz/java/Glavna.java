package hr.tvz.java;
import java.util.Scanner;

public class Glavna {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println(najudaljeniji(input));
    }

    private static String datum(Scanner input) {
        System.out.printf("Unesi dan: ");
        String dan = input.next();

        System.out.printf("Unesi mjesec: ");
        String mjesec = input.next();

        System.out.printf("Unesi godinu: ");
        String godina = input.next();

        String finalniDatum = dan + mjesec + godina;

        return finalniDatum;

    }
    private static Integer razlika(Scanner input) {
        System.out.printf("Unesi prvi broj: ");
        Integer broj1 = input.nextInt();

        System.out.printf("Unesi drugi broj: ");
        Integer broj2 = input.nextInt();

        Integer razlika = broj1 - broj2;

        if (razlika<0)
            razlika = razlika*-1;

        return razlika;
    }


    private static Integer najudaljeniji(Scanner input) {

        Integer finalnaRazlika = Integer.parseInt(datum(input)) - razlika(input);
        return finalnaRazlika;
    }

}
