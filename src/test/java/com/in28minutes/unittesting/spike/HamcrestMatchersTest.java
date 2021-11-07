package com.in28minutes.unittesting.spike;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.apache.logging.log4j.ThreadContext.isEmpty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 15, 45);
        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(12, 45));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(50)));


        assertThat("", isEmpty());
        assertThat("ABCD", containsString("BCD"));
        assertThat("ABCDE", startsWith("AB"));
        assertThat("ABCDE", endsWith("DE"));


    }
}
