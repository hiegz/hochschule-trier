package shopexample.items;

import java.util.Objects;

/**
 * Ein Artikel im Produktkatalog. Hätte normalerweise noch einen Preis und
 * vermutlich noch einige Attribute mehr.
 *
 * @author schmi
 */
public class Item {
    private int id;
    private String name;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + "]";
    }

    // Funktionierende Methode hashCode und equals sind notwendig, damit wir
    // diese Objekte in Datenstrukturen (HashSet, HashMap) stecken können.

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.deepEquals(this, obj);
    }
}
