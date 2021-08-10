/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author abdal
 */
public class GeneUtilitiesTest {
    
    public GeneUtilitiesTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of numValidator method, of class GeneUtilities.
     */
    
    /**
     * Test of isCharOrFloat method, of class GeneUtilities.
     */
    @Test
    public void testIsCharOrFloatGood() {
        System.out.println("isCharOrFloatGood");
        String strNum = "c";
        boolean expResult = true;
        boolean result = GeneUtilities.isCharOrFloat(strNum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testIsCharOrFloatBad() {
        System.out.println("isCharOrFloatBad");
        String strNum = "15";
        boolean expResult = false;
        boolean result = GeneUtilities.isCharOrFloat(strNum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testIsCharOrFloatBoundary() {
        System.out.println("isCharOrFloatBoundary");
        String strNum = "1.1";
        boolean expResult = true;
        boolean result = GeneUtilities.isCharOrFloat(strNum);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of isntInRange method, of class GeneUtilities.
     */
    @Test
    public void testIsntInRangeGood() {
        System.out.println("isntInRangeGood");
        int num = 1;
        int min = 10;
        int max = 17;
        boolean expResult = true;
        boolean result = GeneUtilities.isntInRange(num, min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testIsntInRangeBad() {
        System.out.println("isntInRangeBad");
        int num = 1;
        int min = 10;
        int max = 6;
        boolean expResult = false;
        boolean result = GeneUtilities.isntInRange(num, min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testIsntInRangeBoundary() {
        System.out.println("isntInRangeBoundary");
        int num = 1;
        int min = 10;
        int max = 10;
        boolean expResult = false;
        boolean result = GeneUtilities.isntInRange(num, min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
//    @Test
//    public void testNumValidator() {
//        System.out.println("numValidator");
//        Scanner sc = null;
//        int min = 0;
//        int max = 0;
//        int expResult = 0;
//        int result = GeneUtilities.numValidator(sc, min, max);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    
}
