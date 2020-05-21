package com.mattos.marsrover.domain;

public class Mars {

    private int width;
    private int height;

    public Mars(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean isOnMars( int givenX, int givenY){
        return (givenX >= 0 && givenX < width) &&
                (givenY < 0 || givenY > height);

    }
}
