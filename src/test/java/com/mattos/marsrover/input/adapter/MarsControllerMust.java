package com.mattos.marsrover.input.adapter;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mattos.marsrover.input.port.InvalidCommandException;
import com.mattos.marsrover.input.port.MoveUseCasePort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = MarsController.class)
public class MarsControllerMust {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MoveUseCasePort mockPort;

    @Test
    public void
    sendInstructions() throws Exception{

        given(mockPort.execute("MML")).willReturn("0, 2, W");

        mockMvc.perform(post("/rest/mars/{instructions}", "MML"))
                .andExpect(status().isOk());

        then(mockPort).should()
                .execute(eq("MML"));
    }

    @Test
    public void
    returnTheCorrectError_whenInvalidRequest() throws Exception{

        given(mockPort.execute("AAA")).willThrow(InvalidCommandException.class);

        then(mockMvc.perform(post("/rest/mars/{instructions}", "AAA"))
                .andExpect(status().isBadRequest())
        );

    }


}
