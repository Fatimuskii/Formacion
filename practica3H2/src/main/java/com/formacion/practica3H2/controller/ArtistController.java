package com.formacion.practica3H2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.practica3H2.model.entity.Artist;
import com.formacion.practica3H2.model.service.IArtistService;

@RestController
@RequestMapping(value = "artists")
public class ArtistController {

	@Autowired
	IArtistService artistService;

	// --------- CRUD Methods

	// CREATE
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> create(@RequestBody Artist artist) {
		// Check if student exists
		Artist res = artistService.read(artist.getId());

		if (res != null) { // if not exist we create it
			int id = artistService.create(artist);
			System.out.println("Artist was created successfully");
			return new ResponseEntity<>(id, HttpStatus.CREATED);
		} else {
			String message = "Artist with id " + artist.getId() + " exists already.";
			return new ResponseEntity<Object>(message, HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	//READ
	
	//UPDATE
	
	//DELETE
	
	//LIST
	
}
