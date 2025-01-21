package com.btcag.bootcamp.Interfaces;

import com.btcag.bootcamp.entities.Robot;

import java.util.ArrayList;

public interface IRobotServices {
    public Robot getRobot(int robotID);
    public ArrayList<Robot> getAllRobots(int gameID);
    public Robot createRobot(Robot robot);


}
