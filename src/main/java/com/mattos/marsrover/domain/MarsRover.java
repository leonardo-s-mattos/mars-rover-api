package com.mattos.marsrover.domain;

public class MarsRover {

    private int x;
    private int y;
    private final String cardinal;

    private static final String MOVE_COMMAND = "M";
    private static final String NORTH = "N";
    private static final String SOUTH = "S";
    private static final String WEST = "W";
    private static final String EAST = "E";

    public MarsRover(int x, int y, String cardinal) {
        this.x = x;
        this.y = y;
        this.cardinal = cardinal;
    }

    public String execute(String instructions) {

        String[] individualInstructions = instructions.split("");

        for (String instruction:individualInstructions) {
            if (instruction.equals(MOVE_COMMAND)) {
                move();
            }
        }
        return formatCoordinate();
    }

    private String formatCoordinate() {
        return String.format("%d %d %s", x, y, cardinal);
    }

    private boolean facing(String direction) {
        return this.cardinal.equals(direction);
    }

    private void move(){
        if (facing(NORTH)) y++;
        if (facing(SOUTH)) y--;
    }

}
