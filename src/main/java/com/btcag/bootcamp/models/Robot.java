package com.btcag.bootcamp.models;

import java.util.Scanner;

public class Robot {
    int hp;
    int energy;
    int shield;
    int damage;
    int range;
    int damageZone;
    int accuracy;
    int movementPoints;
    int x;
    int y;
    String username;
    char robotSymbol;
    boolean knockedOut;

    public Robot(String username, int x, int y, char robotSymbol, int hp, int damage, int range, int movementPoints) {
        this.username = username;
        this.x = x;
        this.y = y;
        this.robotSymbol = robotSymbol;
        this.hp = hp;
        this.damage = damage;
        this.range = range;
        this.movementPoints = movementPoints;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getRobotSymbol() {
        return robotSymbol;
    }

    public String getName() {
        return username;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public void move(String direction){
        switch (direction) {
            case "w" -> {
                y--;
            }
            case "e" -> {
                x++;
                y--;
            }
            case "d" -> {
                x++;
            }
            case "c" -> {
                x++;
                y++;
            }
            case "x" -> {
                y++;
            }
            case "y" -> {
                x--;
                y++;
            }
            case "a" -> {
                x--;
            }
            case "q" -> {
                x--;
                y--;
            }
            case "s" -> {

            }
        }
    }

    public int attack(){
        return damage;
    }

    public int doAction(int action, String direction){
        switch(action){
            case 1 -> {
                move(direction);
                return 0;
            }
            case 2 -> {
                return damage;
            }
        }
        return 0;
    }



    public String askDirection(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gebe die Richtung ein: ");
        return scanner.nextLine();
    }


    public int getHp(){
        return hp;
    }

    public void getDamage(int damage){
        hp -= damage;
    }

    public int getterForDamage(){
        return damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setMovementPoints(int movementPoints) {
        this.movementPoints = movementPoints;
    }

    public int getMovementPoints(){
        return movementPoints;
    }


}
