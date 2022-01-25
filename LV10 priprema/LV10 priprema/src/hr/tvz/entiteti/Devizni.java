package hr.tvz.entiteti;

import java.math.BigDecimal;

public interface Devizni {

    BigDecimal konvertirajUKune(BigDecimal pocetniIznos,BigDecimal sifraValute);
    BigDecimal konvertirajUDevize(BigDecimal pocetniIznos,BigDecimal sifraValute);
}
