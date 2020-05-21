package com.mattos.marsrover.application.service;

import com.mattos.marsrover.domain.Mars;
import com.mattos.marsrover.domain.Rover;
import com.mattos.marsrover.domain.Position;
import com.mattos.marsrover.input.port.InvalidCommandException;
import com.mattos.marsrover.input.port.MoveUseCasePort;

public class RoverControlService implements MoveUseCasePort {

    private static final String INTO_CHARACTERS = "";
    private static final String MOVE_COMMAND = "M";
    private static final String TURN_LEFT = "L";
    private static final String TURN_RIGHT = "R";

    @Override
    public String execute(String instructions) {

        String[] individualInstructions = instructions.split(INTO_CHARACTERS);

        Rover rover = new Rover();

        if(!instructions.isEmpty()) {
            for (String instruction : individualInstructions) {
                switch (instruction) {
                    case MOVE_COMMAND:
                        rover.move();
                        if (isRoverOutOfBounds(rover.currentPosition()))
                            throw new InvalidCommandException("Instructions drove rover outside Mars");
                        break;
                    case TURN_LEFT:
                        rover.turnLeft();
                        break;
                    case TURN_RIGHT:
                        rover.turnRight();
                        break;
                    default:
                        throw new InvalidCommandException("Unsupported instruction. Only M, R or L combinations are valid");
                }
            }
        }
        return rover.currentPosition().formatCoordinate();
    }

    private boolean isRoverOutOfBounds(Position position){
        return new Mars(5,5).isOnMars(position.X(), position.Y());
    }


}