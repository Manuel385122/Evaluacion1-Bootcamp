package com.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/evaluacion/test")
public class Test {

	@GetMapping("")
	public String get() {
		int a;
		int b;
		
		return "Hola mundo";
	}

}
