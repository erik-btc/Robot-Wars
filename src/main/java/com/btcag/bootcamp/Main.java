package com.btcag.bootcamp;

public class Main {

    public static Roboter player1 = new Roboter(7,9, "", null);
    public static Roboter player2 = new Roboter(7, 0, "", null);

    public static void main(String[] args) {
        Spielrunde neueSpielrunde = new Spielrunde();
        neueSpielrunde.starteRunde();
        neueSpielrunde.spieleHauptspiel();
    }
}
