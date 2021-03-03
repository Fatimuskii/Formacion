package com.formacion.practica4MVC;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formacion.practica4MVC.utils.HTMLUtilities;

@SpringBootApplication
@RestController
public class Practica4MvcApplication implements ApplicationRunner {

	public static void main(String[] args) {
		say("Thymeleaf Application. Starting...");
		SpringApplication.run(Practica4MvcApplication.class, args);
		say(" Thymeleaf Application. Running...");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		say("Thymeleaf Application. Started.");
		
	}

	@RequestMapping(value="/")
	public String hello(String message) {
		return say("Hello world. Thymeleaf application is running...");
	}

	public static String say(String message) {
		return "[" + LocalDateTime.now() + "]" 
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ message;
	}

	/*@Bean
	public StudentsRepository getApplicationRepo() {
		return new StudentsRepository();
	}*/
}
