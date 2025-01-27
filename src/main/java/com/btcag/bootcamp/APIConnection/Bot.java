package com.btcag.bootcamp.APIConnection;

public class Bot{
    String name;
    int health;
    int attackDamage;
    int attackRange;
    int movementRate;

    public Bot(String name, int health, int attackDamage, int attackRange, int movementRate) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackRange = attackRange;
        this.movementRate = movementRate;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMovementRate() {
        return movementRate;
    }

    public void setMovementRate(int movementRate) {
        this.movementRate = movementRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
