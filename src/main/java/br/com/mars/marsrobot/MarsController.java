package br.com.mars.marsrobot;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class MarsController {
	
	@RequestMapping(method = RequestMethod.POST, value="/{movements}")
    public String greeting(@PathVariable String movements) {
        return new RobotPosition(2, 0, Orientation.S).toString();
    }

}
