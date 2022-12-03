package com.Mars.NASA.validator;

import org.springframework.stereotype.Service;

import java.util.MissingFormatArgumentException;

@Service
public class MarsValidator {

    boolean isValid = true;

    public String marsValidator(String plateauCor, String startPos, String moveCom) throws Exception {
        String invalid = null;
        if(plateauCor.length()< 3 || plateauCor.length() > 3){
            invalid = "Enter Valid Plateau Co-ordinates";
            return invalid;
        }
        if(startPos.length()< 5 || startPos.length() > 5){
            invalid = "Enter Valid Start Position";
            return invalid;
        }
        return invalid;
    }
}
