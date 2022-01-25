package hr.tvz.entiteti;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UplataStednje extends Transakcija implements Kamatna{

    public UplataStednje(Racun polazni, Racun dolazni, BigDecimal iznos) {
        super(polazni, dolazni, iznos);
    }

    @Override
    public void izvrsi() {
        BigDecimal novoPolazno= super.getPolazni().getStanje().subtract(super.getIznos());
        super.getPolazni().setStanje(novoPolazno);

        BigDecimal novoDolazno = super.getDolazni().getStanje().add(super.getIznos());
        super.getDolazni().setStanje(novoDolazno);
    }

    @Override
    public BigDecimal uvecajZaKamatu(BigDecimal polazno) {
        Scanner input = new Scanner(System.in);

        Boolean imaGreske = false;
        do {
            try {
                imaGreske = false;
                System.out.print("Unesi iznos kamate u apsolutnom iznosu (sa zarezom): ");
                BigDecimal kamata = input.nextBigDecimal();

                BigDecimal novoDolazno = getDolazni().getStanje();

                BigDecimal dobitakOdKamate = novoDolazno.multiply(kamata);
                return novoDolazno.add(dobitakOdKamate);

            } catch (InputMismatchException ex) {
                imaGreske = true;
                System.out.println("Unesen je krivi iznos kamate (pokusaj sa zarezom)");
                input.nextLine();
            }
        }while (imaGreske=true);

        return polazno;
    }
}
