package com.mattos.marsrover.input.adapter;

import com.mattos.marsrover.input.port.MoveUseCasePort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/mars")
public class MarsController {

    private final MoveUseCasePort port;

    public MarsController(MoveUseCasePort port){
        this.port = port;
    }

    @PostMapping(value="/{instructions}")
    public String executeInstructions(
            @PathVariable("instructions") String instructions
    ){
            return port.execute(instructions);

    }
}
