package cloudMachines;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Nesse documento temos 3 classes referentes às políticas, elas possuem contrutores e o método 'run()' para escrever o código que a thread irá executar.

class ROI implements Runnable {

	public ROI() {
		
	}

	@Override
	public void run(){

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

//A classe CriadorThreads possui os métodos que são chamados no switch do arquivo 'Entrada.java'. Foi feito um loop com o for para criar a quantidade 'nMaq' de threads.
//Seguindo com o código temos a instanciação da classe Runnable, criação da thread, inicialização da thread e usa-se o método 'Join()' para criar as threads na ordem desejada.
public class CriadorThreads {

	public void ROI(int nMaq, int Pol) {
		
		ExecutorService execService = Executors.newFixedThreadPool(nMaq); //Cria uma thread pool com um número fixo de threads (nMaq). Nesse caso, no máximo (nMaq) threads estarão em ativas simultaneamente.
																		  //Se for necessário executar mais de nMaq tarefas, será criada uma fila de espera.
		for (int i = 0; i < nMaq; i++) {
			execService.execute(new ROI());	//Submissão da 'task'(Execução do Runnable) ROI() para a thread.
		}
		
		execService.shutdown(); //Necessária para o encerramento do programa depois que é finalizada a execução de todas as tarefas.
		execService.execute(new ROI());
	}
	
	public void OnDemand(int nMaq, int Pol) {

		for (int i = 0; i < nMaq; i++) {
			OnDemand RunnableOnDemand = new OnDemand();
			Thread ThreadOnDemand = new Thread(RunnableOnDemand);
			ThreadOnDemand.start();

			try {
				ThreadOnDemand.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void DefineCost(int nMaq, int Pol) {

		for (int i = 0; i < nMaq; i++) {
			DefineCost RunnableDefineCost = new DefineCost();
			Thread ThreadDefineCost = new Thread(RunnableDefineCost);
			ThreadDefineCost.start();

			try {
				ThreadDefineCost.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
