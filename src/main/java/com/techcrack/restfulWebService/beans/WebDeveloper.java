package com.techcrack.restfulWebService.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Qualifier("web")
@Component
public class WebDeveloper implements UIAbstract{
	
	@Override
	public String techStack() {
		return "JavaScript, Html, CSS, React, Tailwind";
	}
}
