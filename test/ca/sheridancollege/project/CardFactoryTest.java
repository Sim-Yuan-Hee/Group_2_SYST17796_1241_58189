/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author NathanSim
 */
public class CardFactoryTest {
    
    public CardFactoryTest() {
    }

    /**
     * Test of getCard method, of class CardFactory.
     */
    @Test
    public void testGetCard() {
        System.out.println("getCard");
        String cardName = "";
        CardFactory instance = new CardFactory();
        Card expResult = null;
        Card result = instance.getCard(cardName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
