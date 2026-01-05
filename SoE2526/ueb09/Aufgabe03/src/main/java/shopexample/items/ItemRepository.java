package shopexample.items;

import static java.util.Arrays.asList;

import java.util.Collection;
import java.util.List;

import shopexample.database.Database;
import shopexample.database.Repository;
import shopexample.gui.Reporter;

/**
 * Verwaltet die bekannten Artikel in unserem Produktkatalog.
 *
 * @author schmi, hiegz
 */
public class ItemRepository implements Repository<Item> {
    private Database database;
    private Reporter reporter;

    public ItemRepository(Database database, Reporter gui) {
        this.database = database;
        this.reporter = gui;
    }

    public Item create(Item item) {
        database.query("insert into items values ...");
        reporter.report("Artikel angelegt: " + item);
        return item;
    }

    public Item findById(int id) {
        database.query("select ... from items");
        Item item = new Item(1, "Füllhalter");
        reporter.report("Artikel gelesen: " + item);
        return item;
    }

    public Collection<Item> findAll() {
        database.query("select * from items");
        List<Item> allItems = asList(new Item(1, "Füllhalter"), new Item(2, "Bleistift"));
        reporter.report("Artikel gelesen: " + allItems);
        return allItems;
    }
}
