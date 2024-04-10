package ca.sheridancollege.project;

import java.util.ArrayList;

/*
 * @author annu annu
 * @author Sim Yuan Hee
 * 10 April, 2024
 */
public class WarPlayer extends Player {

    private ArrayList<Card> hand; // Player's hand

    public WarPlayer(String name) {
        super(name);
        hand = new ArrayList<>();
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public Card playCard() {
        if (!getCards().isEmpty()) {
            return getCards().remove(0);
        } else {
            return null; // Return null if the deck is empty
        } // Remove and return the topmost card from hand
    }

    public boolean hasCardsInHand() {
        return !hand.isEmpty();
    }

    // Implement any additional methods or properties specific to the War game
}
