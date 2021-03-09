package com.formacion.serverBack.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.serverBack.entity.WorkExperience;
import com.formacion.serverBack.repository.IWorkExperienceRepository;

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

}
