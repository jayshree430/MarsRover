package com.Jayshree.MarsRover;

public class Plateau {
    public final int X_MIN = 0;
    public final int Y_MIN = 0;
    public int xmax ;
    public int ymax ;

    public Plateau(int x, int y) throws IllegalArgumentException {
        if (x <= X_MIN || y <= Y_MIN){
             throw new IllegalArgumentException("Plateau size must be greater than zero");
        }
        this.xmax = x;
        this.ymax = y;
    }

    public int getXmax() {
        return xmax;
    }
    public int getYmax(){
        return ymax;
    }

    public String move(int x, int y, Direction d){
        boolean result = edgeCheck(x,y,d);
        // Check the direction then check if the vehicle would go over the edge
        if (!result){
            return "Cannot move further. Vehicle over edge";
        }
        return "Can move further."; //Can do collision check here.Create a new method for collision check
    }

    public boolean edgeCheck(int x, int y, Direction d){

        return (d != Direction.NORTH || y < this.ymax) &&
                (d != Direction.EAST || x < this.xmax) &&
                (d != Direction.SOUTH || y > this.Y_MIN) &&
                (d != Direction.WEST || x > this.X_MIN);
    }
}
