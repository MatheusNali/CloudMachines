package com.cloudmachines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class AlugarMaqController {
	

	@RequestMapping("CloudMachines/AlugarMaq")
	public String AlugarMaq(){
		return "AlugarMaq";
	}
	

	
	
	@RequestMapping("/AlugarMaq")
	  public String aluga(int nMaq ,int Pol) {		
		
<<<<<<< HEAD
<<<<<<< Updated upstream
		CriadorThreads cTh = new CriadorThreads();
=======
	/*	CriadorThreads cTh = new CriadorThreads();
>>>>>>> af5c686... merge
		if(Pol == 1){
		cTh.ROI(execService, nMaq, Futures, ThLog, ID);
		ID += nMaq;
		}
		
		if(Pol == 2){
		cTh.OnDemand(execService, nMaq, Futures, ThLog, ID);
		ID += nMaq;
		}
		
		if(Pol == 3){
			cTh.DefineCost(execService, nMaq, Futures, ThLog, ID);
			ID += nMaq;
<<<<<<< HEAD
		}		
	  return "Theads executadas com sucesso";
=======
	
	  return "ThreadMaster";
>>>>>>> Stashed changes
=======
		}	*/	
	  return "ThreadMaster";
>>>>>>> af5c686... merge
	  }

	

}
	
	
	
	

