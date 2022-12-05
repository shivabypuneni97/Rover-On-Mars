package com.Mars.NASA.constant;

public enum Commands {

    LEFT('L'),
    RIGHT('R'),

    MOVE_FORWARD('M');

    private char value;

    public char asChar() {

        return value;
    }
    Commands(char value){
        this.value = value;
    }
}
