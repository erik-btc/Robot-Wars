package com.btcag.bootcamp.views;

import com.btcag.bootcamp.APIConnection.Bot;
import com.btcag.bootcamp.models.Robot;

public class WinnerView {
    public static void display(Bot winner) {
        System.out.println(winner.getName() + " hat den Kampf gewonnen!");
    }
}
