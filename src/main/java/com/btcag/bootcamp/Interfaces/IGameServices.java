package com.btcag.bootcamp.Interfaces;

import com.btcag.bootcamp.entities.Game;
import com.btcag.bootcamp.entities.Move;
import com.btcag.bootcamp.models.Robot;

import java.util.ArrayList;

public interface IGameServices {
    public Game getGame(int gameID);
    public void createGame(Game game);
    public Game joinGame(int gameID, Robot robot);
    public ArrayList<Move> getMoves(int gameID);
    public Move getMove(int gameID, int moveID);
    public void makeMove(int gameID, Move move);
}
