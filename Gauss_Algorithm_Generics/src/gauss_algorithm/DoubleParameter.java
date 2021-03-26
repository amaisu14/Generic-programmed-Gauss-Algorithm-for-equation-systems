/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauss_algorithm;

import java.text.DecimalFormat;

/**
 *
 * @author user
 */
public class DoubleParameter implements Zahl<DoubleParameter> {

    private double value;

    public DoubleParameter(double z) {
        value = z;
    }

    DoubleParameter() {
    }

    @Override
    public DoubleParameter add(DoubleParameter a) {
        return new DoubleParameter(value + a.value);
    }

    @Override
    public DoubleParameter subtract(DoubleParameter a) {
        return new DoubleParameter(value - a.value);
    }

    @Override
    public DoubleParameter multiply(DoubleParameter a) {
        return new DoubleParameter(value * a.value);
    }

    @Override
    public DoubleParameter divide(DoubleParameter a) {
        return new DoubleParameter(value / a.value);
    }

    @Override
    public int compareTo(DoubleParameter o) {
        if(value>o.value) return 1;
        else if(Math.abs(value-o.value)<0.001) return 0;
        else return -1;
    }

    @Override
    public String toString() {
        
        return new DecimalFormat("#.##").format(value);
    }

    @Override
    public double absolute() {
        return Math.abs(value);
    }
    
    @Override
    public boolean isZero(){
        return Math.abs(value)<0.001;
    }

    @Override
    public DoubleParameter getObjectFromString(String s) {
        return new DoubleParameter(Double.valueOf(s));
    }

    

   
    

}
