package shopexample.orders;

import java.util.Objects;
import java.util.Set;

import shopexample.customers.Customer;
import shopexample.items.Item;

/**
 * Repräsentiert eine Bestellung. Der Einfachheit halber sei eine Bestellung
 * einfach eine ungeordnete Menge von Artikeln ohne Anzahlen, Preise und
 * dergleichen.
 *
 * @author schmi
 */
public class Order {
    private int id;
    private Customer customer;
    private Set<Item> items;

    public Order(int id, Customer customer, Set<Item> items) {
        this.id = id;
        this.customer = customer;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", customer=" + customer + ", items=" + items + "]";
    }

    // Funktionierende Methoden hashCode und equals sind notwendig, damit wir
    // diese Objekte in Datenstrukturen (HashSet, HashMap) stecken können.

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, items);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.deepEquals(this, obj);

    }
}
