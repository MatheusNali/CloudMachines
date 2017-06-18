package com.cloudmachines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LiberarMaqQtnController{

	@RequestMapping("CloudMachines/LiberarMaqQtn")
	public String LiberarMaqQtn(){
		return "LiberarMaqQtn";
	}
}
