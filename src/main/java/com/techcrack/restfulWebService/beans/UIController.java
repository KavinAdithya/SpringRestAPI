package com.techcrack.restfulWebService.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UIController {
	@Autowired
//	@Qualifier("web")
	private UIAbstract ui;
	
	@GetMapping("/{dev}")
	public String webTechstack(@PathVariable String dev) {
		
		return ui.techStack();
	}
}
