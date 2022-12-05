package com.Mars.NASA.validator;

import com.Mars.NASA.constant.Commands;
import com.Mars.NASA.constant.Directions;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.MissingFormatArgumentException;



@Service
public class MarsValidator {

    boolean isValid = true;

    public String marsValidator(String plateauCor, String startPos, String moveCom) throws Exception {
        String invalid = null;

        if(plateauCor.length() != 3 || !Character.isDigit(plateauCor.substring(0,1).charAt(0))
                              || !Character.isDigit(plateauCor.substring(2).charAt(0))){
            invalid = "Error Message: Enter Valid Plateau Co-ordinates";
            return invalid;
        }

        if(plateauCor.length()< 3 || plateauCor.length() > 3){
            invalid = "Error Message: Enter Valid Plateau Co-ordinates";
            return invalid;
        }

        if((startPos.length() != 5 ) || !Character.isDigit(startPos.substring(0, 1).charAt(0))
                || !Character.isDigit(startPos.substring(2, 3).charAt(0))
                || Character.isDigit(startPos.substring(4).charAt(0)) ) {
            invalid = "Error Message: Enter Valid Start Position";
            return invalid;
        }

        boolean isValidStartPosition = Arrays.stream(Directions.values())
                .map(Directions::asString)
                .anyMatch(startPos.substring(4)::equals);

        if(!isValidStartPosition){
            invalid = "Error Message: Enter Valid Start Position";
            return invalid;
        }
        if(moveCom.length()<1){
            invalid = "Error Message: Enter Valid Commands";
            return invalid;
        }

        for (int i = 0; i < moveCom.length(); i++) {
            char[] tempA = moveCom.toCharArray();
            char t = tempA[i];
            if ( !(t == Commands.LEFT.asChar())){
                if(!(t == Commands.RIGHT.asChar())){
                    if(!(t == Commands.MOVE_FORWARD.asChar())){
                        invalid = "Error Message: Enter Valid Commands";
                        return invalid;
                    }
                }
            }
        }

        return invalid;
    }
}
