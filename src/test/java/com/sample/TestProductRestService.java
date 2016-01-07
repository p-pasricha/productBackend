package com.sample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;

public class TestProductRestService {
	
	//@Autowired
	//private WebApplicationContext webApplicationContext;
 
	//private MockMvc mockMvc;
	private final MockMvc mockMvc = standaloneSetup(new ProductRestController()).build();

	@Before
	public void setup() {

		//mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	}

	@Test
	public void validateGetProducts() throws Exception {

		mockMvc.perform(get("/products1"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$[3].description", is("Product4")));

	}

}
