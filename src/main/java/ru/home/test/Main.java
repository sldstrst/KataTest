package ru.home.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String result;
        boolean flag = true;

        while (flag) {
            Scanner sc = new Scanner(System.in);
            String expression = sc.nextLine();
            if (expression.equals("Exit")) {
                flag = false;
            }else {
                result = calc(expression);
                System.out.println(result);
            }
        }
    }

    public static String calc(String input){
        CalculatorNumbers calc = new CalculatorNumbers();
        try {
            input = calc.getExpression(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return input;
    }

}
