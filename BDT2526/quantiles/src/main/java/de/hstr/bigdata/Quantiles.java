package de.hstr.bigdata;

import java.util.Collection;
import java.util.List;

/**
 * Berechnet Quantile auf einer Menge von Objekten
 * 
 * @author schmi
 * @param <T> Typ der Elemente; müssen sich ordnen lassen
 */
public interface Quantiles<T extends Comparable<T>> {
    /**
     * @param elements eine Menge von Elementen
     * @param numQuantiles Anzahl der Quantile, einschließlich 0 und 1; für numQuantiles = 5
     *    werden die Quantile für 0, 0.25, 0.5, 0.75, 1 zurückgegeben.
     * @return eine Liste mit Quantilen, 1/quantileStep viele
     */
    List<T> quantiles(Collection<T> elements, int numQuantiles);
}
