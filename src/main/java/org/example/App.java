/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 James Karlinski
 */

package org.example;

public class App
{
    public static void main( String[] args )
    {
        BloodAlcoholCalculator bac = new BloodAlcoholCalculator();
        int genderTypeId = bac.getGenderTypeId();
        int alcoholAmountConsumedInOz = bac.getIntInput("How many ounces of alcohol did you have? ");
        int weight = bac.getIntInput("What is your weight, in pounds? ");
        int hoursPassedSinceLastDrink = bac.getIntInput("How many hours has it been since your last drink? ");

        double bloodAlcoholLevel = bac.calculateBloodAlcoholLevel(
            genderTypeId, alcoholAmountConsumedInOz, weight, hoursPassedSinceLastDrink
        );

        bac.displayMessage(bloodAlcoholLevel);
    }
}

