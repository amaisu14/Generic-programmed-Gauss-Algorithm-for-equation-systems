/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauss_algorithm;

/**
 *
 * @author user
 */
public class FractionParameter implements Zahl<FractionParameter> {

    private Fraction value;

    public FractionParameter(int n, int d) {
        this.value = new Fraction(n, d);
    }

    public FractionParameter(Fraction v) {
        this.value = v;
    }

    FractionParameter() {
    }

    @Override
    public FractionParameter add(FractionParameter one) {
        return new FractionParameter(value.add(one.value));
    }

    @Override
    public FractionParameter divide(FractionParameter one) {
        return new FractionParameter(value.divide(one.value));
    }

    @Override
    public FractionParameter subtract(FractionParameter one) {
        return new FractionParameter(value.subtract(one.value));
    }

    @Override
    public FractionParameter multiply(FractionParameter one) {
        return new FractionParameter(value.multiply(one.value));
    }

    @Override
    public double absolute() {
        return Math.abs(value.getNumerator() / value.getDenominator());
    }

    @Override
    public int compareTo(FractionParameter o) {
        Fraction diff = value.subtract(o.value);
        double x = diff.getNumerator() / diff.getDenominator();
        if (x > 0) {
            return 1;
        } else if (x == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public boolean isZero() {
        return value.getNumerator() == 0;
    }

    @Override
    public FractionParameter getObjectFromString(String s) {
        String[] sParts = s.split("/");
        return new FractionParameter(Integer.valueOf(sParts[0]), Integer.valueOf(sParts[1]));
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
