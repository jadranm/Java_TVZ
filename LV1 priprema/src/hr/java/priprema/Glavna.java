package hr.java.priprema;
import java.util.Scanner;

public class Glavna {
/*
Napisati program koji učitava jedan cijeli broj s tipkovnice te ispisuje da li je navedeni broj prost ili nije.
Program ne smije prihvaćati negativne brojeve te u slučaju unosa takvih brojeva program mora ispisati pogrešku i od
korisnika zatražiti unos novog broja.
 */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Integer broj;
        Boolean jeliProst=true;

        do{

            System.out.println("upisi broj: ");
            broj = input.nextInt();
            if (broj<0)
                System.out.println("greska");

        }while(broj<0);

        for (int faktor=2; faktor<=broj/2; faktor++){
            if(broj%faktor==0){
                jeliProst=false;
            }
        }
        if (jeliProst)
            System.out.println("broj je prost");
        else
            System.out.println("broj nije prost");

}
}

