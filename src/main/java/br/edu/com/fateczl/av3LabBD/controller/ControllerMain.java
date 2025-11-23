package br.edu.com.fateczl.av3LabBD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class ControllerMain {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	/*
	 * O '@GetMapping' do menu inicial 
	 */
}
