package com.tdd.tdd;

class Money {
    protected int amount;
    protected String currency;
    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }
    String currency() {
        return this.currency;
    }
    public boolean equals(Object object) {
        Money money = (Money) object;
        return this.amount == money.amount
                && currency().equals(money.currency());
    }
    static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }
    static Franc franc(int amount) {
        return new Franc(amount, "CHF");
    }
}
