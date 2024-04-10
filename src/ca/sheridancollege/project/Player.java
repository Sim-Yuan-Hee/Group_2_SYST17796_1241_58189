package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier,
 * which should be unique.
 *
 * @author annu annu
 * @author Sim Yuan Hee March 5, 2024
 */
public abstract class Player {

    private String name;
    private ArrayList<Card> cards; // Player's deck

    public Player(String name) {
        this.name = name;
        cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card playCard() {
        return cards.remove(0); // Remove and return the topmost card
    }

    public boolean hasCards() {
        return !cards.isEmpty();
    }

    public static boolean isUniquePlayerName(String name, ArrayList<Player> players) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return false; // Name already exists
            }
        }
        return true; // Name is unique
    }

}
