package com.btcag.bootcamp.views;

import com.btcag.bootcamp.APIConnection.Bot;
import com.btcag.bootcamp.models.Robot;

import java.util.Scanner;

public class BotSkillpointsView {
    public static void allocationOfSkillPoints(Bot bot){
        Scanner scanner = new Scanner(System.in);
        int skillPoints = 10;
        while (skillPoints != 0){
            System.out.println("In welche Stats willst du skillen ?\n" +
                    "[1] HP: " + bot.getHealth() + "\n" +
                    "[2] Damage: " + bot.getAttackDamage() + "\n" +
                    "[3] Range: " + bot.getAttackRange() + "\n" +
                    "[4] Movement Points: " + bot.getMovementRate() + "\n" +
                    "Verbleibende zu vergebene Skill Points: " + skillPoints);
            int userInput = scanner.nextInt();
            if(userInput == 1){
                bot.setHealth(bot.getHealth() + 1);
            }
            else if(userInput == 2){
                bot.setAttackDamage(bot.getAttackDamage() + 1);
            }
            else if(userInput == 3){
                bot.setAttackRange(bot.getAttackRange() + 1);
            }
            else if(userInput == 4){
                bot.setMovementRate(bot.getMovementRate() + 1);
            }
            skillPoints--;
        }
    }

    public static String showPlayerStats(Bot bot){
        return "\n/------------------\\\n" +
                "Stats von " + bot.getName() + "\n" +
                "HP: " + bot.getHealth() + "\n" +
                "Damage: " + bot.getAttackDamage() + "\n" +
                "Range: " + bot.getAttackRange() + "\n" +
                "Movement Points: " + bot.getMovementRate() + "\n" +
                "\\------------------/\n";
    }
}
