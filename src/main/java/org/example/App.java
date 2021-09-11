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
        int genderTypeId = bac.GetGenderTypeId();
        int alcoholAmountConsumedInOz = bac.GetIntInput("How many ounces of alcohol did you have? ");
        int weight = bac.GetIntInput("What is your weight, in pounds? ");
        int hoursPassedSinceLastDrink = bac.GetIntInput("How many hours has it been since your last drink? ");

        double bloodAlcoholLevel = bac.CalculateBloodAlcoholLevel(
            genderTypeId, alcoholAmountConsumedInOz, weight, hoursPassedSinceLastDrink
        );

        bac.DisplayMessage(bloodAlcoholLevel);
    }
}

