public class Auto {
    private int kmStand;
    private double verbrauch;
    private double tankVolumen;
    private double kraftstoffVorrat;

    public Auto(int kmStand, double verbrauch, double tankVolumen, double kraftstoffVorrat) {
        this.kmStand = kmStand;
        this.verbrauch = verbrauch;
        this.tankVolumen = tankVolumen;
        this.kraftstoffVorrat = kraftstoffVorrat;
    }

    public void info() {
        System.out.printf("Kilometerstand: %d, Tankinhalt: %.3f\n", this.kmStand, this.kraftstoffVorrat);
    }

    public String toString() {
        return String.format("kmStand = %d, verbrauch = %f, tankVolumen = %f, kraftstoffVorrat = %f", kmStand,
                verbrauch, tankVolumen, kraftstoffVorrat);
    }

    public void fahren(int km) {
        double verbraucht;

        if ((verbraucht = km * this.verbrauch / 100) <= this.kraftstoffVorrat) {
            this.kmStand += km;
            this.kraftstoffVorrat -= verbraucht;
        } else {
            this.kmStand += (int) ((this.kraftstoffVorrat * 100) / (this.verbrauch));
            this.kraftstoffVorrat = 0;
        }
    }

    public void tanken(double liter) {
        this.kraftstoffVorrat = Math.min(this.tankVolumen, this.kraftstoffVorrat + liter);
    }

    public static void main(String[] args) {
        Auto goggoMobil = new Auto(0, 5.0, 50, 30);

        System.out.println("Status vor der Fahrt:");
        goggoMobil.info();
        System.out.println(goggoMobil.toString());

        System.out.println();

        goggoMobil.fahren(300);
        System.out.println("Status nach 300km:");
        goggoMobil.info();
        System.out.println(goggoMobil.toString());

        System.out.println();

        goggoMobil.tanken(45);
        System.out.println("Status nach dem Tanken:");
        goggoMobil.info();
        System.out.println(goggoMobil.toString());
    }
}
