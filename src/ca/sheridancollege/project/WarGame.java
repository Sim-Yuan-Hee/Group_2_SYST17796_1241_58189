package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;

/*
*
 * @author annu annu
 * @author Sim Yuan Hee
 * April 10, 2024
 */
public class WarGame extends Game {

    private static final String[] CARD_TYPES = {"Spades", "Hearts", "Clubs", "Diamonds"};
    int Extra_num1 = 0;
    int Extra_num2 = 0;

    private void playWarRound(ArrayList<Player> players) {      //this method is made to run when tie occurs between players 
        // Collect cards for War (face down) and played card (fourth card) (face up)
        List<Card> warCardsFaceDown = new ArrayList<>();
        List<Card> playedCards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            warCardsFaceDown.add(players.get(0).playCard()); // Player 1 plays 3 cards face down
            playedCards.add(players.get(1).playCard()); // Player 2 plays 3 cards face down
        }

        // Play the War round by revealing the top card from each player based on the value of the fourth card
        warCardsFaceDown.add(players.get(0).playCard()); // Player 1 plays 1 card face up
        playedCards.add(players.get(1).playCard()); // Player 2 plays 1 card face up

        System.out.println("Each player contributed three cards to the round");

        // Compare the revealed cards (playedCards.get(playedCards.size() - 1))
        Card fourthCardPlayer1 = warCardsFaceDown.get(3);
        Card fourthCardPlayer2 = playedCards.get(3);

        System.out.println("Fourth card for " + players.get(0).getName() + ": " + fourthCardPlayer1.getCardName());
        System.out.println("Fourth card for " + players.get(1).getName() + ": " + fourthCardPlayer2.getCardName());

        if (fourthCardPlayer1.getRank() > fourthCardPlayer2.getRank()) {
            // Player 1 wins the War
            Extra_num1 += 2;
            System.out.println(players.get(0).getName() + " wins the War!");
            for (Card card : warCardsFaceDown) {
                players.get(0).addCard(card); // Add each card from warCardsFaceDown
            }
            for (Card card : playedCards) {
                players.get(0).addCard(card); // Add each card from playedCards
            }

        } else if (fourthCardPlayer1.getRank() < fourthCardPlayer2.getRank()) {
            // Player 2 wins the War
            Extra_num2 += 2;
            System.out.println(players.get(1).getName() + " wins the War!");
            for (Card card : warCardsFaceDown) {
                players.get(1).addCard(card); // Add each card from warCardsFaceDown
            }
            for (Card card : playedCards) {
                players.get(1).addCard(card); // Add each card from playedCards
            }

        } else {
            System.out.println("It's a tie in War! Declaring another War...");
            // Recursive call to play another War scenario
            playWarRound(players);

        }
    }

    public WarGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("This is War Game.");
        // Initialize players
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            String playerName;
            boolean uniqueName = false;
            do {
                System.out.print("Enter player " + (i + 1) + " name: ");
                playerName = scanner.nextLine();
                if (!Player.isUniquePlayerName(playerName, players)) {
                    System.out.println("Username already exists. Please choose another username.");
                } else {
                    uniqueName = true;
                }
            } while (!uniqueName); // Check uniqueness
            players.add(new WarPlayer(playerName));
        }

        setPlayers(players); // Set the players
        // Initialize deck
        ArrayList<Card> deck = new ArrayList<>();
        for (String suit : CARD_TYPES) { // Loop through card suits
            for (int rank = 2; rank <= 14; rank++) {
                deck.add(new PlayingCard(rank, suit));
            }
        }
        Collections.shuffle(deck);

        // Distribute cards
        // Distribute half of the deck to each player
        for (int i = 0; i < deck.size() / 2; i++) {
            players.get(0).addCard(deck.get(i));
            players.get(1).addCard(deck.get(deck.size() / 2 + i));
        }

        System.out.println("Number of cards both players has = " + players.get(0).getCards().size());

        // Get the number of rounds to play
        System.out.print("Enter the number of rounds to play: ");
        int numRounds = scanner.nextInt();
        scanner.nextLine();

        // Play rounds
        System.out.println();
        System.out.println("Starting the game of War!");
        for (int round = 1; round <= numRounds; round++) {
            if (players.get(0).hasCards() && players.get(1).hasCards()) {
                // Play the round
                System.out.println();
                System.out.println("Round " + round + ":");

                // Get cards played by each player
                Card card1 = players.get(0).playCard();
                Card card2 = players.get(1).playCard();

                System.out.println(players.get(0).getName() + " plays: " + card1.getCardName());
                System.out.println(players.get(1).getName() + " plays: " + card2.getCardName());

                // Compare the ranks of the cards
                if (card1.getRank() > card2.getRank()) {
                    players.get(0).addCard(card1);
                    players.get(0).addCard(card2);
                    System.out.println("After doing comparison: ");
                    System.out.println(players.get(0).getName() + " wins the round!");
                    System.out.println();
                } else if (card1.getRank() < card2.getRank()) {
                    players.get(1).addCard(card1);
                    players.get(1).addCard(card2);
                    System.out.println("After doing comparison: ");
                    System.out.println(players.get(1).getName() + " wins the round!");
                    System.out.println();
                } else {
                    System.out.println("After doing comparison: ");
                    System.out.println("It's a tie! Declaring the War");
                    if (players.get(0).getCards().size() < 4 || players.get(1).getCards().size() < 4) {
                        System.out.println("One or both players don't have enough cards for War! Ending game.");
                        break; // Exit the game loop if not enough cards for War
                    } else {
                        playWarRound(players);

                    }
                }
            } else {
                System.out.println("One of the players ran out of cards!");
                break;
            }
        }

        // Declare the winner
        declareWinner();
    }

    @Override
    public void declareWinner() {
        System.out.println("Result of the game");
        Player player1 = getPlayers().get(0);
        Player player2 = getPlayers().get(1);

        int player1CardCount = player1.getCards().size() + Extra_num1;
        int player2CardCount = player2.getCards().size() + Extra_num2;

        System.out.println(player1.getName() + " has " + player1CardCount + " cards!");
        System.out.println(player2.getName() + " has " + player2CardCount + " cards!");
        System.out.println();
        if (player1CardCount > player2CardCount) {
            System.out.println(player1.getName() + " wins the game with " + player1CardCount + " cards!");
        } else if (player1CardCount < player2CardCount) {
            System.out.println(player2.getName() + " wins the game with " + player2CardCount + " cards!");
        } else {
            System.out.println("It's a tie!");

        }
    }

    public static void main(String[] args) {
        WarGame warGame = new WarGame("War");
        warGame.play();
    }
}
