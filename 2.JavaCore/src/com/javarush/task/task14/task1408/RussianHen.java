package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    int amountOfEggs = 100;
    String country = Country.RUSSIA;

    @Override
    int getCountOfEggsPerMonth() {
        return amountOfEggs;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + amountOfEggs + " яиц в месяц.";
    }
}
