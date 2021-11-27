package hr.tvz;
import java.util.Arrays;
import java.util.Scanner;

public class Glavna {

    static final int BROJ_UPISA = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Integer[] objekti = new Integer[BROJ_UPISA];
        Integer zbroj = 0,max = 0,min = 0;

        System.out.printf("Upisi "+BROJ_UPISA+" razlicitih brojeva: ");

        for (int i=0;i<BROJ_UPISA;i++){
            objekti[i]=input.nextInt();
            
            for (int j=0;j<i;j++){
                if (objekti[i]==objekti[j]){
                    System.out.println("unesen je isti broj");
                    i--;
                }
            }
        }
        
        for (int i=0;i<BROJ_UPISA;i++)
            zbroj += objekti[i];

        Arrays.sort(objekti);

        System.out.println("Srednja vrijednost je: "+(float)zbroj/BROJ_UPISA);
        System.out.println("Maksimalna vrijednost: "+objekti[BROJ_UPISA-1]);
        System.out.println("Minimalna vrijednost: "+objekti[0]);
    }
}
