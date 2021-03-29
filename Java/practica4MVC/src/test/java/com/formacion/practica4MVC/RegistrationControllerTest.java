package com.formacion.practica4MVC;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.formacion.practica4MVC.controllers.RegistrationController;

class RegistrationControllerTest {

	private MockMvc mockMvc;

	private static final String CONTENT_TYPE = "application/json";

	@BeforeEach
	void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new RegistrationController()).build();
	}

	@Test
	public void givenRegistrationPageURI_whenMockMVC_thenReturnsRegistrationJSPViewName() throws Exception {
		this.mockMvc.perform(get("/registration")).andExpect(view().name("templates/registration.html"));
	}

	@Test
	public void givenNewStudent_whenMockMVC_thenVerifyResponse() throws Exception {
		this.mockMvc.perform(post("/registration")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(CONTENT_TYPE))
				.andExpect(jsonPath("$.name").value("Fatima Garcia"))
				.andExpect(view().name("templates/registrationsuccess.html"));
	}

}
