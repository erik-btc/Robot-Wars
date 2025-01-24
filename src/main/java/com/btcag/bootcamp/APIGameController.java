package com.btcag.bootcamp;

import com.btcag.bootcamp.APIConnection.APIconnection;
import com.btcag.bootcamp.APIConnection.Bot;

import java.util.Scanner;

public class APIGameController {
    protected static String gameId = "";
    protected static String robotId = "";
    protected static String playerId = "";
    protected static String mapIndex = "";
    public static Bot bot = new Bot("", 1,1,1,1);
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        robotId = APIconnection.createBot(bot);
        System.out.println("""
                1. Create a Game and join it
                2. Join a Game
                """);
        int userInput = scanner.nextInt();
        if(userInput == 1) {
            gameId = APIconnection.createGame();
        }
        else if(userInput == 2) {
            playerId = APIconnection.joinGame();
        }
        else {
            System.out.println("Invalid user input");
        }
    }
}
