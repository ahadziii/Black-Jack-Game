package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    // define defaults in constructor
    //
    private List<Player> playerList;
    private int numberOfPlayers;
    private Deck deck;

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        playerList = new ArrayList<>();
        deck= Deck.generateCardList();
        createPlayers();
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }


    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    //create players
    public List<Player> createPlayers(){

        for (int x = 0; x < numberOfPlayers; x++) {
            playerList.add(new Player("player"+ x, ""));
        }
        System.out.println(numberOfPlayers + " number of players created");
        System.out.println(playerList);
        return playerList;
    }


    //initial method to deal Cards
    public void dealCards(){

        for (Player player : playerList) {
            player.hit(deck.deal());
            player.hit(deck.deal());
            player.getAction();
        }

        System.out.println(playerList);
        System.out.println(deck.checkDeckSize() + " cards left");

    }

    //TODO

    //calculate each player points and find the strategy
   /* public void checkPlayersStrategy(){


        for (Player player : playerList) {
            String playerAction = player.getAction();

            if (Objects.equals(playerAction, "hit")){
                Card card = deck.deal();


                player.hit(card);
                checkPlayersStrategy();

            } else if(Objects.equals(playerAction, "stick")){
                player.setStatus(Status.STICK);
            } else if(Objects.equals(playerAction, "black jack")){
                player.setStatus(Status.BLACKJACK);
            }
            else if(Objects.equals(playerAction, "bust")){
                player.setStatus(Status.BUST);
            }


        }

    }*/

    //check for winner
    //public void
    public boolean isGameOn(){
        for (Player player : playerList) {
            if (playerList.stream().allMatch(p1 -> p1.getStatus() == Status.STICK)) {
                // loop through each player and get their score
                // return player with highest score
                System.out.println("All players have a stick");
                if (getHighestScore() == player.sumPlayerCards()){
                    System.out.println("Player: " + player.getPlayerName() + " has WON!!");
                }

                return false;


            } else if (playerList.stream().anyMatch(p -> p.getStatus() == Status.BLACKJACK)) {
                System.out.println("Player: " + player.getPlayerName() + " has WON!!");
                return false;// return that particular player

            } else if (playerList.stream().anyMatch(p -> p.getStatus() == Status.HIT)) {


                // check if all others have a Bust Status
                if(playerList.stream().filter(p1-> p1.getStatus()== Status.BUST).count() == playerList.size()-1){
                    return false;
                }else {


                    return true;
                }


            }else {
                return true;
            }

        }
        // TODO
        return true;

    }

    public boolean isBusted(int score) {
        return score > 21;
    }

    public boolean isBlackJack(int score) {
        return score == 21;
    }

    public void startGame(){
        deck.shuffleCards();
        dealCards();

        for (Player player : playerList) {
            if (isBusted(player.sumPlayerCards())) {
                player.setStatus(Status.BUST);
            } else if (isBlackJack(player.sumPlayerCards())) {
                player.setStatus(Status.BLACKJACK);
                // end game because player has black jack
            } else {
                player.setStatus(Status.HIT);
            }
        }

        boolean isGameOn = true;

        if(isGameOn() == false){

        }else{
            while(isGameOn){

                //check to see if any player has a hit
                //and give them a card

                for (Player player : playerList) {
                    //List<Player> playersWithHit = playerList.stream().filter(p1 -> p1.getStatus() == Status.HIT).collect(Collectors.toList());
                    if(player.getStatus() == Status.HIT){
                        Card card = deck.deal();
                        player.hit(card);
                    }

                }







                isGameOn();

                //go for each player
                //get their actions
            }

        }



        // go for each player, check their strategy

    }

    //get highest score

    public int getHighestScore(){
        return playerList.stream().mapToInt(Player::sumPlayerCards).max().getAsInt();
    }









    //startGame - initialise the deck
    //shuffle the cards
    //distribute the cards to players
    //check black jack
    //check the strategy
    //decide what to do after the strategy
    //check black jack

}
