package de.hstr.bigdata;

public class MeanAggregate implements Aggregate<Double, MeanAggregate> {
    SumAggregate sum;
    CountAggregate count;

    private MeanAggregate() {
        this.sum = (new SumAggregate(0.0)).getNeutralElement();
        this.count = (new CountAggregate()).getNeutralElement();
    }

    public MeanAggregate(Integer value) {
        this.sum = new SumAggregate(value);
        this.count = new CountAggregate();
    }

    public MeanAggregate(Double value) {
        this.sum = new SumAggregate(value);
        this.count = new CountAggregate();
    }

    /**
     * Füge diesem Aggregat (in-place) ein anderes Aggregat des gleichen
     * Typs hinzu.
     * 
     * @param otherAggregate ein anderes Aggregat des gleichen Typs
     */
    public void add(MeanAggregate otherAggregate) {
        this.sum.add(otherAggregate.sum);
        this.count.add(otherAggregate.count);
    }

    /**
     * @return den Wert dieses Aggregats
     */
    public Double getValue() {
        return sum.getValue() / count.getValue();
    }

    /**
     * @return das neutrale Element für diese Art von Aggregat; eigentlich möchte
     *         man hier
     *         eine Klassenmethode haben, aber das können Java-Interfaces nicht.
     */
    public MeanAggregate getNeutralElement() {
        return new MeanAggregate();
    }
}
