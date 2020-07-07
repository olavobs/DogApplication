package com.udacity.dogRestApi;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.udacity.dogRestApi.entity.Dog;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogIntegrationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAllLocations() {
		ResponseEntity<List> response = this.restTemplate.getForEntity("http://localhost:" + port + "/dogs/",
				List.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

	@Test
	public void getLocation() {
		ResponseEntity<String> response = this.restTemplate.getForEntity("http://localhost:" + port + "/1/breed",
				String.class);

		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
	}

}
