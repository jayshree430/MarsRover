package com.Jayshree.MarsRover;

import java.util.ArrayList;
import java.util.List;

public class Plateau implements PlateauRoverFunctions{
    public final int MIN_EDGE = 0;
    public int maxEdgeX;
    public int maxEdgeY;
    public List<Rover> roverList = new ArrayList<>();

    public Plateau(int edgeCoordinateX, int edgeCoordinateY) throws IllegalArgumentException {
        if (edgeCoordinateX <= MIN_EDGE || edgeCoordinateY <= MIN_EDGE) {
            throw new IllegalArgumentException("Plateau size must be greater than zero");
        }
        this.maxEdgeX = edgeCoordinateX;
        this.maxEdgeY = edgeCoordinateY;
    }

    public int getMaxEdgeX() {
        return maxEdgeX;
    }

    public int getMaxEdgeY() {
        return maxEdgeY;
    }

    public Status edgeCheck(int x, int y, Direction d) {
        Status status = Status.NO_ERROR;

        if (x > maxEdgeX + 1 || y > maxEdgeY + 1 || x<0 || y< 0){
            status = Status.ERROR_OVER_EDGE;
        }
        return status;
    }

    @Override
    public Status checkEdgeCoordinates(int x, int y, Direction d) {

        // Check the direction then check if the vehicle would go over the edge
        return edgeCheck(x, y, d);
    }

    @Override
    public void addRover(Rover rover) {
        //Add rover to the roverList
        roverList.add(rover);
    }

    @Override
    public Rover getRoverByCoordinates(int x, int y) {
        //Comparing x & y with coordinates from list of rovers and returning the rover object if found

        return roverList.stream()
                .filter(r -> r.getPosX() == x && r.getPosY() == y)
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean forwardPosition(int x, int y, Direction direction){
        //Checking if the forward position in a particular direction is valid or not.

        switch (direction) {
            case NORTH -> y += 1;
            case EAST -> x += 1;
            case SOUTH -> y -= 1;
            case WEST -> x -= 1;
        }
        return getRoverByCoordinates(x, y) != null;
    }

}
