package com.nathanducey.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.nathanducey.main.PrimeController;
import com.nathanducey.main.PrimeInput;
import com.nathanducey.main.PrimeOutput;

@RunWith(MockitoJUnitRunner.class)
public class PrimeControllerTest {
	
	private MockMvc mockMvc;

	@InjectMocks
	private PrimeController controller;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .build();
	}

	@Test
	public void test_validRequest_returns_validResponse() throws Exception {
		// Given
		String jsonInput = "{\"inputVal\": 5}";
		PrimeInput pInput = new PrimeInput();
		pInput.setInputVal(5);
				
		// When
		MockHttpServletResponse response = mockMvc.perform(
                post("/findPrimes")
                	.contentType(MediaType.APPLICATION_JSON)
                    .content(jsonInput))
                	.andReturn()
                	.getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertEquals(response.getContentAsString(), "{\"primes\":[2,3,5]}");
	}
	
	@Test
	public void test_invalidRequest_returns_400BadRequestResponse() throws Exception {
			
		// When
		MockHttpServletResponse response = mockMvc.perform(
                post("/findPrimes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("some text"))
                .andReturn().getResponse();

        // Then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
	}
		
}
