package de.hstr.bigdata;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SumAggregateTest {
    @Test
    public void testOneElement() {
        assertThat(new SumAggregate(47.11).getValue(), closeTo(47.11, 1e-9));
    }

    @Test
    public void testMultipleElements() {
        SumAggregate m1 = new SumAggregate(1d);
        SumAggregate m2 = new SumAggregate(3d);
        SumAggregate m3 = new SumAggregate(5d);
        SumAggregate m4 = new SumAggregate(3d);
        SumAggregate m5 = new SumAggregate(1d);

        m1.add(m2);
        m3.add(m4);
        m3.add(m5);
        m1.add(m3);

        assertThat(m1.getValue(), closeTo(13d, 1e-9));
    }

    @Test
    public void testManyElements() {
        SumAggregate agg = new SumAggregate(0).getNeutralElement();
        for (int i = 0; i <= 100; i++) {
            agg.add(new SumAggregate(((double) i) / 100));
        }

        assertThat(agg.getValue(), closeTo(50.50, 1e-9));
    }
}
