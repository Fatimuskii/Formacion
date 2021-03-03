package com.formacion.practica3H2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.practica3H2.model.entity.Song;
import com.formacion.practica3H2.model.service.ISongService;


@RestController
@RequestMapping(value = "songs")
public class SongController {

	@Autowired
	ISongService songService;

	// --------- CRUD Methods

	// CREATE
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> create(@RequestBody Song song) {
		// Check if student exists
		Song res = songService.read(song.getId());
		
		if (res!=null) { // if not exist we create it
			int id = songService.create(song);
			System.out.println("Song was created successfully");
			return new ResponseEntity<>(id, HttpStatus.CREATED);
		} else {
			String message = "Song with id " + song.getId() + " exists already.";
			return new ResponseEntity<Object>(message, HttpStatus.EXPECTATION_FAILED);
		}

	}
	
	//READ
	
	//UPDATE
	
	//DELETE
	
	//LIST
	
}
