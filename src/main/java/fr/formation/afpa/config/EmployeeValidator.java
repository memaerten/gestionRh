package fr.formation.afpa.config;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.formation.afpa.domain.Employee;

public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
