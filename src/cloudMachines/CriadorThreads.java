package cloudMachines;

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

		for (int i = 0; i < nMaq; i++) {
			ROI RunnableROI = new ROI();				
			Thread ThreadROI = new Thread(RunnableROI);
			ThreadROI.start();
			
		}
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
