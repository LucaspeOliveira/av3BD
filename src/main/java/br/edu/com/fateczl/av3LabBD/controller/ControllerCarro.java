package br.edu.com.fateczl.av3LabBD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.com.fateczl.av3LabBD.service.ServiceCarro;

@Controller
@RequestMapping("/carro")
public class ControllerCarro {
	
	@Autowired
	private ServiceCarro serviceCarro;
	
	
	
}
