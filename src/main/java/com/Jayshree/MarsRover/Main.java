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
}
