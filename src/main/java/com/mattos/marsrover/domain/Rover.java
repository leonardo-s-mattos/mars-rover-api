package com.mattos.marsrover.domain;

import static com.mattos.marsrover.domain.Cardinal.*;

public class Rover {

    private Position position;

    private static final int UP = 1;
    private static final int DOWN = -1;
    private static final int RIGHT = 1;
    private static final int LEFT = -1;

    public Rover(Position position) {
        this.position = position;
    }

    public Rover() {
        this.position = Position.starting();
    }

    public void move() {
        if (isFacing(NORTH)) moveVertically(UP);
        if (isFacing(SOUTH)) moveVertically(DOWN);
        if (isFacing(EAST)) moveHorizontally(RIGHT);
        if (isFacing(WEST)) moveHorizontally(LEFT);
    }

    public void turnLeft() {
        position = new Position(position.X(), position.Y(), position.cardinal().left());
    }

    public void turnRight() {
        position = new Position(position.X(), position.Y(), position.cardinal().right());
    }

    public Position currentPosition() {
        return position;
    }

    private boolean isFacing(String givenDirection) {
        return this.position.cardinal().name().equals(givenDirection);
    }

    private void moveVertically(int stepSize) {
        position = new Position(position.X(), position.Y() + stepSize, position.cardinal());
    }

    private void moveHorizontally(int stepSize) {
        position = new Position(position.X() + stepSize, position.Y(), position.cardinal());
    }
}
