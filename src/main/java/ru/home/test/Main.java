package ru.home.test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean flag = true;

        while (flag) {
            Scanner sc = new Scanner(System.in);
            String expression = sc.nextLine();
            if (expression.equals("Exit")) {
                flag = false;
            }else {
                new СalculatorNumbers(expression);
            }
        }
    }
}
