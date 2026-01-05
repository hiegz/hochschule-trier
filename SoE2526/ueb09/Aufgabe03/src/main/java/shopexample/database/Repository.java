package shopexample.database;

import java.util.Collection;

// @formatter:off

public interface Repository<T> {
    T create(T entity);
    T findById(int id);
    Collection<T> findAll();
}
