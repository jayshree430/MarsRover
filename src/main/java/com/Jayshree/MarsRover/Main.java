package com.Jayshree.MarsRover;

public class Main {
    public static void main(String[] args) {
        Plateau plateau = new Plateau(7, 7);
        Rover rover = new Rover(1, 1, Direction.SOUTH, plateau);

        System.out.println("Initial Position of the rover: x" + rover.getPosX() + " y" + rover.getPosY() + " " + rover.getDirection());
        String result = rover.processMovement("MMMLM");
        System.out.println("Position of the rover: x" + rover.getPosX() + " y" + rover.getPosY() + " " + rover.getDirection());
        System.out.println(result);
    }
}
