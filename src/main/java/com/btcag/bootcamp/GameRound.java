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

    public void allocationOfSkillPoints(Robot player){
        Scanner scanner = new Scanner(System.in);
        int skillPoints = 10;
        while (skillPoints != 0){
            System.out.println("In welche Stats willst du skillen ?\n" +
                    "[1] HP: " + player.getHp() + "\n" +
                    "[2] Damage: " + player.getterForDamage() + "\n" +
                    "[3] Range: " + player.getRange() + "\n" +
                    "[4] Movement Points: " + player.getMovementPoints() + "\n" +
                    "Verbleibende zu vergebene Skill Points: " + skillPoints);
            int userInput = scanner.nextInt();
            if(userInput == 1){
                player.setHp(player.getHp() + 1);
            }
            else if(userInput == 2){
                player.setDamage(player.getterForDamage() + 1);
            }
            else if(userInput == 3){
                player.setRange(player.getRange() + 1);
            }
            else if(userInput == 4){
                player.setMovementPoints(player.getMovementPoints() + 1);
            }
            skillPoints--;
        }
    }

    private Robot[] setupPlayer(String username){
        Scanner scanner = new Scanner(System.in);
        Robot[] players = new Robot[2];
        players[0] = new Robot(7, 9, 1, 1, 1, 1, username, "*", false);
        players[1] = new Robot(7, 0, 1, 1, 1, 1, "enemy", "#", false);

        System.out.println("Vergabe von Skill Points für Spieler 1: ");
        allocationOfSkillPoints(players[0]);
        System.out.println("Vergabe von Skill Points für Spieler 2: ");
        allocationOfSkillPoints(players[1]);
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
                    if (player2.getHp() < 1){
                        i = player1.getMovementPoints();
                    }
                }
            }
            else{
                while (i != player2.getMovementPoints()){
                    System.out.println("\n\nSpieler 2 ist dran");
                    int damageDone = player2.doAction(player2.askAction(), player2.askDirection());
                    player1.getDamage(damageDone);
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

    public boolean checkKnockedOut() {
        if (player1.getHp() < 1) {
            player1.setKnockedOut(true);
            System.out.println("Spieler 1 ist tot");
            return true;
        }
        else if (player2.getHp() < 1) {
            player2.setKnockedOut(true);
            System.out.println("Spieler 2 ist tot");
            return true;
        }
        else {
            return false;
        }
    }
}
