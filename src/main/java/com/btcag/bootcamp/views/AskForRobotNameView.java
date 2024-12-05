package com.btcag.bootcamp.views;

import java.util.Scanner;

public class AskForRobotNameView {
    public static String display() {
        System.out.println("Bitte geben Sie den Namen für ihren Roboter ein:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
