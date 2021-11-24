package tvz.hr;
import java.util.Scanner;

public class Glavna {
    public static Float vratiNajveci(Float[] objekti) {

        Float temp;

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++){
                if (objekti[i] > objekti[j]){

                    temp = objekti[i];
                    objekti[i] = objekti[j];
                    objekti[j] = temp;
                }
            }
        }
        return objekti[3-1];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("upisi 3 decimalna broja ");

        Float[] objekti = new Float[3];

        for (int i=0;i<3;i++){
                objekti[i] = input.nextFloat();
        }
        System.out.print(vratiNajveci(objekti));
    }




}

