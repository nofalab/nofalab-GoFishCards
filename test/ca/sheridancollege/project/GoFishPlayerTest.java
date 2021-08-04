/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Arrays;
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
public class GoFishPlayerTest {
    
    public GoFishPlayerTest() {
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

//    /**
//     * Test of play method, of class GoFishPlayer.
//     */
//    @Test
//    public void testPlay() {
//        System.out.println("play");
//        Game newFishGame = null;
//        Scanner sc = null;
//        int turnsCounter = 0;
//        int booksLimit = 0;
//        GoFishPlayer instance = null;
//        instance.play(newFishGame, sc, turnsCounter, booksLimit);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toString method, of class GoFishPlayer.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        GoFishPlayer instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of playerDeal method, of class GoFishPlayer.
//     */
//    @Test
//    public void testPlayerDeal() {
//        System.out.println("playerDeal");
//        int numOfCards = 0;
//        GoFishPlayer instance = null;
//        instance.playerDeal(numOfCards);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPlayerSequence method, of class GoFishPlayer.
//     */
//    @Test
//    public void testGetPlayerSequence() {
//        System.out.println("getPlayerSequence");
//        GoFishPlayer instance = null;
//        EnumSequence expResult = null;
//        EnumSequence result = instance.getPlayerSequence();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCardsInHand method, of class GoFishPlayer.
//     */
//    @Test
//    public void testGetCardsInHand() {
//        System.out.println("getCardsInHand");
//        GoFishPlayer instance = null;
//        CardsInHand expResult = null;
//        CardsInHand result = instance.getCardsInHand();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of checkWinCombinations method, of class GoFishPlayer.
//     */
//    @Test
//    public void testCheckWinCombinations() {
//        System.out.println("checkWinCombinations");
//        GoFishPlayer instance = null;
//        instance.checkWinCombinations();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getWinComb method, of class GoFishPlayer.
//     */
//    @Test
//    public void testGetWinComb() {
//        System.out.println("getWinComb");
//        GoFishPlayer instance = null;
//        int expResult = 0;
//        int result = instance.getWinComb();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of whoToAskChecker method, of class GoFishPlayer.
     */
    @Test
    public void testWhoToAskCheckerGood() {
        System.out.println("whoToAskCheckerGood");
        Scanner sc = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<Player>(Arrays.asList(new GoFishPlayer("A", 0), new GoFishPlayer("B", 1), new GoFishPlayer("C", 3)));
        int expResult = 2;
        int result = GoFishPlayer.whoToAskChecker(sc, players);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
//    
// @Test
//    public void testWhoToAskChecker() {
//        System.out.println("whoToAskChecker");
//        Scanner sc = null;
//        ArrayList<Player> players = null;
//        int expResult = 0;
//        int result = GoFishPlayer.whoToAskChecker(sc, players);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
    
// @Test
//    public void testWhoToAskChecker() {
//        System.out.println("whoToAskChecker");
//        Scanner sc = null;
//        ArrayList<Player> players = null;
//        int expResult = 0;
//        int result = GoFishPlayer.whoToAskChecker(sc, players);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of valueChecker method, of class GoFishPlayer.
//     */
//    @Test
//    public void testValueChecker() {
//        System.out.println("valueChecker");
//        Scanner sc = null;
//        int expResult = 0;
//        int result = GoFishPlayer.valueChecker(sc);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
