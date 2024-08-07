package ru.stepup.homework;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) throws IllegalArgumentException {
        if (denominator < 0) {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным числом");
        }
        this.numerator = numerator;
        this.denominator = denominator;
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

}

