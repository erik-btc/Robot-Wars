package com.btcag.bootcamp.enums;

public enum Alignment {
    NORD,
    NORDOST,
    OST,
    SUEDOST,
    SUED,
    SUEDWEST,
    WEST,
    NORDWEST;


    public static Alignment fromUserInput(char userChoice) {
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

}
