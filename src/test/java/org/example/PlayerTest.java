package org.example;

import junit.framework.TestCase;

import java.util.List;

public class PlayerTest extends TestCase {

    Player player;
    List<Card> cardList;

    public void setUp() throws Exception {
        super.setUp();
        cardList= List.of(new Card(Suit.Heart,Rank.ACE), new Card(Suit.Club, Rank.KING));
        player = new Player("Player 1",cardList);
    }

    public void testSumPlayerCards() {

        assertEquals(19, player.sumPlayerCards());
    }

    public void testCheckStrategy(){
        assertEquals("stick", player.checkStrategy());
    }

    public void testCheckBlackJack(){
        assertEquals("black jack", player.checkBlackJack());
    }
}