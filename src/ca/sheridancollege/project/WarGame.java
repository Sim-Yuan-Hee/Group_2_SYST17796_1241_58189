/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Scanner;

/**
 *
 * @author NathanSim
 */

//I am not sure why we are given abstract classes to start with...
//Oh, some revision: https://www.youtube.com/watch?v=pt1S11yX-7k
public class WarGame extends Game
{
    
    public WarGame(String name) {
        super(name);
    }

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
        
        System.out.println("Please enter your name: ");
        Scanner keyboard = new Scanner(System.in);
        String playerName = keyboard.nextLine();
        
        
    }
}