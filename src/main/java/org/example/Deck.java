package org.example;


import java.util.ArrayList;
import java.util.List;

public class Deck {

    private List<Card> cardList;

    public Deck(List<Card> cardList) {
        this.cardList = cardList;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public static List<Card> generateCardList(){
        List<Card> cardList = new ArrayList<>();

        for (Suit suitValue : Suit.values()){
            for (Rank rankValue: Rank.values()){
                cardList.add(new Card(suitValue,rankValue));
            }
        }
        return cardList;

    }
}
