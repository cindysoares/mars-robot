package br.com.mars.marsrobot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsRobotControllerTest {
	
	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testRightRotations() {
		testRobotMovement("/rest/mars/MMRMMRMM", "(2, 0, S)", HttpStatus.OK);
	}
	
	@Test
	public void testLeftMovement() {
		testRobotMovement("/rest/mars/MML", "(0, 2, W)", HttpStatus.OK);
	}

	@Test
	public void testInvalidCommand() {
		testRobotMovement("/rest/mars/AAA", "400 Bad Request", HttpStatus.BAD_REQUEST);
	}

	@Test
	public void testRightRotation() {
		testRobotMovement("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM", "400 Bad Request", HttpStatus.BAD_REQUEST);
	}

	private void testRobotMovement(String uri, String expectedAnswer, HttpStatus expectedStatus) {
		ResponseEntity<String> response = restTemplate.postForEntity(
				createURLWithPort(uri), null, String.class);

		Assert.assertEquals(expectedAnswer, response.getBody());
		Assert.assertEquals(expectedStatus, response.getStatusCode());
		
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:8080" + uri;
	}


}
