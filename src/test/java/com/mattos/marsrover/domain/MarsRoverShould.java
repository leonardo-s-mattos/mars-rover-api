package com.mattos.marsrover.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarsRoverShould {

    @ParameterizedTest
    @CsvSource({"1, 2, N, '1 2 N'",
            "1, 3, N, '1 3 N'"})
    void
    doNothing_whenEmptyInstruction(
            int initialX, int initialY, String initialCardinal,
            String expectedCoordinate
    ) {
        final String emptyInstruction = "";
        final MarsRover rover = new MarsRover(new Position(initialX, initialY, initialCardinal));

        final String actualCoordinate = rover.execute(emptyInstruction);

        assertThat(actualCoordinate, is(expectedCoordinate));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, N, M, '1 3 N'",
            "1, 1, N, MM, '1 3 N'",
            "0, 0, N, MMMM, '0 4 N'",
            "1, 1, S, M, '1 0 S'",
            "2, 1, E, M, '3 1 E'",
            "3, 1, W, MM, '1 1 W'",
    })
    void
    move(
            int initialX, int initialY, String initialCardinal,
            String instructions,
            String expectedCoordinate
    ) {
        final MarsRover rover = new MarsRover(new Position(initialX, initialY, initialCardinal));
        String actualCoordinate = rover.execute(instructions);
        assertThat(actualCoordinate, is(expectedCoordinate));
    }

    @ParameterizedTest
    @CsvSource({
            "N, R, E",
            "E, R, S",
            "S, R, W",
            "W, R, N",
            "N, L, W",
            "W, L, S",
            "S, L, E",
            "E, L, N",
    })
    void turn(
            String initialCardinal,
            String instructions,
            String expectedCardinal) {

        final String expectedPosition = "1 1 " + expectedCardinal;
        final MarsRover rover = new MarsRover(new Position(1, 1, initialCardinal));

        final String actualPosition = rover.execute(instructions);

        assertThat(actualPosition, is(expectedPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, N, LMLMLMLMM, '1 3 N'",
    })
    public void
    moveAndTurn(
            int initialX, int initialY, String initialCardinal,
            String commands,
            String expectedCoordinate
    ) {
        final Position initialPosition = new Position(initialX, initialY, initialCardinal);
        final MarsRover rover = new MarsRover(initialPosition);

        String actualCoordinate = rover.execute(commands);

        assertThat(actualCoordinate, is(expectedCoordinate));
    }
}
