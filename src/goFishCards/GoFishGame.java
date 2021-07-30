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
 * @author Jake M
 */
public class GoFishGame extends Game {

    Scanner in;
    private int numOfPlayers;
    private int currentPlayer = 0;
    private ArrayList<GoFishPlayer> playerList;
    StandardDeck deck;

    public GoFishGame() {
        in = new Scanner(System.in);
        this.deck = new StandardDeck();
        this.playerList = new ArrayList<>();
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
        System.out.println("-----------------------------------------------------------------------------\n");

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

        System.out.println("Thank you... Preparing the game...");
        deck.shuffle();
        for (int i = 0; i < numOfPlayers; i++) {
            if (numOfPlayers < 5) {
                playerList.get(i).setCardsInHand(deck.newHand(7));
            } else if (numOfPlayers > 5) {
                playerList.get(i).setCardsInHand(deck.newHand(5));
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }



        System.out.println("Ready? (Press enter to start)...");
        try {
            System.in.read();
        } catch (Exception e) {
        }

        String fishBaitstr;
        int fishBait = -1;
        boolean goFish = false;
        boolean numCheckHand=false;
        do {
            do {
                numCheckHand = false;
                goFish = false;
                if (playerList.get(currentPlayer).getCardsInHand().isEmpty()) {
                    System.out.println("Your hand is empty,  Please draw a new hand from the deck\n");
                    System.out.println("Press enter to draw hand");
                    if (numOfPlayers < 5)
                        playerList.get(currentPlayer).getCardsInHand().addAll(deck.newHand(7));
                    else
                        playerList.get(currentPlayer).getCardsInHand().addAll(deck.newHand(5));
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }

                }
                System.out.print("Here is your hand ");
                System.out.println(playerList.get(currentPlayer).toString() + "\n");
                System.out.println("Enter the number of the card you want to fish for: ");

                try {
                    fishBaitstr = in.nextLine();
                    fishBait =  Integer.parseInt(fishBaitstr);

                } catch (Exception ex) {
                    System.err.println("*You must enter a number*");

                }
                for (int i=0; i < playerList.get(currentPlayer).getCardsInHand().size(); i++){
                    if (playerList.get(currentPlayer).getCardsInHand().get(i).getValue().ordinal()+1 == fishBait) {
                        numCheckHand = true;
                        break;
                    }
                }
            } while (!numCheckHand);


            boolean setFound = false; // boolean to check if a full set is found
            int matchCount = 0; // number of matches in current player's hand, if reaches '3' full set is found
                                // bc if a single card matches with 3 others, that is 4 cards matching in hand
            int matchIndex1 = 0; // holds the array position of the matching card
            int matchIndex2 = 0; // holds the array position of the matching card
            int matchIndex3 = 0; // holds the array position of the matching card
            boolean opponentMatch; // boolean for entering and finding opponent name in playerList
            String opponent = " "; // initializing opponent name that will be entered
            do {
                System.out.print("Here are your opponents: ");
                for (int i = 0; i < playerList.size(); i++) { // Displaying player opponent list
                    if (playerList.get(i).equals(playerList.get(currentPlayer))) // will skip from showing current player
                        continue;
                    if (i == playerList.size() - 1) // if last player in list, it will not show comma (still shows if current player is last in list)
                        System.out.print(" " + playerList.get(i).getName() + "\n");
                    else
                        System.out.print(" " + playerList.get(i).getName() + ","); // print opponent list with comma in between
                }
                System.out.println();
                opponentMatch = false;
                System.out.println("Enter the opponent's name you wish to choose from: ");
                try {
                    opponent = in.nextLine(); // taking opponents name from input
                } catch (InputMismatchException ex) { // if wrong input detected
                    System.err.println("*You must enter a name*");
                    in.nextLine(); // will clear scanner
                }

                // Loop will search the playerList for opponent
                for (int i = 0; i < playerList.size(); i++) { //looking for opponent's name

                    if (playerList.get(i).getName().equalsIgnoreCase(opponent) && playerList.get(i).equals(playerList.get(currentPlayer))) { // if user entered their own name it will be caught by checkName
                        opponentMatch = false;
                        System.err.println("You cannot ask yourself enter an opponent");
                        break;
                    } else if (playerList.get(i).getName().equalsIgnoreCase(opponent)) { // opponent name valid
                        opponentMatch = true;
                        for (int m = 0; m < playerList.get(i).getCardsInHand().size(); m++) {
                            if ((playerList.get(i).getCardsInHand().get(m).getValue().ordinal() + 1) == fishBait) {
                                goFish = true;
                                System.out.println("Match found! " + playerList.get(i).getCardsInHand().get(m).toString() + "\n");
                                playerList.get(currentPlayer).getCardsInHand().add(playerList.get(i).getCardsInHand().get(m));
                                playerList.get(i).getCardsInHand().remove(playerList.get(i).getCardsInHand().get(m));
                                m--; // because the arraylist shuffles down, check same m position again (if two matching cards sit next to each other
                            }
                        }
                    }
                }
                if (!opponentMatch)
                    System.err.println("Opponent not found Please try entering again...\n");

            } while (!opponentMatch);
                // Now check current player's hand for full books (4 matching cards)
                for (int j = 0; j < playerList.get(currentPlayer).getCardsInHand().size(); j++) {
                    if (setFound)
                        break;
                    matchCount = 0;
                    for (int k = 0; k < playerList.get(currentPlayer).getCardsInHand().size(); k++) {
                        if (k == j)
                            continue;
                        else if (matchCount == 0 && playerList.get(currentPlayer).getCardsInHand().get(j).getValue() == playerList.get(currentPlayer).getCardsInHand().get(k).getValue()) {
                            matchIndex1 = k;
                            matchCount++;
                        } else if (matchCount == 1 && playerList.get(currentPlayer).getCardsInHand().get(j).getValue() == playerList.get(currentPlayer).getCardsInHand().get(k).getValue()) {
                            matchIndex2 = k;
                            matchCount++;
                        } else if (matchCount == 2 && playerList.get(currentPlayer).getCardsInHand().get(j).getValue() == playerList.get(currentPlayer).getCardsInHand().get(k).getValue()) {
                            matchIndex3 = k;
                            matchCount++;
                            playerList.get(currentPlayer).getCardMatches().add(playerList.get(currentPlayer).getCardsInHand().get(matchIndex1));
                            playerList.get(currentPlayer).getCardMatches().add(playerList.get(currentPlayer).getCardsInHand().get(matchIndex2));
                            playerList.get(currentPlayer).getCardMatches().add(playerList.get(currentPlayer).getCardsInHand().get(matchIndex3));
                            playerList.get(currentPlayer).getCardMatches().add(playerList.get(currentPlayer).getCardsInHand().get(j));

                            playerList.get(currentPlayer).getCardsInHand().removeAll(playerList.get(currentPlayer).getCardMatches());

                            setFound = true;
                            System.out.println("You have a full book! Press enter to continue...");
                            try {
                                System.in.read();
                            } catch (Exception e) {
                            }

                            break;
                        }
                    }
                }


                if (!goFish) {
                    try {
                        Thread.sleep(1200);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("Match Not found in " + opponent.toUpperCase() + "'s hand\n");
                    System.out.println("You must draw a card: Press enter \n");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }
                    playerList.get(currentPlayer).getCardsInHand().add(deck.drawCard());
                    System.out.println("*You pick up a card from the deck*");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println("Next player's turn! \n");
                    try {
                        Thread.sleep(1400);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    if (currentPlayer == numOfPlayers-1) { // if current player is the last one in playerList
                        currentPlayer = 0; // go to first player in playerList
                    }
                    else {
                        currentPlayer++; // to next player in the playerList
                    }
                    System.out.println("Player " + (currentPlayer + 1) + ": " + playerList.get(currentPlayer).getName() + "'s turn");

                    System.out.println("Ready Player " + (currentPlayer+1) + "? (Press enter to start)...");
                    try {
                        System.in.read();
                    } catch (Exception e) {
                    }
                }





        } while (deck.hasCards());
            System.out.println("Game is over \n     The player with the most books wins.");

            int winner = currentPlayer;
            for (int i=0; i< playerList.size(); i++) {
                if (playerList.get(i).getCardMatches().size() >= playerList.get(winner).getCardMatches().size())
                    winner = i;
            }
            System.out.println("the winner of the game is player " + winner+1 + ": " + playerList.get(winner).getName());
    }

    public boolean opponentNameValidator(String opponent) {
        for (int i = 0; i < playerList.size(); i++) {// loop through player list, looking for opponent's name
            if (playerList.get(i).getName().equalsIgnoreCase(opponent) && playerList.get(i).equals(playerList.get(currentPlayer))) { // if user entered their own name it will be caught by checkName
                System.err.println("You cannot ask yourself, enter an opponent");
                break;
            } else if (playerList.get(i).getName().equalsIgnoreCase(opponent)) { // opponent name valid
                return true;
            }
        }
        return false;
    }





    /**
     * @return the playerList
     */
    public ArrayList<GoFishPlayer> getPlayerList() {
        return playerList;
    }

    /**
     * @param playerList the playerList to set
     */
    public void setPlayerList(ArrayList<GoFishPlayer> playerList) {
        this.playerList = playerList;
    }
}
