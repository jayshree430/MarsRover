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
}
