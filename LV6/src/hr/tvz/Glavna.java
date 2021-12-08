package hr.tvz;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Glavna {

    static final Integer BROJ_UNOSA = 3;


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Fakultet[] faks = new Fakultet[BROJ_UNOSA];

        System.out.println("Upisi podatke o fakultetu:");

        for (int i = 0; i < BROJ_UNOSA; i++) {
            System.out.println("Upisi " + (i + 1) + ". fakultet: ");

            System.out.print("naziv fakulteta: ");
            String nazivFaksa = input.next();

            System.out.println("Upisi broj smjerova: ");
            Integer brojSmjerova = input.nextInt();

            List<String> smjerovi=new ArrayList<String>();

            for(int j=0;j<brojSmjerova;j++) {

                System.out.print("smjer: ");
                String tempSmjerovi = input.next();
                smjerovi.add(tempSmjerovi);
            }

            System.out.print("adresa: ");
            String adresa = input.next();

            Fakultet noviUnos = new Fakultet(nazivFaksa,smjerovi, adresa);
            faks[i] = noviUnos;
        }

        System.out.println("¨\nUnesi trazeni smjer: ");
        String trazeniFaks = input.next();

        int indexTrazenog=0;

        for(int i=0;i<BROJ_UNOSA;i++){

            List<String> tempSmjer = faks[i].getSmjerovi();

            if(tempSmjer.contains(trazeniFaks)){
                i=indexTrazenog;
            }


        }
        System.out.println(faks[indexTrazenog].getNazivFaksa());
        System.out.println(faks[indexTrazenog].getSmjerovi());
        System.out.println(faks[indexTrazenog].getAdresa());
    }
}
