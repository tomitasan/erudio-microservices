package br.com.erudio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Person;
import br.com.erudio.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
//	private SimpleMath math = new SimpleMath();
	
	@Autowired
	private PersonServices service;
	
	@RequestMapping(method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return service.findAll();
	}	
	
	@RequestMapping(value="/{id}",
			method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") String id) {
		return service.findById(id);
	}	
	
	@RequestMapping(method=RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person) {
		return service.create(person);
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person) {
		return service.update(person);
	}	
	
	@RequestMapping(value="/{id}", 
			method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	
//	@RequestMapping(value="/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET)
//	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
//		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
//		{
//			throw new UnsupportedMathOperationException("Please set a numeric value!");
//		}
//		return math.sum(NumberConverter.convertToNumber(numberOne), NumberConverter.convertToNumber(numberTwo));		
//	}
	
//	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}",method=RequestMethod.GET)
//	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
//		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
//		{
//			throw new UnsupportedMathOperationException("Please set a numeric value!");
//		}
//		return math.subtraction(NumberConverter.convertToNumber(numberOne), NumberConverter.convertToNumber(numberTwo));		
//	}
//	
//	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}",method=RequestMethod.GET)
//	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
//		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
//		{
//			throw new UnsupportedMathOperationException("Please set a numeric value!");
//		}
//		return math.multiplication(NumberConverter.convertToNumber(numberOne), NumberConverter.convertToNumber(numberTwo));		
//	}
//	
//	@RequestMapping(value="/division/{numberOne}/{numberTwo}",method=RequestMethod.GET)
//	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
//		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
//		{
//			throw new UnsupportedMathOperationException("Please set a numeric value!");
//		}
//		if (NumberConverter.convertToNumber(numberTwo) != 0) {
//			
//			return math.division(NumberConverter.convertToNumber(numberOne), NumberConverter.convertToNumber(numberTwo));
//		}
//		else {
//			throw new UnsupportedMathOperationException("Please set a value different of zero to number two");
//		}
//	}
//	
//	@RequestMapping(value="/mean/{numberOne}/{numberTwo}",method=RequestMethod.GET)
//	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
//		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
//		{
//			throw new UnsupportedMathOperationException("Please set a numeric value!");
//		}
//		return math.mean(NumberConverter.convertToNumber(numberOne), NumberConverter.convertToNumber(numberTwo));		
//	}
//	
//	@RequestMapping(value="/squareRoot/{number}",method=RequestMethod.GET)
//	public Double squareRoot(@PathVariable("number") String number) throws Exception {
//		if(!NumberConverter.isNumeric(number))
//		{
//			throw new UnsupportedMathOperationException("Please set a numeric value!");
//		}
//		return math.squareRoot(NumberConverter.convertToNumber(number));
//	}
}