package hr.tvz.entiteti;

import java.math.BigDecimal;

public class UplataStednje extends Transakcija{

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
}
