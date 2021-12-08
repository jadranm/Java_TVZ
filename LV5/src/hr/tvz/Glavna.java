package hr.tvz;
import java.util.Scanner;


public class Glavna {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String recenica;

        do {
            System.out.printf("Upisi recenicu: ");
             recenica = input.next();

            if (recenica.contains("  ")){
                System.out.printf("Los unos ");
            }
        }while (recenica.contains("  "));


        }
    }

