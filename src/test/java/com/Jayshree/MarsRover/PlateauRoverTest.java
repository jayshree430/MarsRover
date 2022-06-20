package com.Jayshree.MarsRover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlateauRoverTest {

    //Testing Complete implementation of rover and plateau
    @Test
    public void checkPlateauRover(){
        PlateauRoverFunctions plateau = new Plateau(5,5);
        Rover rover = null;
        try{
            Status status = plateau.checkEdgeCoordinates(3,3,Direction.EAST);
            if (status == Status.NO_ERROR){
                rover = plateau.getRoverByCoordinates(3,3);
                if (rover == null){
                    rover = new Rover(3,3,Direction.EAST, plateau);
                }
            }
            status = rover.processMovement( "MMRMMRMRRM");

            Assertions.assertEquals(5, rover.getPosX());
            Assertions.assertEquals(1, rover.getPosY());

        }catch (Exception e){
            System.out.println(e);
        }


    }
}
