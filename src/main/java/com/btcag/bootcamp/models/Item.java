package com.btcag.bootcamp.models;

public class Item {
    int x;
    int y;
    char itemSymbol;
    int itemEffect;
    int itemDuration;
    boolean itemActive;

    public Item(int x, int y, int itemEffect, int itemDuration, boolean itemActive) {
        this.x = x;
        this.y = y;
        this.itemSymbol = '?';
        this.itemEffect = itemEffect;
        this.itemDuration = itemDuration;
        this.itemActive = itemActive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setItemActive(){
        this.itemActive = true;
    }


    public char getItemSymbol() {
        return itemSymbol;
    }

    public void setItemSymbol(char itemSymbol) {
        this.itemSymbol = itemSymbol;
    }

    public boolean checkCollision(Robot player, Item item) {
        if (isColliding(player, item)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isColliding(Robot player, Item item){
        return player.getX() == item.getX() && player.getY() == item.getY();
    }

    public int getItemDuration() {
        return itemDuration;
    }

    public void setItemDuration(int itemDuration) {
        this.itemDuration = itemDuration;
    }

    public int getItemEffect() {
        return itemEffect;
    }

    public void setItemEffect(int itemEffect) {
        this.itemEffect = itemEffect;
    }
}
