package com.Mars.NASA.constant;

public enum Directions {

    NORTH('N'),

    EAST('E'),

    WEST('W'),

    SOUTH('S');


    public char asChar() {
        return value;
    }

    public String asString(){
        return Character.toString(value);
    }



    private char value;

    Directions(char value){
        this.value = value;
    }

}
