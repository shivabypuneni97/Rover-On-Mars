package com.Mars.NASA.Controller;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Mars.NASA.Service.MarsService;



@Controller

public class MarsController {
	
	

	@Autowired
	private MarsService marsService;
	
	
	@GetMapping("/rover")
	public ResponseEntity<String> getLocation (@NotNull @RequestParam ("plateauCor") String plateauCor, @RequestParam (required = false, name= "startPos") String startPos,
	                   @RequestParam(required = false, name="moveCom") String moveCom) throws Exception {
	String returnedLocation = marsService.getLocation(plateauCor,startPos,moveCom);
	if(returnedLocation.length() >3){
		return ResponseEntity.badRequest().body(returnedLocation);
	}
	return ResponseEntity.ok().body(returnedLocation);

}
}
