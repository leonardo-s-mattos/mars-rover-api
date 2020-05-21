package com.mattos.marsrover.domain;

public class MarsRover {

    private final int x;
    private final int y;
    private final String cardinal;

    public MarsRover(int x, int y, String cardinal) {
        this.x = x;
        this.y = y;
        this.cardinal = cardinal;
    }

    public String execute(String commands) {
        return formatCoordinate();
    }

    private String formatCoordinate() {
        return String.format("%d %d %s", x, y, cardinal);
    }

}
