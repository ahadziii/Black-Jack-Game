package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {


        Scanner myObj = new Scanner(System.in);

        System.out.println("Enter the number of players playing");
        int numberOfPlayers = myObj.nextInt();
        Game blackJack = new Game(numberOfPlayers);


        //start the game
        blackJack.startGame();

        //check for black jack
        blackJack.checkForBlackJack();



       //continue running the game
        while (!blackJack.isGameEnded()){
            blackJack.getPlayerList().forEach(Player::getAction);
            System.out.println(blackJack.getPlayerList());
            System.out.println();

            blackJack.anotherRound();

        }

//all players in the game have the same value



    }
}
