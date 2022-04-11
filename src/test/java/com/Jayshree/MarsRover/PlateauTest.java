package com.Jayshree.MarsRover;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauTest {
    Plateau plateau;

    @Test
    public void checkZeroPlateauValueXY() {
        String exceptionMessage = "";
        String message = "Plateau size must be greater than zero";
        try {
            Plateau plateau = new Plateau(0, 0);
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }
    @Test
    public void checkNegativePlateauValueXY() {
        String exceptionMessage = "";
        String message = "Plateau size must be greater than zero";
        try {
             plateau = new Plateau(-5, -2);
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }
    @Test
    public void checkPlateauValueX() {
        String exceptionMessage = "";
        try {
             plateau = new Plateau(50, 20);
            assertEquals(50, plateau.getXmax());
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }

    }

    @Test
    public void checkPlateauValueY() {
        String exceptionMessage = "";
        try {
            plateau = new Plateau(50, 20);
            assertEquals(20, plateau.getYmax());
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }

    }

    @Test
    public void checkMoveNorthEdge() {
        //Checking weather the vehicle can move 1 space in given direction
        String exceptionMessage = "";
        try {
            plateau = new Plateau(5, 6);
            String expected = "Cannot move further. Vehicle over edge";
            assertEquals(expected, plateau.move(4,6, Direction.NORTH));
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }

    }

    @Test
    public void checkMoveEastEdge() {
        String exceptionMessage = "";
        try {
            plateau = new Plateau(5, 6);
            String expected = "Cannot move further. Vehicle over edge";
            assertEquals(expected, plateau.move(5,3, Direction.EAST));
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
    }

    @Test
    public void checkMoveSouthEdge() {
        String exceptionMessage = "";
        try {
            plateau = new Plateau(5, 6);
            String expected = "Cannot move further. Vehicle over edge";
            assertEquals(expected, plateau.move(5,0, Direction.SOUTH));
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
    }

    @Test
    public void checkMoveWestEdge() {
        String exceptionMessage = "";
        try {
            plateau = new Plateau(5, 6);
            String expected = "Cannot move further. Vehicle over edge";
            assertEquals(expected, plateau.move(0,3, Direction.WEST));
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
    }


}
