package com.cloudmachines.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cloudmachines.modelSemBD.MaqAlugada;

@Controller
public class cmController {

	ThreadMaster ThMaster;
	VerLogController VerLogControl;

	@RequestMapping("CloudMachines/AlugarMaq")
	public String AlugarMaq() {
		return "AlugarMaq";
	}

	@RequestMapping("CloudMachines/LiberarMaqID")
	public String LiberarMaqID() {
		return "LiberarMaqID";
	}

	@RequestMapping("CloudMachines/LiberarMaqQtn")
	public String LiberarMaqQtn() {
		return "LiberarMaqQtn";
	}

	@RequestMapping("CloudMachines/Homepage")
	public String Homepage() {
		return "Homepage";
	}

	@RequestMapping("CloudMachines/Header")
	public String Header() {
		return "Header";
	}

	@RequestMapping("CloudMachines/VerLog")
	public String VerLog() {
		return "VerLog";
	}

	@RequestMapping(value = "CloudMachines/AlugarMaq", method = RequestMethod.POST)
	public String SalvarMaq(MaqAlugada maqAlugada) {
		if (ThMaster == null) {
			ThMaster = new ThreadMaster();
		}
		
		if(VerLogControl == null){
			VerLogControl = new VerLogController();
			VerLogControl.add(ThMaster);
		}

		if (maqAlugada.getPolEnum().getPol().equals("ROI")) {
			ThMaster.ROI(maqAlugada.getnMaq());
		} else if (maqAlugada.getPolEnum().getPol().equals("OnDemand")) {
			ThMaster.OnDemand(maqAlugada.getnMaq());
		} else if (maqAlugada.getPolEnum().getPol().equals("DefineCost")) {
			ThMaster.DefineCost(maqAlugada.getnMaq());
		}

		VerLogControl.Standart_Log();
		return "VerLog";

	}

	@RequestMapping(value = "CloudMachines/LiberarMaqID", method = RequestMethod.POST)
	public String LiberariD(int ID) {

		if (ThMaster == null)
			return "IDNotFound";
		
		ArrayList<Logging> ArrLog = null;

		for (int i = 0; i < 2; i++) {
			if (i == 0)
				ArrLog = ThMaster.getArrLogROI();
			else if (i == 1)
				ArrLog = ThMaster.getArrLogOnDemand();
			else if (i == 2)
				ArrLog = ThMaster.getArrLogDefineCost();
			for (int j = 0; j < ArrLog.size(); j++) {
				if (ArrLog.get(j).getMaqID() == ID) {
					ThMaster.getFutures().get(j).cancel(true);
					ThMaster.getFutures().remove(j);
					ArrLog.get(j).setEstado(0);
					ArrLog.get(j).setDataFim(new Date());
					return "VerLog";
				}
			}
		}

		return "IDNotFound";
	}

	@RequestMapping(value = "CloudMachines/LiberarMaqQtn", method = RequestMethod.POST)
	public String LiberarQtn(int nMaq) {
		System.out.println(nMaq);
		if (ThMaster == null)
			return "LowQtn";

		ArrayList<Logging> ArrLog = ThMaster.getArrLogROI();
		int Counter = 0;

		for (int i = 0; i < 2; i++) {
			if (Counter == nMaq)
				return "VerLog";
			else if (i == 1)
				ArrLog = ThMaster.getArrLogOnDemand();
			else if (i == 2)
				ArrLog = ThMaster.getArrLogDefineCost();
			for (int j = 0; j < ArrLog.size(); j++) {
				if(ThMaster.getFutures().get(j).cancel(true)){
					ThMaster.getFutures().remove(j);
					ArrLog.get(j).setEstado(0);
					ArrLog.get(j).setDataFim(new Date());
					Counter++;
				}
			}
		}

		return "LowQtn";
	}

}
