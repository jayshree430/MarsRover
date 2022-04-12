package com.Jayshree.MarsRover;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class RoverTest {

    Rover rover;

    @Test
    public void checkPositionShouldNotBeZero(){
        String exceptionMessage = "";
        String message = "Position should be greater than Zero";
        try {
            rover = new Rover(0,3,Direction.EAST);
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
            rover = new Rover(5,-3,Direction.EAST);
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }
    @Test
    public void checkPositionAndDirection(){
        rover = new Rover(3,3,Direction.EAST);
        assertEquals(3, rover.getPosX());
        assertEquals(3, rover.getPosY());
        assertEquals(Direction.EAST, rover.getDirection());
    }
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" "})
    public void isBlank_ShouldReturnFalseForNullOrBlankStrings(String instruction){
        rover = new Rover(3, 5, Direction.EAST);
        String expected = "Instructions cannot be Empty or null";
        assertEquals(expected,rover.processMovement(instruction));
    }

    @ParameterizedTest
    @ValueSource(strings = {"L", "R", "l", "r"})
    public void move_ShouldTurnToNewDirection(String instruction){
        rover = new Rover(3, 5, Direction.EAST);
        String expected = "Rover moved to new direction";
        assertEquals(expected,rover.processMovement(instruction));
    }

    @ParameterizedTest
    @ValueSource(strings = {"t", "S", "K"})
    public void move_InvalidInput(String instruction){
        rover = new Rover(3, 5, Direction.EAST);
        String expected = "Invalid Instructions. Please provide only L, R or M as input";
        assertEquals(expected,rover.processMovement(instruction));
    }



}
