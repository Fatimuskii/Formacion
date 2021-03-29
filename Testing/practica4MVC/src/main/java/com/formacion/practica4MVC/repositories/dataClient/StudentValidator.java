package com.formacion.practica4MVC.repositories.dataClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.formacion.practica4MVC.entities.Student;
import com.formacion.practica4MVC.repositories.StudentsRepository;

@Component
public class StudentValidator implements Validator{
	
	@Autowired
    StudentsRepository repo;

    @Override
    public boolean supports(Class<?> clazz) {
        return StudentClient.class.isAssignableFrom(clazz);
    }

  
	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		StudentClient user = (StudentClient) target;
        String email = user.getEmail();
        Student userByEmail = repo.findByEmail(email);
        if (userByEmail != null) {
            errors.rejectValue("email", "email.exists", new Object[] { email }, "Email " + email + " already in use");
        }
	}
	
	public void validateEdition(Object target, Errors errors) {
		StudentClient user = (StudentClient) target;
        String email = user.getEmail();
        Student userByEmail = repo.findByEmail(email);
    
        if (userByEmail == null) {
            errors.rejectValue("email", "email.Notexists", new Object[] { email }, "Email " + email + " does not exists");
        }
        
	}
}
