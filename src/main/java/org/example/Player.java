package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private List<Card> playerCards;
    private String strategy;
    private int score;
    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Player(String playerName, String strategy) {
        this.playerName = playerName;
        this.strategy = strategy;
        this.playerCards = new ArrayList<>();
        this.status = Status.DEFAULT;
    }



    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }



    //method to sum player cards
    public int sumPlayerCards(){
        return this.playerCards.stream().mapToInt(x -> x.getValue()).sum();
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerCards=" + playerCards +
                ", strategy='" + strategy + '\'' +
                ", score='" + sumPlayerCards() + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }

    //method to check the strategy
    public void getAction() {
        if (sumPlayerCards() < 17 ) {
            setStatus(Status.HIT);

        } else if (sumPlayerCards() >= 17 && sumPlayerCards() < 21) {
            setStatus(Status.STICK);

        } else if(sumPlayerCards() == 21){
            setStatus(Status.BLACKJACK);

        } else if(sumPlayerCards() > 21)  {
            setStatus(Status.BUST);

        }
    }



    //hhit method to distribute a card to a player
    public void hit(Card card){
        this.playerCards.add(card);
    }


}
