package com.formacion.serverBack.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.serverBack.entity.WorkExperience;
import com.formacion.serverBack.repository.IWorkExperienceRepository;
import com.mysql.cj.x.protobuf.MysqlxResultset.ContentType_BYTES;

@RestController
public class ExperienceController {

	@Autowired
	private IWorkExperienceRepository experienceRepo;

	// AUTOMATIC IMPORTS
	// CREATE
	@RequestMapping(value = "work/init")
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500" })
	public ResponseEntity<Object> init() {

		WorkExperience work1 = new WorkExperience();
		work1.setYear(2021);
		work1.setCompany("Sopra Steria");
		work1.setJob("Junior Fullstack Developer");
		
		WorkExperience work2 = new WorkExperience(); 
		work2.setYear(2020);
		work2.setCompany("Arena Financial Tech");
		work2.setJob("Intern Fullstack Developer");
		
		WorkExperience work3 = new WorkExperience(); 
		work3.setYear(2019);
		work3.setCompany("Prosegur");
		work3.setJob("Help Desk Assistant");

		experienceRepo.save(work1);
		experienceRepo.save(work2);
		experienceRepo.save(work3);
		return new ResponseEntity<Object>("Experience Added", HttpStatus.OK);

	}

	// CREATE
	@RequestMapping(value = "work/", produces = "application/json")
	@CrossOrigin(origins = { "http://localhost:8080", "http://127.0.0.1:5500" })
	public ResponseEntity<Object> getAll() {

		Iterable<WorkExperience> iterable = experienceRepo.findAll();
		List<WorkExperience> list = new ArrayList<>();
		iterable.forEach(list::add);
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	/*
	@RequestMapping(value = "work/sendEmail", method = RequestMethod.POST)
	@CrossOrigin(origins = { "http://localhost:8080", "http://127.0.0.1:5500" })
	public ResponseEntity<Object> emailRequest(@RequestParam (value="email") String email) {

		if(email != null && !email.isEmpty()) {
			System.out.println("Email" + email);
			return new ResponseEntity<Object>(true, HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Object>(false, HttpStatus.OK);

	}*/
	
	/*@RequestMapping(value = "work/sendEmail", method = RequestMethod.POST, produces = "application/json")*/
	@RequestMapping(value = "work/sendEmail", method = RequestMethod.POST)
	@CrossOrigin(origins = { "http://localhost:8080", "http://127.0.0.1:5500" })
	public ResponseEntity<Object> emailRequest(@RequestBody String object) {
		if(object!= null && !object.isBlank() && !object.equals("empty")) {
			System.out.println("Email received -> " + object);
			return new ResponseEntity<Object>("Email received sucesfully", HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Object>("Error", HttpStatus.OK);
	}
	
	
	
	
	/*------------------------------------------------------------*/
	/*
	 * 
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
//        }​​​​​​
 * */

}
