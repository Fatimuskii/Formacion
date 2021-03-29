package com.formacion.practica4MVC.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	// Method that receives a student from the view
	@PostMapping("/editInformation")
	public ModelAndView handleRegistration(@ModelAttribute("student") @Valid StudentClient student, BindingResult result) {
		// logger.debug("Registering Student : "+ student);

		ModelAndView mav = new ModelAndView();

		validator.validateEdition(student, result);
		if (result.hasErrors()) {
			mav.addObject("student", student);
			System.out.println("Student not in database. Check email");
			mav.setViewName("editPage");
		} else {
			// updates the name of the student
			// Inizialize new Student class (entity)

			Student studentUpdated = studentRepo.findByEmail(student.getEmail());
			studentUpdated.setName(student.getName());
			studentUpdated.setPassword(student.getPassword());
			studentRepo.save(studentUpdated);
			mav.addObject("student", studentUpdated);
			// We send the data to a new view
			mav.setViewName("updatesuccess");
		}

		return mav;
	}

	// Method that shows the edit view
	@GetMapping("/list")
	public String listStudents(Model model) {
		Iterable<Student> iterable = studentRepo.findAll();
		List<Student> list = new ArrayList<>();
		iterable.forEach(list::add);
		model.addAttribute("students", list);
		return "list";
	}
	
	/*
	 * @RequestMapping(value = "/share", method = RequestMethod.POST)
    public ResponseEntity<Object> share(@RequestParam String email) {​​​​​​
        if (email!=null) {​​​​​​
            System.out.println("Sending email to: " + email);
            return new ResponseEntity<Object>(HttpStatus.OK);
        }​​​​​​
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
 
    }​​​​​​

//    @RequestMapping(value = "/share", method = RequestMethod.POST)
//    public ResponseEntity<Object> share(@RequestParam Map<String, String> form) {​​​​​​
//        if (form.containsKey("email")) {​​​​​​
//            System.out.println("Sending email to: " + form.get("email"));
//            return new ResponseEntity<Object>("Sending email to: " + form.get("email"),HttpStatus.OK);
//        }​​​​​​
//        return new ResponseEntity<Object>("Email not found",HttpStatus.BAD_REQUEST);
//    }​​​​​​
 
        
//        @RequestMapping(value = "/share", method = RequestMethod.POST,consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//        public ResponseEntity<Object> share(Form form) {​​​​​​
//            if (form.getEmail()!=null) {​​​​​​
//                System.out.println("Sending email to: " + form.getEmail());
//                return new ResponseEntity<Object>("Sending email to: " + form.getEmail(),HttpStatus.OK);
//            }​​​​​​
//            return new ResponseEntity<Object>("Email not found",HttpStatus.BAD_REQUEST);
//        }​​​​​​*/
}
