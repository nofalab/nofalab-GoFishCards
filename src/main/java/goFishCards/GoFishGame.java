/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishCards;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jake M
 */
public class GoFishGame extends Game {

    Scanner in;
    private int numOfPlayers;
    private ArrayList<Player> playerList;

    public GoFishGame() {
        in = new Scanner(System.in);
        StandardDeck deck = new StandardDeck();
        this.playerList = new ArrayList<Player>();
        numOfPlayers = 0;

    }

    @Override
    public void playGame() {
        System.out.println("Welcome to Go Fish...");
        String finDot = " _";
        String bodyDot = "              ^_^_^_^_^_";
        int two = 2;
        for (int i = 0; i < 5; i++) {
            System.out.print(finDot);

            System.out.println(bodyDot);

            try {
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            finDot += "^_";
            bodyDot = bodyDot.substring(i + 2) + "^_^_";
        }
        System.out.println("-----------------------------------------------------------------------\n\n");

        while (this.numOfPlayers < 2 || this.numOfPlayers > 7) {
            try {
                System.out.println("Please select the number players 2-7: ");
                this.numOfPlayers = in.nextInt();
                in.nextLine();

            } catch (InputMismatchException ex) {
                System.err.println("*You must enter a number*");
                in.nextLine();
            }

        }

        for (int i = 0; i < numOfPlayers; i++) {
            String playerName = " ";
            System.out.println("Player " + (i + 1) + " name: ");
            playerName = in.nextLine().toUpperCase();

            try {
                this.getPlayerList().add(i, new GoFishPlayer(playerName, i + 1));
            } catch (Exception ex) {
                System.err.println("*Please try again*");
            }

        }

        System.out.println("Thank you... shuffling deck");

    }

    /**
     * @return the playerList
     */
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    /**
     * @param playerList the playerList to set
     */
    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
}
