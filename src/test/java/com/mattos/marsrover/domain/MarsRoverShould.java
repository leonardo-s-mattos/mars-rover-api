package com.mattos.marsrover.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

public class MarsRoverShould {

    @Test
    void return_initial_position_of_rover_without_any_command() {
        final String emptyCommand = "";

        assertThat(new MarsRover(1,2,"N").execute(emptyCommand),
                is("1 2 N"));
    }

}
