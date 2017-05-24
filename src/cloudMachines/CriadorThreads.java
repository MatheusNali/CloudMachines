package cloudMachines;

import java.util.concurrent.ExecutorService;

//Nesse documento temos 3 classes referentes às políticas, elas possuem contrutores e o método 'run()' para escrever o código que a thread irá executar.

class ROI implements Runnable {

	private int ID;
	private int Pol;
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public int getPol() {
		return Pol;
	}
	public void setPol(int Pol) {
		this.Pol = Pol;
	}
	
	public ROI(int ID) {
		this.ID = ID;
		this.Pol = 1;
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

public class CriadorThreads {
	
	public void ROI(ExecutorService execService, int nMaq) {
		
		int Counter = 1;
																  
		for (int i = 0; i < nMaq; i++) {
			execService.submit(new ROI(Counter)); //Submissão da 'task'(Execução do Runnable) ROI() para a thread.
			execService.submit(new OnDemand());
			Counter++;
		}
		
		execService.shutdown(); //Necessária para o encerramento do programa depois que é finalizada a execução de todas as tarefas.
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
