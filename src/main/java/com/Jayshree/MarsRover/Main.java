package com.Jayshree.MarsRover;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {

        System.out.println("Welcome to Mars!");
        System.out.print("Please enter the size of Plateau. Enter two numbers separated by a space: ");
        int[] plateauSize = getCommandNumbers();
        Plateau plateau = new Plateau(plateauSize[0], plateauSize[1]);
        do {
            System.out.print("Enter the vehicle coordinates (x y) separated by a space: ");
            int[] coords = getCommandNumbers();

            Rover rover = new Rover(coords[0], coords[1], getDirection(), plateau);

            System.out.print("Enter the vehicle instructions - L/R/M : ");

            if (rover.processMovement(getCommand()).equals("Invalid Instructions. Please provide only L, R or M as input")) {
                System.out.println("Movement string can only contain the letters LRM.");
            }
            System.out.println(rover.getPosX() + " " + rover.getPosY() + " " + rover.getDirection());
        } while (addAnotherVehicle());
        System.out.println("Thank you for visiting Mars");
    }
    public static int[] getCommandNumbers(){
        String size;
        boolean hasSize = false;
        do {
            size = getCommand();
            if (!size.matches("^[0-9]+( [0-9]+)")) {
                System.out.println("Must be two numbers separated by a single space.");
            }
            else{
                hasSize = true;
            }
        } while (!hasSize);
        String[] plateauSize = size.split(" ");
        return new int[]{Integer.parseInt(plateauSize[0]), Integer.parseInt(plateauSize[1])};
    }
    private static String getCommand() {
        String movement = "";
        try {
            movement = reader.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return movement;
    }

    private static Direction getDirection() {
        System.out.print("Enter the direction the rover is facing - N/S/E/W: ");
        String direction;
        boolean haveResponse = false;
        do {
            direction = getCommand();
            if (direction.matches("^[nsew|NSEW]")) haveResponse = true;
            else System.out.println("Must be single character: N/S/E/W ");
        } while (!haveResponse);
        return switch (direction.toLowerCase()) {
            case "n" -> Direction.NORTH;
            case "e" -> Direction.EAST;
            case "s" -> Direction.SOUTH;
            default -> Direction.WEST;
        };
    }
    private static boolean addAnotherVehicle() {
        String response;
        boolean haveResponse = false;
        do {
            System.out.print("Would you like to add another vehicle? y/n: ");
            response = getCommand();
            if (response.matches("^[yn]")) haveResponse = true;
            else System.out.println("Must be either y or n");
        } while (!haveResponse);
        return response.equals("y");
    }
}
