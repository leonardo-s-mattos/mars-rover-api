package com.mattos.marsrover.application.service;

import com.mattos.marsrover.input.port.InvalidCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class RoverControlServiceMust {

    RoverControlService target;

    @BeforeEach
    public void init(){
        target = new RoverControlService();
    }

    @ParameterizedTest
    @CsvSource({"0, 0, N, '0, 0, N'"})
    void
    doNothing_whenEmptyInstruction(
            int initialX, int initialY, String initialCardinal,
            String expectedCoordinate
    ) {
        //given
        final String emptyInstruction = "";

        //when
        final String actualCoordinate = target.execute(emptyInstruction);

        //then
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

        //when
        final String actualCoordinate = target.execute(instructions);

        //then
        assertThat(actualCoordinate, is(expectedCoordinate));
    }

    @Test
    public void
    complain_whenInstructionsArentSupported(){

        //when
        Throwable exception = assertThrows(InvalidCommandException.class, () -> {
           target.execute("AAA");
        });

        //then
        assertTrue(exception.getMessage().startsWith("Unsupported instruction"));

    }

    @Test
    public void
    complain_whenInstructionsDriveRoverOutOfBounds(){

        //when
        Throwable exception = assertThrows(InvalidCommandException.class, () -> {
            target.execute("MMMMMMMMMMMMMMMMMMM");
        });

        //then
        assertTrue(exception.getMessage().contains("outside Mars"));

    }
}