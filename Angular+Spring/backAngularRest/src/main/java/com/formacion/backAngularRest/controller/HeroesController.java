package com.formacion.backAngularRest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.backAngularRest.entity.Hero;
import com.formacion.backAngularRest.repository.IHeroesRepository;

@RestController
public class HeroesController {

	@Autowired
	private IHeroesRepository heroesRepo;

	@RequestMapping(value = "/heroes", produces = "application/json")
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://localhost:4200" })
	public ResponseEntity<Object> getAll() {
		System.out.println("Front List request received");
		Iterable<Hero> iterable = heroesRepo.findAll();
		List<Hero> list = new ArrayList<>();
		iterable.forEach(list::add);
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/heroes/{id}", produces = "application/json")
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://localhost:4200" })
	public ResponseEntity<Object> getById(@PathVariable(value="id") int id) {
		System.out.println("Front getById request received");
		Optional<Hero> res = heroesRepo.findById(id);
		
		if(!res.isEmpty()) {
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Error. Hero not found", HttpStatus.BAD_REQUEST);
	
	}
	
	

	@RequestMapping(value = "/heroes/create", method = RequestMethod.POST, produces = "application/json")
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://localhost:4200" })
	public ResponseEntity<Object> create(@RequestBody Hero hero) {
		System.out.println("Front Create request received");
		Optional<Hero> result = heroesRepo.findById(hero.getId());

		if (result.isEmpty()) { // if not exist we create it
			heroesRepo.save(hero);
			System.out.println("Hero was created successfully");
			return new ResponseEntity<>(hero, HttpStatus.CREATED);
		} else {
			String message = "Student with id " + hero.getId() + " exists already.";
			System.out.println(message);
			return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(value = "/heroes/update", method = RequestMethod.PUT, produces = "application/json")
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://localhost:4200" })
	public ResponseEntity<Object> update(@RequestBody Hero hero) {
		System.out.println("Front Update request received");
		Optional<Hero> result = heroesRepo.findById(hero.getId());

		if (result.isEmpty()) { // if not exist we create it
			String message = "Hero with id " + hero.getId() + " does not exist.";
			System.out.println(message);
			return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
		} else {
			heroesRepo.save(hero);
			System.out.println("Hero was updaterd successfully");
			return new ResponseEntity<>(hero, HttpStatus.OK);
		}

	}
	
	@RequestMapping(value = "/heroes/delete/{id}", method = RequestMethod.DELETE,produces = "application/json")
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:5500", "http://localhost:4200" })
	public ResponseEntity<Object> deleteById(@PathVariable(value="id") int id) {
		System.out.println("Front deleteById request received");
		Optional<Hero> res = heroesRepo.findById(id);
		
		if(!res.isEmpty()) {
			heroesRepo.deleteById(id);
			return new ResponseEntity<Object>(true, HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Error. Hero not found", HttpStatus.BAD_REQUEST);
	
	}

}
