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
    public static void main( String[] args )
    {


        Scanner myObj = new Scanner(System.in);

        System.out.println("enter number of players you want");
        int numberOfPlayers = myObj.nextInt();
        Game newGame = new Game(numberOfPlayers);


        //start the game
        newGame.startGame();




    }
}
