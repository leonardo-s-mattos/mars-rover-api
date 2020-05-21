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

    private static final int UP = 1;
    private static final int DOWN = -1;
    private static final int RIGHT = 1;
    private static final int LEFT = -1;

    private static final String COORDINATE_FORMAT = "%d %d %s";
    private static final String INTO_CHARACTERS = "";

    public MarsRover(int x, int y, String cardinal) {
        this.x = x;
        this.y = y;
        this.cardinal = cardinal;
    }

    public String execute(String instructions) {

        String[] individualInstructions = instructions.split(INTO_CHARACTERS);

        for (String instruction:individualInstructions) {
            if (instruction.equals(MOVE_COMMAND)) {
                move();
            }
        }
        return formatCoordinate();
    }

    private String formatCoordinate() {
        return String.format(COORDINATE_FORMAT, x, y, cardinal);
    }

    private boolean facing(String direction) {
        return this.cardinal.equals(direction);
    }

    private void move(){
        if (facing(NORTH)) moveVertically(UP);
        if (facing(SOUTH)) moveVertically(DOWN);
        if (facing(EAST)) moveHorizontally(RIGHT);
        if (facing(WEST)) moveHorizontally(LEFT);
    }

    private void moveVertically(int stepSize) {
        y += stepSize;
    }

    private void moveHorizontally(int stepSize) {
        x += stepSize;
    }

}
