package org.example;

import junit.framework.TestCase;

import java.util.List;

public class DeckTest extends TestCase {
    private List<Card> expectedDeck;

    public void setUp() throws Exception {
        super.setUp();

        expectedDeck = List.of(
                new Card(Suit.Heart, Rank.TWO),
                new Card(Suit.Heart, Rank.THREE),
                new Card(Suit.Heart, Rank.FOUR),
                new Card(Suit.Heart, Rank.FIVE),
                new Card(Suit.Heart, Rank.SIX),
                new Card(Suit.Heart, Rank.SEVEN),
                new Card(Suit.Heart, Rank.EIGHT),
                new Card(Suit.Heart, Rank.NINE),
                new Card(Suit.Heart, Rank.TEN),
                new Card(Suit.Heart, Rank.JACK),
                new Card(Suit.Heart, Rank.QUEEN),
                new Card(Suit.Heart, Rank.KING),
                new Card(Suit.Heart, Rank.ACE),
                new Card(Suit.Club, Rank.TWO),
                new Card(Suit.Club, Rank.THREE),
                new Card(Suit.Club, Rank.FOUR),
                new Card(Suit.Club, Rank.FIVE),
                new Card(Suit.Club, Rank.SIX),
                new Card(Suit.Club, Rank.SEVEN),
                new Card(Suit.Club, Rank.EIGHT),
                new Card(Suit.Club, Rank.NINE),
                new Card(Suit.Club, Rank.TEN),
                new Card(Suit.Club, Rank.JACK),
                new Card(Suit.Club, Rank.QUEEN),
                new Card(Suit.Club, Rank.KING),
                new Card(Suit.Club, Rank.ACE),
                new Card(Suit.Diamond, Rank.TWO),
                new Card(Suit.Diamond, Rank.THREE),
                new Card(Suit.Diamond, Rank.FOUR),
                new Card(Suit.Diamond, Rank.FIVE),
                new Card(Suit.Diamond, Rank.SIX),
                new Card(Suit.Diamond, Rank.SEVEN),
                new Card(Suit.Diamond, Rank.EIGHT),
                new Card(Suit.Diamond, Rank.NINE),
                new Card(Suit.Diamond, Rank.TEN),
                new Card(Suit.Diamond, Rank.JACK),
                new Card(Suit.Diamond, Rank.QUEEN),
                new Card(Suit.Diamond, Rank.KING),
                new Card(Suit.Diamond, Rank.ACE),
                new Card(Suit.Spade, Rank.TWO),
                new Card(Suit.Spade, Rank.THREE),
                new Card(Suit.Spade, Rank.FOUR),
                new Card(Suit.Spade, Rank.FIVE),
                new Card(Suit.Spade, Rank.SIX),
                new Card(Suit.Spade, Rank.SEVEN),
                new Card(Suit.Spade, Rank.EIGHT),
                new Card(Suit.Spade, Rank.NINE),
                new Card(Suit.Spade, Rank.TEN),
                new Card(Suit.Spade, Rank.JACK),
                new Card(Suit.Spade, Rank.QUEEN),
                new Card(Suit.Spade, Rank.KING),
                new Card(Suit.Spade, Rank.ACE)
        );

    }



    public void testGenerateCardList() {
        assertEquals(Deck.generateCardList(), expectedDeck);
    }
}