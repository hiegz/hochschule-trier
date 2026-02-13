package de.hstr.bigdata;

public class CountAggregate implements Aggregate<Integer, CountAggregate> {
    Integer count;

    public CountAggregate() {
        this.count = 1;
    }

    public CountAggregate(Integer count) {
        this.count = 0;
    }

    /**
     * Füge diesem Aggregat (in-place) ein anderes Aggregat des gleichen
     * Typs hinzu.
     * 
     * @param otherAggregate ein anderes Aggregat des gleichen Typs
     */
    public void add(CountAggregate otherAggregate) {
        this.count += otherAggregate.getValue();
    }

    /**
     * @return den Wert dieses Aggregats
     */
    public Integer getValue() {
        return count;
    }

    /**
     * @return das neutrale Element für diese Art von Aggregat; eigentlich möchte
     *         man hier
     *         eine Klassenmethode haben, aber das können Java-Interfaces nicht.
     */
    public CountAggregate getNeutralElement() {
        return new CountAggregate(0);
    }

}
