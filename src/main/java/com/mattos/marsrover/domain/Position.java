package com.mattos.marsrover.domain;

class Position {
    private final int x;
    private final int y;
    private final String cardinal;

    Position(int x, int y, String cardinal) {
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

    public String cardinal() {
        return cardinal;
    }

    public static Position starting(){
        return new Position(0,0, "N");
    }
}
