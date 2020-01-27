package xo.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(path = "/api/hello")
	public String sayHello() {
		return "Hello from Spring Boot 2 with angular 2";
	}

}
