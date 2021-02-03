package com.javarush.task.task14.task1417;

public class USD extends Money {
    @Override
    public double getAmount() {
        return super.getAmount();
    }

    public USD(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
