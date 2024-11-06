package com.btcag.bootcamp;

import java.util.Scanner;

public class GameRound {
    private Gamefield battlefield;
    private Robot player1;
    private Robot player2;

    public GameRound() {

    }
    public void startRound(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen bei \n" +
                "  _____       _           _       __          __            \n" +
                " |  __ \\     | |         | |      \\ \\        / /            \n" +
                " | |__) |___ | |__   ___ | |_ _____\\ \\  /\\  / /_ _ _ __ ___ \n" +
                " |  _  // _ \\| '_ \\ / _ \\| __|______\\ \\/  \\/ / _` | '__/ __|\n" +
                " | | \\ \\ (_) | |_) | (_) | |_        \\  /\\  / (_| | |  \\__ \\\n" +
                " |_|  \\_\\___/|_.__/ \\___/ \\__|        \\/  \\/ \\__,_|_|  |___/\n" +
                "                                                            \n" +
                "                                                            ");
        String username1;
        System.out.println("Bitte geben Sie ihren Username ein: ");
        username1 = scanner.nextLine();
        Robot[] player = setupPlayer(username1);
        player1 = player[0];
        player2 = player[1];
        battlefield = new Gamefield();
        battlefield.setPlayers(player1, player2);

    }

    private Robot[] setupPlayer(String username){
        Scanner scanner = new Scanner(System.in);
        Robot[] players = new Robot[2];
        int hp = 1;
        int damage = 1;
        int range = 1;
        int movementPoints = 1;
        int skillPoints = 3;
        while (skillPoints != 0){
            System.out.println("In welche Stats willst du skillen ?\n" +
                    "[1] HP: " + hp + "\n" +
                    "[2] Damage: " + damage + "\n" +
                    "[3] Range: " + range + "\n" +
                    "[4] Movement Points: " + movementPoints);
            int userInput = scanner.nextInt();
            if(userInput == 1){
                hp++;
            }
            else if(userInput == 2){
                damage++;
            }
            else if(userInput == 3){
                range++;
            }
            else if(userInput == 4){
                movementPoints++;
            }
            skillPoints--;
        }


        players[0] = new Robot(7, 9, hp, damage, range, movementPoints, username, "*");
        players[1] = new Robot(7, 0, 1, 1, 1, 1, "enemy", "#");
        return players;
    }

    public void playGame(){
        int round = 1;
        battlefield.drawField();
        do{
            int i = 0;
            if (round % 2 == 1){
                while (i != player1.getMovementPoints()){
                    System.out.println("\n\nSpieler 1 ist dran");
                    int damageDone = player1.doAction(player1.askAction(), player1.askDirection());
                    player2.getDamage(damageDone);
                    i++;
                    battlefield.drawField();
                }
            }
            else{
                while (i != player2.getMovementPoints()){
                    System.out.println("\n\nSpieler 2 ist dran");
                    int damageDone = player2.doAction(player2.askAction(), player2.askDirection());
                    player1.getDamage(damageDone);
                    i++;
                    battlefield.drawField();
                }
            }
            System.out.println(round + " Runde");
            round++;
        }while(!checkGameOver());
    }

    public boolean checkGameOver() {
        return player1.getHp() < 1 || player2.getHp() < 1;
    }
}
