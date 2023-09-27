import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String calc(String input) throws IOException {
        String[] values = input.split(" ");
        if (values.length > 3) {
            throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if (values.length < 3) {
            throw new IOException("Неверный формат математической операции");
        }
        int num1, num2, result;
        Converter converter = new Converter();
        char act = values[1].charAt(0);
        if (converter.isRoman(values[0]) == converter.isRoman(values[2])) {
            boolean isRoman = converter.isRoman(values[0]);
            if (isRoman) {
                num1 = converter.romanToArabic(values[0]);
                num2 = converter.romanToArabic(values[2]);
            } else {
                try {
                    num1 = Integer.parseInt(values[0]);
                    num2 = Integer.parseInt(values[2]);
                } catch (NumberFormatException e) {
                    throw new IOException("Неверное выражение");
                }
            }
            if (num1<1 | num1>10 | num2 <1 | num2>10){
                throw new IOException("Только значения от 1 до 10 (В римской системе от I до X)");
            }
            switch (act) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
                default -> throw new IOException("Не является математической операцией");
            }
            if (isRoman) {
                if (result < 1) {
                    throw new IOException("В римской системе нет отрицательных чисел");
                } else input = converter.arabicToRoman(result);
            } else {
                input = Integer.toString(result);
            }
        } else {
            throw new IOException("Одна система счисления");
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println(calc(input.nextLine()));
    }
}