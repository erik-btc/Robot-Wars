package com.btcag.bootcamp;

import java.util.Scanner;

public class Spielrunde {
    private Spielfeld spielfeld;
    private Roboter spieler1;
    private Roboter spieler2;

    public Spielrunde() {

    }
    public void starteRunde(){
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
        Roboter[] player = setupPlayer(username1);
        spieler1 = player[0];
        spieler2 = player[1];
        spielfeld = new Spielfeld();
        spielfeld.setPlayers(spieler1, spieler2);

    }

    private Roboter[] setupPlayer(String username){
        Roboter[] players = new Roboter[2];
        players[0] = new Roboter(7, 9, username, "*");
        players[1] = new Roboter(7, 0, "enemy", "#");
        return players;
    }

    public void spieleHauptspiel(){
        int runde = 0;
        do{
            if (runde % 2 == 0){
                int damageDone = spieler1.doAction(spieler1.askAction(), spieler1.askDirection());
                spieler2.getDamage(damageDone);
            }
            else{
                int damageDone = spieler2.doAction(spieler2.askAction(), spieler2.askDirection());
                spieler1.getDamage(damageDone);
            }
            spielfeld.drawField();
            System.out.println(runde + " Runde");
            runde++;
        }while(!checkGameOver());
    }

    public boolean checkGameOver() {
        return spieler1.getHp() == 0 || spieler2.getHp() == 0;
    }
}
