package com.sergio.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	// URI Versioning
	
	@GetMapping("v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping("v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		Name name = new Name("Bob", "Charlie");
		return new PersonV2(name);
	}
	
	// Request Parameter Versioning
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPerson_RequestParameter() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPerson_RequestParamaeter() {
		Name name = new Name("Bob", "Charlie");
		return new PersonV2(name);
	}
	
	// (Custom) headers versioning
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPerson_RequestHeader() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPerson_RequestHeader() {
		Name name = new Name("Bob", "Charlie");
		return new PersonV2(name);
	}
	
	// Media Type Versioning - Content Negotiation - Accept Header
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPerson_MediaType() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPerson_MediaType() {
		Name name = new Name("Bob", "Charlie");
		return new PersonV2(name);
	}
}
