package ru.home.test;

import java.util.List;

public class ArabToRoman {
    public String arabicToRoman(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(number + " в римской системе нет не положительных чисел");
        }
        if (number > 40000) {
            throw new IllegalArgumentException(number + " число более 40000");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
