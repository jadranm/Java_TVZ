package hr.tvz;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
/*
Od korisnika zatražiti unos rečenice te iz nje izdvojiti riječi te ih ispisati na ekran. Odrediti najdužu i najkraću
riječ u rečenici te ih također ispisati na kraju programa.
 */
public class Glavna {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("unesi recenicu: ");
        String recenica=input.nextLine();

        StringTokenizer tokenizer = new StringTokenizer(recenica," ,.!?:;");
        String[] rijeci = new String[tokenizer.countTokens()];
        int brojRijeci = 0;

        while (tokenizer.hasMoreTokens()) {
            rijeci[brojRijeci] = tokenizer.nextToken();
            ++brojRijeci;
        }

        for (int i=0;i<brojRijeci;i++) {
            System.out.println(rijeci[i]);
        }
        Arrays.sort(rijeci, (a, b)->Integer.compare(a.length(), b.length()));

        System.out.println("\nNajduža riječ je: "+rijeci[brojRijeci-1]);
        System.out.println("Najkrača riječ je: "+rijeci[0]);
    }
}
j