package in.devdutt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeRestController {

	private static final Logger logger = LoggerFactory.getLogger(WelcomeRestController.class);

	@GetMapping("/welcome/{name}")
	public ResponseEntity<String> wish(@PathVariable String name) {
		logger.info("WelcomeRestController.wish() start " + (double) System.currentTimeMillis() / 1000 + " sec");

		ResponseEntity<String> result = null;

		if (name.isEmpty()) {
			logger.info("Checking the name is present in uri");

			result = new ResponseEntity<String>("Please Enter Name with the uri", HttpStatus.INTERNAL_SERVER_ERROR);

			logger.error("Exception occured");
		} else {

			HttpHeaders headers = new HttpHeaders();

			headers.add("info", "Getting Name" + name);

			result = ResponseEntity.status(HttpStatusCode.valueOf(200)).headers(headers)
					.body(name.toUpperCase() + " *- Welcome To Spring Boot with Docker Workshop..! -*");

			logger.info("WelcomeRestController.wish() execute successfully..!");
		}

		logger.info("WelcomeRestController.wish() stop " + (double) System.currentTimeMillis() / 1000 + " sec");
		return result;
	}// wish()
}// welcomeRestController
