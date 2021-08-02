/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goFishCards;

import java.util.ArrayList;

/**
 * @author Jake M
 */
public class GoFishPlayer extends Player {

    public GoFishPlayer(String name, int num) {
        super(name, num);
        this.cardsInHand = new ArrayList<>();
        this.setCardMatches(new ArrayList<>());
    }

    private ArrayList<StandardCard> cardsInHand;
    private ArrayList<StandardCard> cardMatches;

    private int score;
    public int correctGuesses;
    public int totalGuesses;

    public String toString() {
        String cardsInHandDisplay = " ";
        String matchesInHandDisplay = "\nBooks completed: ";
        for (int i = 0; i < cardsInHand.size(); i++) {
            if (i%2==0) {
                cardsInHandDisplay += "\n" + "(" + (cardsInHand.get(i).getValue().ordinal() + 1) + ") " + cardsInHand.get(i) + " ";
            }
            else
                cardsInHandDisplay += " " + "(" + (cardsInHand.get(i).getValue().ordinal() + 1) + ") " + cardsInHand.get(i) + ","+ " ";
        }

        if (!cardMatches.isEmpty()) {
            for (int i = 0; i < cardMatches.size(); i++) {
                if (i%2==0) {
                    matchesInHandDisplay += "\n " + "(" + (cardMatches.get(i).getValue().ordinal() + 1) + ") " + cardMatches.get(i) + ",";
                }
                else
                    matchesInHandDisplay += " " + "(" + (cardMatches.get(i).getValue().ordinal() + 1) + ") " + cardMatches.get(i) + ",";
            }
        } else if (cardMatches.isEmpty()) {
            matchesInHandDisplay = "\nNo books in hand";
        }
        return super.getName() + ": \n\n" + cardsInHandDisplay + "\n" + matchesInHandDisplay;
    }


    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        GoFishPlayer c = (GoFishPlayer) o;
        return (c.getName().equalsIgnoreCase(this.getName()) && c.getPlayerNumber() == this.getPlayerNumber());
    }

    /**
     * @return the cardsInHand
     */
    public ArrayList<StandardCard> getCardsInHand() {
        return cardsInHand;
    }

    /**
     * @param cardsInHand the cardsInHand to set
     */
    public void setCardsInHand(ArrayList<StandardCard> cardsInHand) {
        this.cardsInHand = cardsInHand;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<StandardCard> getCardMatches() {
        return cardMatches;
    }

    public void setCardMatches(ArrayList<StandardCard> cardMatches) {
        this.cardMatches = cardMatches;
    }
}
