package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {

    private List<Player> playerList;
    private int numberOfPlayers;
    private Deck deck;
    private boolean isGameEnded ;

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        playerList = new ArrayList<>();
        deck= Deck.generateCardList();
        createPlayers();
        isGameEnded = false;
    }

    public boolean isGameEnded() {
        return isGameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        isGameEnded = gameEnded;
    }

    //create players
    public void createPlayers() {

        for (int x = 0; x < numberOfPlayers; x++) {
            playerList.add(new Player("player"+ x, ""));
        }
        System.out.println("Creating your players. Kindly Hold on");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(numberOfPlayers + " players created");
        System.out.println();
        System.out.println(playerList);

    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    //initial method to deal Cards
    public void dealCards() {
        System.out.println("Dealing Cards to your players");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Player player : playerList) {
            player.hit(deck.deal());
            player.hit(deck.deal());
            player.getAction();
        }
        //printing the players after dealing the card
    }

    public void startGame(){

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       shuffleCards();
        System.out.println();


        dealCards();
        System.out.println();

    }



    //checks is busted player is busted or not
    //if not we check if he is a hit
    //if yes we hand him a new card
    //if not he is a stick and we do nothing

    public void isHitOrStick(Player player){

        if(isGameEnded()== false) {
            player.getAction();
            if (!isBusted(player.getScore())) {
                player.getAction();
                if (player.getAction() == Status.HIT) {
                    Card card = deck.deal();
                    player.hit(card);
                    System.out.println(player.getPlayerName() + " has been hit with another card");
                }
            }


        }

    }


    public boolean isBusted(int score) {
        return score > 21;
    }

    @Override
    public String toString() {
        return "Game{" +
                "playerList=" + playerList +
                '}';
    }

    public boolean isBlackJack(int score) {
        return score == 21;
    }

    //does another is there is no black jack in the initial
    public void anotherRound(){
        System.out.println("No player has a BlackJack");
        System.out.println("The Game continues!!!!!!");



        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //check if more than 1 person has a stick
        if (playerList.stream().filter(p1 -> p1.getStatus() == Status.STICK).count() > 1 && playerList.stream().filter(p1 -> p1.getStatus() == Status.HIT).count() == 0){

            System.out.println("More than one player has a Stick and the others are bust");
            System.out.println("Calculating the winner");
            List<Player> playersWithStick = playerList.stream().filter(p1 -> (p1.getStatus() == Status.STICK)).collect(Collectors.toList());

            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            getHighestScorer(playersWithStick);
            setGameEnded(true);
            endGame();
        }

        //check to see if all the players have have a bust
        if(playerList.stream().filter(p1-> p1.getStatus() == Status.BUST).count() == playerList.size()){
            System.out.println("All players are busted out of the game");
            System.out.println("There is no the winner");
            setGameEnded(true);
            endGame();
        }


        // check if all others have a Bust Status
        if(playerList.stream().filter(p1-> p1.getStatus() == Status.BUST).count() == numberOfPlayers - 1){
            Stream<Player> notBustPlayer = playerList.stream().filter(p1 -> p1.getStatus() != Status.BUST);
            System.out.println(notBustPlayer.map(player -> player.getPlayerName().toLowerCase()) + " has won the game");
            this.setGameEnded(true);
            endGame();
        }

        // check if the game is On(whether someone has a stick or a hit) or someone has a blackjack
        for (Player player : playerList) {
            isHitOrStick(player);
            player.setScore(player.getScore());
            player.getAction();

        }
        checkForBlackJack();



    }




    //get each players highest scorer
    public void getHighestScorer(List<Player> players){
        int highestScore = players.stream().mapToInt(Player::getScore).max().getAsInt();
        for (Player player : players) {
            if(player.getScore() == highestScore){
                System.out.println(player.getPlayerName() + " is the winner");
            }
        }
    }


    //shuffleCards
    public void shuffleCards(){
        System.out.println("Shuffling cards now");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deck.shuffleCards();
    }

    //end the game
    public void endGame(){
        setGameEnded(true);
        System.out.println("The game has ended");
    }


    public void checkForBlackJack(){



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (Player player : playerList) {
            if (isBusted(player.getScore())) {
                player.setStatus(Status.BUST);
            } else if (isBlackJack(player.getScore())) {
                player.setStatus(Status.BLACKJACK);
                System.out.println(playerList);
                System.out.println("Player: " + player.getPlayerName() + " has hit a BLACK JACK!!");
                System.out.println("Player: " + player.getPlayerName() + " has WON!!");
                setGameEnded(true);
                endGame();
            } else {
                player.setStatus(Status.HIT);
            }

        }

    }




    //startGame - initialise the deck
    //shuffle the cards
    //distribute the cards to players
    //check black jack
    //check the strategy
    //decide what to do after the strategy
    //check black jack

}
