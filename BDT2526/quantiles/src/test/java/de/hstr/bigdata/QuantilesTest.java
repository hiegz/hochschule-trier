package de.hstr.bigdata;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;

public class QuantilesTest {

    @Test
    public void testInt() {
        Collection<Integer> ints = new HashSet<>();
        for (int i = 0; i <= 1000; i++) {
            ints.add(i);
        }

        List<Integer> quantiles = new QuantilesImpl<Integer>().quantiles(ints, 5);
        List<Integer> expected = ImmutableList.of(0, 250, 500, 750, 1000);

        assertThat(quantiles, equalTo(expected));
    }

    @Test
    public void testString() throws IOException {
        List<String> shakespeare = Resources.readLines(
                Resources.getResource(QuantilesTest.class, "/shakespeare-words.txt"), Charsets.UTF_8);

        List<String> quantiles = new QuantilesImpl<String>().quantiles(shakespeare, 11);
        List<String> expected = ImmutableList.of("a", "be", "do", "guns", "ill", "master", "of",
                "she", "the", "very", "zwaggered");

        assertThat(quantiles, equalTo(expected));
    }
}
