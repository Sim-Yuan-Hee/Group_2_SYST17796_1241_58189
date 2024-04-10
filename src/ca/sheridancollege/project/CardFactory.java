/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author NathanSim
 */
public class CardFactory{
    
    public ArrayList<Card> get52Cards(String cardName) 
    {
        Card card = null;
        ArrayList<Card> cards_52 = new ArrayList<Card>();
        
        if (cardName.equals("Poker"))
        {
            String suits [] = {"Hearts", "Diamonds", "Spades", "Clubs"};
            
            for (String suit : suits) {
                for (int rank = 0; rank <=13; rank++)
                {
                    card = new Poker(rank, suit + " of " + suit);
                }
            }    
        } 
        
        for (Card c : cards_52)
            System.out.println(c);
        
        return cards_52;
    }   
    
//    public Card getCard(String cardName) 
//    {
//        Card card = null;
//        ArrayList<Card> cards_52 = new ArrayList<Card>();
//        
//        if (cardName.equals("Poker"))
//        {
//            String suits [] = {"Hearts", "Diamonds", "Spades", "Clubs"};
//            
//            for (String suit : suits) {
//                for (int rank = 0; rank <=13; rank++)
//                {
//                    card = new Poker(rank, suit + " of " + suit);
//                }
//            }
//            
//            Random random = new Random();
//            int rank = random.nextInt(13)+1;
//            String suit = suits[random.nextInt(4)];
//            
//            switch (rank) {
//                case 10:
//                    card = new Poker(rank, "Jack" + " of " + suit);
//                    break;
//                case 11:
//                    card = new Poker(rank, "Queen" + " of " + suit);
//                    break;
//                case 12:
//                    card = new Poker(rank, "Ace" + " of " + suit);
//                    break;
//                case 13:
//                    card = new Poker(rank, "Queen" + " of " + suit);
//                    break;
//                default:
//                    card = new Poker(rank, rank + " of " + suit);
//                    break;
//            }       
//        } 
//        return cards_52;
//    }   
}
