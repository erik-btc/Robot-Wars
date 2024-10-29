package com.btcag.bootcamp;

public class Spielfeld {
    private int xSize;
    private int ySize;
    private Roboter player1;
    private Roboter player2;
    private boolean playersSet = false;
    public Spielfeld(){
        xSize=10;
        ySize=15;
    }

    public void drawField() {
        if (playersSet) {
            for (int i = 0; i < xSize; i++) {
                for (int j = 0; j < ySize; j++) {
                    if (player1.checkPosition(i, j)){
                        System.out.print("[" + player1.roboterSymbol + "]");
                    }
                    else if (player2.checkPosition(i, j)){
                        System.out.print("[" + player2.roboterSymbol + "]");
                    }
                    else {
                        System.out.print("[ ]");
                    }
                }
                System.out.println();
            }
        }
    }

    public void setPlayers(Roboter player1, Roboter player2) {
        this.player1=player1;
        this.player2=player2;
        this.playersSet = true;
    }

}
