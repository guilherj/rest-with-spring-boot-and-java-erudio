package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMatchOperationException;
import br.com.erudio.helper.NumberConverter;
import br.com.erudio.service.MathOperations;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private MathOperations mathOperations;
	
	@RequestMapping(value = "/{operation}/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double operation(@PathVariable(value = "operation") String operation,
						    @PathVariable(value = "numberOne") String numberOne,
						    @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			
			throw new UnsupportedMatchOperationException("Please set a numeric value!");
		}
		
		
		return mathOperations.operations(operation, NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
		
	}
	
	
	@RequestMapping(value = "/squareRoot/{number}", method=RequestMethod.GET)
	public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {
		
		if(!NumberConverter.isNumeric(number)) {
			
			throw new UnsupportedMatchOperationException("Please set a numeric value!");
		}
		
		return  mathOperations.squareRoot(NumberConverter.convertToDouble(number));
		
	}
	
	
	

}
