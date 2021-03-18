package com.formacion.pr5WebSocket;

import java.time.LocalDateTime;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.formacion.pr5WebSocket.utils.HTMLUtilities;


@SpringBootApplication
public class Pr5WebSocketApplication implements ApplicationRunner {

	public static void main(String[] args) {
		say("WebSockets Application. Starting...");
		SpringApplication.run(Pr5WebSocketApplication.class, args);
		say(" WebSockets Application. Running...");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		say(" Hellow there! Websockets Application. The application is currently running...");
	}
	
	public static String say(String message) {
		return "[" + LocalDateTime.now() + "]" 
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ HTMLUtilities.Entities.__NonBreakingSpace
				+ message;
	}

}
