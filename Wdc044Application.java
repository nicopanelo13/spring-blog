package com.zuitt.wdc044;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// "@SpringBootApplication" is an example of "Annotations" mark.
// Annotations are used to provide supplemental information about the program.
// These are used to manage and configure the behavior of the framework.
// Annotations are used extensively in Spring Boot to configure components, define dependencies, or enable specific functionalities
// Spring Boot scans for classes in its class path upon running and assigns behaviors on them based on their annotations.

//This specifies the main class of the Spring boot Application
@SpringBootApplication
//This indicates that the class is a controller that will handle RESTful web request and returns an HTTP response
@RestController
public class Wdc044Application {

	public static void main(String[] args) {
		//	This method starts the whole Spring Framework
		//	This serves as the entry point to start the application.
		SpringApplication.run(Wdc044Application.class, args);
	}

	//This is used for mapping HTTP GET Requests.
	//Note: @GETMapping annotation is always followed by a "method body"
	//"method body" contains the logic to generate the response
	@GetMapping("/hello")
	//@RequestParam is used to extract query parameters, form parameters followed by "key=value" pair.
	//"?" means the start of parameters followed by the "key=value" pair
		//localhost:8080/hello?name=Tolits
		//localhost:8080/hello
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name){
		// "%s" is a placeholder value for the name
		return String.format("Hello %s", name);
	}

	//S01 Activity

	@GetMapping("/hi")
	public String hi(@RequestParam(value = "user", defaultValue = "user") String user){
		return String.format("hi %s!", user);
	}
	//http://localhost:8080/hi?user=Jane

	//S01 Stretch Goal
	@GetMapping("/nameAge")
	public String nameAge(@RequestParam(value = "name", defaultValue = "name") String name, @RequestParam(value = "age", defaultValue = "0") int age){
		return String.format("Hello %s! Your age is %d.", name, age);
	}
	//http://localhost:8080/nameAge?name=Juan&age=18





}
