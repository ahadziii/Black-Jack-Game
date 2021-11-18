package org.example;

import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Player player1 = new Player("Player 1", List.of());
        Player player2 = new Player("Player 2", List.of());
        Player player3 = new Player("Player 3", List.of());

        Player testPlayer= new Player("PlayerTest", List.of(new Card(Suit.Heart,Rank.ACE), new Card(Suit.Club, Rank.EIGHT)));
        System.out.println("Score = " + testPlayer.sumPlayerCards() + ", Strategy = " + testPlayer.checkStrategy());
        System.out.println(testPlayer);
//        player = new Player("Player 1",cardList);

        //create a deck
        /**
        Deck deck = Deck.generateCardList();

        System.out.println(deck);

        deck.shuffleCards();

        System.out.println(deck);

        System.out.println(deck.deal());

        System.out.println(deck);
        **/

    }
}
