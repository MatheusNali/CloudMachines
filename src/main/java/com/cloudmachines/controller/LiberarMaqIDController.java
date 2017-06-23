package com.cloudmachines.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LiberarMaqIDController {

	@RequestMapping("CloudMachines/LiberarMaqID")
	public String LiberarMaqID(){
		return "LiberarMaqID";
	}
	
	ThreadMaster ThMaster;
	
	@RequestMapping(value = "CloudMachines/LiberarMaqID", method = RequestMethod.POST)
	public String LiberariD(){
		
		if(ThMaster == null)
			ThMaster = new ThreadMaster();
		
		
		return "VerLog";
	}
}
