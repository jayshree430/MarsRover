package com.Jayshree.MarsRover;

public class Plateau {
    public final int X_MIN = 0;
    public final int Y_MIN = 0;
    public int xmax ;
    public int ymax ;

    public Plateau(int x, int y) throws Exception {
        if (x <= X_MIN || y <= Y_MIN){
             throw new Exception("Plateau size must be greater than zero");
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
        String result = "";
        // Check the direction then check if the vehicle would go over the edge
        if (d == Direction.NORTH && y >= this.ymax) {
            return "Cannot move further. Vehicle over edge";
        }else if (d == Direction.EAST && x >= this.xmax) {
            return "Cannot move further. Vehicle over edge";
        } else if (d == Direction.SOUTH && y <= this.Y_MIN) {
            return "Cannot move further. Vehicle over edge";
        } else if (d == Direction.WEST && x <= this.X_MIN) {
            return "Cannot move further. Vehicle over edge";
        }
        return "Can move further.";
    }
}
