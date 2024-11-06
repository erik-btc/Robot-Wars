package com.btcag.bootcamp;

public class Gamefield {
    private int xSize;
    private int ySize;
    private Robot player1;
    private Robot player2;
    private boolean playersSet = false;
    public Gamefield(){
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

    public void setPlayers(Robot player1, Robot player2) {
        this.player1=player1;
        this.player2=player2;
        this.playersSet = true;
    }

    public void setPlayersSet(boolean playersSet) {
        this.playersSet = playersSet;
    }
}
