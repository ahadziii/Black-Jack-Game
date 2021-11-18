package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cardList = new ArrayList<>();

    private Deck(List<Card> cardList) {
        this.cardList = cardList;
    }

    public static Deck generateCardList(){
        List<Card> cardList = new ArrayList<>();
        for (Suit suitValue : Suit.values()){
            for (Rank rankValue: Rank.values()){
                cardList.add(new Card(suitValue,rankValue));
            }
        }
        return new Deck(cardList);

    }

    public void shuffleCards() {
        Collections.shuffle(cardList);
    }


    public Card deal() {
        return cardList.remove(0);
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardList=" + cardList +
                '}';
    }


}
