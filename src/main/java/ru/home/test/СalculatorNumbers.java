package ru.home.test;
import java.util.ArrayList;
import java.util.regex.*;

public class СalculatorNumbers {
    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String DIVIDE = ":";
    private final static String MULTIPLY = "*";
    private final static String QUESTIONMARK = "?";

    СalculatorNumbers(String ex) {
        getExpression(ex);
    }


    public static void solve(int first, int second, String sign){
        System.out.println(switch (sign){
            case PLUS -> first + second;
            case MINUS -> first - second;
            case MULTIPLY -> first * second;
            case DIVIDE -> first / second;
            case QUESTIONMARK -> "Error of sign";
            default -> "default";
        });
    }


    public static void getExpression(String expression) {
        ArrayList<Integer> numb = new ArrayList<>();
        String sign = QUESTIONMARK;
        boolean bad = false;

        String[] words = expression.split("\\D");
        if (words.length == 0 || words == null) {
            System.out.println("enter the expression correctly");
        } else {
            for (String word : words) {
                if (word == "") {
                    System.out.println("no correctly");
                    bad = true;
                    break;
                } else {
                    try {
                        numb.add(Integer.parseInt(word));
                    } catch (NumberFormatException e) {
                        System.out.println("Bag!");
                    }
                }
            }
        }

        if (!bad) {
            char[] under_char = new char[10];
            for (int i = 0; i < expression.length(); i++) {
                under_char[i] = expression.charAt(i);
                sign = switch (under_char[i]){
                    case '+' -> PLUS;
                    case '-' -> MINUS;
                    case ':' -> DIVIDE;
                    case '*' -> MULTIPLY;
                    default -> "?";
                };
                if (sign != "?") break;
            }
        }

            if (!numb.isEmpty() && sign != "?") {
                solve(numb.get(0), numb.get(1), sign);
            }

    }
}
