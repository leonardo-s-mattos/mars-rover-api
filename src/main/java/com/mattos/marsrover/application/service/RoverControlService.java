package com.mattos.marsrover.application.service;

import com.mattos.marsrover.domain.Rover;
import com.mattos.marsrover.domain.Position;
import com.mattos.marsrover.input.port.InvalidCommandException;
import com.mattos.marsrover.input.port.MoveUseCasePort;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mars")
public class RoverControlService implements MoveUseCasePort {

    private static final String INTO_CHARACTERS = "";
    private static final String MOVE_COMMAND = "M";
    private static final String TURN_LEFT = "L";
    private static final String TURN_RIGHT = "R";

    @Setter
    @Value("${width:5}")
    private int marsWidth;

    @Setter
    @Value("${height:5}")
    private int marsHeight;

    private Rover rover;

    public RoverControlService(){
        super();
    }

    public RoverControlService(int marsWidth, int marsHeight){
        this.marsHeight = marsHeight;
        this.marsWidth = marsWidth;
    }

    @Override
    public String execute(String instructions) {

        String[] individualInstructions = instructions.split(INTO_CHARACTERS);

        deployRover();

        if (!instructions.isEmpty()) {
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

    private boolean isRoverOutOfBounds(Position position) {

        return (position.X() < 0 || position.X() >= marsWidth) ||
                (position.Y() < 0 || position.Y() >= marsHeight);

    }

    private void deployRover(){
        rover = new Rover();
    }


}
