package com.formacion.practica3Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*; 
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { TestConfiguration.class })
public class StudentServiceMockRestServiceServerUnitTest {

	@Autowired
	private StudentService studentService; 
	@Autowired
	private RestTemplate restTemplate; 
	
	private MockRestServiceServer mockServer;
	private ObjectMapper mapper = new ObjectMapper();
	
	
	@BeforeEach
	public void init() {
		mockServer = MockRestServiceServer.createServer(restTemplate);
		
	}
	
	@Test
	public void getStudent() {
		
		Student stud = new Student(1, "Fatima Garcia");
		
		try {
			mockServer.expect(ExpectedCount.once(), requestTo(new URI("http://localhost:8080/students/read/1")))
			.andExpect(method(HttpMethod.GET))
			.andRespond(withStatus(HttpStatus.OK)
					.contentType(MediaType.APPLICATION_JSON)
					.body(mapper.writeValueAsString(stud))
					);
			
			Student student = studentService.read(1);
			mockServer.verify();
			assertEquals(stud, student);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
