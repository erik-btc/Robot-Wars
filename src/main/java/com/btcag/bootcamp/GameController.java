package com.btcag.bootcamp;

import com.btcag.bootcamp.enums.Direction;
import com.btcag.bootcamp.models.Battlefield;
import com.btcag.bootcamp.models.Robot;
import com.btcag.bootcamp.services.RobotService;
import com.btcag.bootcamp.views.*;

import java.util.Scanner;

public class GameController {

    public static Battlefield battlefield = new Battlefield(15, 10);
    public static int newX;
    public static int newY;

    public static void movementOfPlayers(Robot player){
            BattlefieldView.display(battlefield);
            do {
                Direction direction = MoveRobotView.display();
                newX = player.getX() + direction.getX();
                newY = player.getY() + direction.getY();
            } while (!battlefield.isValidField(newX, newY));

            battlefield.setField(player.getX(), player.getY(), ' ');

            player.setPosition(newX, newY);
            battlefield.setField(player.getX(), player.getY(), player.getRobotSymbol());
    }

    public static boolean inRange(Robot player1, Robot player2){
        //Rechts und Oben
        if ((player1.getX() + player1.getRange() >= player2.getX() && player2.getX() >= player1.getX()) && (player1.getY() + player1.getRange() >= player2.getY() && player2.getY() >= player1.getY())
                //Rechts und Unten
                || (player1.getX() + player1.getRange() >= player2.getX() && player2.getX() >= player1.getX()) && (player1.getY() - player1.getRange() <= player2.getY() && player2.getY() <= player1.getY())
                //Links und Oben
                || (player1.getX() - player1.getRange() <= player2.getX() && player2.getX() <= player1.getX()) && (player1.getY() + player1.getRange() >= player2.getY() && player2.getY() >= player1.getY())
                //Links und Unten
                || (player1.getX() - player1.getRange() <= player2.getX() && player2.getX() <= player1.getX()) && (player1.getY() - player1.getRange() <= player2.getY() && player2.getY() <= player1.getY()))
        {
            return true;
        }
        else{
            return false;
        }
    }


    public static void main(String[] args) {
        IntroScreenView.display();

        String player1Username = AskForRobotNameView.display();
        char player1Symbol = AskForRobotSymbolView.display();
        Robot player1 = new Robot(player1Username, 1, 1, player1Symbol,1,1,1,1);
        SkillPointsView.allocationOfSkillPoints(player1);
        RobotView.display(player1);

        String player2Username = AskForRobotNameView.display();
        char player2Symbol = AskForRobotSymbolView.display();
        Robot player2 = new Robot(player2Username, 15, 10, player2Symbol,1,1,1,1);
        SkillPointsView.allocationOfSkillPoints(player2);
        RobotView.display(player2);

        battlefield.setField(player1.getX(), player1.getY(), player1.getRobotSymbol());
        battlefield.setField(player2.getX(), player2.getY(), player2.getRobotSymbol());

        Robot winner = null;
        boolean playersTurn = true; //true for player 1, false for player 2
        System.out.println(SkillPointsView.showPlayerStats(player1));
        System.out.println(SkillPointsView.showPlayerStats(player2));

        do {
            if (playersTurn){
                int i = 0;
                while (i != player1.getMovementPoints()){
                    BattlefieldView.display(battlefield);
                    System.out.println(player1.getName() + " ist dran!");
                    int action = AskActionView.display(player1);
                    if (action == 1){
                        movementOfPlayers(player1);
                    }
                    else if (action == 2){
                        if (inRange(player1, player2)){
                            player2.getDamage(player1.getterForDamage());
                            System.out.println("Spieler 2 HP: " + player2.getHp());
                            i = player1.getMovementPoints();
                            break;
                        }
                        else {
                            System.out.println("Spieler 2 nicht in Range");
                        }
                    }
                    i++;
                }
            }
            else{
                int i = 0;
                while (i != player2.getMovementPoints()){
                    BattlefieldView.display(battlefield);
                    System.out.println(player2.getName() + " ist dran!");
                    int action = AskActionView.display(player2);
                    if (action == 1){
                        movementOfPlayers(player2);
                    }
                    else if (action == 2){
                        if (inRange(player1, player2)){
                            player1.getDamage(player2.getterForDamage());
                            System.out.println("Spieler 1 HP: " + player1.getHp());
                            i = player2.getMovementPoints();
                            break;
                        }
                        else{
                            System.out.println("Spieler 1 nicht in Range");
                        }
                    }
                    i++;
                }
            }
            if (RobotService.checkHpPlayer1(player1)) {
                winner = player2;
            }
            if (RobotService.checkHpPlayer2(player2)) {
                winner = player1;
            }
            playersTurn = !playersTurn;
        } while (null == winner);
        WinnerView.display(winner);
    }
}


/*
    public void playGame(){
        int round = 1;
        System.out.println(showPlayerStats(player1));
        System.out.println(showPlayerStats(player2));
        battlefield.drawField();
        do{
            int i = 0;
            if (round % 2 == 1){
                while (i != player1.getMovementPoints()){
                    System.out.println("\n\nSpieler 1 ist dran");
                    int damageDone = player1.doAction(player1.askAction(), player1.askDirection());
                    if (inRange(player1, player2)){
                        player2.getDamage(damageDone);
                        System.out.println("Spieler 2 HP: " + player2.getHp());
                        i = player1.getMovementPoints();
                    }
                    else {
                        System.out.println("\nSpieler 2 ist nicht in Range\n");
                    }
                    i++;
                    battlefield.drawField();
                    if (player2.getHp() < 1){
                        i = player1.getMovementPoints();
                    }
                }
            }
            else{
                while (i != player2.getMovementPoints()){
                    System.out.println("\n\nSpieler 2 ist dran");
                    int damageDone = player2.doAction(player2.askAction(), player2.askDirection());
                    if (inRange(player2, player1)){
                        player1.getDamage(damageDone);
                        System.out.println("Spieler 1 HP: " + player1.getHp());
                        i = player2.getMovementPoints();
                    }
                    else{
                        System.out.println("\nSpieler 1 ist nicht in Range\n");
                    }
                    i++;
                    battlefield.drawField();
                    if (player1.getHp() < 1){
                        i = player2.getMovementPoints();
                    }
                }
            }
            System.out.println(round + " Runde");
            round++;
        }while(!checkKnockedOut());
    }
*/