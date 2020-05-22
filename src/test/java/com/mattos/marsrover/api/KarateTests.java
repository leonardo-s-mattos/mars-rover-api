package com.mattos.marsrover.api;

import com.intuit.karate.junit5.Karate;

public class KarateTests {

    @Karate.Test
    Karate validCommand(){
        return Karate.run().feature("functional").tags("RightRotation", "LeftRotation").relativeTo(getClass());
    }

    @Karate.Test
    Karate repeatCommand(){
        return Karate.run().feature("functional").tags("Repeat").relativeTo(getClass());
    }

    @Karate.Test
    Karate invalidCommand(){
        return Karate.run().feature("functional").tags("Invalid").relativeTo(getClass());
    }
}
