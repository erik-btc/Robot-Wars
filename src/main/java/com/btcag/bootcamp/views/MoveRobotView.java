package com.btcag.bootcamp.views;

import com.btcag.bootcamp.enums.Direction;

import java.util.Scanner;

public class MoveRobotView {
    public static Direction display() {

        System.out.println("Bitte gib die Richtung an, in die sich der Roboter bewegen soll.");
        System.out.println("[W]Nord, [E]Nordosten, [D]Osten, [C]Südosten, [X]Süden, [Y]Südwesten, [A]Westen, [Q]Nordwesten");
        Scanner scanner = new Scanner(System.in);

        Direction direction;
        do {
            direction = Direction.fromUserInput(
                    scanner.next().toLowerCase().charAt(0)
            );
        } while (null == direction);

        return direction;
    }
}
