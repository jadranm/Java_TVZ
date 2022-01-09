package entiteti;

public class TekuciRacun extends Racun {

    private double dozvoljeniMinus;

    public TekuciRacun(double stanje, String brojRacuna, double dozvoljeniMinus) {
        super(stanje, brojRacuna);
        this.dozvoljeniMinus = dozvoljeniMinus;
    }
    public double getStanje(){
        return dozvoljeniMinus+super.getStanje();
    }

    @Override
    public String toString() {
        return "Tekuci Racun " + "dozvoljeni minus = " + dozvoljeniMinus + super.toString();
    }

    public void setDozvoljeniMinus(double dozvoljeniMinus) {
        this.dozvoljeniMinus = dozvoljeniMinus;
    }
}
