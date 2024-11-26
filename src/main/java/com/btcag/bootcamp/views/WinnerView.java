package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

public class WinnerView {
    public static void display(Robot winner) {
        System.out.println(winner.getName() + " hat den Kampf gewonnen!");
    }
}
