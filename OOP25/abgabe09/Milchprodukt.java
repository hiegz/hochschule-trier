import utilities.Datum;

public class Milchprodukt extends Artikel {
    private Datum verfallsDatum;
    private double maxLagerTemperatur;

    public Milchprodukt(String bez, double pr, Datum mhd, double maxT) {
        super(bez, pr);

        this.verfallsDatum = mhd;
        this.maxLagerTemperatur = maxT;
    }

    @Override
    public boolean istWareOk() {
        return new Datum().vor(this.verfallsDatum);
    }

    @Override
    public String toString() {
        return String.format("%s, verfallsDatum = %s, maxLagerTemperatur = %f",
                super.toString(),
                this.verfallsDatum.toString(),
                this.maxLagerTemperatur);
    }
}
