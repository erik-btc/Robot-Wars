package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

public class PlayerIsNotInRangeOrObstacleIsInTheWayView {
    public static void display(Robot player){
        System.out.println(player.getName() + " ist nicht in Range oder ein Gegenstand ist im Weg.");
    }
}
