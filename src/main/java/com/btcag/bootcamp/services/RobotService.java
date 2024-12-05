package com.btcag.bootcamp.services;

import com.btcag.bootcamp.models.Robot;

import java.util.Objects;
import java.util.Random;

public class RobotService {

    public static boolean checkHpPlayer1 (Robot player) {
        return player.getHp() < 1;
    }

    public static boolean checkHpPlayer2 (Robot player) {
        return player.getHp() < 1;
    }

    public static boolean decidingWhoStarts(Robot player1, Robot player2){
        Random random = new Random();
        if (player1.getMovementPoints() > player2.getMovementPoints()){
            return true;
        }
        else if(player2.getMovementPoints() > player1.getMovementPoints()){
            return false;
        }
        else if(player1.getMovementPoints() == player2.getMovementPoints()){
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

    public static boolean inRange(Robot player1, Robot player2){
        //Rechts und Oben
        if ((player1.getX() + player1.getRange() >= player2.getX() && player2.getX() >= player1.getX()) && (player1.getY() + player1.getRange() >= player2.getY() && player2.getY() >= player1.getY())
                //Rechts und Unten
                || (player1.getX() + player1.getRange() >= player2.getX() && player2.getX() >= player1.getX()) && (player1.getY() - player1.getRange() <= player2.getY() && player2.getY() <= player1.getY())
                //Links und Oben
                || (player1.getX() - player1.getRange() <= player2.getX() && player2.getX() <= player1.getX()) && (player1.getY() + player1.getRange() >= player2.getY() && player2.getY() >= player1.getY())
                //Links und Unten
                || (player1.getX() - player1.getRange() <= player2.getX() && player2.getX() <= player1.getX()) && (player1.getY() - player1.getRange() <= player2.getY() && player2.getY() <= player1.getY()))
        {
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean checkDiagonalAlignment(Robot player1, Robot player2){
        int valueOne;
        int valueTwo;
        valueOne = player1.getX() - player2.getX();
        valueTwo = player1.getY() - player2.getY();
        if (Math.abs(valueOne) == Math.abs(valueTwo)) {
            return true;
        }
        return false;
    }

    public static boolean checkDiagonal(Robot player1, Robot player2){
        if(Objects.equals(player1.getAlignment(), "NORDOST")){
            if (player1.getX() < player2.getX() && player1.getY() > player2.getY() && checkDiagonalAlignment(player1, player2)){
                return true;
            }
            return false;
        }
        else if(Objects.equals(player1.getAlignment(), "NORDWEST")){
            if (player1.getX() > player2.getX() && player1.getY() > player2.getY() && checkDiagonalAlignment(player1, player2)){
                return true;
            }
            return false;
        }
        else if(Objects.equals(player1.getAlignment(), "SUEDOST")){
            if (player1.getX() < player2.getX() && player1.getY() < player2.getY() && checkDiagonalAlignment(player1, player2)){
                return true;
            }
            return false;
        }
        else if(Objects.equals(player1.getAlignment(), "SUEDWEST")){
            if (player1.getX() > player2.getX() && player1.getY() < player2.getY() && checkDiagonalAlignment(player1, player2)){
                return true;
            }
            return false;
        }
        else{
            return false;
        }
    }

    public static boolean checkHorizontalAlignment(Robot player1, Robot player2){
        if (Objects.equals(player1.getAlignment(), "OST")) {
            if(player1.getX() < player2.getX() && player1.getY() == player2.getY()){
                return true;
            }
        }
        else if (Objects.equals(player1.getAlignment(), "WEST")) {
            if(player1.getX() > player2.getX() && player1.getY() == player2.getY()){
                return true;
            }
        }
        return false;
    }

    public static boolean checkVerticalAlignment(Robot player1, Robot player2){
        if(Objects.equals(player1.getAlignment(), "NORD")) {
            if(player1.getY() > player2.getY() && player1.getX() == player2.getX()){
                return true;
            }
        }
        else if (Objects.equals(player1.getAlignment(), "SUED")) {
            if (player1.getY() < player2.getY() && player1.getX() == player2.getX()){
                return true;
            }
        }
        return false;
    }



}
