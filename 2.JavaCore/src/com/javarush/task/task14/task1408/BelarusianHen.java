package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {

    int amountOfEggs = 97;
    String country = Country.BELARUS;

    @Override
    int getCountOfEggsPerMonth() {
        return amountOfEggs;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.BELARUS + ". Я несу " + amountOfEggs + " яиц в месяц.";
    }
}
