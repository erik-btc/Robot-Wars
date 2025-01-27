package com.btcag.bootcamp.views;

import com.btcag.bootcamp.APIConnection.Bot;

public class PlayersTurnView {
    public static void display(Bot bot){
        System.out.println(bot.getName() + "'s turn");
    }
}
