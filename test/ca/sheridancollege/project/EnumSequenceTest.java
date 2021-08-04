/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

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
public class EnumSequenceTest {
    
    public EnumSequenceTest() {
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
     * Test of values method, of class EnumSequence.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        EnumSequence[] expResult = null;
        EnumSequence[] result = EnumSequence.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class EnumSequence.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "";
        EnumSequence expResult = null;
        EnumSequence result = EnumSequence.valueOf(string);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescrisption method, of class EnumSequence.
     */
    @Test
    public void testGetDescrisption() {
        System.out.println("getDescrisption");
        EnumSequence instance = null;
        String expResult = "";
        String result = instance.getDescrisption();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
