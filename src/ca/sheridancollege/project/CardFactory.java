/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.Random;

/**
 *
 * @author NathanSim
 */
public class CardFactory{
    
    public Card getCard(String cardName) 
    {
        Card card = null;
        
        if (cardName.equals("Poker"))
        {
            String suits [] = {"Hearts", "Diamonds", "Spades", "Clubs"};
            
            Random random = new Random();
            int rank = random.nextInt(13)+1;
            String suit = suits[random.nextInt(4)];
            
            switch (rank) {
                case 10:
                    card = new Poker(rank, "Jack" + " of " + suit);
                    break;
                case 11:
                    card = new Poker(rank, "Queen" + " of " + suit);
                    break;
                case 12:
                    card = new Poker(rank, "Ace" + " of " + suit);
                    break;
                case 13:
                    card = new Poker(rank, "Queen" + " of " + suit);
                    break;
                default:
                    card = new Poker(rank, rank + " of " + suit);
                    break;
            }       
        } 
        return card;
    }   
}
