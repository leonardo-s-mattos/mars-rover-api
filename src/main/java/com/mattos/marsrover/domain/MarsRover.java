package com.mattos.marsrover.domain;

public class MarsRover {

    private Position position;

    private static final int UP = 1;
    private static final int DOWN = -1;
    private static final int RIGHT = 1;
    private static final int LEFT = -1;

    public MarsRover(Position position) {
        this.position = position;
    }

    public MarsRover() {
        this.position = Position.starting();
    }

    public void move() {
        if (facing(Cardinal.NORTH)) moveVertically(UP);
        if (facing(Cardinal.SOUTH)) moveVertically(DOWN);
        if (facing(Cardinal.EAST)) moveHorizontally(RIGHT);
        if (facing(Cardinal.WEST)) moveHorizontally(LEFT);
    }

    private void moveVertically(int stepSize) {
        position = new Position(position.X(), position.Y() + stepSize, position.cardinal());
    }

    private void moveHorizontally(int stepSize) {
        position = new Position(position.X() + stepSize, position.Y(), position.cardinal());
    }

    public void turnLeft() {
        position = new Position(position.X(), position.Y(), position.cardinal().left());
    }

    public void turnRight() {
        position = new Position(position.X(), position.Y(), position.cardinal().right());
    }

    public Position giveCurrentPosition() {
        return position;
    }

    private boolean facing(String givenDirection) {
        return this.position.cardinal().name().equals(givenDirection);
    }
}
