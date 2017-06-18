package com.cloudmachines.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

@Controller
public class AlugarMaqController {
	public int nMaq;
	public int Pol;
	public int ID;
	ExecutorService execService = Executors.newCachedThreadPool();
	ArrayList<Future> Futures = new ArrayList<Future>();
	ArrayList<Integer> idFutures = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> ThLog = new ArrayList<ArrayList<Integer>>();  // Variáveis para logging.
//	ThLog.add(new ArrayList<Integer>()); // Posição 0 para Threads em modo sleep.
//	ThLog.add(new ArrayList<Integer>()); // Posição 1 para Threads ativas.
	

	@RequestMapping("CloudMachines/AlugarMaq")
	public String AlugarMaq(){
		return "AlugarMaq";
	}
	
	public class CriadorThreads{

		public void ROI(ExecutorService execService, int nMaq, ArrayList<Future> Futures, ArrayList<ArrayList<Integer>> ThLog, int ID) {

			for (int i = 0; i < nMaq; i++) {
				
				Futures.add(execService.submit(new ROI(ThLog, ID))); // Submissão da 'task'(Execução do Runnable) ROI() para a thread.
				ID++;
			}
		}

		public void OnDemand(ExecutorService execService, int nMaq, ArrayList<Future> Futures, ArrayList<ArrayList<Integer>> ThLog, int ID) {
			Futures.add(execService.submit(new OnDemand(ThLog, ID)));
		}

		public void DefineCost(ExecutorService execService, int nMaq, ArrayList<Future> Futures, ArrayList<ArrayList<Integer>> ThLog, int ID) {
			Futures.add(execService.submit(new DefineCost(ThLog, ID)));
		}
	}
	
	
	@RequestMapping("/AlugarMaq")
	  public String aluga(int nMaq ,int Pol) {		
		
		CriadorThreads cTh = new CriadorThreads();
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
		}		
	  return "Theads executadas com sucesso";
	  }

	
	
	class ROI implements Runnable {
		
		public ROI(ArrayList<ArrayList<Integer>> ThLog, int ID) {
			ThLog.get(1).add(ID);
		}

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {

			}
		}
	}

	class OnDemand implements Runnable {

		public OnDemand(ArrayList<ArrayList<Integer>> ThLog, int ID) {
			ThLog.get(1).add(ID);
		}

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {

			}
		}

	}

	class DefineCost implements Runnable {

		public DefineCost(ArrayList<ArrayList<Integer>> ThLog, int ID) {
			ThLog.get(1).add(ID);
		}
		
		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {

			}
		}		
	}
}
	
	
	
	

