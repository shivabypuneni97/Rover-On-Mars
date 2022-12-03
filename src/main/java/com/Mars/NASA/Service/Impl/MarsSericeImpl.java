package com.Mars.NASA.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.Mars.NASA.constant.Commands;
import com.Mars.NASA.constant.Directions;
import com.Mars.NASA.validator.MarsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Mars.NASA.Service.MarsService;



@Service
public class MarsSericeImpl implements MarsService {


	@Autowired
	private MarsValidator marsValidator;
	public String getLocation(String plateauCor, String startPos, String moveCom) throws Exception {

			String valid = marsValidator.marsValidator(plateauCor, startPos, moveCom);
			String finalLocation = null;
			if(valid == null) {


				String location;
				char returnedLocation;
				int platx;
				int platy;
				int startx;
				int starty;
				char tempD;
				List<Integer> temp = new ArrayList<Integer>();
				platx = Integer.parseInt(plateauCor.substring(0, 1));
				platy = Integer.parseInt(plateauCor.substring(2));
				startx = Integer.parseInt(startPos.substring(0, 1));
				starty = Integer.parseInt(startPos.substring(2, 3));
				String startD = startPos.substring(4);
				tempD = startD.charAt(0);
				returnedLocation = tempD;


				for (int i = 0; i < moveCom.length(); i++) {
					char[] tempA = moveCom.toCharArray();
					// if((startx <= platx) && (starty <= platy))

					char t = tempA[i];
					if (t == Commands.LEFT.asChar() || t == Commands.RIGHT.asChar()) {
						returnedLocation = rotate(returnedLocation, t);
					} else {
						List<Integer> returnedNumberList = moveDirection(returnedLocation, startx, starty);

						if (returnedNumberList.get(0) > platx || returnedNumberList.get(1) > platy) {
							return "Rover coordinates exceeds plateau range";
						} else {
							startx = returnedNumberList.get(0);
							starty = returnedNumberList.get(1);

						}

					}
				}


				String tempx = Integer.toString(startx);
				String tempy = Integer.toString(starty);
				finalLocation = tempx.concat(tempy).concat(String.valueOf(returnedLocation));
			}
			else {
				finalLocation = valid;
			}
			return finalLocation;

    }
	
		
	  private List<Integer> moveDirection(char returnedLocation, int startx, int starty){
		List<Integer> numberList = new ArrayList<Integer>();
				   
		if(returnedLocation == Directions.WEST.asChar())
			{
				startx = startx-1;
			}
		else if (returnedLocation == Directions.EAST.asChar() )
			{
				startx = startx +1;
			}
		else if (returnedLocation == Directions.NORTH.asChar())
			{
				starty = starty +1;
			}
		else if (returnedLocation == Directions.SOUTH.asChar())
			{
				starty = starty - 1;
			}
			numberList.add( 0, startx);
			numberList.add( 1, starty);
			return numberList;
	    }
	

      	private char rotate(char location, char move){
			char returnLocation='X';
             if(location == Directions.NORTH.asChar())
			 	{
            	    if (move == Commands.LEFT.asChar())
            	        {
                    	   returnLocation=Directions.WEST.asChar();
                        }
                    else {
                    	    returnLocation=Directions.EAST.asChar();
					}
				 }
             else if (location == Directions.SOUTH.asChar())
                    {
                       if (move == Commands.LEFT.asChar())
                       {
                    		returnLocation =Directions.EAST.asChar();
                        }
                    else
                       {
                    		returnLocation =Directions.WEST.asChar();
                       }
                    }
              else if(location == Directions.EAST.asChar())
                  {
                     if (move == Commands.LEFT.asChar())
                     {
                  		returnLocation = Directions.NORTH.asChar();
                      }
                  else
                     {
                  		returnLocation =Directions.SOUTH.asChar();
                     }
                }
			  else if(location == Directions.WEST.asChar())
              {
                 if (move == Commands.LEFT.asChar())
                 {
              		returnLocation =Directions.SOUTH.asChar();
                  }
                 else
                 {
              		returnLocation =Directions.NORTH.asChar();
                 }
            }
             
           return returnLocation;  
              
      	}
      	
}
				     
		
		
		


