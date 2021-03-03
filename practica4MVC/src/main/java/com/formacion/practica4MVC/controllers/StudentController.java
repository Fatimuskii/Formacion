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
public class StudentController {
	@Autowired
	private StudentValidator validator;
	@Autowired
	private StudentsRepository studentRepo;

	// Method that shows the edit view
	@GetMapping("/editInformation")
	public String editForm(Model model) {
		model.addAttribute("student", new StudentClient());
		return "editPage";
	}

	// Method that receives a student  from the view
	@PostMapping("/editInformation")
	public ModelAndView handleRegistration(@Valid StudentClient student, BindingResult result) {
		// logger.debug("Registering Student : "+ student);

		ModelAndView mav = new ModelAndView();

		validator.validateEdition(student, result);
		if (result.hasErrors()) {
			mav.addObject("student", student);
			mav.setViewName("registration");
		} else {
			// updates the name of the student 
			// Inizialize new Student class (entity)

			Student studentUpdated = studentRepo.findByEmail(student.getEmail());
			studentUpdated.setName(student.getName());
			studentUpdated.setPassword(student.getPassword());
			studentRepo.save(studentUpdated);
			mav.addObject("student", studentUpdated);
			// We send the data to a new view
			mav.setViewName("userInformation");
		}

		return mav;
	}
}