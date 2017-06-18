package com.cloudmachines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LiberarMaqIDController {

	@RequestMapping("CloudMachines/LiberarMaqID")
	public String LiberarMaqID(){
		return "LiberarMaqID";
	}
}
