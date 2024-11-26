package com.btcag.bootcamp.enums;

public enum Direction {
    NORD(0, -1),
    NORDOST(1, -1),
    OST(1, 0),
    SUEDOST(1, 1),
    SUED(0, 1),
    SUEDWEST(-1, 1),
    WEST(-1, 0),
    NORDWEST(-1, -1);

    private int x;
    private int y;


    Direction(int x, int y){
        this.x = x;
        this.y = y;
    }

    public static Direction fromUserInput(char userChoice) {
        return switch (userChoice) {
            case 'w' -> NORD;
            case 'e' -> NORDOST;
            case 'x' -> SUED;
            case 'c' -> SUEDOST;
            case 'd' -> OST;
            case 'a' -> WEST;
            case 'y' -> SUEDWEST;
            case 'q' -> NORDWEST;
            default -> null;
        };
    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


}
