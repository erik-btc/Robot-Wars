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
        Robot[] players = new Robot[2];
        players[0] = new Robot(7, 9, username, "*");
        players[1] = new Robot(7, 0, "enemy", "#");
        return players;
    }

    public void playGame(){
        int round = 0;
        do{
            if (round % 2 == 0){
                int damageDone = player1.doAction(player1.askAction(), player1.askDirection());
                player2.getDamage(damageDone);
            }
            else{
                int damageDone = player2.doAction(player2.askAction(), player2.askDirection());
                player1.getDamage(damageDone);
            }
            battlefield.drawField();
            System.out.println(round + " Runde");
            round++;
        }while(!checkGameOver());
    }

    public boolean checkGameOver() {
        return player1.getHp() == 0 || player2.getHp() == 0;
    }
}
