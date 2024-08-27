package ru.stepup.homework;

public class Fraction extends Number {

    private int numerator;
    private int denominator;
    private double number;

    public Fraction(int numerator, int denominator) throws IllegalArgumentException {
        if (denominator < 0) {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным числом");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(double number) {
        this.numerator = (int) (number * 10);
        this.denominator = 10;
    }

    @Override
    public String toString() {
        return "числитель/знаменатель: " + numerator + "/" + denominator;
    }

    public Fraction sum(Fraction fraction) {
        int sumNumerator = this.numerator * fraction.denominator + this.denominator * fraction.numerator;
        int sumDenominator = this.denominator * fraction.denominator;
        return new Fraction(sumNumerator, sumDenominator);
    }

    public Fraction sum(int num) {
        return sum(new Fraction(num, 1));
    }

    public Fraction minus(Fraction fraction) {
        int minusNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator;
        int minusDenominator = this.denominator * fraction.denominator;
        return new Fraction(minusNumerator, minusDenominator);
    }

    public Fraction minus(int num) {
        return minus(new Fraction(num, 1));
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
}

