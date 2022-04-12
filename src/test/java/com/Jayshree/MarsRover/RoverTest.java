package com.Jayshree.MarsRover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void checkPosition(){
        rover = new Rover(3,3,Direction.EAST);
        assertEquals(3, rover.getPosX());
        assertEquals(3, rover.getPosY());
    }



}
