package com.techcrack.restfulWebService.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path="/hello-world")
	public String getReply() {
		return "Hello World !";
	}
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hi.. Spring Boot !");
	}
	
	@GetMapping(path="/hello-world/pathvariable/{name}")
	public HelloWorldBean pathVariableName(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hi %s", name));
	}
}
