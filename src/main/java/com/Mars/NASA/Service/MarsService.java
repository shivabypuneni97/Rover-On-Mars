package com.Mars.NASA.Service;

import org.springframework.stereotype.Service;

@Service
public interface MarsService {

	String getLocation(String plateauCor, String startPos, String moveCom) throws Exception;
	
	
	

}
