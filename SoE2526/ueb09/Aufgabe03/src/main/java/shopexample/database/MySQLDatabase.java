package shopexample.database;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.Set;

import shopexample.gui.Reporter;

/**
 * Repräsentiert eine konkrete relationale Datenbank, z. B. MySQL.
 * Der Einfachheit halber gibt es hier nur eine Methode, die
 * irgendein SQL ausführt und Resultate als eine Menge von Strings
 * zurückliefert.
 *
 * In der Realität kämen hier dann Zeilen und Spalten zurück, und es
 * gäbe vermutlich weitere Methoden für Einfügungen und Updates.
 *
 * @author schmi
 */
public class MySQLDatabase implements Database {
    private Reporter reporter;

    public MySQLDatabase(Reporter reporter) {
        this.reporter = reporter;
    }

    public Set<String> query(String sql) {
        reporter.report("MySQL: " + sql);
        return new HashSet<>(asList("result1", "result2", "result3"));
    }
}
