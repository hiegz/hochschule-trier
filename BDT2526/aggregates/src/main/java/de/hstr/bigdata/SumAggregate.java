package de.hstr.bigdata;

public class SumAggregate implements Aggregate<Double, SumAggregate> {
    Double value;

    public SumAggregate(Integer value) {
        this.value = Double.valueOf(value);
    }

    public SumAggregate(Double value) {
        this.value = value;
    }

    /**
     * Füge diesem Aggregat (in-place) ein anderes Aggregat des gleichen
     * Typs hinzu.
     * 
     * @param otherAggregate ein anderes Aggregat des gleichen Typs
     */
    public void add(SumAggregate otherAggregate) {
        this.value += otherAggregate.getValue();
    }

    /**
     * @return den Wert dieses Aggregats
     */
    public Double getValue() {
        return value;
    }

    /**
     * @return das neutrale Element für diese Art von Aggregat; eigentlich möchte
     *         man hier
     *         eine Klassenmethode haben, aber das können Java-Interfaces nicht.
     */
    public SumAggregate getNeutralElement() {
        return new SumAggregate(0.0);
    }

}
