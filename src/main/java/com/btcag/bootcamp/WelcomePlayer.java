package com.btcag.bootcamp;

import java.util.Scanner;

public class WelcomePlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie ihren Username ein: ");
        String username = scanner.nextLine();
        System.out.println("Willkommen bei ");
        System.out.println("  _____       _           _       __          __            \n" +
                " |  __ \\     | |         | |      \\ \\        / /            \n" +
                " | |__) |___ | |__   ___ | |_ _____\\ \\  /\\  / /_ _ _ __ ___ \n" +
                " |  _  // _ \\| '_ \\ / _ \\| __|______\\ \\/  \\/ / _` | '__/ __|\n" +
                " | | \\ \\ (_) | |_) | (_) | |_        \\  /\\  / (_| | |  \\__ \\\n" +
                " |_|  \\_\\___/|_.__/ \\___/ \\__|        \\/  \\/ \\__,_|_|  |___/\n" +
                "                                                            \n" +
                "                                                            ");
        String roboter = "";
        boolean roboterstatus = true;
        while (roboterstatus){
            System.out.println("Bitte gib ein Zeichen ein, welches deinen Roboter symbolisieren soll: ");
            roboter = scanner.nextLine();
            if (roboter.length() != 1){
                System.out.println("Bitte nur ein Zeichen für den Roboter.");
            }
            else {
                roboterstatus = false;
            }
        }
        System.out.println("Mach dich bereit zu kämpfen.\nHier ist das Spielfeld:\n");
        int x = 0;
        int y = 0;
        while(y < 15){
            x = 0;
            while(x < 15){
                System.out.print("[ ]");
                x++;
                while(y == 14 && x==7) {
                    System.out.print("[" + roboter + "]");
                    x++;
                }
            }
            System.out.println();
            y++;
        }
        System.out.println("Dein Roboter sieht so aus: " + roboter);

    }
}
