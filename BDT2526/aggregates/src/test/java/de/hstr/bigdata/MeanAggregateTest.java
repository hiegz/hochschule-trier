package de.hstr.bigdata;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MeanAggregateTest {
    @Test
    public void testOneElement() {
        assertThat(new MeanAggregate(5d).getValue(), closeTo(5d, 1e-9));
    }

    @Test
    public void testMultipleElements() {
        MeanAggregate m1 = new MeanAggregate(4d);
        MeanAggregate m2 = new MeanAggregate(5d);
        MeanAggregate m3 = new MeanAggregate(6d);
        MeanAggregate m4 = new MeanAggregate(7d);
        MeanAggregate m5 = new MeanAggregate(8d);

        m1.add(m2);
        m3.add(m4);
        m3.add(m5);
        m1.add(m3);

        assertThat(m1.getValue(), closeTo(6d, 1e-9));
    }

    @Test
    public void testManyElements() {
        MeanAggregate agg = new MeanAggregate(0).getNeutralElement();
        for (int i = 0; i <= 100; i++) {
            agg.add(new MeanAggregate(i));
        }

        assertThat(agg.getValue(), closeTo(50d, 1e-9));
    }
}
