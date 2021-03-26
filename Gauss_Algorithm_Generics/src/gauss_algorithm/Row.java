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
public class Row<T extends Zahl> {

    T[] elements;
    T rhs;

    boolean isPivot = false;
    MaxRowElement max;

    int xiPosition;

    public Row(T[] e, T r) {
        this.elements = e;
        this.rhs = r;
    }

    public void divideWithMax() {
        setMaxElement();

        if (max.position >= 0) {
//            System.out.println("Dividing with "+max.value);
            for (int i = 0; i < elements.length; i++) {
//                elements[i]/=max.value;
                elements[i] = (T) elements[i].divide((T) max.value);
            }
            rhs = (T) rhs.divide((T) max.value);
            isPivot = true;
        }
    }

    public void subtractRow(Row dividedRow) {
//        int pivotPosition=dividedRow.getMaxElement().position;
        T x = elements[dividedRow.max.position];
        for (int i = 0; i < elements.length; i++) {
//            elements[i]-=x*dividedRow.elements[i];
            elements[i] = (T) elements[i].subtract(x.multiply(dividedRow.elements[i]));
        }
//        rhs-=x*dividedRow.rhs;
        rhs = (T) rhs.subtract(x.multiply(dividedRow.rhs));
    }

    public void setMaxElement() {
        Double maxV = new Double(0.0);
        int maxPos = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].absolute() > maxV) {
                maxV = elements[i].absolute();
                maxPos = i;
            }
        }
        max = new MaxRowElement(maxPos, elements[maxPos]);
    }

    public boolean isZeroRow() {
        boolean b = true;
        for (T e : elements) {
            if (e.absolute() > 0.00001) {
                b = false;
            }
        }
        return b;
    }

    public void setXiPosition() {
        if (isPivot) {
            for (int i = 0; i < elements.length; i++) {
                //if not zero
                if (!elements[i].isZero()) {
                    xiPosition = i;
                }
            }
        }
    }

    public void printRow() {
        int positionStern = isPivot ? max.position : -1;
        for (int i = 0; i < elements.length; i++) {
            if (i == positionStern) {
                System.out.print("*");
            }
            System.out.printf("%s\t", elements[i].toString());
        }
        System.out.printf("|  %s", rhs.toString());
    }
}
