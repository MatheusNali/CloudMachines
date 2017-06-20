package com.cloudmachines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cloudmachines.modelSemBD.MaqAlugada;

@Controller
public class AlugarMaqController {
	
	ThreadMaster ThMaster;

	@RequestMapping("CloudMachines/AlugarMaq")
	public String AlugarMaq(){
		return "AlugarMaq";
	}
	
	@RequestMapping(value = "CloudMachines/AlugarMaq", method = RequestMethod.POST)
	public String Salvar(MaqAlugada maqAlugada){
		
		ThMaster = new ThreadMaster();
		
		if(maqAlugada.getPolEnum().getPol().equals("ROI")){
			ThMaster.ROI(maqAlugada.getnMaq());
		}else if(maqAlugada.getPolEnum().equals("OnDemand")){
			ThMaster.OnDemand(maqAlugada.getnMaq());
		}else if(maqAlugada.getPolEnum().equals("DefineCost")){
			ThMaster.DefineCost(maqAlugada.getnMaq());
		}
		
		return "VerLog";
	}
}
	
	
	
	

