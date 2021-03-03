package com.formacion.practica3.controller;

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

import com.formacion.practica3.entity.Student;
import com.formacion.practica3.repository.IStudentRepository;


@RestController
public class StudentController {


	@Autowired
	private IStudentRepository studentRepo;

	// --------- CRUD Methods

	// AUTOMATIC IMPORTS
	// CREATE
	@RequestMapping(value = "students/init")
	public ResponseEntity<Object> init() {

		Student student1 = new Student(); 
		student1.setName("Fatima Garcia");
		student1.setEmail("fatima@ucm.es");
		
		Student student2 = new Student(); 
		student2.setName("Jonathan Zambrano");
		student2.setEmail("jonny@ucm.es");
		
		Student student3= new Student(); 
		student3.setName("Marina Lozano");
		student3.setEmail("marina@ucm.es");
		
		Student student4 = new Student(); 
		student4.setName("Ana Banana");
		student4.setEmail("banana@ucm.es");
		
		studentRepo.save(student1);
		studentRepo.save(student2);
		studentRepo.save(student3);
		studentRepo.save(student4);

		return new ResponseEntity<Object>("4 Students created", HttpStatus.OK);
		
	}
	
	// CREATE
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:9090" })
	@RequestMapping(value = "students/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Object> create(@RequestBody Student student) {
		// Check if student exists
		// Student studentRes = repo.get(student.getId());
		Optional<Student> result = studentRepo.findById(student.getId());

		if (result.isEmpty()) { // if not exist we create it
			studentRepo.save(student);
			System.out.println("Student was created successfully");
			return new ResponseEntity<>(student, HttpStatus.CREATED);
		} else {
			String message = "Student with id " + student.getId() + " exists already.";
			System.out.println(message);
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}

	}

	// READ
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:9090" })
	@RequestMapping(value = "students/read/{id}")
	public ResponseEntity<Object> get(@PathVariable("id") int id) {

		Optional<Student> student = studentRepo.findById(id);
		if (!student.isEmpty()) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			String res = "Student with id " + id + " does not exist";
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}

	}

	// UPDATE
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:9090" })
	@RequestMapping(value = "students/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object> update(@PathVariable("id") int id, @RequestBody Student student) {
		// Check if student exists
		Optional<Student> studentRes = studentRepo.findById(id);
		if (!studentRes.isEmpty()) {
			student.setId(id);
			studentRepo.save(student);
			System.out.println("Student was updated successfully");
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			String res = "Student with id " + id + " does not exist";
			System.out.println(res);
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}

	}

	// DELETE
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:9090" })
	@RequestMapping(value = "students/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") int id) {
		// Check if student exists
		// Student studentRes = repo.get(id);

		Optional<Student> res = studentRepo.findById(id);
		if (!res.isEmpty()) {
			studentRepo.deleteById(id);
			return new ResponseEntity<>(res, HttpStatus.OK);

		} else {
			//String message = "Student with id " + id + " does not exist";
			return new ResponseEntity<Object>(res, HttpStatus.BAD_REQUEST);
		}

	}

	// LIST
	@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:9090" })
	@RequestMapping(value = "students", produces = "application/json")
	public ResponseEntity<Object> getAll() {

		Iterable<Student> iterable = studentRepo.findAll();
		List<Student> list = new ArrayList<>();
		iterable.forEach(list::add);
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}

	// @RquestBody - nos referimos al cuerpo del mensaje que recibimos
	/*
	 * Peticiones tiene cabecera o body 1024 la cabecera - mandamos datos a traves
	 * de la url Formularios cargan los datos a traves del body
	 * 
	 * -- ? request params {} / - pathvariable
	 */
	
	// MOCK
	/*
	 * private static HashMap<String, Student> repo = new HashMap<>();
	 * 
	 * static {
	 * 
	 * Student student;
	 * 
	 * student = new Student(); student.setId("1");
	 * student.setName("Bethanie G. Addams"); repo.put(student.getId(), student);
	 * 
	 * student = new Student(); student.setId("2");
	 * student.setName("John F. McReally"); repo.put(student.getId(), student);
	 * 
	 * student = new Student(); student.setId("3");
	 * student.setName("Claudia M. Kirshner"); repo.put(student.getId(), student);
	 * 
	 * student = new Student(); student.setId("4");
	 * student.setName("Nelson B. Ransom"); repo.put(student.getId(), student);
	 * 
	 * student = new Student(); student.setId("5");
	 * student.setName("Roxane L. Russell"); repo.put(student.getId(), student); }
	 */
	
	// @CrossOrigin(origins = { "http://localhost:8080", "http://localhost:9090"})
		// --- por seguridad para filtrar que local pueden pedir peticiones
}
