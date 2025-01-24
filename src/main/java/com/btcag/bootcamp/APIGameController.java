package com.btcag.bootcamp;
import com.btcag.bootcamp.APIConnection.APIconnection;
import com.btcag.bootcamp.APIConnection.Bot;
import com.btcag.bootcamp.views.*;
import java.util.Scanner;

public class APIGameController {
    protected static String gameId = "";
    protected static String robotId = "";
    protected static String playerId = "";
    protected static String mapIndex = "";
    public static Bot bot = new Bot("", 1,1,1,1);
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        bot.setName(AskForRobotNameView.display());
        BotSkillpointsView.allocationOfSkillPoints(bot);
        BotSkillpointsView.showPlayerStats(bot);
        robotId = APIconnection.createBot(bot);
        do {
            ShowOptionsView.display();
            System.out.println("Input: ");
            userInput = scanner.nextInt();
            if (userInput == 1) {
                CreatingTheGameView.display();
                gameId = APIconnection.createGame();
                CreatedTheGameView.display();
                APIconnection.joinGame(gameId);
                JoinedTheGameView.display();
                runningGame(bot);
            }
            else if (userInput == 2) {
                System.out.println("Enter gameId: ");
                gameId = scanner.nextLine();
                JoiningTheGameView.display();
                APIconnection.joinGame(gameId);
                JoinedTheGameView.display();
                runningGame(bot);
            }
            else if (userInput == 0){
                ExitingTheProgramView.display();
            }
            else {
                InvalidInputView.display();
            }
        }while(userInput != 0);
    }

    private static void runningGame(Bot bot) throws Exception {
        Bot winner = null;
        do{

        }while(winner == null);
    }
}
