package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

public class alignView {
    public static void display(Robot player) {
        System.out.println("Ausrichtung von " + player.getName() + ": " + player.getAlignment());
    }
}
