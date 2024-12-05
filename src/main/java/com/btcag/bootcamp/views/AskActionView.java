package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

import java.util.Scanner;

public class AskActionView {
    public static int display(){
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        do{
            System.out.println("""
                [1] Bewegen
                [2] Angreifen
                [3] Ausrichten
                [4] Zug abbrechen
                """);
            userInput = scanner.next();
        }while(!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") && !userInput.equals("4"));
        int temp = Integer.parseInt(userInput);
        return temp;
    }
}
