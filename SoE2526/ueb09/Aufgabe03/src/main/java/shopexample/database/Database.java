package shopexample.database;

import java.util.Set;

public interface Database {
    Set<String> query(String query);
}
