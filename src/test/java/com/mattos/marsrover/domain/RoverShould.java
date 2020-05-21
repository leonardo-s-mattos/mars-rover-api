package com.mattos.marsrover.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RoverShould {

    @ParameterizedTest
    @CsvSource({
            "1, 2, N, '1, 3, N'",
            "1, 1, S, '1, 0, S'",
            "2, 1, E, '3, 1, E'",
            "3, 1, W, '2, 1, W'",
    })
    void
    move(
            int initialX, int initialY, String initialCardinal,
            String expectedCoordinate
    ) {
        final Rover rover = new Rover(new Position(initialX, initialY, Cardinal.cardinalFor(initialCardinal)));
        rover.move();
        String actualCoordinate = rover.currentPosition().formatCoordinate();
        assertThat(actualCoordinate, is(expectedCoordinate));
    }

    @ParameterizedTest
    @CsvSource({
            "N, W",
            "W, S",
            "S, E",
            "E, N",
    })
    void turn90DegreesLeft_thenFaceTheNextLeftCardinal(
            String initialCardinal,
            String expectedCardinal) {

        final String expectedPosition = "1, 1, " + expectedCardinal;
        final Rover rover = new Rover(new Position(1, 1, Cardinal.cardinalFor(initialCardinal)));

        rover.turnLeft();
        final String actualPosition = rover.currentPosition().formatCoordinate();

        assertThat(actualPosition, is(expectedPosition));
    }

    @ParameterizedTest
    @CsvSource({
            "N, E",
            "E, S",
            "S, W",
            "W, N",
    })
    void turn90DegreesRight_thenFaceTheNextRightCardinal(
            String initialCardinal,
            String expectedCardinal) {

        final String expectedPosition = "1, 1, " + expectedCardinal;
        final Rover rover = new Rover(new Position(1, 1, Cardinal.cardinalFor(initialCardinal)));
        rover.turnRight();
        final String actualPosition = rover.currentPosition().formatCoordinate();

        assertThat(actualPosition, is(expectedPosition));
    }

}
