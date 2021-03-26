/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauss_algorithm;

/**
 *
 * @author user
 * @param <T>
 */
public interface Zahl<T> extends Comparable<T> {

    T getObjectFromString(String s);

    T add(T one);

    T divide(T one);

    T subtract(T one);

    T multiply(T one);

    double absolute();

    boolean isZero();
}
