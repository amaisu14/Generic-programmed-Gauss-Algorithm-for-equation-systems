/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gauss_algorithm;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author user
 */
public class RowNGTest {
    
    public RowNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of divideWithMax method, of class Row.
     */
    @Test
    public void testDivideWithMax() {
        System.out.println("divideWithMax");
        Row instance = null;
        instance.divideWithMax();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class Row.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        Row dividedRow = null;
        Row instance = null;
        instance.subtract(dividedRow);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxElement method, of class Row.
     */
    @Test
    public void testSetMaxElement() {
        System.out.println("setMaxElement");
        Row instance = null;
        instance.setMaxElement();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isZeroRow method, of class Row.
     */
    @Test
    public void testIsZeroRow() {
        System.out.println("isZeroRow");
        Row instance = null;
        boolean expResult = false;
        boolean result = instance.isZeroRow();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setXiPosition method, of class Row.
     */
    @Test
    public void testSetXiPosition() {
        System.out.println("setXiPosition");
        Row instance = null;
        instance.setXiPosition();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printRow method, of class Row.
     */
    @Test
    public void testPrintRow() {
        System.out.println("printRow");
        Row instance = null;
        instance.printRow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
