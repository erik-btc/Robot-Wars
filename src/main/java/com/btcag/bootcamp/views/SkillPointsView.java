package com.btcag.bootcamp.views;

import com.btcag.bootcamp.models.Robot;

import java.util.Scanner;

public class SkillPointsView {
    public static void allocationOfSkillPoints(Robot player){
        Scanner scanner = new Scanner(System.in);
        int skillPoints = 10;
        while (skillPoints != 0){
            System.out.println("In welche Stats willst du skillen ?\n" +
                    "[1] HP: " + player.getHp() + "\n" +
                    "[2] Damage: " + player.getterForDamage() + "\n" +
                    "[3] Range: " + player.getRange() + "\n" +
                    "[4] Movement Points: " + player.getMovementPoints() + "\n" +
                    "Verbleibende zu vergebene Skill Points: " + skillPoints);
            int userInput = scanner.nextInt();
            if(userInput == 1){
                player.setHp(player.getHp() + 1);
            }
            else if(userInput == 2){
                player.setDamage(player.getterForDamage() + 1);
            }
            else if(userInput == 3){
                player.setRange(player.getRange() + 1);
            }
            else if(userInput == 4){
                player.setMovementPoints(player.getMovementPoints() + 1);
            }
            skillPoints--;
        }
    }

    public static String showPlayerStats(Robot player){
        return "\n/------------------\\\n" +
                "Stats von " + player.getName() + "\n" +
                "HP: " + player.getHp() + "\n" +
                "Damage: " + player.getterForDamage() + "\n" +
                "Range: " + player.getRange() + "\n" +
                "Movement Points: " + player.getMovementPoints() + "\n" +
                "\\------------------/\n";
    }
}
