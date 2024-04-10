package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author annu
 * @author Sim Yuan Hee March 5, 2024
 */
public abstract class Card {

    private int rank;
    private String description;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Card(int rank, String description) {
        this.rank = rank;
        this.description = description;
    }

    public String getCardName() {
        String rankName;
        switch (rank) {
            case 11:
                rankName = "Jack";
                break;
            case 12:
                rankName = "Queen";
                break;
            case 13:
                rankName = "King";
                break;
            case 14:
                rankName = "Ace";
                break;
            default:
                rankName = String.valueOf(rank);
                break;
        }
        return rankName + " of " + description;
    }

    @Override
    public abstract String toString();

}
