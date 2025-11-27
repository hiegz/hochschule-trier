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
public interface FIFO<T extends Serializable> extends AutoCloseable {
    void push(T t) throws IOException;
    T pop() throws ClassNotFoundException, IOException;
}
