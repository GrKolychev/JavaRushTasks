package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {

    int amountOfEggs=99;
    String country = Country.UKRAINE;

    @Override
    int getCountOfEggsPerMonth() {
        return amountOfEggs;
    }

    @Override
    String getDescription() {
        return super.getDescription()+ " Моя страна - " + Country.UKRAINE + ". Я несу " + amountOfEggs + " яиц в месяц.";
    }
}
