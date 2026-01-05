package shopexample.customers;

import java.util.Objects;

/**
 * Ein Kunde unseres Onlineshops. Hätte normalerweise vermutlich mehrere
 * Lieferadressen, Zahlungsinformationen usw.
 *
 * @author schmi
 */
public class Customer {
    private int id;
    private String name;
    private String address;

    public Customer(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

    // Funktionierende Methode hashCode und equals sind notwendig, damit wir
    // diese Objekte in Datenstrukturen (HashSet, HashMap) stecken können.

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.deepEquals(this, obj);
    }
}
