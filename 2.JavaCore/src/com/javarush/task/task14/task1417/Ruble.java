package com.javarush.task.task14.task1417;

public class Ruble extends Money {
    @Override
    public double getAmount() {
        return super.getAmount();
    }

    public Ruble(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "RUB";
    }
}
