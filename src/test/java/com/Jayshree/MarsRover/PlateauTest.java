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
        try {
             plateau = new Plateau(50, 20);
            assertEquals(50, plateau.getXmax());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    @Test
    public void checkPlateauValueY() {
        try {
            plateau = new Plateau(50, 20);
            assertEquals(20, plateau.getYmax());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    @Test
    public void checkMoveNorthEdgeIsNotPossible() {
        //Checking weather the vehicle can move 1 space in given direction
        try {
            plateau = new Plateau(5, 6);
            String expected = "Cannot move further. Vehicle over edge";
            assertEquals(expected, plateau.move(4,6, Direction.NORTH));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    @Test
    public void checkMoveEastEdgeIsNotPossible() {
        try {
            plateau = new Plateau(5, 6);
            String expected = "Cannot move further. Vehicle over edge";
            assertEquals(expected, plateau.move(5,3, Direction.EAST));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void checkMoveSouthEdgeIsNotPossible() {
        try {
            plateau = new Plateau(5, 6);
            String expected = "Cannot move further. Vehicle over edge";
            assertEquals(expected, plateau.move(5,0, Direction.SOUTH));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Test
    public void checkMoveWestEdgeIsNotPossible() {
        try {
            plateau = new Plateau(5, 6);
            String expected = "Cannot move further. Vehicle over edge";
            assertEquals(expected, plateau.move(0,3, Direction.WEST));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }


}
