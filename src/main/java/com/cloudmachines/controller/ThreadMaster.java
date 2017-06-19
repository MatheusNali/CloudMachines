package com.cloudmachines.controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

<<<<<<< HEAD:target/classes/com/cloudmachines/controller/AlugarMaqController.java
<<<<<<< Updated upstream:target/classes/com/cloudmachines/controller/AlugarMaqController.java
@Controller
public class AlugarMaqController {
=======
public class ThreadMaster {

>>>>>>> af5c686... merge:src/main/java/com/cloudmachines/controller/ThreadMaster.java
	public int nMaq;
	public int Pol;
	public int ID;
	ExecutorService execService = Executors.newCachedThreadPool();
	ArrayList<Future> Futures = new ArrayList<Future>();
	ArrayList<Integer> idFutures = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> ThLog = new ArrayList<ArrayList<Integer>>();  // Variáveis para logging.
<<<<<<< HEAD:target/classes/com/cloudmachines/controller/AlugarMaqController.java
//	ThLog.add(new ArrayList<Integer>()); // Posição 0 para Threads em modo sleep.
//	ThLog.add(new ArrayList<Integer>()); // Posição 1 para Threads ativas.
	
=======
public class ThreadMaster {


	//Nesse documento temos 3 classes referentes às políticas, elas possuem contrutores e o método 'run()' para escrever o código que a thread irá executar.
	//O loop de cada algoritmo é rodado até que a Thread seja interrompida (Nesse caso, ocorre quando é pedido a liberação da máquina).
>>>>>>> Stashed changes:src/main/java/com/cloudmachines/controller/ThreadMaster.java

	@RequestMapping("CloudMachines/AlugarMaq")
	public String AlugarMaq(){
		return "AlugarMaq";
	}
=======
	//ThLog.add(new ArrayList<Integer>()); // Posição 0 para Threads em modo sleep.
	//ThLog.add(new ArrayList<Integer>()); // Posição 1 para Threads ativas.
>>>>>>> af5c686... merge:src/main/java/com/cloudmachines/controller/ThreadMaster.java
	
	//Nesse documento temos 3 classes referentes às políticas, elas possuem contrutores e o método 'run()' para escrever o código que a thread irá executar.
	//O loop de cada algoritmo é rodado até que a Thread seja interrompida (Nesse caso, ocorre quando é pedido a liberação da máquina).

	class ROI implements Runnable {

		public ROI() {

		}

		@Override
		public void run() {
			while (!Thread.currentThread().isInterrupted()) {

			}

		}
	}

	class OnDemand implements Runnable {

		public OnDemand() {

		}

		@Override
		public void run() {

		}

	}

	class DefineCost implements Runnable {

		public DefineCost() {

		}

		@Override
		public void run() {

		}

	}

	// A classe CriadorThreads possui os métodos que são chamados no switch do arquivo 'Entrada.java'. Foi feito um loop com o for para criar a quantidade 'nMaq' de threads.

	public class CriadorThreads {

		public void ROI(ExecutorService execService, int nMaq, ArrayList<Future> Futures, ArrayList<Integer> idFutures) {

			for (int i = 0; i < nMaq; i++) {
				Futures.add(execService.submit(new ROI())); // Submissão da 'task'(Execução do Runnable) ROI() para a thread.
			}
		}

		public void OnDemand(ExecutorService execService, int nMaq, ArrayList<Future> Futures, ArrayList<Integer> idFutures) {

		}

		public void DefineCost(ExecutorService execService, int nMaq, ArrayList<Future> Futures, ArrayList<Integer> idFutures) {

		}
	}
	
	
	
	
}
