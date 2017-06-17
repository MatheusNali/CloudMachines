package com.cloudmachines.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VerLogController {

	@RequestMapping("CloudMachines/VerLog")
	public String Homepage(){
		return "VerLog";
	}
}
