/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauss_algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 * @param <N>
 */
public class Matrix<N extends Zahl> {

    private List<Row<N>> rowsList;
//    Row<N>[] rows;

    int dimensionRows, dimensionColumns;

    public Matrix() {
        this.rowsList = new ArrayList<>();
    }

    public void elimination() {
        System.out.println("Elimination:");
        for (int pR = 0; pR < rowsList.size(); pR++) {
            if (!rowsList.get(pR).isPivot && !rowsList.get(pR).isZeroRow()) {
                rowsList.get(pR).divideWithMax();
                for (int otherRows = pR + 1; otherRows < rowsList.size(); otherRows++) {
                    rowsList.get(otherRows).subtractRow(rowsList.get(pR));
                }
                printMatrix();
            }
        }
    }

    public void rSubstitution() {
        System.out.println("Rücksubstitution:");
        for (int pR = rowsList.size() - 1; pR >= 0; pR--) {
            if (rowsList.get(pR).isPivot) {
//                rows[pR].divideWithMax();                
                for (int otherRows = pR - 1; otherRows >= 0; otherRows--) {
                    rowsList.get(otherRows).subtractRow(rowsList.get(pR));
                }
                printMatrix();
            }
        }
    }

    public boolean isSolvable() {
        boolean b = true;
        for (Row<N> row : rowsList) {
            if (row.isZeroRow() && !row.rhs.isZero()) {
                b = false;
            }
        }
        return b;
    }

    public void solve() {
        elimination();
        if (isSolvable()) {
            rSubstitution();
            System.out.println("System is solvable:");
            printResults();
        } else {
            System.out.println("System is not solvable");
        }
    }

    public void printResults() {
        System.out.println("");
        for (Row r : rowsList) {
            if (r.isPivot) {
                r.setXiPosition();
                System.out.printf("{  (%s)   \t\t-mu_%d(%s)\t}",
                        r.rhs.toString(), rowsList.size(), r.elements[r.xiPosition].toString());
            }
            System.out.println("");
        }
    }

    //ich konnte nicht ein Array mit generic Variablen erstellen, deshalb T[] row :/
    public <T extends Zahl> void loadFromFiles(String matrixFile, String rhsFile, T[] row) {
        rowsList = new ArrayList<>();
        try {
            File m = new File(matrixFile);
            File r = new File(rhsFile);
            Scanner sM = new Scanner(m);
            Scanner sR = new Scanner(r);

            dimensionRows = sM.nextInt();
            dimensionColumns = sM.nextInt();

            //ich brauche ein Objekt mit Laufzeittyp T, habe keine andere Möglichkeit gefunden :/
            T x = row[0];
            T[] emptyRow = row.clone();
            sR.next();
            for (int j = 0; j < dimensionRows; j++) {
                String s1 = sR.next();
                T rhs = (T) x.getObjectFromString(s1);

                //empty the array
                row = emptyRow.clone();

                for (int i = 0; i < row.length; i++) {
                    row[i] = (T) x.getObjectFromString(sM.next());
                }
                Row rowObject = new Row<>(row, rhs);
                rowsList.add(rowObject);
            }

            System.out.println("Matrix:");
            printMatrix();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Matrix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void printMatrix() {
        System.out.println("");
        for (Row r : rowsList) {
            r.printRow();
            System.out.println("");
        }
        System.out.println("");
    }
}
