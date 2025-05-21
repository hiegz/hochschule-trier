class Omnibus extends Auto {
    private int anzahlSitze;

    public Omnibus(
            int kmStand,
            double verbrauch,
            double tankVolumen,
            double kraftstoffVorrat,
            int anzahlSitze) {
        super(kmStand, verbrauch, tankVolumen, kraftstoffVorrat);
        this.anzahlSitze = anzahlSitze;
    }

    @Override
    public String toString() {
        return String.format("%s, anzahlSitze = %d", super.toString(), this.anzahlSitze);
    }

    public static void main(String[] args) {
        Omnibus omnibus = new Omnibus(0, 10.0, 100.0, 80.0, 20);

        System.out.println("Status vor der Fahrt:");
        omnibus.info();
        System.out.println(omnibus.toString());

        System.out.println();

        omnibus.fahren(300);
        System.out.println("Status nach 300km:");
        omnibus.info();
        System.out.println(omnibus.toString());

        System.out.println();

        omnibus.tanken(45);
        System.out.println("Status nach dem Tanken:");
        omnibus.info();
        System.out.println(omnibus.toString());
    }
}
