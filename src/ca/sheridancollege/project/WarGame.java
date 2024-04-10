/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author Sim Yuan Hee
 */

//I am not sure why we are given abstract classes to start with...
//Oh, some revision: https://www.youtube.com/watch?v=pt1S11yX-7k
public class WarGame extends Game
{
    
    public WarGame(String name) {
        super(name);
    }

    private int score = 0;
    
    @Override
    public void play() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void declareWinner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Actual process of the game
    public static void main(String[] args)
    {
        WarGame warGame = new WarGame("War");
        
        System.out.println("This game is played with a deck of 52 cards. The deck is divided equally, one at a time, "
                + "face down and the players are not allowed to see the cards. Each player places their stack of cards face down, "
                + "in front of them. The game starts and each player turns up a card and the player with the higher card wins and collects all "
                + "the cards revealed during the round and puts them, face down, on the bottom of stack. If there is a tie, it is War, then each "
                + "player faces down three cards and face-up one card and the player having the higher card wins all the cards. This game continues "
                + "until a player has won all the 52 cards or a specified number of rounds are completed.");
        
        while (true)
        {
            System.out.println("Player 1, please enter your name: ");
            Scanner keyboard = new Scanner(System.in);
            String player1Name = keyboard.nextLine();

            System.out.println("Player 2, please enter your name: ");
            Scanner keyboard2 = new Scanner(System.in);
            String player2Name = keyboard2.nextLine();

            if (player1Name == null ? player2Name == null : player1Name.equals(player2Name))
            {
                System.out.println("Player names not unique, please try again");
            }
            else
            {
                System.out.println("Player names valid");
                Player_WarGame player1 = new Player_WarGame(player1Name);
                Player_WarGame player2 = new Player_WarGame(player2Name);  
                System.out.println("Player names valid, please continue");
                break;
            }
        }
        
        CardFactory cf = new CardFactory();
        
        Card testCard = cf.getCard("Poker");
       
//        System.out.println(testCard.getRank());
//        System.out.println(testCard.getDescription());
        
        GroupOfPokers gp1 = new GroupOfPokers(26);
        GroupOfPokers gp2 = new GroupOfPokers(26);
        
        //2 groups of cards...but need to make sure each unique card only repeat 4 times, because 13(jack, 10, 9...) x 4 = 52, achieve with cardfactory?
        //no cardfactory only creates 1 card, new class?
        
        System.out.println("Please enter the number of rounds you agreed on: ");
        Scanner kb_numOfRounds = new Scanner(System.in);
        int numOfRounds = kb_numOfRounds.nextInt();
        System.out.println("You have agreed to end the game after " + numOfRounds + " rounds.");
        
    }   
}