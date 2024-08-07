package ru.stepup.homework;

public class MainApp {

    public static void main(String[] args) {

        double result1 = sumAll(new Fraction(2), new Fraction(3, 5), new Fraction(2.3));
        System.out.println("Результат выражения 2 + 3/5 + 2.3: " + result1);

        double result2 = sumAll(new Fraction(3.6), new Fraction(49, 12),
                new Fraction(3), new Fraction(3, 2));
        System.out.println("Результат выражения 3.6 + 49/12 + 3 + 3/2: " + result2);

        double result3 = sumAll(new Fraction(1,3), new Fraction(1));
        System.out.println("Результат выражения 1/3 + 1: " + result3);

    }

    public static double sumAll(Fraction... fractions) {
        double sum = 0;
        for (Fraction fraction : fractions) {
            sum += fraction.doubleValue();
        }
        return sum;
    }
}