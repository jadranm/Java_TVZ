package hr.tvz;
import java.util.Scanner;
/*
Napisati program koji će od korisnika prvo učitati količinu cijelih brojeva koje je potrebno unijeti te nakon toga učitati
te brojeve i spremiti ih u polje. Pronaći broj koji se najčešće pojavljuje u polju i ispisati ga. Također pronaći i broj
koji je nabliži prosječnoj vrijednosti od svih brojeva koje je korisnik unio.
 */

public class Glavna {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("koliko cijelih brojeva zelis unijeti: ");
        Integer odabir = input.nextInt();

        Integer[] objekti = new Integer[odabir];

        Float   srednja;
        Integer zbroj = 0;

        for (int i=0;i<odabir;i++){     //unos
            objekti[i]=input.nextInt();
            zbroj += objekti[i];
        }

        Integer max_count = 1, rezultat = objekti[0];
        Integer curr_count = 1;

        for (int i = 1; i < odabir; i++) {
            if (objekti[i] == objekti[i - 1])
                curr_count++;
            else {
                if (curr_count > max_count) {
                    max_count = curr_count;
                    rezultat = objekti[i - 1];
                }
                curr_count = 1;
            }
        }

        if (curr_count > max_count) {
            max_count = curr_count;
            rezultat = objekti[odabir - 1];
        }

        System.out.println("\nNajcesce se ponavlja broj: " +rezultat);


        Float[] razlika = new Float[odabir];

        srednja=(float)zbroj/odabir;
        System.out.println("srednja vrijednost je: "+srednja);

        float min=0;
        Integer n=0;

        for (int i=0;i<odabir;i++) {
            razlika[i] = Math.abs((float) objekti[i] - srednja);
            //System.out.println("*** " + razlika[i]);
        }

        min = razlika[0];

            for (int i=0;i<odabir;i++){
                if (razlika[i]<min){
                    min = razlika[i];
                    n=i;
                }
        }
        System.out.println("Broj koji je najblizi srednjoj vrijednosti: " +objekti[n]);

    }
}
