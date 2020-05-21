package com.mattos.marsrover.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MarsRoverShould {

    @ParameterizedTest
    @CsvSource({"1, 2, N, '1 2 N'",
                "1, 3, N, '1 3 N'"})
    void returnInitialPosition_whenEmptyCommand(int initialX, int initialY, String initialCardinal, String expectedCoordinate) {
        final String emptyCommand = "";
        final MarsRover rover = new MarsRover(initialX, initialY, initialCardinal);

        final String actualCoordinate = rover.execute(emptyCommand);

        assertThat(actualCoordinate, is(expectedCoordinate));
    }

}
