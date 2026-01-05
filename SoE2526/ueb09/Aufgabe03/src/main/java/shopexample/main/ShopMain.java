package shopexample.main;

import shopexample.gui.GUI;
import shopexample.gui.Reporter;
import shopexample.gui.WindowsReporter;
import shopexample.database.Database;
import shopexample.database.MySQLDatabase;;

/**
 * Einstieg in unseren Online-Shop.
 *
 * @author schmi
 */
public class ShopMain {
    public static void main(String[] args) {
        Reporter reporter = new WindowsReporter();
        Database database = new MySQLDatabase(reporter);
        GUI gui = new GUI(database, reporter);

        gui.run();
    }
}
