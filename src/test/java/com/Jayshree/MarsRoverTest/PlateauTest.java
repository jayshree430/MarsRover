package com.Jayshree.MarsRoverTest;

import com.Jayshree.MarsRover.Plateau;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauTest {
    Plateau plateau;

    @Test
    public void assertZeroPlateauValueXY() {
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
    public void assertMinusPlateauValueXY() {
        String exceptionMessage = "";
        String message = "Plateau size must be greater than zero";
        try {
            Plateau plateau = new Plateau(-5, -2);
        } catch (Exception exception) {
            exceptionMessage = exception.getMessage();
        }
        assertEquals(message, exceptionMessage);
    }
}
