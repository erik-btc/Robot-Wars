package com.btcag.bootcamp;
import com.btcag.bootcamp.APIConnection.APIconnection;
import com.btcag.bootcamp.APIConnection.Bot;
import com.btcag.bootcamp.models.Battlefield;
import com.btcag.bootcamp.services.BotService;
import com.btcag.bootcamp.services.RobotService;
import com.btcag.bootcamp.views.*;

import java.util.Objects;
import java.util.Scanner;

public class APIGameController {
    protected static String gameId = "";
    protected static String robot1Id = "";
    protected static String robot2Id = "";
    protected static String player1Id = "";
    protected static String player2Id = "";
    protected static String mapIndex = "";
    public static Bot bot1 = new Bot("", 1,1,1,1);
    public static Bot bot2 = new Bot("",1,1,1,1);
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        bot1.setName(AskForRobotNameView.display());
        BotSkillpointsView.allocationOfSkillPoints(bot1);
        BotSkillpointsView.showPlayerStats(bot1);
        robot1Id = APIconnection.createBot(bot1);
        do {
            ShowOptionsView.display();
            System.out.println("Input: ");
            userInput = scanner.nextInt();
            scanner.nextLine();
            if (userInput == 1) {
                CreatingTheGameView.display();
                gameId = APIconnection.createGame();
                CreatedTheGameView.display();
                JoiningTheGameView.display();
                player1Id = APIconnection.joinGame(gameId);
                JoinedTheGameView.display();
                runningGame();
            }
            else if (userInput == 2) {
                EnterGameIdView.display();
                gameId = scanner.nextLine();
                JoiningTheGameView.display();
                APIconnection.joinGame(gameId);
                JoinedTheGameView.display();
                runningGame();
            }
            else if (userInput == 0){
                ExitingTheProgramView.display();
            }
            else {
                InvalidInputView.display();
            }
        }while(userInput != 0);
    }

    private static void runningGame() throws Exception {
        Bot winner = null;
        int turn = 0;
        boolean playersTurn = true; //true for player1 and false for player2
        //checking every 5 seconds if another player joined the game
        do{
            Thread.sleep(5000);
            System.out.println("Waiting for player 2 to join...");
        }while(Objects.equals(APIconnection.getGameStatus(gameId), "INITIAL"));

        //getting all the necessary information before the game can start
        if(Objects.equals(APIconnection.getGameStatus(gameId), "STARTED")) {
            player2Id = APIconnection.getPlayer2Id(gameId, player1Id);
            robot2Id = APIconnection.getRobot2Id(gameId, player2Id);
            int[] statsPlayer2 = APIconnection.statsFromPlayer2(robot2Id);
            bot2.setHealth(statsPlayer2[0]);
            bot2.setAttackDamage(statsPlayer2[1]);
            bot2.setAttackDamage(statsPlayer2[2]);
            bot2.setMovementRate(statsPlayer2[3]);
            System.out.println(bot2);
        }
        else{
            throw new RuntimeException();
        }

        Battlefield battlefield = new Battlefield(5,9);

        //main game
        do{
            boolean alreadyAttacked = false;
            if(playersTurn){
                int i = 0;
                while(i != bot1.getMovementRate()){
                    battlefield.initializeMap();
                    PlayersTurnView.display(bot1);
                    int action = AskActionView.display();
                    if(action == 1){
                        //move
                    }
                    else if(action == 2){
                        //attack
                    }
                    else if(action == 3){
                        //align
                    }
                    else if (action == 4){
                        //end turn
                    }
                    else if(action == 5){
                        InvalidInputView.display();
                    }
                }
            }
            else{
                int i = 0;
                while(i != bot2.getMovementRate()){
                    battlefield.initializeMap();
                    PlayersTurnView.display(bot2);

                }
            }
            turn++;
            System.out.println("Turn: " + turn);
            if(playersTurn != BotService.decidingWhoStarts(bot1, bot2)){
                playersTurn = BotService.decidingWhoStarts(bot1, bot2);
            }
            else {
                playersTurn = !playersTurn;
            }
        }while(winner == null);
        WinnerView.display(winner);
    }
}
