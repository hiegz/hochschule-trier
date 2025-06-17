import utilities.Datum;

public class WarenlagerTest {
    public static void main(String[] args) {
        Warenlager lager = new Warenlager(10);
        Milchprodukt frischMilch = new Milchprodukt("Frischmilch", 0.89, new Datum(17, 1, 2009), 7.0);
        lager.einlagern(frischMilch, 500);
        lager.entnehmen(frischMilch, 150);
        Milchprodukt hMilch = new Milchprodukt("H-Milch", 0.55, new Datum(8, 3, 2009), 50.0);

        lager.einlagern(hMilch, 1234);
        lager.einlagern(new Haushaltsgeraet("Kaffeemat extra", 17.95, 750, 0.8), 23);
        lager.einlagern(new Haushaltsgeraet("Supersauger", 109.95, 1500, 4.3), 46);

        lager.print();
        System.out.println();

        lager.artikelPruefen();

        lager.print();
        System.out.println();

        Artikel haarbuerste = new Artikel("Wildschweinborste spezial", 5.95);
        // Die folgende Anweisung loest eine Fehlerausgabe aus.
        lager.entnehmen(haarbuerste, 12);

        System.out.println();

        Haushaltsgeraet hgeraet = new Haushaltsgeraet("Haushaltsgeraet", 20, 5, 9);
        lager.einlagern(hgeraet, 50);

        lager.print();
        System.out.println();

        lager.einlagern(hgeraet, 50);

        lager.print();
        System.out.println();

        lager.entnehmen(hgeraet, 30);

        lager.print();
        System.out.println();

        lager.entnehmen(hgeraet, 80);
        System.out.println();

        lager.print();
    }
}
