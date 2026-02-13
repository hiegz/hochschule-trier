package de.hstr.bigdata;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Berechnet Quantile auf einer Menge von Objekten
 * 
 * @author schmi
 * @param <T> Typ der Elemente; müssen sich ordnen lassen
 */
public class QuantilesImpl<T extends Comparable<T>> implements Quantiles<T> {
    /**
     * @param elements     eine Menge von Elementen
     * @param numQuantiles Anzahl der Quantile, einschließlich 0 und 1; für
     *                     numQuantiles = 5
     *                     werden die Quantile für 0, 0.25, 0.5, 0.75, 1
     *                     zurückgegeben.
     * @return eine Liste mit Quantilen, 1/quantileStep viele
     */
    public List<T> quantiles(Collection<T> elements, int numQuantiles) {
        final double step = 1.0 / (numQuantiles - 1);

        List<T> result = new ArrayList<>();
        List<T> sorted = new ArrayList<>(elements);
        Collections.sort(sorted);

        for (int i = 0; i < numQuantiles; ++i) {
            result.add(sorted.get((int) Math.floor((sorted.size() - 1) * (i * step))));
        }

        return result;
    }
}
