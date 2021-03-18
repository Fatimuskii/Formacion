package com.formacion.practica3Consumer;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class RestConsumerService {

	private static final String URL_API_INFO = "http://localhost:8080/students";

	RestTemplate restTemplate= new RestTemplate();

	// CRUD Methods -----
	// CREATE
	// @RequestMapping(value="/students", method=RequestMethod.POST)
	public Student create(Student student) {
		System.out.println(".............. CREATING NEW STUDENT ........\n");

		HttpHeaders headers;
		HttpEntity<Student> entity;
		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		entity = new HttpEntity<Student>(student, headers);
		try {
			Student studentCreated = restTemplate
					.exchange(URL_API_INFO + "/create", HttpMethod.POST, entity, Student.class).getBody();
			if (studentCreated != null) {

				System.out.println("STUDENT WAS CREATED SUCCESSFULLY WITH ID: " + studentCreated.getId() + "\n");
				return studentCreated;
			}

		} catch (HttpClientErrorException e) {
			System.out.println("Student was not created. Error message: " + e.getMessage());
		}

		return null;

	}

	// READ
	public Student read(int id) {

		System.out.println(".............. READING STUDENT........\n");
		HttpHeaders headers;
		HttpEntity<?> entity;
		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		entity = new HttpEntity<Object>(headers);
		try {
			Student studentRead = restTemplate
					.exchange(URL_API_INFO + "/read/" + id, HttpMethod.POST, entity, Student.class).getBody();
			if (studentRead != null) {
				return studentRead;

			}
		} catch (HttpClientErrorException e) {
			System.out.println("Student was not readable. Error message: " + e.getMessage() + "\n");
		}

		return null;
	}

	// UPDATE
	// @RequestMapping(value="/students/{id}", method=RequestMethod.PUT)
	public Student update(String id, Student studentUpdated) {
		System.out.println(".............. UPDATING DATA FROM STUDENT........\n");

		HttpHeaders headers;
		HttpEntity<Student> entity;
		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		entity = new HttpEntity<Student>(studentUpdated, headers);

		try {
			Student studentCreated = restTemplate
					.exchange(URL_API_INFO + "/update/" + id, HttpMethod.PUT, entity, Student.class).getBody();
			if (studentCreated != null) {
				System.out.println("PUT (UPDATE)executed");
				System.out.println("STUDENT WITH ID: " + studentCreated.getId() + " INFORMATION:");
				System.out.println("Student's new name: " + studentCreated.getName());
				return studentCreated;
			}
		} catch (HttpClientErrorException e) {
			System.out.println("Student was not readable. Error message: " + e.getMessage());

		}

		return null;
	}

	// DELETE
	// @RequestMapping(value="/students/{id}", method=RequestMethod.DELETE)
	public Student delete(int id) {
		System.out.println(".............. DELETING DATA ........\n");
		// restTemplate.delete(URL_API_INFO + "{id}", 1);
		HttpHeaders headers;
		HttpEntity<?> entity;

		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		entity = new HttpEntity<Object>(headers);
		Student response = restTemplate
				.exchange(URL_API_INFO + "/delete/" + id, HttpMethod.DELETE, entity, Student.class).getBody();
		System.out.println(response);

		return response;
	}

	// LIST
	// @RequestMapping(value="/students/", method=RequestMethod.GET)

	public Student[] list() {
		System.out.println(".............. LIST OF STUDENTS ........\n");

		HttpHeaders headers;
		HttpEntity<?> entity;

		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		entity = new HttpEntity<Object>(headers);

		try {
			Student[] response = restTemplate.exchange(URL_API_INFO + "/", HttpMethod.GET, entity, Student[].class)
					.getBody();
			return response;

		} catch (HttpClientErrorException e) {
			System.out.println("Error message: " + e.getMessage());
		}

		return null;
	}
}
