package com.btcag.bootcamp;

import com.btcag.bootcamp.enums.Direction;
import com.btcag.bootcamp.models.Battlefield;
import com.btcag.bootcamp.models.Item;
import com.btcag.bootcamp.models.Obstacle;
import com.btcag.bootcamp.models.Robot;
import com.btcag.bootcamp.services.ItemService;
import com.btcag.bootcamp.services.RobotService;
import com.btcag.bootcamp.views.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameController {
    public static Random random = new Random();
    public static Battlefield battlefield = new Battlefield(15, 10);
    public static int newX;
    public static int newY;
    public static Obstacle[] obstacles = new Obstacle[15];
    public static Robot player1 = new Robot("", 1, 1, '*',1,1,1,1, "s");
    public static Robot player2 = new Robot("", 15, 10, '#',1,1,1,1, "n");


    public static void movementOfPlayers(Robot player){
            BattlefieldView.display(battlefield);
            do {
                Direction direction = MoveRobotView.display();
                newX = player.getX() + direction.getX();
                newY = player.getY() + direction.getY();
            } while (!battlefield.isValidField(newX, newY, obstacles));

            battlefield.setField(player.getX(), player.getY(), ' ');

            player.setPosition(newX, newY);

            battlefield.setField(player.getX(), player.getY(), player.getRobotSymbol());

    }

    public static void main(String[] args) {

        for(int i = 0; i < obstacles.length; i++){
            obstacles[i] = new Obstacle(random.nextInt(1, 16), random.nextInt(1, 11));
        }

        IntroScreenView.display();

        String player1Username = AskForRobotNameView.display();
        char player1Symbol = AskForRobotSymbolView.display();
        player1.setName(player1Username);
        player1.setRobotSymbol(player1Symbol);
        SkillPointsView.allocationOfSkillPoints(player1);
        RobotView.display(player1);

        String player2Username = AskForRobotNameView.display();
        char player2Symbol = AskForRobotSymbolView.display();
        player2.setName(player2Username);
        player2.setRobotSymbol(player2Symbol);

        SkillPointsView.allocationOfSkillPoints(player2);
        RobotView.display(player2);

        battlefield.setField(player1.getX(), player1.getY(), player1.getRobotSymbol());
        battlefield.setField(player2.getX(), player2.getY(), player2.getRobotSymbol());

        Robot winner = null;
        boolean playersTurn = RobotService.decidingWhoStarts(player1, player2); //true for player 1, false for player 2

        System.out.println(SkillPointsView.showPlayerStats(player1));
        System.out.println(SkillPointsView.showPlayerStats(player2));

        Item item1 = new Item(15, 5, random.nextInt(-2, 3), random.nextInt(1, 3), false);
        Item item2 = new Item(8, 5, random.nextInt(-2, 3), random.nextInt(1, 3), false);
        Item item3 = new Item(1, 5, random.nextInt(-2, 3), random.nextInt(1, 3), false);


        battlefield.setField(item1.getX(), item1.getY(), item1.getItemSymbol());
        battlefield.setField(item2.getX(), item2.getY(), item2.getItemSymbol());
        battlefield.setField(item3.getX(), item3.getY(), item3.getItemSymbol());


        for(Obstacle obstacle : obstacles){
            battlefield.setField(obstacle.getX(), obstacle.getY(), obstacle.getObstacleSymbol());
        }

        int turn = 0;
        do {
            boolean alreadyAttacked = false;
            if (playersTurn){
                int i = 0;
                while (i != player1.getMovementPoints()){
                    alignView.display(player1);
                    BattlefieldView.display(battlefield);
                    System.out.println(player1.getName() + " ist dran!");
                    int action = AskActionView.display();
                    if (action == 1){
                        movementOfPlayers(player1);
                        if(item1.checkCollision(player1, item1)){
                            ItemService.processingItemEffect(player1, item1);
                        }
                        else if(item2.checkCollision(player1, item2)){
                            ItemService.processingItemEffect(player1, item2);
                        }
                        else if(item3.checkCollision(player1, item3)){
                            ItemService.processingItemEffect(player1, item3);
                        }
                    }
                    else if (action == 2){
                        if(!alreadyAttacked){
                            if (RobotService.checkDiagonal(player1, player2) ||
                                    RobotService.checkHorizontalAlignment(player1, player2) ||
                                    RobotService.checkVerticalAlignment(player1, player2) &&
                                    RobotService.checkIfObstacleIsInWayVertically(player1, player2, obstacles) &&
                                    RobotService.checkIfObstacleIsInWayDiagonally(player1, player2, obstacles) &&
                                    RobotService.checkIfObstacleIsInWayHorizontally(player1, player2, obstacles) &&
                                    RobotService.inRange(player1, player2)){
                                player2.getDamage(player1.getterForDamage());
                                System.out.println("Spieler 2 HP: " + player2.getHp());
                                alreadyAttacked = true;
                                if (RobotService.checkHpPlayer2(player2)) {
                                    winner = player1;
                                    break;
                                }
                            }
                            else {
                                PlayerIsNotInRangeOrObstacleIsInTheWayView.display(player2);
                                i--;
                            }
                        }
                        else{
                            AlreadyAttackedThisRoundView.display();
                            i--;
                        }
                    }
                    else if(action == 3){
                        player1.setAlignment(AskAlignmentView.display());
                    }
                    else if(action == 4){
                        i = player1.getMovementPoints() - 1;
                    }
                    else{
                        InvalidInputView.display();
                        i--;
                    }
                    i++;
                }
            }
            else{
                int i = 0;
                while (i != player2.getMovementPoints()){
                    alignView.display(player2);
                    BattlefieldView.display(battlefield);
                    System.out.println(player2.getName() + " ist dran!");
                    int action = AskActionView.display();
                    if (action == 1){
                        movementOfPlayers(player2);
                        if(item1.checkCollision(player2, item1)){
                            ItemService.processingItemEffect(player2, item1);
                        }
                        else if(item2.checkCollision(player2, item2)){
                            ItemService.processingItemEffect(player2, item2);
                        }
                        else if(item3.checkCollision(player2, item3)){
                            ItemService.processingItemEffect(player2, item3);
                        }
                    }
                    else if (action == 2){
                        if(!alreadyAttacked){
                            if ((RobotService.checkDiagonal(player2, player1) ||
                                    RobotService.checkHorizontalAlignment(player2, player1) ||
                                    RobotService.checkVerticalAlignment(player2, player1)) &&
                                    RobotService.checkIfObstacleIsInWayVertically(player2, player1, obstacles) &&
                                    RobotService.checkIfObstacleIsInWayDiagonally(player2, player1, obstacles) &&
                                    RobotService.checkIfObstacleIsInWayHorizontally(player2, player1, obstacles) &&
                                    RobotService.inRange(player1, player2)){
                                player1.getDamage(player2.getterForDamage());
                                System.out.println("Spieler 1 HP: " + player1.getHp());
                                alreadyAttacked = true;
                                if (RobotService.checkHpPlayer1(player1)) {
                                    winner = player2;
                                    break;
                                }
                            }
                            else{
                                PlayerIsNotInRangeOrObstacleIsInTheWayView.display(player1);
                                i--;
                            }
                        }
                        else{
                            AlreadyAttackedThisRoundView.display();
                            i--;
                        }
                    }
                    else if(action == 3){
                        player2.setAlignment(AskAlignmentView.display());
                    }
                    else if(action == 4){
                        i = player2.getMovementPoints() - 1;
                    }
                    else{
                        InvalidInputView.display();
                    }
                    i++;
                }
            }
            turn++;
            System.out.println("Runde: " + turn);
            if(playersTurn != RobotService.decidingWhoStarts(player1, player2)){
                playersTurn = RobotService.decidingWhoStarts(player1, player2);
            }
            else {
                playersTurn = !playersTurn;
            }
        } while (null == winner);
        WinnerView.display(winner);
    }
}

