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

    public Rover(int posX, int posY, Direction direction, Plateau plateau) throws IllegalArgumentException{
        if(posX <= 0 || posY <= 0){
            throw new IllegalArgumentException("Position should be greater than Zero");
        }
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
        this.plateau = plateau;
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
        Direction d = this.direction;
        switch (d) {
            case EAST -> this.direction = Direction.NORTH;
            case SOUTH -> this.direction = Direction.EAST;
            case WEST -> this.direction = Direction.SOUTH;
            case NORTH -> this.direction = Direction.WEST;
            default -> System.out.println("Direction = " + d);
        }
    }

        private void goRight() {
        Direction d = this.direction;
            switch (d) {
                case EAST -> this.direction = Direction.SOUTH;
                case SOUTH -> this.direction = Direction.WEST;
                case WEST -> this.direction = Direction.NORTH;
                case NORTH -> this.direction = Direction.EAST;
                default -> System.out.println("Direction = " + d);
            }

        }
    private void move() throws Exception{
        String result = plateau.move(posX, posY, direction);
        if (result.equals("Cannot move further. Vehicle over edge")){
            throw new Exception("Rover has reached the Edge");
        }
        Direction d = this.direction;
        switch (d) {
            case NORTH -> this.posY += 1;
            case EAST -> this.posX += 1;
            case SOUTH -> this.posY -= 1;
            case WEST -> this.posX -= 1;
        }
    }

}
