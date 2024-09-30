package com.btcag.bootcamp;

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
    public static Random random = new Random();

    public static String[] getNames(){
        String username1;
        String username2;
        System.out.println("Bitte geben Sie ihren Username ein: ");
        username1 = scanner.nextLine();
        System.out.println("Bitte geben Sie ihren Username ein: ");
        username2 = scanner.nextLine();
        return new String[]{username1, username2};
    }

    public static String introWelcomingScreen(){
        return "Willkommen bei \n" +
        "  _____       _           _       __          __            \n" +
        " |  __ \\     | |         | |      \\ \\        / /            \n" +
                " | |__) |___ | |__   ___ | |_ _____\\ \\  /\\  / /_ _ _ __ ___ \n" +
                " |  _  // _ \\| '_ \\ / _ \\| __|______\\ \\/  \\/ / _` | '__/ __|\n" +
                " | | \\ \\ (_) | |_) | (_) | |_        \\  /\\  / (_| | |  \\__ \\\n" +
                " |_|  \\_\\___/|_.__/ \\___/ \\__|        \\/  \\/ \\__,_|_|  |___/\n" +
                "                                                            \n" +
                "                                                            ";
    }



    public static String[] avatarSelection(){
        String roboter1 = "";
        String roboter2 = "";
        boolean roboterstatus = true;
        while (roboterstatus) {
            System.out.println(username1 + " bitte gib ein Zeichen ein, welches deinen Roboter symbolisieren soll: ");
            roboter1 = scanner.nextLine();
            System.out.println(username2 + " bitte gib ein Zeichen ein, welches deinen Roboter symbolisieren soll: ");
            roboter2 = scanner.nextLine();
            if (roboter1.length() != 1 || roboter2.length() != 1) {
                System.out.println("Bitte gib nur ein Zeichen ein.");
            }
            else if (roboter1.equals(roboter2)) {
                System.out.println("Gib bitte nicht das gleiche Zeichen ein wie der andere Spieler.");
            }
            else {
                roboterstatus = false;
            }
        }
        return new String[]{roboter1, roboter2};
    }

    public static void drawField(){
        int x = 0;
        int y = 0;
        while(y < 10){
            x = 0;
            while(x < 15){
                System.out.print("[ ]");
                x++;
                while (y == yPlayer2 && x == xPlayer2){
                    System.out.print("[" + roboter2 + "]");
                    x++;
                }
                while(y == yPlayer1 && x == xPlayer1) {
                    System.out.print("[" + roboter1 + "]");
                    x++;
                }
            }
            System.out.println();
            y++;
        }
        System.out.println(username1 + " dein Roboter sieht so aus: " + roboter1 + ", und hat diese Koordinaten X Y : " + (xPlayer1 + 1) + " " + (yPlayer1 + 1));
        System.out.println(username2 + " dein Roboter sieht so aus: " + roboter2 + ", und hat diese Koordinaten X Y : " + (xPlayer2 + 1) + " " + (yPlayer2 + 1));
        playersTurn();
    }

    public static void playersTurn(){
        if (!playersTurnStatus) {
            System.out.println("\n" + username1 + " bitte geben Sie ein wie Sie sich bewegen möchten, \n" +
                    "U für Up, R für Right, D für Down, L für Left und wenn Sie sich nicht bewegen möchten dann bitte Leer lassen.");
            String playerMove = scanner.nextLine();
            switch (playerMove) {
                case "U" -> {
                    yPlayer1--;
                    if (yPlayer1 < 0) yPlayer1++;
                    else playersTurnStatus = true;
                }
                case "R" -> {
                    xPlayer1++;
                    if (xPlayer1 >= 15) xPlayer1--;
                    else playersTurnStatus = true;
                }
                case "D" -> {
                    yPlayer1++;
                    if (yPlayer1 >= 10) yPlayer1--;
                    else playersTurnStatus = true;
                }
                case "L" -> {
                    xPlayer1--;
                    if (xPlayer1 < 0) xPlayer1++;
                    else playersTurnStatus = true;
                }
                default -> playersTurnStatus = true;
            }
        } else {
            System.out.println("\n" + username2 + " bitte geben Sie ein wie Sie sich bewegen möchten, \n" +
                    "U für Up, R für Right, D für Down, L für Left und wenn Sie sich nicht bewegen möchten dann bitte Leer lassen.");
            String playerMove = scanner.nextLine();
            switch (playerMove) {
                case "U" -> {
                    yPlayer2--;
                    if (yPlayer2 < 0) yPlayer2++;
                    else playersTurnStatus = false;
                }
                case "R" -> {
                    xPlayer2++;
                    if (xPlayer2 >= 15) xPlayer2--;
                    else playersTurnStatus = false;
                }
                case "D" -> {
                    yPlayer2++;
                    if (yPlayer2 >= 10) yPlayer2--;
                    else playersTurnStatus = false;
                }
                case "L" -> {
                    xPlayer2--;
                    if (xPlayer2 < 0) xPlayer2++;
                    else playersTurnStatus = false;
                }
                default -> playersTurnStatus = false;
            }
        }
        drawField();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] players = getNames();
        username1 = players[0];
        username2 = players[1];
        String[] roboters = avatarSelection();
        roboter1 = roboters[0];
        roboter2 = roboters[1];
        System.out.println(introWelcomingScreen());
        System.out.println("Mach dich bereit zu kämpfen.\nHier ist das Spielfeld:\n");
        drawField();

    }
}
