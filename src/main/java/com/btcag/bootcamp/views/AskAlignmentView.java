package com.btcag.bootcamp.views;

import com.btcag.bootcamp.enums.Alignment;

import java.util.Scanner;

public class AskAlignmentView {
    public static String display(){

    System.out.println("Bitte gib die Richtung an, in die sich der Roboter ausrichten soll.");
    System.out.println("[W]Nord, [E]Nordosten, [D]Osten, [C]Südosten, [X]Süden, [Y]Südwesten, [A]Westen, [Q]Nordwesten");
    Scanner scanner = new Scanner(System.in);

    Alignment alignment;
        do {
            alignment = Alignment.fromUserInput(
            scanner.next().toLowerCase().charAt(0)
        );
        } while (null == alignment);

        return alignment.toString();
    }
}
