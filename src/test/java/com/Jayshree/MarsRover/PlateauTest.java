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
           plateau = new Plateau(0, 0);
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
        plateau = new Plateau(50, 20);
        assertEquals(50, plateau.getXmax());
    }

    @Test
    public void checkPlateauValueY() {
        plateau = new Plateau(50, 20);
        assertEquals(20, plateau.getYmax());
    }

    @Test
    public void checkMoveNorthEdgeIsNotPossible() {
        //Checking weather the vehicle can move 1 space in given direction
        plateau = new Plateau(5, 6);
        String expected = "Cannot move further. Vehicle over edge";
        assertEquals(expected, plateau.move(4,6, Direction.NORTH));
    }

    @Test
    public void checkMoveEastEdgeIsNotPossible() {
        plateau = new Plateau(5, 6);
        String expected = "Cannot move further. Vehicle over edge";
        assertEquals(expected, plateau.move(5,3, Direction.EAST));
    }

    @Test
    public void checkMoveSouthEdgeIsNotPossible() {
        plateau = new Plateau(5, 6);
        String expected = "Cannot move further. Vehicle over edge";
        assertEquals(expected, plateau.move(5,0, Direction.SOUTH));
    }

    @Test
    public void checkMoveWestEdgeIsNotPossible() {
      plateau = new Plateau(5, 6);
      String expected = "Cannot move further. Vehicle over edge";
      assertEquals(expected, plateau.move(0,3, Direction.WEST));
    }

    @Test
    public void checkMoveNorthIsPossible() {
        //Checking weather the vehicle can move 1 space in given direction
        plateau = new Plateau(5, 6);
        String expected = "Can move further.";
        assertEquals(expected, plateau.move(1,3, Direction.NORTH));
    }
    @Test
    public void checkMoveEastIsPossible() {
        plateau = new Plateau(5, 6);
        String expected = "Can move further.";
        assertEquals(expected, plateau.move(4,3, Direction.EAST));
    }
    @Test
    public void checkMoveSouthIsPossible() {
       plateau = new Plateau(5, 6);
       String expected = "Can move further.";
       assertEquals(expected, plateau.move(1,1, Direction.SOUTH));
    }
    @Test
    public void checkMoveWestIsPossible() {
      plateau = new Plateau(5, 6);
      String expected = "Can move further.";
      assertEquals(expected, plateau.move(1,3, Direction.WEST));
    }
}
