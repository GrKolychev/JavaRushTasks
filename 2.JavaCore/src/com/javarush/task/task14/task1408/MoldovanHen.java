package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen {

    int amountOfEggs = 98;
    String country = Country.MOLDOVA;

    @Override
    int getCountOfEggsPerMonth() {
        return amountOfEggs;
    }

    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + amountOfEggs + " яиц в месяц.";
    }
}
