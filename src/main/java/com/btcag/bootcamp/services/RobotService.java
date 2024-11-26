package com.btcag.bootcamp.services;

import com.btcag.bootcamp.models.Robot;

import java.util.Random;

public class RobotService {

    public static boolean checkHpPlayer1 (Robot player) {
        return player.getHp() < 1;
    }

    public static boolean checkHpPlayer2 (Robot player) {
        return player.getHp() < 1;
    }
}
