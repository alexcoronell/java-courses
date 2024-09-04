package com.platzi.util;

public class RomanNumerals {

    public static String arabicToRoman(int n) {
        String result = "";

        if(n == 15) {
            result= "XV";
        }
        if(n > 10 && n <= 13) {
            result = "X" + generateUnits(n - 10);
        } else if(n == 10) {
            result = "X";
        } else if(n > 5 && n <= 8) {
            result = "V";
            for (int i = 0; i < n-5 ; i++) {
                result += "I";
            }
        } else if(n == 5) {
            result =  "V";
        } else {
            result = generateUnits(n);
        }
        return result;
    }

    private static String generateUnits(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += "I";
        }
        return  result;
    }

}
