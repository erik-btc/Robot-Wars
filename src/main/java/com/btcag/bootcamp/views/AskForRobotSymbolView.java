package com.btcag.bootcamp.views;

import java.util.Scanner;

public class AskForRobotSymbolView {
    public static char display() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welches Roboter Symbol möchtest du haben ? [Max. 1 Zeichen]: ");
        return scanner.next().charAt(0);
    }
}
