package com.mattos.marsrover.domain;

public class MarsRover {

    private Position position;

    private static final String MOVE_COMMAND = "M";
    private static final String TURN_LEFT = "L";
    private static final String TURN_RIGHT = "R";

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

    public MarsRover(Position position) {
        this.position = position;
    }

    public MarsRover() {
        this.position = Position.starting();
    }

    public String execute(String instructions) {

        String[] individualInstructions = instructions.split(INTO_CHARACTERS);

        for (String instruction:individualInstructions) {
            if (instruction.equals(MOVE_COMMAND)) move();
            if (instruction.equals(TURN_LEFT)) position = turnLeft();
            if (instruction.equals(TURN_RIGHT)) position = turnRight();
        }
        return formatCoordinate();
    }

    private String formatCoordinate() {
        return String.format(COORDINATE_FORMAT, position.X(), position.Y(), position.cardinal());
    }

    private boolean facing(String direction) {
        return this.position.cardinal().equals(direction);
    }

    private void move(){
        if (facing(NORTH)) moveVertically(UP);
        if (facing(SOUTH)) moveVertically(DOWN);
        if (facing(EAST)) moveHorizontally(RIGHT);
        if (facing(WEST)) moveHorizontally(LEFT);
    }

    private void moveVertically(int stepSize) {
        position = new Position(position.X(), position.Y()+stepSize, position.cardinal());
    }

    private void moveHorizontally(int stepSize) {
        position = new Position(position.X()+stepSize, position.Y(), position.cardinal());
    }

    private Position turnLeft(){
        if (facing(NORTH)) return new Position(position.X(), position.Y(), WEST);
        if (facing(SOUTH)) return new Position(position.X(), position.Y(), EAST);
        if (facing(EAST)) return new Position(position.X(), position.Y(), NORTH);
        return new Position(position.X(), position.Y(), SOUTH);
    }

    private Position turnRight(){
        if (facing(NORTH)) return new Position(position.X(), position.Y(), EAST);
        if (facing(SOUTH)) return new Position(position.X(), position.Y(), WEST);
        if (facing(EAST)) return new Position(position.X(), position.Y(), SOUTH);
        return new Position(position.X(), position.Y(), NORTH);
    }

}
