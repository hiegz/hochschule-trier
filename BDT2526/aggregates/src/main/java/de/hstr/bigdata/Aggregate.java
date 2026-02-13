package de.hstr.bigdata;

/**
 * Ein Aggregat eines bestimmten Typs. Der Typparameter
 * AggType stellt sicher, dass nur kompatible Aggregate
 * zusammengefasst werden können.
 * 
 * @author schmi
 *
 * @param <ResultType> Typ des Resultats der Aggregation, z. B. Integer
 * @param <AggType>    Typ des Aggregats selbst, z. B. CountAggregate
 */
public interface Aggregate<ResultType, AggType> {

    /**
     * Füge diesem Aggregat (in-place) ein anderes Aggregat des gleichen
     * Typs hinzu.
     * 
     * @param otherAggregate ein anderes Aggregat des gleichen Typs
     */
    void add(AggType otherAggregate);

    /**
     * @return den Wert dieses Aggregats
     */
    ResultType getValue();

    /**
     * @return das neutrale Element für diese Art von Aggregat; eigentlich möchte
     *         man hier
     *         eine Klassenmethode haben, aber das können Java-Interfaces nicht.
     */
    AggType getNeutralElement();
}
