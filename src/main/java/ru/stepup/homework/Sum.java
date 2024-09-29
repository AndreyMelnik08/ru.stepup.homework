package ru.stepup.homework;
import java.util.regex.Pattern;

public class Sum {
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("^[+-]?([0-9]*[.])?[0-9]+$");
    // Pattern DOUBLE_PATTERN проверяет, является ли строка допустимым представлением числа с плавающей точкой.

    private static boolean isValidDouble(String str) {
        return DOUBLE_PATTERN.matcher(str).matches();
    }

    public static void main(String[] args) {

        double sum = 0;
        for (String arg : args) {
            if (isValidDouble(arg)) {
                sum += Double.parseDouble(arg);
            } else  {
                System.out.println("Неверный формат строки");
            }
        }
        System.out.println("Результат: " + sum);
    }
}
