package com.nparo.codefellowship;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CodefellowshipApplicationTests {
	@Autowired
	MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testHomeRoute() throws Exception {
		this.mockMvc
		.perform(get("/"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Please log in to your account")));
	}
	
	@Test
	public void testLoginPageRoute() throws Exception {
		this.mockMvc
		.perform(get("/login"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Log in to your account:")));
	}
	
	@Test
	public void testSignUpPageRoute() throws Exception {
		this.mockMvc
		.perform(get("/signup"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Sign up for a new account:")));
	}
}
