package de.hstr.bigdata.redisexample;

import java.io.IOException;
import java.io.Serializable;

/**
 * Warteschlange für Elemente des Typs T.
 * 
 * @author schmi
 *
 * @param <T>
 */
public interface PriorityQueue<T extends Serializable> extends AutoCloseable {
    void push(T t, double weight) throws IOException;
    T pop() throws ClassNotFoundException, IOException;
}
