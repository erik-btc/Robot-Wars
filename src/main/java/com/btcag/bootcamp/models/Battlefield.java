package com.btcag.bootcamp.models;

import java.util.Arrays;

public class Battlefield {
    private char[]board;
    private final int rows;
    private final int   cols;

    // Erstellung der Map
    public Battlefield(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        board = new char[rows*cols];
        for(int i = 0; i < board.length; i++) {
            board[i] = '.';
        }
    }

    // Map wird initalisiert
    public void initializeMap() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(board[i*cols+j] + " ");
            }
            System.out.println();
        }
    }

    // Symbol (Roboter, Hindernisse oder items) auf die Karte bringen
    public void printSymbol(int mapIndex, char symbol) {
        board[mapIndex] = symbol;
    }

    /*private final char[][] map;
    private final int width;
    private final int height;

    public Battlefield(int width, int height) {
        this.map = new char[height][width];
        this.initializeMap();
        this.width = width;
        this.height = height;
    }

    private void initializeMap() {
        for (char[] row : map) {
            Arrays.fill(row, ' ');
        }
    }

    public char getField(int x, int y) {
        return map[y - 1][x - 1];
    }

    public void setField(int x, int y, char field) {
        map[y - 1][x - 1] = field;
    }

    public int getWidth() {
        return width;
    }

    public char[][] getMap() {
        return map;
    }

    public boolean isValidField(int x, int y, Obstacle[] obstacles) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getX() == x && obstacle.getY() == y) {
                return false;
            }
        }
        return x > 0 && x <= width && y > 0 && y <= height;
    }*/
}
