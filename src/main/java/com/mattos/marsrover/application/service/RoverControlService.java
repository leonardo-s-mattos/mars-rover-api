package com.mattos.marsrover.application.service;

import com.mattos.marsrover.domain.MarsRover;
import com.mattos.marsrover.input.port.MoveUseCasePort;

public class RoverControlService implements MoveUseCasePort {

    private static final String INTO_CHARACTERS = "";
    private static final String MOVE_COMMAND = "M";
    private static final String TURN_LEFT = "L";
    private static final String TURN_RIGHT = "R";

    @Override
    public String execute(String instructions) {

        validateInstructions(instructions);

        String[] individualInstructions = instructions.split(INTO_CHARACTERS);

        MarsRover rover = new MarsRover();

        for (String instruction:individualInstructions) {
            if (instruction.equals(MOVE_COMMAND))
                rover.move();
            if (instruction.equals(TURN_LEFT))
                rover.turnLeft();
            if (instruction.equals(TURN_RIGHT))
                rover.turnRight();
        }

        return rover.giveCurrentPosition();
    }


    private void validateInstructions(String givenInstructions){

    }
}
