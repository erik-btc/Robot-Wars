package com.btcag.bootcamp;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static String username1;
    public static String username2;
    public static String roboter1;
    public static String roboter2;

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
        int xPlayer1 = 7;
        int yPlayer1 = 9;
        int xPlayer2 = 7;
        int yPlayer2 = 0;
        while(y < 10){
            x = 0;
            while(x < 15){
                System.out.print("[ ]");
                x++;
                while (y == 0 && x == 7){
                    System.out.print("[" + roboter2 + "]");
                    x++;
                }
                while(y == 9 && x==7) {
                    System.out.print("[" + roboter1 + "]");
                    x++;
                }
            }
            System.out.println();
            y++;
        }
        System.out.println(username1 + " dein Roboter sieht so aus: " + roboter1 + ", und hat diese Koordinaten X Y : " + xPlayer1 + " " + yPlayer1);
        System.out.println(username2 + " dein Roboter sieht so aus: " + roboter2 + ", und hat diese Koordinaten X Y : " + xPlayer2 + " " + yPlayer2);

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
