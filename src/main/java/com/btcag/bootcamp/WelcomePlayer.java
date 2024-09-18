package com.btcag.bootcamp;

import java.util.Scanner;

public class WelcomePlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte teilen Sie uns Ihren Username mit: ");
        String username = scanner.nextLine();
        System.out.println("Herzlich Willkommen " + username);
    }
}
