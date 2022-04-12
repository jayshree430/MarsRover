package com.Jayshree.MarsRover;

public class Rover {

    private int posX;
    private int posY;
    Direction direction;
    private Plateau plateau;

    public Rover(int posX, int posY, Direction direction) throws IllegalArgumentException{
        if(posX <= 0 || posY <= 0){
            throw new IllegalArgumentException("Position should be greater than Zero");
        }
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
    }

    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
    public Direction getDirection(){
        return direction;
    }
    public String processMovement(String instruction){
        if (instruction == null || instruction.isEmpty() || instruction.equals(" ")){
            return "Instructions cannot be Empty or null";
        }
        if (!instruction.matches("^[LMRlmr]+$")) {
            return "Invalid Instructions. Please provide only L, R or M as input";
        }
        String[] instructionArray = instruction.split("");
        for (String input : instructionArray) {
            try {
                switch (input.toUpperCase()) {
                    case "L" -> goLeft();
                    case "R" -> goRight();
                    case "M" -> move();
                    default -> System.out.println("Something else? " + input);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return "Rover moved to new direction";
    }

    private void goLeft(){
        switch (direction) {
            case EAST -> direction = Direction.NORTH;
            case SOUTH -> direction = Direction.EAST;
            case WEST -> direction = Direction.SOUTH;
            case NORTH -> direction = Direction.WEST;
            default -> System.out.println("Direction = " + direction);
        }
    }

        private void goRight() {
            switch (direction) {
                case EAST -> direction = Direction.SOUTH;
                case SOUTH -> direction = Direction.WEST;
                case WEST -> direction = Direction.NORTH;
                case NORTH -> direction = Direction.EAST;
                default -> System.out.println("Direction = " + direction);
            }

        }
    private void move(){
        switch (direction) {
            // todo add edge checking
            case NORTH -> posY += 1;
            case EAST -> posX += 1;
            case SOUTH -> posY -= 1;
            case WEST -> posX -= 1;
        }
    }

}
