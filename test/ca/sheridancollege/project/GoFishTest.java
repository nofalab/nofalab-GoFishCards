/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
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
public class GoFishTest {
    
    public GoFishTest() {
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
     * Test of play method, of class GoFish.
     */
//    @Test
//    public void testPlay() {
//        System.out.println("play");
//        Scanner sc = null;
//        GoFish instance = null;
//        instance.play(sc);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of numOfCardsCalculator method, of class GoFish.
//     */
    @Test
    public void testNumOfCardsCalculatorGood() {
        System.out.println("numOfCardsCalculatorGood");
        int numOfPlayers = 3;
        int expResult = 5;
        int result = GoFish.numOfCardsCalculator(numOfPlayers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testNumOfCardsCalculatorBad() {
        System.out.println("numOfCardsCalculatorBad");
        int numOfPlayers = 20;
        int expResult = 0;
        int result = GoFish.numOfCardsCalculator(numOfPlayers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

        @Test
    public void testNumOfCardsCalculatorBoundary() {
        System.out.println("numOfCardsCalculatorBoundary");
        int numOfPlayers = 8;
        int expResult = 0;
        int result = GoFish.numOfCardsCalculator(numOfPlayers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


//    /**
//     * Test of validatedNumOfPlayers method, of class GoFish.
//     */
//    @Test
//    public void testValidatedNumOfPlayers() {
//        System.out.println("validatedNumOfPlayers");
//        Scanner sc = null;
//        int expResult = 0;
//        int result = GoFish.validatedNumOfPlayers(sc);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of validatedNumOfBooks method, of class GoFish.
//     */
//    @Test
//    public void testValidatedNumOfBooks() {
//        System.out.println("validatedNumOfBooks");
//        Scanner sc = null;
//        int expResult = 0;
//        int result = GoFish.validatedNumOfBooks(sc);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of playersAdding method, of class GoFish.
//     */
//    @Test
//    public void testPlayersAdding() {
//        System.out.println("playersAdding");
//        Scanner sc = null;
//        int numOfPlayers = 0;
//        Game newGame = null;
//        GoFish.playersAdding(sc, numOfPlayers, newGame);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of declareWinner method, of class GoFish.
//     */
//    @Test
//    public void testDeclareWinner() {
//        System.out.println("declareWinner");
//        ArrayList<Player> players = null;
//        GoFish instance = null;
//        Player expResult = null;
//        Player result = instance.declareWinner(players);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addPlayer method, of class GoFish.
//     */
//    @Test
//    public void testAddPlayer() {
//        System.out.println("addPlayer");
//        Player player = null;
//        GoFish instance = null;
//        instance.addPlayer(player);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of dealCardsToPlayers method, of class GoFish.
//     */
//    @Test
//    public void testDealCardsToPlayers() {
//        System.out.println("dealCardsToPlayers");
//        GoFish instance = null;
//        instance.dealCardsToPlayers();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of giveTurns method, of class GoFish.
//     */
//    @Test
//    public void testGiveTurns() {
//        System.out.println("giveTurns");
//        Scanner sc = null;
//        int booksLimit = 0;
//        GoFish instance = null;
//        instance.giveTurns(sc, booksLimit);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
