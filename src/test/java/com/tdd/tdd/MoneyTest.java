package com.tdd.tdd;

import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {
    @Test
    public void multiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }
    @Test
    public void equality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }
    @Test
    public void currency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }
    @Test
    public void simpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }
    @Test
    public void plusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }
    @Test
    public void reduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }
    @Test
    public void reduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
    @Test
    public void reduceMoneyDifferentCurrency() {
        // レートの変換をテストする
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money money = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), money);
    }
    @Test
    public void identityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
    }
//    @Test
//    public void arrayEquals() {
//        assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
//    }
}
