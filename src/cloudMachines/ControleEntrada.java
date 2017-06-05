package cloudMachines;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ControleEntrada {
	private static final Logger logger = LogManager.getLogger();
	
	public static void main(String[] args) {

		Boolean pLoop = true;
		int nMaq = 0, Pol = 0, Op = 0;

		ArrayList<ArrayList<Integer>> ThLog = new ArrayList<ArrayList<Integer>>(); int ID = 0; // Variáveis para logging.
		ThLog.add(new ArrayList<Integer>()); // Posição 0 para Threads em modo sleep.
		ThLog.add(new ArrayList<Integer>()); // Posição 1 para Threads ativas.

		Scanner Sc = new Scanner(System.in);

		CriadorThreads cTh = new CriadorThreads();

		ExecutorService execService = Executors.newCachedThreadPool();
		ArrayList<Future> Futures = new ArrayList<Future>();
		ArrayList<Integer> idFutures = new ArrayList<Integer>();

		while (pLoop) {
			System.out.println("------------------------ Cloud Machines ------------------------\n");
			System.out.println("Bem vindo, escolha uma das opções abaixo.");
			System.out.println("1 = Alugar máquinas, 2 = Liberar máquinas, 3 = Threads Log, 4 = Encerrar programa.");
			Op = Sc.nextInt();

			if (Op == 1) {
				System.out.println("Quantas máquinas deseja?");
				nMaq = Sc.nextInt();
				System.out.println("Qual política deseja utilizar? \n 1=ROI, 2=OnDemand, 3=DefineCost.");
				Pol = Sc.nextInt();
			}

			else if (Op == 2) {
				System.out.println(
						"\nEscolha uma opção.\n1 = Liberar máquinas por quantidade, 2 = Liberar máquina por ID.");
				Op = Sc.nextInt();
				if (Op == 1) {
					System.out.println("Quantas máquinas deseja liberar?");
					nMaq = Sc.nextInt();
					LiberarMaqQuantidade(nMaq, Futures, ThLog);
				} else if (Op == 2) {
					System.out.println("Qual máquina deseja liberar (ID)?");
					idMaqFree = Sc.nextInt();
					LiberarMaqID(nMaq, Futures, ThLog, idMaqFree);
				}
			}

			else if (Op == 3) {
				MostrarThLog(ThLog);
			}

			else if (Op == 4) {
				if (vTarefasAtivas(Futures)){
					System.out.println("Ainda há tarefas ativas, deseja finalizá-las?");
					System.out.println("1 = Não, 2 = Sim.");
					if (Sc.nextInt() == 2) {
						System.out.println("Aguardando finalização das tarefas.");
						LiberarMaqs(Futures);
						execService.shutdown();
						pLoop = false;
					}

				} else {
					System.out.println("Aguardando finalização das tarefas.");
					execService.shutdown();
					pLoop = false;
				}
			}

			switch (Pol) {

			case 1:
				cTh.ROI(execService, nMaq, Futures, ThLog, ID);
				ID += nMaq;
				break;
			case 2:
				cTh.OnDemand(execService, nMaq, Futures, ThLog, ID);
				ID += nMaq;
				break;
			case 3:
				cTh.DefineCost(execService, nMaq, Futures, ThLog, ID);
				ID += nMaq;
				break;
			default:
				break;
			}

			Pol = 0;

		}
		Sc.close();
		System.out.println("Programa Encerrado.");
	}
	
//Por enquanto o print é apenas do ID mas podemos adicionar conforme mudamos o código
	private static void MostrarThLog(ArrayList<ArrayList<Integer>> ThLog) {
		System.out.println("");
		int i = 0;
		while(i < ThLog.get(1).size()){
			logger.info("Maquina online: "+ThLog.get(1).get(i).toString());
			i++;
		}
		i=0;
		while(i < ThLog.get(0).size()){
			logger.info("Maquina offline: "+ThLog.get(0).get(i).toString());
			i++;
		}
		System.out.println("");
	}

	private static void LiberarMaqs(ArrayList<Future> Futures) {
		while(Futures.size() != 0) {
			Futures.get(0).cancel(true);
			Futures.remove(0);
		}
	}

	private static boolean vTarefasAtivas(ArrayList<Future> Futures) {
		for (int i = 0; i < Futures.size(); i++) {
			if (Futures.get(i).isDone())
				return false;
		}
		return true;
	}

	public static boolean LiberarMaqQuantidade(int nMaq, ArrayList<Future> Futures, ArrayList<ArrayList<Integer>> ThLog) {
		int MaqAtual = 0, CounterMaqFree = 0;

		if (nMaq > Futures.size()) {
			System.out.println("Erro, número de máquinas para liberar é maior que o número de máquinas ativas.");
			return false;
		}

		while (CounterMaqFree < nMaq) {
			if (MaqAtual == nMaq) {
				if (CounterMaqFree == 0) {
					System.out.println("Não há máquinas em execução.\n");
					return false;
				}
				MaqAtual = 0; // Fica no loop até conseguir liberar as nMaq.Pode ser colocado um contador de tentativas para liberar.
			}
			if (!Futures.get(MaqAtual).isDone()) {
				if (Futures.get(MaqAtual).cancel(true)) {
					Futures.remove(MaqAtual);
					CounterMaqFree++;
					ThLog.get(0).add(ThLog.get(1).get(MaqAtual));
					ThLog.get(1).remove(MaqAtual);
				}
			}
		}
		System.out.println("Máquinas liberadas.");
		return true;

	}

	// O ID é a posição da task no ArrayList de Future. Precisa melhorar e colocar o ID certo (Banco de dados).
	public static void LiberarMaqID(int nMaq, ArrayList<Future> Futures, ArrayList<ArrayList<Integer>> ThLog, int idMaqFree) {
		int MaqAtual = 0, MaqAtualAtiva = 0;

		while (MaqAtual < nMaq) {
			if (ThLog.get(1).get(MaqAtualAtiva) == idMaqFree) {
				if (Futures.get(MaqAtual).cancel(true)) {
					Futures.remove(MaqAtual);
					ThLog.get(0).add(ThLog.get(1).get(MaqAtual));
					ThLog.get(1).remove(MaqAtual);
					System.out.println("");
					System.out.println("Finalizando máquina " + MaqAtual);
					System.out.println("");
					return;
				}
			}
			if (!Futures.get(MaqAtual).isDone()) MaqAtualAtiva++;
			MaqAtual++;
		}
	}
}
