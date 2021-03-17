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
        Money five = Money.franc(5);
        // 5 * 2 を想定
        assertEquals(Money.franc(10), five.times(2));
        // 5 * 3 を想定
        assertEquals(Money.franc(15), five.times(3));
    }
    @Test
    public void equality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));

        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void currency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void differentClass() {
        assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));
    }
}
