package com.tdd.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DollarTest {
    @Test
    public void multiplication() {
        Dollar five = new Dollar(5);
        five.times(2);
        // 5 * 2 を想定
        assertEquals(10, five.amount);
        five.times(3);
        // 5 * 3 を想定
        assertEquals(15, five.amount);
    }
}
