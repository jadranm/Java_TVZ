package labos.java;
import java.util.Scanner;

public class Glavna {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Integer broj,prvaZnamenka,drugaZnamenka;

        do{
            System.out.println("upisi parni broj između 10 i 20: ");
            broj = input.nextInt();
        }while((broj<10 || broj>20)|| broj%2!=0);//dodati za parne

            prvaZnamenka = broj/10;
            drugaZnamenka = broj%10;

        System.out.println(prvaZnamenka+drugaZnamenka);


    }
}
