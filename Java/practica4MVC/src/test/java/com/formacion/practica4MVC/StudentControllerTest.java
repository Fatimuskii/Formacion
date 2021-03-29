package com.formacion.practica4MVC;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.formacion.practica4MVC.controllers.StudentController;

class StudentControllerTest {

	private MockMvc mockMvc;


	@BeforeEach
	void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new StudentController()).build();
	}
	
	@Test
	public void givenRegistrationPageURI_whenMockMVC_thenReturnsRegistrationJSPViewName() throws Exception {
		this.mockMvc.perform(get("/registration")).andExpect(view().name("templates/registration.html"));
	}

}
