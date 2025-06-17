package com.techcrack.restfulWebService.socialmedia.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	
	@GetMapping("/v1/person")
	public PersonV1 firstVersion() {
		return new PersonV1("James Clear");
	}
	
	@GetMapping("/v2/person") 
	public PersonV2 secondVersion() {
		return new PersonV2("James", "Clear");
	}
	
	@GetMapping(path = "/person", params="version=1")
	public PersonV1 firstVersionRequestParam() {
		return new PersonV1("James Clear");
	}
	
	@GetMapping(path = "/person", params="version=2")
	public PersonV2 secondVersionRequestParam() {
		return new PersonV2("James", "Clear");
	}
	
	@GetMapping(path = "/person", headers="X-API-VERSION=1")
	public PersonV1 firstVersionHeaderRequest() {
		return new PersonV1("James Clear");
	}
	
	@GetMapping(path = "/person", headers="X-API-VERSION=2")
	public PersonV2 secondVersionHeaderRequest() {
		return new PersonV2("James", "Clear");
	}
	
	@GetMapping(path = "/person", produces="application/vnd.company.app-v1+json")
	public PersonV1 firstVersionMediaParameter() {
		return new PersonV1("James Clear");
	}
	
	@GetMapping(path = "/person", produces="application/v2+json")
	public PersonV2 secondVersionMediaParameter() {
		return new PersonV2("James", "Clear");
	}
}
