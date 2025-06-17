public class Artikel {
    private static int aktuelleNummer = 0;
    private int nummer;
    private String bezeichnung;
    private double preis;
    private int anzahl;

    public Artikel(String bezeichnung, double preis) {
        this.nummer = Artikel.aktuelleNummer;
        Artikel.aktuelleNummer += 1;

        this.bezeichnung = bezeichnung;
        this.preis = preis;
        this.anzahl = 0;
    }

    public int getNummer() {
        return this.nummer;
    }

    public String getBezeichnung() {
        return this.bezeichnung;
    }

    public double getPreis() {
        return this.preis;
    }

    public int getAnzahl() {
        return this.anzahl;
    }

    public void einlagern(int anzahl) {
        this.anzahl += anzahl;
    }

    public void entnehmen(int anzahl) {
        if (anzahl > this.anzahl) {
            this.anzahl = 0;
            System.out.println("Nicht genug Artikels");
        } else {
            this.anzahl -= anzahl;
        }
    }

    public boolean istWareOk() {
        return true;
    }

    public void print() {
        System.out.printf("Artikelnr.: %d, Bezeichnung: %s, Anzahl: %d", this.nummer, this.bezeichnung, this.anzahl);
    }

    public String toString() {
        return String.format(
                "nummer = %d, bezeichnung = %s, preis = %f, anzahl = %d",
                this.nummer,
                this.bezeichnung,
                this.preis,
                this.anzahl);
    }
}
