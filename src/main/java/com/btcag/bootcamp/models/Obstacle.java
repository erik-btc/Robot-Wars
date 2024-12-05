package com.btcag.bootcamp.models;

public class Obstacle {
    private int x;
    private int y;
    private char obstacleSymbol;

    public Obstacle(int x, int y){
        this.x = x;
        this.y = y;
        this.obstacleSymbol = '■';
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public char getObstacleSymbol(){
        return obstacleSymbol;
    }

    public void setObstacleSymbol(char obstacleSymbol){
        this.obstacleSymbol = obstacleSymbol;
    }

    public boolean checkCollision(Robot player, Obstacle obstacle){
        if (isColliding(player, obstacle)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isColliding(Robot player, Obstacle obstacle){
       return player.getX() == obstacle.getX() && player.getY() == obstacle.getY();
    }


}
