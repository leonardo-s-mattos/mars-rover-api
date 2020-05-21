package com.mattos.marsrover.domain;

public abstract class Cardinal {

    public static final String NORTH = "N";
    public static final String SOUTH = "S";
    public static final String WEST = "W";
    public static final String EAST = "E";

    public abstract Cardinal left();
    public abstract Cardinal right();
    public abstract String name();

    public static class North extends Cardinal{
        public String name() { return  "N"; }
        public Cardinal left(){ return new Cardinal.West(); }
        public Cardinal right(){ return new Cardinal.East(); }

    }

    public static class South extends Cardinal{
        public String name() { return  "S"; }
        public Cardinal left(){ return new Cardinal.East(); }
        public Cardinal right(){ return new Cardinal.West(); }

    }

    public static class East extends Cardinal{
        public String name() { return  "E"; }
        public Cardinal left(){ return new Cardinal.North(); }
        public Cardinal right(){ return new Cardinal.South(); }

    }

    public static class West extends Cardinal{
        public String name() { return  "W"; }
        public Cardinal left(){ return new Cardinal.South(); }
        public Cardinal right(){ return new Cardinal.North(); }

    }

    public static Cardinal cardinalFor(String cardinalName){
        Cardinal result = null;
        switch (cardinalName){
            case NORTH: result =  new North(); break;
            case SOUTH: result =  new South(); break;
            case EAST: result =  new East(); break;
            case WEST: result =  new West(); break;
        }

        return result;
    }

    @Override
    public String toString(){
        return name();
    }

}
