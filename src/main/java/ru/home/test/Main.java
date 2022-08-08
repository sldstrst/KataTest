package ru.home.test;

import java.util.Scanner;

public class Main {
    private static boolean flag = true;

    public static void main(String[] args) {
        String result;

        while (flag) {
            Scanner sc = new Scanner(System.in);
            String expression = sc.nextLine();
            if (expression.equals("Exit")) {
                flag = false;
            }else {
                result = calc(expression);
                if (!result.equals(expression)) System.out.println(result);
            }
        }
    }

    public static String calc(String input){
        CalculatorNumbers calc = new CalculatorNumbers();
        try {
            input = calc.getExpression(input);
        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        }
        return input;
    }

}
