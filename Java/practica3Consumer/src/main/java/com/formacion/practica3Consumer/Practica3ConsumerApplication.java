package com.formacion.practica3Consumer;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Practica3ConsumerApplication implements CommandLineRunner, ApplicationRunner {
	private final static String targetURL = "http://localhost:8080/students";
	   
    @Autowired
    private RestConsumerService restConsumerService;
   
    public static void main(String[] args) {
        SpringApplication.run(Practica3ConsumerApplication.class, args);
    }

	// Dependency injection
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RestConsumerService getService() {
		return new RestConsumerService();
	}

	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RESTConsumerApplication. ApplicationRunner...");

		HttpEntity<?> entity;
		ResponseEntity<Student[]> response;
		HttpHeaders headers;
		RestTemplate restTemplate;

		restTemplate = new RestTemplate();

		headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		entity = new HttpEntity<Object>(headers);

		response = restTemplate.exchange(targetURL+"/", HttpMethod.GET, entity, Student[].class);

		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println(response);

			for (Student student : (Student[]) response.getBody()) {
				System.out.println(student.getName());
			}
		} else
			System.out.println("RESTConsumerApplication. Error [" + response.getStatusCode() + "].");

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RESTConsumerApplication. CommandLineRunner...");

		Student[] whenBeginingTest;
		Student[] whenDeletingIsFinished;
		Student[] atTheEnd;

		System.out.println("*** STUDENTS SET MANIPULATION STARTED ***");

		whenBeginingTest = restConsumerService.list();

		System.out.println("*** " + whenBeginingTest.length + " ***");
		for (Student student : whenBeginingTest) {
			System.out.println(student.toString());
		}
		System.out.println("*** " + "*" + "***");

		for (Student student : whenBeginingTest) {
			System.out.println("Deleting... [" + student.getName() + "].");
			Student deleted = restConsumerService.delete(student.getId());
            if (deleted != null)
                System.out.println("Deleted!");
		}

		whenDeletingIsFinished = restConsumerService.list();

		System.out.println("*** " + whenDeletingIsFinished.length + " ***");
		for (Student student : whenDeletingIsFinished) {
			System.out.println(student.toString());
		}
		System.out.println("*** " + "*" + "***");

		for (Student student : whenBeginingTest) {
			System.out.println("Creating... [" + student.getName() + "].");
			Student created = restConsumerService.create(student);
			if (created != null)
				System.out.println("Created!");
		}

		atTheEnd = restConsumerService.list();

		System.out.println("*** " + atTheEnd.length + " ***");
		for (Student student : atTheEnd) {
			System.out.println(student.toString());
		}
		System.out.println("*** " + "*" + "***");

		System.out.println("*** STUDENTS SET MANIPULATION ENDED ***");

	}
	
	/*
	 * RestTemplate restTemplate = new RestTemplate();
	 * 
	 * getAllStudents(restTemplate);
	 * 
	 * Student student1 = createStudent("Fatima Garcia"); Student student2 =
	 * createStudent ("Irene Villalba"); Student student3 =
	 * createStudent("Pepe Mangas Verdes");
	 * 
	 * createStudent(restTemplate, student1); createStudent(restTemplate, student2);
	 * createStudent(restTemplate, student3);
	 * 
	 * getAllStudents(restTemplate);
	 * 
	 * int id = 1; // deberia ser Fatima Garcia readStudent(restTemplate, id);
	 * 
	 * 
	 * Student studentUpdated = new Student();
	 * studentUpdated.setName("Fatima (Modificado)");
	 * 
	 * updateStudent(restTemplate, studentUpdated, id);
	 * 
	 * getAllStudents(restTemplate);
	 * 
	 * deleteStudent(restTemplate, 3); // Borramos a Pepe
	 * 
	 * getAllStudents(restTemplate);
	 */

	/*
	 * readStudent(restTemplate);
	 * 
	 * updateStudent(restTemplate);
	 * 
	 * deleteStudent(restTemplate);
	 * 
	 * getAllStudents(restTemplate);
	 */

}
