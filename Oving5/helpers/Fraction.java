package helpers;

import java.util.List;
import java.util.ArrayList;

public class Fraction {
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Fraction denominator can not be zero");
        this.m_numerator = numerator;
        this.m_denominator = denominator;
    }

    public Fraction(int numerator) {
        this.m_numerator = numerator;
        this.m_denominator = 1;
    }

    public Fraction(Fraction other) {
        this.m_numerator = other.getNumerator();
        this.m_denominator = other.getDenominator();
    }

    public int getNumerator() {
        return this.m_numerator;
    }

    public int getDenominator() {
        return this.m_denominator;
    }

    public void add(Fraction other) {
        int preExpandDenominator = this.m_denominator;
        Fraction toAdd = new Fraction(other);

        this.expand(other.getDenominator());
        toAdd.expand(preExpandDenominator);

        this.m_numerator += toAdd.getNumerator();

        this.simplify();
    }

    public void subtract(Fraction other) {
        int preExpandDenominator = this.m_denominator;
        Fraction toSubtract = new Fraction(other);

        this.expand(other.getDenominator());
        toSubtract.expand(preExpandDenominator);

        this.m_numerator -= toSubtract.getNumerator();
        
        this.simplify();
    }

    public void multiply(Fraction other) {
        this.m_numerator *= other.getNumerator();
        this.m_denominator *= other.getDenominator();

        this.simplify();
    }

    public void divide(Fraction other) {
        if (other.getNumerator() == 0) throw new IllegalArgumentException("Can't divide by fraction of value zero");
        this.m_numerator *= other.getDenominator();
        this.m_denominator *= other.getNumerator();

        this.simplify();
    }

    public String toString() {
        return String.format("%d/%d", this.m_numerator, this.m_denominator);
    }

    private void expand(int multiplier) {
        this.m_numerator *= multiplier;
        this.m_denominator *= multiplier;
    }

    private void simplify() {
        List<Integer> numeratorFactors = factorize(this.m_numerator);
        List<Integer> denominatorFactors = factorize(this.m_denominator);

        boolean numeratorfactorLongest = numeratorFactors.size() > denominatorFactors.size();

        List<Integer> longer = numeratorfactorLongest ? numeratorFactors : denominatorFactors;
        List<Integer> shorter = !numeratorfactorLongest ? numeratorFactors : denominatorFactors;
        
        List<Integer> toRemove = new ArrayList<Integer>();

        for (Integer number : shorter) {
            if (longer.contains(number)) {
                longer.remove(longer.lastIndexOf(number));
                toRemove.add(number);
            }
        }

        for (Integer number : toRemove) {
            shorter.remove(number);
        }

        int newNumerator = 1;
        int newDenominator = 1;

        for (Integer integer : numeratorfactorLongest ? longer : shorter) {
            newNumerator *= integer;
        }

        for (Integer integer : numeratorfactorLongest ? shorter : longer) {
            newDenominator *= integer;
        }

        this.m_numerator = newNumerator;
        this.m_denominator = newDenominator;
    }

    private List<Integer> factorize(int number) {
        List<Integer> factors = new ArrayList<Integer>();

        while (number > 1) {
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) {
                    factors.add(i);
                    number /= i;
                }
            }
        }

        return factors;
    }

    private int m_numerator, m_denominator;
}
