package com.nathanducey.main;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class PrimeController {
	
	private PrimeService pService = new PrimeService();	
	
	@RequestMapping(value="/findPrimes", method=RequestMethod.POST,
			produces = "application/json")
	@ResponseBody
    public PrimeOutput findPrimes(@RequestBody PrimeInput pInput) {
		PrimeOutput pOutput = new PrimeOutput();
		
		pOutput.setPrimes(pService.findPrimes(pInput.getInputVal()));
		
		return pOutput;
    }

    

}
