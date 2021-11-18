package org.example;

import java.util.List;

public class Player {
   private String playerName;
    private List<Card> playerCards;

    public Player(String playerName, List<Card> playerCards) {
        this.playerName = playerName;
        this.playerCards = playerCards;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    //method to sum player cards
    public int sumPlayerCards(){
        return playerCards.stream().mapToInt(x -> x.getValue()).sum();
    }

    //method to check the strategy
    public String checkStrategy() {
        String strategyValue = "";
        if (sumPlayerCards() < 17 ) {
            strategyValue = "hit";
        } else if (sumPlayerCards() >= 17) {
            strategyValue = "stick";
        } else if (sumPlayerCards() > 21) {
            strategyValue = "go burst";
        }
        return strategyValue;
    }

    //method to check for black jack or return check strategy
    public String checkBlackJack(){
        if(sumPlayerCards() == 21){
            return  "black jack";
        }
        else {
            return checkStrategy();
        }
    }

    @Override
    public String toString() {
        return "Player Score = " + sumPlayerCards() + '\'' +
                ", Strategy =" + checkStrategy();
    }
}
