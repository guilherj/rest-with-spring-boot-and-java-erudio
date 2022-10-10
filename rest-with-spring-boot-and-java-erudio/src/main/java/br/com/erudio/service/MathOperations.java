package br.com.erudio.service;

import org.springframework.stereotype.Service;

@Service
public class MathOperations {

	public Double operations(String operation, Double numberOne, Double numberTwo) {

		Double result;

		switch (operation) {

		case "sum":

			result = numberOne + numberTwo;
			break;

		case "subtraction":

			result = numberOne - numberTwo;
			break;

		case "multiplication":

			result = numberOne * numberTwo;
			break;
			
		case "division":

			result = numberOne / numberTwo;
			break;
			
		case "mean":

			result = (numberOne + numberTwo) / 2;
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + operation);
		}
		
		return result;
	}
	
	
	public Double squareRoot(Double number) {
		
		return Math.sqrt(number);
	}

}
