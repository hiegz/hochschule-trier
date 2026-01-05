package shopexample.gui;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Set;

import shopexample.customers.Customer;
import shopexample.customers.CustomerRepository;
import shopexample.database.Database;
import shopexample.items.Item;
import shopexample.items.ItemRepository;
import shopexample.orders.OrderRepository;
import shopexample.orders.Order;

/**
 * Benutzeroberfläche für Windows-Betriebssysteme, hier nur angedeutet. Von hier
 * aus wird die Businesslogik angestoßen, also z. B. das Absetzen von
 * Bestellungen.
 *
 * @author schmi, hiegz
 */
public class GUI {
    private Reporter reporter;
    private ItemRepository items;
    private CustomerRepository customers;
    private OrderRepository orders;

    public GUI(Database database, Reporter reporter) {
        this.reporter = reporter;

        items = new ItemRepository(database, reporter);
        customers = new CustomerRepository(database, reporter);
        orders = new OrderRepository(database, reporter);
    }

    /**
     * Diese Operationen stehen stellvertretend für das, was der Endbenutzer mit der
     * GUI anfangen würde.
     */
    public void run() {
        Customer customer = createCustomer();
        Set<Item> items = selectItems();
        placeOrder(customer, items);
        listOrders();
    }

    private Customer createCustomer() {
        Customer mustermann = customers.create(new Customer(1, "Max Mustermann", "Trier"));
        return mustermann;
    }

    private Set<Item> selectItems() {
        Item pen = items.findById(1);
        return new HashSet<>(asList(pen));
    }

    private void placeOrder(Customer customer, Set<Item> items) {
        orders.create(new Order(1, customer, items));
    }

    private void listOrders() {
        for (Order anOrder : orders.findAll()) {
            reporter.report(anOrder.toString());
        }
    }
}
