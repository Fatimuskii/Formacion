package com.formacion.practica3;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Practica3Application {

	public static void main(String[] args) {
		SpringApplication.run(Practica3Application.class, args);

	}
	
	@RequestMapping(value="/")
	public String sayHelloWorld() {
		return "[DEMO DE SPRING - " + LocalDateTime.now() + "]";
	}

}
