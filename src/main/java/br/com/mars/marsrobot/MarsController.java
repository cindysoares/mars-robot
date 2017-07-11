package br.com.mars.marsrobot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class MarsController {
	
	private static final String BAD_REQUEST_MESSAGE = "400 Bad Request";

	@RequestMapping(method = RequestMethod.POST, value="/{movements}")
    public ResponseEntity<String> greeting(@PathVariable String movements) {
		RobotPosition position = new RobotPosition();
		try {
			position.move(movements);
			return ResponseEntity.ok(position.toString());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(BAD_REQUEST_MESSAGE);
		}        
    }

}
