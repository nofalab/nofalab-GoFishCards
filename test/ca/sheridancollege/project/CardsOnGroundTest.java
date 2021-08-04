/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
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
public class CardsOnGroundTest {
    
    public CardsOnGroundTest() {
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
     * Test of cardGenerator method, of class CardsOnGround.
     */
    @Test
    public void testCardGenerator() {
        System.out.println("cardGenerator");
        CardsOnGround instance = null;
        instance.cardGenerator();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCardsOnGround method, of class CardsOnGround.
     */
    @Test
    public void testGetCardsOnGround() {
        System.out.println("getCardsOnGround");
        ArrayList<Card> expResult = null;
        ArrayList<Card> result = CardsOnGround.getCardsOnGround();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
