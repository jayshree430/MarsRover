package com.Jayshree.MarsRover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class RoverTest {

    Rover rover;
    PlateauRoverFunctions plateau;

    @BeforeEach
    void init(){
        plateau = new Plateau(10, 10);
    }

    @Test
    public void checkPositionShouldNotBeZero(){
        String exceptionMessage = "";
        String message = "Position should be greater than Zero";
        try {
            rover = new Rover(0,3,Direction.EAST, plateau);
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }
    @Test
    public void checkPositionShouldNotBeNegative(){
        String exceptionMessage = "";
        String message = "Position should be greater than Zero";
        try {
            rover = new Rover(5,-3,Direction.EAST, plateau);
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }
    @Test
    public void checkPositionAndDirection(){
        rover = new Rover(3,3,Direction.EAST, plateau);
        assertEquals(3, rover.getPosX());
        assertEquals(3, rover.getPosY());
        assertEquals(Direction.EAST, rover.getDirection());
    }

    @ParameterizedTest
    @ValueSource(strings = {"L", "R", "l", "r"})
    public void move_ShouldTurnToNewDirection(String instruction){
        rover = new Rover(3, 5, Direction.EAST, plateau);
        String expected = "Rover moved to new direction";
        assertEquals(Status.NO_ERROR, rover.processMovement(instruction));
    }

    @ParameterizedTest
    @ValueSource(strings = {"t", "S", "K"})
    public void move_InvalidInput(String instruction){
        rover = new Rover(3, 5, Direction.EAST, plateau);
        assertEquals(Status.ERROR_BAD_MOVEMENT_STRING, rover.processMovement(instruction));
    }

    @Test
    public void checkDirectionForRoverIsSouth(){
        rover = new Rover(3, 5, Direction.EAST, plateau);
        Status status = rover.processMovement("R");
        assertEquals(Direction.SOUTH, rover.getDirection());
    }

    @Test
    public void checkDirectionForRoverIsNorth(){
        rover = new Rover(3, 5, Direction.EAST, plateau);
        Status status = rover.processMovement("L");
        assertEquals(Direction.NORTH, rover.getDirection());
    }

    @Test
    public void checkMove() {
        rover = new Rover(3, 5, Direction.EAST, plateau);
        Status status = rover.processMovement("M");
        assertEquals(4, rover.getPosX());
    }

    @Test
    public void checkTurnLeftMove() {
        rover = new Rover(3, 5, Direction.EAST,plateau);
        Status status = rover.processMovement("LM");
        assertEquals(6, rover.getPosY());
    }

    @Test
    public void checkTurnRightMove() {
        rover = new Rover(3, 5, Direction.EAST, plateau);
        Status status = rover.processMovement("RM");
        assertEquals(4, rover.getPosY());
    }

    @Test
    public void checkTurnRightRightMove() {
        rover = new Rover(3, 5, Direction.EAST, plateau);
        Status status = rover.processMovement("RRM");
        assertEquals(2, rover.getPosX());
    }

    @Test
    public void checkLongInstruction() {
        rover = new Rover(5, 5, Direction.EAST,plateau);
        Status status = rover.processMovement("LMLMMMLMRM");
        assertEquals(1, rover.getPosX());
        assertEquals(5, rover.getPosY());
        assertEquals(Direction.WEST, rover.getDirection());
    }

}
