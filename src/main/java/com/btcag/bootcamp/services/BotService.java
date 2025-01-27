package com.btcag.bootcamp.services;

import com.btcag.bootcamp.APIConnection.Bot;
import com.btcag.bootcamp.models.Robot;

import java.util.Random;

public class BotService {
    public static boolean decidingWhoStarts(Bot bot1, Bot bot2){
        Random random = new Random();
        if (bot1.getMovementRate() > bot2.getMovementRate()){
            return true;
        }
        else if(bot2.getMovementRate() > bot1.getMovementRate()){
            return false;
        }
        else if(bot1.getMovementRate() == bot2.getMovementRate()){
            int randomNumber = random.nextInt(0, 2);
            if(randomNumber == 0){
                return true;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
