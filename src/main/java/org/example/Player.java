package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String playerName;
    private List<Card> playerCards;
    private String strategy;
    private int score;
    private Status status;




    public void setScore(int score) {
        this.score = score;
    }

    //method to sum player cards
    public int getScore(){
        int s = playerCards.stream().mapToInt(Card::getValue).sum();
        setScore(s);
        return s;
    }

    public Player(String playerName, String strategy) {
        this.playerName = playerName;
        this.strategy = strategy;
        this.playerCards = new ArrayList<>();
        this.status = Status.DEFAULT;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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





    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerCards=" + playerCards +
                ", strategy='" + strategy + '\'' +
                ", score='" + score + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }

    //method to check the strategy
    public Status getAction() {
        Status status = getStatus();
        if (getScore() < 17 ) {
            setStatus(Status.HIT);
            return status;

        } else if (getScore() >= 17 && getScore() < 21) {
            setStatus(Status.STICK);
            return status;

        } else if(getScore() == 21){
            setStatus(Status.BLACKJACK);
            return status;

        } else if(getScore() > 21)  {
            setStatus(Status.BUST);
            return status;
        }
        return status;
    }


    //hit method to hand a card to a player
    public void hit(Card card){
        playerCards.add(card);
    }


}
