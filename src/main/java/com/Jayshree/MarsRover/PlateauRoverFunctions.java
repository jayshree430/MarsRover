package com.Jayshree.MarsRover;

public interface PlateauRoverFunctions {

    void addRover(Rover rover);
    Status checkEdgeCoordinates(int x, int y, Direction d);
    Rover getRoverByCoordinates(int x, int y);
    boolean forwardPosition(int x, int y, Direction direction);
}
