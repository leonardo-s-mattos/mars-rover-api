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
    returnInitialPosition_whenEmptyCommand(
            int initialX, int initialY, String initialCardinal,
            String expectedCoordinate
    ) {
        final String emptyCommand = "";
        final MarsRover rover = new MarsRover(initialX, initialY, initialCardinal);

        final String actualCoordinate = rover.execute(emptyCommand);

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
            String commands,
            String expectedCoordinate
    ) {
        final MarsRover rover = new MarsRover(initialX, initialY, initialCardinal);
        String actualCoordinate = rover.execute(commands);
        assertThat(actualCoordinate, is(expectedCoordinate));
    }

}
