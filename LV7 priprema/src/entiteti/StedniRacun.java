package entiteti;

public class StedniRacun extends Racun{
    private double kamataPrinosa;
    private int godineStednje;
    public StedniRacun(double stanje, String brojRacuna,double kamataPrinosa,int godineStednje) {
        super(stanje, brojRacuna);
        this.kamataPrinosa = kamataPrinosa;
        this.godineStednje = godineStednje;
    }

    public void setKamataPrinosa(double kamataPrinosa) {
        this.kamataPrinosa = kamataPrinosa;
    }

    public void setGodineStednje(int godineStednje) {
        this.godineStednje = godineStednje;
    }

    @Override
    public double getStanje() {
        return super.getStanje() + (super.getStanje()* godineStednje *kamataPrinosa);
    }

    @Override
    public String toString() {
        return "Stedni Racun" + "kamataPrinosa = " + kamataPrinosa +
                ", brojGodinaStednje = " + godineStednje + super.toString();
    }
}
