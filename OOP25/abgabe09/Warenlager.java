public class Warenlager {
    private Artikel[] waren;

    public Warenlager(int maxAnzahl) {
        this.waren = new Artikel[maxAnzahl];
    }

    public void einlagern(Artikel a, int anzahl) {
        int index = -1;

        for (int i = 0; i < this.waren.length; i++) {
            if (this.waren[i] == null) {
                index = i;
                continue;
            }

            if (this.waren[i] == a) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Lager ist voll");
            return;
        }

        this.waren[index] = a;
        this.waren[index].einlagern(anzahl);
    }

    public void entnehmen(Artikel a, int anzahl) {
        int index = -1;

        for (int i = 0; i < this.waren.length; i++) {
            if (this.waren[i] == a) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Artikel nicht vorhanden:");
            System.out.printf("\tArtikelnr.: %d, Bezeichnung: %s, Preis: %f, Anzahl: %d\n",
                    a.getNummer(),
                    a.getBezeichnung(),
                    a.getPreis(),
                    a.getAnzahl());
            return;
        }

        this.waren[index].entnehmen(anzahl);
    }

    public void artikelPruefen() {
        for (int i = 0; i < this.waren.length; i++) {
            if (this.waren[i] != null && !this.waren[i].istWareOk()) {
                this.waren[i] = null;
            }
        }
    }

    public void print() {
        for (int i = this.waren.length - 1; i >= 0; i--) {
            if (this.waren[i] != null) {
                this.waren[i].print();
                System.out.println();
            }
        }
    }
}
