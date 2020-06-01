package com.sujit.greetings.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	@GetMapping("/greetings")
	public String greet(){
		
		return "Hello! Sujit";
		
	}

}
