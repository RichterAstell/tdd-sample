package com.tdd.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    @Test
    public void DollarMultiplication() {
        Money five = Money.dollar(5);
        // 5 * 2 を想定
        assertEquals(Money.dollar(10), five.times(2));
        // 5 * 3 を想定
        assertEquals(Money.dollar(15), five.times(3));
    }
    @Test
    public void FrancMultiplication() {
        Franc five = new Franc(5);
        // 5 * 2 を想定
        assertEquals(new Franc(10), five.times(2));
        // 5 * 3 を想定
        assertEquals(new Franc(15), five.times(3));
    }
    @Test
    public void equality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));

        assertFalse(new Franc(5).equals(new Dollar(6)));
    }
}
