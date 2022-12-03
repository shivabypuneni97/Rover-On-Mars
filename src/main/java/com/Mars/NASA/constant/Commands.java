package com.Mars.NASA.constant;

public enum Commands {

    LEFT('L'),
    RIGHT('R');

    public char asChar() {
        return value;
    }

    private char value;

    Commands(char value){
        this.value = value;
    }
}
