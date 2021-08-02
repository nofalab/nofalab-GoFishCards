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
 * @author Jacob
 */
public class GoFishGame extends Game {

    Scanner in;
    private int numOfPlayers;
    private int currentPlayer = 0;
    private ArrayList<GoFishPlayer> playerList;
    StandardDeck deck;
    boolean numCheckHand; // check if the card number entered by currentPlayer is actually in the player's hand;
    String fishBaitstr=" "; // initial string value for the card number (will be parsed into int);
    int fishBait = -1; // initial value to hold for fishBait;
    boolean goFish = false; // check if match is made from another player;
    boolean setFound = false; // boolean to check if a full set is found;
    int matchCount; // number of matches in current player's hand, if reaches '3' full set is found;
    // if a single card matches with 3 others, that is 4 cards matching in hand;
    int matchIndex1 = 0; // holds the array position of the matching card;
    int matchIndex2 = 0; // holds the array position of the matching card;
    int matchIndex3 = 0; // holds the array position of the matching card;
    boolean opponentMatch; // boolean for finding entered opponent name in playerList;
    String opponent = " "; // initializing opponent name that will be entered;


    public GoFishGame() {
        in = new Scanner(System.in);
        this.deck = new StandardDeck();
        this.playerList = new ArrayList<>();
        numOfPlayers = 0;

    }
    public void openingSequence() {
        System.out.println("Welcome to Go Fish...");
        String finDot = " _";
        String bodyDot = "              ^_^_^_^_^_";
        int two = 2;
        for (int i = 0; i < 5; i++) { // Display opening fish;
            System.out.print(finDot);

            System.out.println(bodyDot);

            try { // sleep between each line
                Thread.sleep(400);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            finDot += "^_"; // adding finDot together
            bodyDot = bodyDot.substring(i + 2) + "^_^_"; // reducing bodyDot String by 2 char places each iteration
        }
        System.out.println("-----------------------------------------------------------------------------\n");
    }

    public void numberOfPlayers() {
        while (this.numOfPlayers < 2 || this.numOfPlayers > 7) { // check if number of players entered is between 2-7
            try {
                System.out.println("Please select the number players 2-7: ");
                this.numOfPlayers = in.nextInt();
                in.nextLine();
            } catch (InputMismatchException ex) {
                System.err.println("*You must enter a number*");
                in.nextLine();
            }
        }
    }

    public void playerCreator() {
        for (int i = 0; i < numOfPlayers; i++) { // Enter player names;
            String playerName;
            System.out.println("Player " + (i + 1) + " name: ");
            playerName = in.nextLine().toUpperCase();
            try {
                this.getPlayerList().add(i, new GoFishPlayer(playerName, i + 1)); // add all player objects to playerList;
            } catch (Exception ex) {
                System.err.println("*Fatal error Please try again*"); // if player objects fail to create for some reason;
            }
        }
    }

    public void drawHands() {
        for (int i = 0; i < numOfPlayers; i++) { // drawing hands for each player;
            if (numOfPlayers < 5) {
                playerList.get(i).setCardsInHand(deck.newHand(7));
            } else if (numOfPlayers > 5) {
                playerList.get(i).setCardsInHand(deck.newHand(5));
            }
        }
    }

    public void checkForEmptyHand(){
        if (playerList.get(currentPlayer).getCardsInHand().isEmpty()) { // if currentPlayer has no cards in hand, will draw a new hand;
            playerList.get(currentPlayer).getCardsInHand().clear(); // clear empty hand to fix the IndexOutOfBoundsException;
            System.out.println("Your hand is empty,  Please draw a new hand from the deck\n");
            System.out.println("Press enter to draw hand");

            if (numOfPlayers < 5)
                playerList.get(currentPlayer).setCardsInHand(deck.newHand(7));
            else
                playerList.get(currentPlayer).setCardsInHand(deck.newHand(5));
            try {
                System.in.read(); // wait for enter;
            } catch (Exception e) {
            }
        }
    }

    public void displayHand() {
        System.out.print("Here is your hand ");
        System.out.println(playerList.get(currentPlayer).toString() + "\n"); // display player's hand from player's toString;
    }

    public void askForCard() {
        System.out.println("Enter the number of the card you want to fish for: ");
        try {
            fishBaitstr = in.nextLine();
            fishBait = Integer.parseInt(fishBaitstr);
        } catch (Exception ex) {
            System.err.println("*You must enter a number*");
        }
        for (int i = 0; i < playerList.get(currentPlayer).getCardsInHand().size(); i++) { // check if entered card number is actually in the currentPlayer's hand;
            if (playerList.get(currentPlayer).getCardsInHand().get(i).getValue().ordinal() + 1 == fishBait) {
                numCheckHand = true; // if found true, if not found will loop back to input;
                break;
            }
        }
    }
    public void displayOpponents() {
        System.out.print("Here are your opponents: ");
        for (int i = 0; i < playerList.size(); i++) { // Displaying player opponent list;
            if (playerList.get(i).equals(playerList.get(currentPlayer))) // will skip from showing current player;
                continue;
            if (i == playerList.size() - 1) // if last player in list, it will not show comma (still shows if current player is last in list);
                System.out.print(" " + playerList.get(i).getName() + "\n");
            else
                System.out.print(" " + playerList.get(i).getName() + ","); // print opponent list with comma in between;
        }
        System.out.println(); // new line;
    }

    public void checkOpponentName() { // checks opponents name and hand for matching card
        // Loop will search the playerList for opponent
        for (int i = 0; i < playerList.size(); i++) { //looking for opponent's name;

            if (playerList.get(i).getName().equalsIgnoreCase(opponent) && playerList.get(i).equals(playerList.get(currentPlayer))) { // if user entered their own name it will be caught by checkName;
                opponentMatch = false;
                System.err.println("You cannot ask yourself enter an opponent");
                break;
            } else if (playerList.get(i).getName().equalsIgnoreCase(opponent)) { // opponent name valid ignoring case;
                opponentMatch = true;  // opponent name is found true, will not loop back to input;
                for (int m = 0; m < playerList.get(i).getCardsInHand().size(); m++) {  // loop through opponents hand, looking for 'fishBait' card values;
                    if ((playerList.get(i).getCardsInHand().get(m).getValue().ordinal() + 1) == fishBait) { // if card value.ordinal + 1 == fishBait;
                        goFish = true;  // will loop for another turn
                        System.out.println("Match found! " + playerList.get(i).getCardsInHand().get(m).toString() + "\n"); // display card that was found;
                        playerList.get(currentPlayer).getCardsInHand().add(playerList.get(i).getCardsInHand().get(m)); // add the found card into currentPlayer's hand;
                        playerList.get(i).getCardsInHand().remove(playerList.get(i).getCardsInHand().get(m)); // delete the card from the opponents hand;
                        m--;  // because the arraylist shuffles down, check same m position again (if two matching cards sit next to each other);
                        try { // sleep 1 second
                            Thread.sleep(800);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }

                    }
                }
            }
        }
    }

    public void pickupNewCard() {
        System.out.println("You must draw a card: Press enter \n");
        try { // wait for enter input
            System.in.read();
        } catch (Exception e) {
        }
        StandardCard drawCard = deck.drawCard();
        playerList.get(currentPlayer).getCardsInHand().add(drawCard); // draw top card from deck;
        System.out.println("*You pick up a card from the deck*");
        System.out.println(drawCard + "\n");
    }

    public void checkForBooksInHand() {
        /* Check current player's hand for full books (4 matching cards)
           loop will take each card, and compare to every other card looking for 3 other matches;
             */
        for (int j = 0; j < playerList.get(currentPlayer).getCardsInHand().size(); j++) {
            if (setFound)  // if set is found from previous iteration, break from loop because only one book can be made each card guess;
                break;
            matchCount = 0;  // each iteration of 'j' is a new card, so reset matchCount to 0;
            for (int k = 0; k < playerList.get(currentPlayer).getCardsInHand().size(); k++) { // compare card j to card k;
                if (k == j) // j == k it is the same card;
                    continue; // go to next card;
                else if (matchCount == 0 && playerList.get(currentPlayer).getCardsInHand().get(j).getValue() == playerList.get(currentPlayer).getCardsInHand().get(k).getValue()) {
                    matchIndex1 = k; // save first match index matchIndex1;
                    matchCount++; // matchCount+1 just for the check cases;
                } else if (matchCount == 1 && playerList.get(currentPlayer).getCardsInHand().get(j).getValue() == playerList.get(currentPlayer).getCardsInHand().get(k).getValue()) {
                    matchIndex2 = k; // save second match index matchIndex2;
                    matchCount++; // matchCount=2 for next check;
                } else if (matchCount == 2 && playerList.get(currentPlayer).getCardsInHand().get(j).getValue() == playerList.get(currentPlayer).getCardsInHand().get(k).getValue()) { // 3 matches found = book, add set of cards to the match arrayList;
                    matchIndex3 = k; // third matchIndex3;
                    playerList.get(currentPlayer).getCardMatches().add(playerList.get(currentPlayer).getCardsInHand().get(matchIndex1)); // add the first matchIndex1 to cardMatches arrayList;
                    playerList.get(currentPlayer).getCardMatches().add(playerList.get(currentPlayer).getCardsInHand().get(matchIndex2)); // add second matchIndex2;
                    playerList.get(currentPlayer).getCardMatches().add(playerList.get(currentPlayer).getCardsInHand().get(matchIndex3)); // add third matchIndex3;
                    playerList.get(currentPlayer).getCardMatches().add(playerList.get(currentPlayer).getCardsInHand().get(j)); // add the 4th matched index which is the current value of 'j';

                    playerList.get(currentPlayer).getCardsInHand().removeAll(playerList.get(currentPlayer).getCardMatches()); // remove the set of cards we now have in 'cardMatches' from cardsInHand;
                    setFound = true;
                    System.out.println("You have a full book! Press enter to continue...");
                    try { // wait for enter;
                        System.in.read();
                    } catch (Exception e) {
                    }
                    break; // exit loop;
                }
            }
        }
    }

    public void playerRotator() {
        if (!goFish) { // only activates when no card match is made
            try { // wait 1.4 seconds
                Thread.sleep(800);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            if (currentPlayer == numOfPlayers - 1) { // if current player is the last one in playerList;
                currentPlayer = 0; // go to first player in playerList;
            } else {
                currentPlayer++; // to next player in the playerList;
            }
            System.out.println("Player " + (currentPlayer + 1) + ": " + playerList.get(currentPlayer).getName() + "'s turn");
            System.out.println("Ready Player " + (currentPlayer + 1) + "? (Press enter to start)...");
            try {
                System.in.read();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void playGame() {

        openingSequence();
        numberOfPlayers();
        playerCreator();

        System.out.println("Thank you... Preparing the game...");
        deck.shuffle(); // shuffle the deck
        drawHands();

        try { // 0.5s rest
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Ready? (Press enter to start)...");
        try { // wait for user to press enter;
            System.in.read();
        } catch (Exception e) {
        }

        do {
            do {
                numCheckHand = false;
                goFish = false;

                checkForEmptyHand();
                displayHand();
                askForCard();

                if (!numCheckHand)
                    System.err.println("You can only ask for a card currently in your hand");

            } while (!numCheckHand); // loop back to card number input;


            do {
                displayOpponents();

                opponentMatch = false; // initiate opponent check to false;
                System.out.println("Enter the opponent's name you wish to choose from: ");
                try {
                    opponent = in.nextLine(); // taking opponents name from input;
                } catch (InputMismatchException ex) { // if wrong input detected;
                    System.err.println("*You must enter a name*");
                }

                checkOpponentName(); // check for valid opponent name, and will check for the card in their hand

                if (!opponentMatch)
                    System.err.println("Opponent not found Please try entering again...\n"); // wrong opponent name error message;

            } while (!opponentMatch); // loop back to opponent name entry;

            if (!goFish) { // if no match was found in opponent's hand;

                System.out.println("NO Match in " + opponent.toUpperCase() + "'s hand\n");
                try { // sleep 1.2 seconds
                    Thread.sleep(800);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                pickupNewCard();
                System.out.println("Next player's turn! \n");
                try { // wait 1 second
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.out.println("-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n-\n");
            }

            checkForBooksInHand();
            playerRotator();

        } while (deck.hasCards());

        System.out.println("Game is over \n     The player with the most books wins.");
        try { // sleep 1.5 seconds
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        int winner = currentPlayer;
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getCardMatches().size() > playerList.get(winner).getCardMatches().size())
                winner = i;
            else if (playerList.get(i).getCardMatches().size() == playerList.get(winner).getCardMatches().size())
                winner = currentPlayer;
        }
        System.out.println("the winner of the game is player " + (winner + 1) + ": " + playerList.get(winner).getName());
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