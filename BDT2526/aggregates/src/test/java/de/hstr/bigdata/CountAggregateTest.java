package de.hstr.bigdata;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CountAggregateTest {
    @Test
    public void testOneElement() {
        assertThat(new CountAggregate().getValue(), is(1));
    }

    @Test
    public void testMultipleElements() {
        CountAggregate m1 = new CountAggregate();
        CountAggregate m2 = new CountAggregate();
        CountAggregate m3 = new CountAggregate();
        CountAggregate m4 = new CountAggregate();
        CountAggregate m5 = new CountAggregate();

        m1.add(m2);
        m3.add(m4);
        m3.add(m5);
        m1.add(m3);

        assertThat(m1.getValue(), is(5));
    }

    @Test
    public void testManyElements() {
        CountAggregate agg = new CountAggregate().getNeutralElement();
        for (int i = 0; i < 100; i++) {
            agg.add(new CountAggregate());
        }

        assertThat(agg.getValue(), is(100));
    }
}
