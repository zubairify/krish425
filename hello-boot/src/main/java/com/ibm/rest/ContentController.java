package com.ibm.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;

@RestController
public class ContentController {
	// http://localhost:9000/text/Zubair
	@GetMapping(value = "/text/{pname}", produces = "text/plain")
	public String greetText(@PathVariable("pname") String name) {
		return "Text: Welcome to Spring Boot, " + name;
	}
	
	// http://localhost:8880/html?pname=Shaikh
	@GetMapping(value = "/html", produces = "text/html")
	public String greetHtml(@RequestParam("pname") String name) {
		return "<h1>HTML: Welcome to Spring Boot, "  + name + "</h1>";
	}
	
	@GetMapping(value = "/xml", produces = "text/xml")
	public String greetXml() {
		return "<?xml version=\"1.0\"?><greeting>XML: Welcome to Spring Boot</greeting>";
	}
	
	@GetMapping(value = "/json", produces = "application/json")
	public String greetJson() {
		JSONPObject obj = new JSONPObject("greeting", "JSON: Welcome to Spring Boot");
		return obj.getValue().toString();
	}
}
