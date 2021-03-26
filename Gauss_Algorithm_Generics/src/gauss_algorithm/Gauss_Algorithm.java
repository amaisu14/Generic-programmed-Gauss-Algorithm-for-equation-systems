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
public class Gauss_Algorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FractionParameter[] fractions = new FractionParameter[5];
        fractions[0] = new FractionParameter();

        
        DoubleParameter[] doubles = new DoubleParameter[5];
        doubles[0] = new DoubleParameter();

        Matrix mF = new Matrix();

        
        mF.loadFromFiles("matrix_4_4_frac.txt", "rhs_4_frac.txt", fractions);
        mF.solve();

        System.out.println("----------------------------------------------");

        mF.loadFromFiles("matrix.txt", "rhs.txt", doubles);
        mF.solve();

    }

}
