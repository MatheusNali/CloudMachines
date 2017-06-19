package com.cloudmachines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloudmachines.modelSemBD.MaqAlugada;

@Controller
public class AlugarMaqController {

	@RequestMapping("CloudMachines/AlugarMaq")
	public String AlugarMaq(){
		return "AlugarMaq";
	}
	
	@RequestMapping(value = "CloudMachines/AlugarMaq", method = RequestMethod.POST)
	public String Salvar(MaqAlugada maqAlugada){
		System.out.println(maqAlugada.getnMaq()+" "+maqAlugada.getPol());
		return "VerLog";
	}
}
	
	
	
	

