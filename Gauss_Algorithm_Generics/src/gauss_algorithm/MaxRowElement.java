/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauss_algorithm;

import java.math.MathContext;

/**
 *
 * @author user
 */
public class MaxRowElement<T extends Zahl> {
    int position;
    T value;
    public MaxRowElement(int p,T v){
        this.position=p;
        this.value=v;
    }

}
