package com.techcrack.restfulWebService.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class AndroidDeveloper implements UIAbstract{
	
	@Override
	public String techStack() {
		return "Android Studio, Kotlin, React Native";
	}
}
