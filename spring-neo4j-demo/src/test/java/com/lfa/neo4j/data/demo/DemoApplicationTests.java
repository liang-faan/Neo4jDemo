package com.lfa.neo4j.data.demo;

import com.lfa.neo4j.data.demo.controller.MoviesController;
import com.lfa.neo4j.data.demo.controller.TokenController;
import com.lfa.neo4j.data.demo.security.ResourceSecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for {@link MoviesController}
 *
 * @author Josh Cummings
 */
@WebMvcTest({ MoviesController.class, TokenController.class })
@Import(ResourceSecurityConfiguration.class)
//@DataNeo4jTest
class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void rootWhenAuthenticatedThenSaysHelloUser() throws Exception {
		// @formatter:off
		MvcResult result = this.mvc.perform(post("/token")
						.with(httpBasic("tester", "password")))
				.andExpect(status().isOk())
				.andReturn();

		String token = result.getResponse().getContentAsString();

		this.mvc.perform(get("/")
						.header("Authorization", "Bearer " + token))
				.andExpect(content().string("Hello, user!"));
		// @formatter:on
	}

	@Test
	void rootWhenUnauthenticatedThen401() throws Exception {
		// @formatter:off
		this.mvc.perform(get("/"))
				.andExpect(status().isUnauthorized());
		// @formatter:on
	}

	@Test
	void tokenWhenBadCredentialsThen401() throws Exception {
		// @formatter:off
		this.mvc.perform(post("/token"))
				.andExpect(status().isUnauthorized());
		// @formatter:on
	}
}
