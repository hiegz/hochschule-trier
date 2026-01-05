package shopexample.orders;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import shopexample.customers.Customer;
import shopexample.database.Database;
import shopexample.database.Repository;
import shopexample.gui.Reporter;
import shopexample.items.Item;

/**
 * Verwaltet die Bestellungen in einer MySQL-Datenbank.
 *
 * @author schmi, hiegz
 */
public class OrderRepository implements Repository<Order> {
    private Database database;
    private Reporter reporter;

    public OrderRepository(Database database, Reporter reporter) {
        this.database = database;
        this.reporter = reporter;
    }

    public Order create(Order order) {
        database.query("insert into orders values ...");
        reporter.report("Bestellung angelegt: " + order);
        return order;
    }

    public Order findById(int id) {
        database.query("select ... from orders");
        Order order = new Order(1, new Customer(1, "Max Mustermann", "Trier"),
                new HashSet<>(asList(new Item(1, "Füllhalter"))));
        reporter.report("Bestellung gelesen: " + order);
        return order;
    }

    public Collection<Order> findAll() {
        database.query("select * from orders");
        List<Order> allOrders = Arrays.asList(new Order(1, new Customer(1, "Max Mustermann", "Trier"),
                new HashSet<>(asList(new Item(1, "Füllhalter")))));
        reporter.report("Bestellungen gelesen: " + allOrders);
        return allOrders;
    }
}
