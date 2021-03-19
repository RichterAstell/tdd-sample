package com.tdd.tdd;

public class Sum implements Expression {
    Money augend;
    Money addend;
    Sum (Money augend, Money addend) {
        this.augend = augend;
        this.addend = addend;
    }
    @Override
    public Money reduce(String to) {
        int amount = this.augend.amount + this.addend.amount;
        return new Money(amount, to);
    }
}