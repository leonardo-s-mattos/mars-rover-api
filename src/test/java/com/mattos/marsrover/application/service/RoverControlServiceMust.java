package com.mattos.marsrover.application.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RoverControlServiceMust {

    @ParameterizedTest
    @CsvSource({"0, 0, N, '0, 0, N'"})
    void
    doNothing_whenEmptyInstruction(
            int initialX, int initialY, String initialCardinal,
            String expectedCoordinate
    ) {
        final String emptyInstruction = "";
        final RoverControlService roverControl = new RoverControlService();

        final String actualCoordinate = roverControl.execute(emptyInstruction);

        assertThat(actualCoordinate, is(expectedCoordinate));
    }

    @ParameterizedTest
    @CsvSource({
            "MMRMMRMM, '2, 0, S'",
            "MML, '0, 2, W'"
    })
    public void
    identifyDifferentInstructions_whenGivenASequenceOfCommands(
            String instructions,
            String expectedCoordinate
    ) {
        final RoverControlService roverControl = new RoverControlService();
        final String actualCoordinate = roverControl.execute(instructions);

        assertThat(actualCoordinate, is(expectedCoordinate));
    }
}