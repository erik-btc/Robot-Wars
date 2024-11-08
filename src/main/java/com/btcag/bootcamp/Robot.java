package com.btcag.bootcamp;

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
    String roboterSymbol;
    boolean knockedOut;

    public Robot(int x, int y, int hp, int damage, int range, int movementPoints,String username, String roboterSymbol, boolean knockedOut) {
        this.hp = hp;
        this.energy = 1;
        this.shield = 1;
        this.damage = damage;
        this.range = range;
        this.damageZone = 1;
        this.accuracy = 1;
        this.movementPoints = movementPoints;
        this.x = x;
        this.y = y;
        this.username = username;
        this.roboterSymbol = roboterSymbol;
        this.knockedOut = knockedOut;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String getRoboterSymbol(){
        return roboterSymbol;
    }

    public void setKnockedOut(boolean knockedOut) {
        this.knockedOut = knockedOut;
    }

    public boolean getKnockedOut() {
        return knockedOut;
    }

    public void move(String direction){
        switch (direction) {
            case "w" -> {
                if (y > 0) y--;
                else System.out.println("Invalid direction");
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

    public int askAction(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gib an [1]Bewegen oder [2]Angreifen");
        return scanner.nextInt();
    }

    public String askDirection(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte gebe die Richtung ein: ");
        return scanner.nextLine();
    }

    public boolean checkPosition(int i, int j){
        return x == j && y == i;
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
