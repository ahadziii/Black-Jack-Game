package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cardList = new ArrayList<>();

    public List<Card> getCardList() {
        return cardList;
    }


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

    //check deck size
    public int checkDeckSize(){
        return getCardList().size();
    }


    public Card deal() {
        Card card = cardList.get(cardList.size()-1);
        cardList.remove(cardList.size()-1);
        return card;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardList=" + cardList +
                '}';
    }


}
