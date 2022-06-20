package com.Jayshree.MarsRover;

public class Rover {

    private final String INVALID_POSITION = "Position should be greater than Zero";
    private final String TAKEN_SPOT = "Another rover is already present at that coordinate";
    private final String EDGE_MESSAGE = "Rover has reached the edge";

    private int posX;
    private int posY;
    Direction direction;
    private PlateauRoverFunctions plateau;

    public Rover(int posX, int posY, Direction direction, PlateauRoverFunctions plateau) throws IllegalArgumentException{
        if(posX <= 0 || posY <= 0){
            throw new IllegalArgumentException(INVALID_POSITION);
        }
        if (plateau.getRoverByCoordinates(posX, posY) != null){
            throw new IllegalArgumentException(TAKEN_SPOT);
        }
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
        this.plateau = plateau;
        plateau.addRover(this);
    }
    public int getPosX(){
        return posX;
    }

    public int getPosY(){
        return posY;
    }

    public Direction getDirection(){
        return direction;
    }

    public Status processMovement(String instruction){
        Status status = Status.NO_ERROR;
        if (!instruction.matches("^[LMRlmr]+$")) {
            return Status.ERROR_BAD_MOVEMENT_STRING;
        }
        String[] instructionArray = instruction.split("");
        for (String input : instructionArray) {
            try {
                switch (input.toUpperCase()) {
                    case "L" -> goLeft();
                    case "R" -> goRight();
                    case "M" -> status = move();
                    default -> System.out.println("Something else? " + input);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return status;
    }

    private void goLeft(){
        Direction d = this.direction;
        switch (d) {
            case EAST -> this.direction = Direction.NORTH;
            case SOUTH -> this.direction = Direction.EAST;
            case WEST -> this.direction = Direction.SOUTH;
            case NORTH -> this.direction = Direction.WEST;
            default -> System.out.println("Direction = " + d);
        }
    }

    private void goRight() {
    Direction d = this.direction;
        switch (d) {
            case EAST -> this.direction = Direction.SOUTH;
            case SOUTH -> this.direction = Direction.WEST;
            case WEST -> this.direction = Direction.NORTH;
            case NORTH -> this.direction = Direction.EAST;
            default -> System.out.println("Direction = " + d);
        }

    }

    public Status move() throws Exception{
        Status status = plateau.checkEdgeCoordinates(posX, posY, direction);
        if (status == Status.NO_ERROR) {
            if (plateau.forwardPosition(posX, posY, direction)) {
                status = Status.ERROR_TAKEN_SPOT;
            }
        }
        switch (status) {
            case ERROR_OVER_EDGE -> throw new Exception(EDGE_MESSAGE );
            case ERROR_TAKEN_SPOT -> throw new Exception(TAKEN_SPOT);
            case NO_ERROR -> moveForward();
        }
        return status;
    }

    private void moveForward() {
        switch (direction) {
            case NORTH -> this.posY += 1;
            case EAST -> this.posX += 1;
            case SOUTH -> this.posY -= 1;
            case WEST -> this.posX -= 1;
        }

    }

}
