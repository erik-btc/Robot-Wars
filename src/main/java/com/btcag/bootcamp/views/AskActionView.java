package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

import java.util.Scanner;

public class AskActionView {
    public static int display(Robot robot){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib an [1]Bewegen oder [2]Angreifen");
        return scanner.nextInt();
    }
}
