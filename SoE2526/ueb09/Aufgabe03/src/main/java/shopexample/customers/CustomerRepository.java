package shopexample.customers;

import java.util.Arrays;
import java.util.Collection;

import shopexample.database.Database;
import shopexample.database.Repository;
import shopexample.gui.Reporter;

/**
 * Verwaltet die Kunden in einer MySQL-Datenbank.
 *
 * @author schmi, hiegz
 */
public class CustomerRepository implements Repository<Customer> {
    private Database database;
    private Reporter reporter;

    public CustomerRepository(Database database, Reporter reporter) {
        this.database = database;
        this.reporter = reporter;
    }

    public Customer create(Customer customer) {
        database.query("insert into customers values ...");
        reporter.report("Kunde angelegt: " + customer);
        return customer;
    }

    public Customer findById(int id) {
        database.query("select ... from customers");
        Customer customer = new Customer(1, "Max Mustermann", "Trier");
        reporter.report("Kunde gelesen.");
        return customer;
    }

    public Collection<Customer> findAll() {
        database.query("select * from customers");
        reporter.report("Kunden gelesen.");
        return Arrays.asList(new Customer(1, "Max Mustermann", "Trier"));
    }
}
