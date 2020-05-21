package com.mattos.marsrover.input.port;

public class InvalidCommandException extends RuntimeException {

    public InvalidCommandException(String message){
        super(message);
    }
}
