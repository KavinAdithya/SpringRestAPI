package com.techcrack.restfulWebService.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

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
	
	@GetMapping(path="/hello-world-i18n")
	public HelloWorldBean helloWorldInternationalization() {
		String m = messageSource.getMessage("good.morning", null, "No Transformation for your language", LocaleContextHolder.getLocale());
		return new HelloWorldBean(m);
	}
}
