package com.cloudmachines.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Future;

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

		if (VerLogControl == null) {
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

		ArrayList<Logging> ArrLogAc = null;
		ArrayList<Logging> ArrLogIn = null;
		ArrayList<Future> Futures = null;

		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				ArrLogAc = ThMaster.getArrLogROI(1);
				ArrLogIn = ThMaster.getArrLogROI(0);
				Futures = ThMaster.getFutures(1);
			} else if (i == 1) {
				ArrLogAc = ThMaster.getArrLogOnDemand(1);
				ArrLogIn = ThMaster.getArrLogOnDemand(0);
				Futures = ThMaster.getFutures(2);
			} else if (i == 2) {
				ArrLogAc = ThMaster.getArrLogDefineCost(1);
				ArrLogIn = ThMaster.getArrLogDefineCost(0);
				Futures = ThMaster.getFutures(3);
			}
			for (int j = 0; j < ArrLogAc.size(); j++) {
				if (ArrLogAc.size() == 0)
					break;
				if (ArrLogAc.get(j).getMaqID() == ID) {
					Futures.get(j).cancel(true);
					Futures.remove(j);

					ArrLogIn.add(ArrLogAc.get(j));
					ArrLogAc.remove(j);
					ArrLogIn.get(ArrLogIn.size() - 1).setDataFim(new Date());
					ArrLogIn.get(ArrLogIn.size() - 1).setEstado(0);
					VerLogControl.Standart_Log();
					return "VerLog";
				}
			}
		}

		return "IDNotFound";
	}

	@RequestMapping(value = "CloudMachines/LiberarMaqQtn", method = RequestMethod.POST)
	public String LiberarQtn(int nMaq) {

		if (ThMaster == null)
			return "LowQtn";

		ArrayList<Logging> ArrLogAc = ThMaster.getArrLogROI(1);
		ArrayList<Logging> ArrLogIn = ThMaster.getArrLogROI(0);
		ArrayList<Future> Futures = ThMaster.getFutures(1);
		int Counter = 0;

		for (int i = 0; i < 2; i++) {

			if (i == 1) {
				ArrLogAc = ThMaster.getArrLogOnDemand(1);
				ArrLogIn = ThMaster.getArrLogOnDemand(0);
				Futures = ThMaster.getFutures(2);
			} else if (i == 2) {
				ArrLogAc = ThMaster.getArrLogDefineCost(1);
				ArrLogIn = ThMaster.getArrLogDefineCost(0);
				Futures = ThMaster.getFutures(3);
			}
			
			while (Counter != nMaq) {

				if (Futures.size() == 0 && Counter < nMaq)
					break;
				else if(Futures.size() == 0)
					return "LowQtn";

				Futures.get(0).cancel(true);
				Futures.remove(0);
				ArrLogIn.add(ArrLogAc.get(0));
				ArrLogAc.remove(0);
				ArrLogIn.get(ArrLogIn.size() - 1).setEstado(0);
				ArrLogIn.get(ArrLogIn.size() - 1).setDataFim(new Date());
				Counter++;
			}
			
			if (Counter == nMaq) {
				VerLogControl.Standart_Log();
				return "VerLog";
			}
		}
		return "LowQtn";
	}
}
