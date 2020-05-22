package com.mattos.marsrover.api;

import com.intuit.karate.junit5.Karate;

public class KarateTests {

    @Karate.Test
    Karate validCommand(){
        return Karate.run().feature("validCommand").tags("RightRotation", "LeftRotation").relativeTo(getClass());
    }

    @Karate.Test
    Karate repeatCommand(){
        return Karate.run().feature("repeatCommand").tags("Repeat").relativeTo(getClass());
    }

    @Karate.Test
    Karate invalidCommand(){
        return Karate.run().feature("invalidCommand").tags("Invalid").relativeTo(getClass());
    }
}
