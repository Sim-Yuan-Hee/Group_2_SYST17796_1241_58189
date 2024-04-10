package ca.sheridancollege.project;

/*
 * @author annu annu
 * @author Sim Yuan Hee
 * 10 April, 2024
 */

public class PlayingCard extends Card {

    public PlayingCard(int rank, String description) {
        super(rank, description);
    }

    @Override
    public String toString() {
        return getDescription(); // Override toString method if needed
    }
}
