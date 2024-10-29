package com.btcag.bootcamp;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String username1;
    public static String username2;
    public static String roboter1;
    public static String roboter2;
    public static int xPlayer1 = 7;
    public static int yPlayer1 = 9;
    public static int xPlayer2 = 7;
    public static int yPlayer2 = 0;
    public static boolean playersTurnStatus = false;


    public static Roboter player1 = new Roboter(7,9, "", null);
    public static Roboter player2 = new Roboter(7, 0, "", null);




    public static void checkWin() {
        Random random = new Random();
        if (xPlayer1 == xPlayer2 && yPlayer1 == yPlayer2) {
            int winner = random.nextInt(0, 2);
            if (winner == 0) {
                System.out.println("\n\n" + username1 + " hat gewonnen.");
            } else if (winner == 1) {
                System.out.println("\n\n" + username2 + " hat gewonnen.");
            }
        }
        else {


        }
    }

    public static void main(String[] args) {
        Spielrunde neueSpielrunde = new Spielrunde();
        neueSpielrunde.starteRunde();
        neueSpielrunde.spieleHauptspiel();
    }
}
