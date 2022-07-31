package ru.home.test;
import java.util.ArrayList;

public class СalculatorNumbers {
    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String DIVIDE = ":";
    private final static String MULTIPLY = "*";
    private final static String QUESTIONMARK = "?";

    СalculatorNumbers(String ex) {
        try {
            getExpression(ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static int solve(int first, int second, String sign){
        int result;
        result = (switch (sign){
            case PLUS -> first + second;
            case MINUS -> first - second;
            case MULTIPLY -> first * second;
            case DIVIDE -> first / second;
            default -> 0;
        });
        return result;
    }

    private static void outResult(int result){
        System.out.println("Result: " + result);
    }

    public static void outResultRoman(int result)  {
        String resultRoman;
        ArabToRoman arabToRoman = new ArabToRoman();
        resultRoman = arabToRoman.arabicToRoman(result);
        System.out.println(resultRoman);
    }


    public static void getExpression(String expression) throws Exception {
        int resultExp;
        ArrayList<Integer> numb = new ArrayList<>();
        String sign = QUESTIONMARK;
        int indexSign = 0;
        String firstRomanNumb;
        String secondRomanNumb;

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
            if (!sign.equals("?")) {
                indexSign = i;
                break;
            }
        }

        String[] words = expression.split("\\D");
        if (words.length != 0) {
            for (String word : words) {
                try {
                        numb.add(Integer.parseInt(word));
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Напишите выражение правильно");
                    }
            }
        }

        if (numb.isEmpty() && !sign.equals("?")){
            int firstArabNumb;
            int secondArabNumb;
            firstRomanNumb = expression.substring(0, indexSign);
            secondRomanNumb = expression.substring(indexSign+1);
            TestTask first = new TestTask(firstRomanNumb);
            firstArabNumb = first.getArabNumb();
            TestTask second = new TestTask(secondRomanNumb);
            secondArabNumb = second.getArabNumb();

            if (firstArabNumb == 0 && secondArabNumb == 0){
                System.out.println("Error");
            }else{
                resultExp = solve(firstArabNumb, secondArabNumb, sign);
                outResultRoman(resultExp);
            }
        } else if(sign.equals("-")){
            System.out.println("throws Exception");
        }else if (!numb.isEmpty() && sign.equals("?")) {
            try {
                resultExp = solve(numb.get(0), numb.get(1), sign);
                outResult(resultExp);
            } catch (Exception e){
                throw new Exception("no correctly");
            }
        }
    }
}
