package org.example;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Scanner;

public class BloodAlcoholCalculator {
    Scanner Scanner = new Scanner(System.in);

    public int GetGenderTypeId()
    {
        System.out.print("Enter a 1 if you are male or a 2 if you are female: ");
        int genderTypeId = 0;
        try
        {
            String genderTypeInput = Scanner.nextLine();

            // 1 is male
            // 2 is female
            genderTypeId = Integer.parseInt(genderTypeInput);
        }
        catch(Exception exception) {
            System.out.println("Invalid input. Non-numeric value was provided.");
            System.exit(0);
        }

        if(genderTypeId != 1 && genderTypeId != 2){
            System.out.println("Invalid input: only numbers 1 or 2 are accepted as gender type input.");
            System.exit(0);
        }

        return genderTypeId;
    }

    public int GetIntInput(String inputRequestMessage)
    {
        System.out.print(inputRequestMessage);

        int intInput = 0;
        try
        {
            String alcoholAmountConsumedInput = Scanner.nextLine();
            intInput = Integer.parseInt(alcoholAmountConsumedInput);
        }
        catch(Exception exception) {
            System.out.println("Error: non numeric value was provided.");
            System.exit(0);
        }
        return intInput;
    }

    public double CalculateBloodAlcoholLevel(
            int genderIdType,
            int alcoholAmountConsumedInOz,
            int weight,
            int hoursPassedSinceLastDrink)
    {
        final double MALE_ALC_DIST_RATIO = 0.73;
        final double FEMALE_ALC_DIST_RATIO = 0.66;

        // alcohol distribution ratio
        double alcDistRatio = genderIdType == 2 ? FEMALE_ALC_DIST_RATIO : MALE_ALC_DIST_RATIO;

        double bloodAlcoholLevel =
                (alcoholAmountConsumedInOz * 5.14 / weight * alcDistRatio) - 0.015 * hoursPassedSinceLastDrink;

        return bloodAlcoholLevel;
    }

    public void DisplayMessage(double bloodAlcoholLevel) {
        DecimalFormat formatter = new DecimalFormat("0.00");
        System.out.println(MessageFormat.format("Your BAC is {0}.", formatter.format(bloodAlcoholLevel)));
        if(bloodAlcoholLevel >= 0.08) {
            System.out.print("It is not legal for you to drive.");
        }
        else {
            System.out.print("It is legal for you to drive.");
        }
    }
}
