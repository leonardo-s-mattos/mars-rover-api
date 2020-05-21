package com.mattos.marsrover.domain;

public class Position {

    private static final String COORDINATE_FORMAT = "%d, %d, %s";

    private final int x;
    private final int y;
    private final Cardinal cardinal;

    Position(int x, int y, Cardinal cardinal) {
        this.x = x;
        this.y = y;
        this.cardinal = cardinal;
    }

    public int X() {
        return x;
    }

    public int Y() {
        return y;
    }

    public Cardinal cardinal() {
        return cardinal;
    }

    public static Position starting(){
        return new Position(0,0, new Cardinal.North());
    }

    public String formatCoordinate() {
        return String.format(COORDINATE_FORMAT, X(), Y(), cardinal());
    }
}
