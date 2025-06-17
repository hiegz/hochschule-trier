public class Haushaltsgeraet extends Artikel {
    private double anschlussLeistung;
    private double gewicht;

    public Haushaltsgeraet(String bez, double pr, double leistung, double gew) {
        super(bez, pr);

        this.anschlussLeistung = leistung;
        this.gewicht = gew;
    }

    @Override
    public String toString() {
        return String.format(
                "%s, %f, %f",
                super.toString(),
                this.anschlussLeistung,
                this.gewicht);
    }
}
