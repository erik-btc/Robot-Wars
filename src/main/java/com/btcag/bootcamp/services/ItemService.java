package com.btcag.bootcamp.services;

import com.btcag.bootcamp.models.Item;
import com.btcag.bootcamp.models.Robot;

import java.util.Random;

public class ItemService {
    public static void processingItemEffect(Robot player, Item item){
        Random random = new Random();
        item.setItemSymbol(' ');
        int randomNumber = random.nextInt(3);
        if(randomNumber == 0){
            player.setDamage(player.getterForDamage() + item.getItemEffect());
            System.out.println(player.getName() + "'s Damage ist jetzt: " + player.getterForDamage());
        }
        else if(randomNumber == 1){
            player.setRange(player.getRange() + item.getItemEffect());
            System.out.println(player.getName() + "'s Range ist jetzt: " + player.getRange());
        }
        else if(randomNumber == 2){
            player.setMovementPoints(player.getMovementPoints() + item.getItemEffect());
            System.out.println(player.getName() + "'s Movement Points ist jetzt: " + player.getMovementPoints());
        }
    }
}
