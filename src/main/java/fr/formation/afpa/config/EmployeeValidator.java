package fr.formation.afpa.config;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.formation.afpa.domain.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "lastName", "label.empty");
		ValidationUtils.rejectIfEmpty(errors, "firstName", "label.empty");
		ValidationUtils.rejectIfEmpty(errors, "startDate", "label.empty");
		Employee e = (Employee) obj;

		
	}

}
