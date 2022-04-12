package com.Jayshree.MarsRover;

public class Rover {

    private int posX;
    private int posY;
    Direction d;

    public Rover(int posX, int posY, Direction d) throws IllegalArgumentException{
        if(posX <= 0 || posY <= 0){
            throw new IllegalArgumentException("Position should be greater than Zero");
        }
        this.posX = posX;
        this.posY = posY;
        this.d = d;
    }

}
