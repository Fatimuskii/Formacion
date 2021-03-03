package com.formacion.practica4MVC.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.formacion.practica4MVC.entities.Student;
import com.formacion.practica4MVC.repositories.StudentsRepository;
import com.formacion.practica4MVC.repositories.dataClient.StudentClient;
import com.formacion.practica4MVC.repositories.dataClient.StudentValidator;

@Controller
public class RegistrationController {

	@Autowired
	private StudentValidator validator;
	@Autowired
	private StudentsRepository studentRepo;

	//Method that shows the registration view
	@GetMapping("/registration")
	public String registrationForm(Model model) {
		model.addAttribute("student", new StudentClient());
		return "registration";
	}

	//Method that receives a student form from the view
	@PostMapping("/registration")
	public ModelAndView handleRegistration(@Valid StudentClient student, BindingResult result) {
		// logger.debug("Registering Student : "+ student);

		ModelAndView mav = new ModelAndView();

		validator.validate(student, result);
		if (result.hasErrors()) {

			mav.addObject("student", student);
			mav.setViewName("registration");
		} else {
			// saves the new student if data was successfully validate
			//Inizialize new Student class (entity)
			Student newStudent = new Student();
			newStudent.setName(student.getName());
			newStudent.setEmail(student.getEmail());
			newStudent.setPassword(student.getPassword());
			
			studentRepo.save(newStudent);
			mav.addObject("student", student);
			//We send the data to a new view
			mav.setViewName("registrationsuccess");
		}

		return mav;
	}
}
