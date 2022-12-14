package ru.home.test;
import java.util.ArrayList;

public class CalculatorNumbers {
    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String DIVIDE = ":";
    private final static String MULTIPLY = "*";
    private final static String QUESTIONMARK = "?";

    CalculatorNumbers(){}


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

    public static String outResultRoman(int result)  {
        String resultRoman;
        ArabToRoman arabToRoman = new ArabToRoman();
        resultRoman = arabToRoman.arabicToRoman(result);
        return resultRoman;
    }


    public static String getExpression(String expression) throws Exception {
        String exit = "EXIT";
        String result;
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
                case '/' -> DIVIDE;
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
                        throw new NumberFormatException("???????????????????????? ???????????? ?????????????? ????????????????????");
                    }
            }
        }

        int resultExp;
        if (numb.isEmpty() && !sign.equals("?")){
            int firstArabNumb;
            int secondArabNumb;
            firstRomanNumb = expression.substring(0, indexSign);
            secondRomanNumb = expression.substring(indexSign+1);
            TestTask first = new TestTask(firstRomanNumb);
            firstArabNumb = first.getArabNumb();
            TestTask second = new TestTask(secondRomanNumb);
            secondArabNumb = second.getArabNumb();

             if (firstArabNumb <= secondArabNumb && sign.equals("-")){
                throw new Exception("?????????????? ?????????? ???? ?????????? ???????? ????????????????????????????");
            }else{
                resultExp = solve(firstArabNumb, secondArabNumb, sign);
                result = outResultRoman(resultExp);
                return result;
            }
        }
        else if (!numb.isEmpty() && !sign.equals("?")) {

            if (numb.size() >=3 ){
                throw new Exception("???????????? ???????????????????????????? ???????????????? ???? ?????????????????????????? ??????????????");
            }

            try {
                resultExp = solve(numb.get(0), numb.get(1), sign);
                return toString(resultExp);
            } catch (Exception e){
                throw new Exception("throws Exception");
            }
        }
        else if (numb.size() == 1){
            throw new Exception("???????????? ???? ???????????????? ???????????????????????????? ??????????????????");
        }
    return exit;
}

    private static String toString(int exp){
        return "" + exp;
    }

}
