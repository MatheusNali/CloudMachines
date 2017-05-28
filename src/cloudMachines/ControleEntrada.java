package cloudMachines;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ControleEntrada {

	public static void main(String[] args) {

		Boolean pLoop = true;
		int nMaq = 0, Pol = 0, Op = 0, idMaqFree = 0;

		Scanner Sc = new Scanner(System.in);

		CriadorThreads cTh = new CriadorThreads();

		ExecutorService execService = Executors.newCachedThreadPool();
		ArrayList<Future> Futures = new ArrayList<Future>();
		ArrayList<Integer> idFutures = new ArrayList<Integer>();

		while (pLoop) {
			System.out.println("------------------------ Cloud Machines ------------------------\n");
			System.out.println("Bem vindo, escolha uma das opções abaixo.");
			System.out.println("1 = Alugar máquinas, 2 = Liberar máquinas, 3 = Encerrar programa.");
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
					LiberarMaqQuantidade(nMaq, Futures);
				} else if (Op == 2) {
					System.out.println("Qual máquina deseja liberar (ID)?");
					idMaqFree = Sc.nextInt();
					LiberarMaqID(nMaq, Futures, idFutures, idMaqFree);
				}
			}

			else if (Op == 3) {
				if (vTarefasAtivas(Futures)) {
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
				cTh.ROI(execService, nMaq, Futures, idFutures);
				break;
			case 2:
				cTh.OnDemand(execService, nMaq, Futures, idFutures);
				break;
			case 3:
				cTh.DefineCost(execService, nMaq, Futures, idFutures);
				break;
			default:
				break;
			}

			Pol = 0;

		}
		Sc.close();
		System.out.println("Programa Encerrado.");
	}

	private static void LiberarMaqs(ArrayList<Future> Futures) {
		for (int i = 0; i < Futures.size(); i++) {
			Futures.get(i).cancel(true);
		}

	}

	private static boolean vTarefasAtivas(ArrayList<Future> Futures) {
		for (int i = 0; i < Futures.size(); i++) {
			if (Futures.get(i).isDone())
				return false;
		}
		return true;
	}

	public static boolean LiberarMaqQuantidade(int nMaq, ArrayList<Future> Futures) {
		int MaqAtual = 0, CounterMaqFree = 0;

		while (CounterMaqFree < nMaq) {
			if (MaqAtual == nMaq) {
				if (CounterMaqFree == 0) {
					System.out.println("Não há máquinas em execução.\n");
					return false;
				}
				MaqAtual = 0;
			}
			if (!Futures.get(MaqAtual).isDone()) {
				if (Futures.get(MaqAtual).cancel(true)) {
					CounterMaqFree++;
				}
			}
			MaqAtual++;
		}
		System.out.println("Máquinas liberadas.");
		return true;
	}

	// O ID é a posição da task no ArrayList de Future. Precisa melhorar e colocar o ID certo (Banco de dados).
	public static void LiberarMaqID(int nMaq, ArrayList<Future> Futures, ArrayList<Integer> idFutures, int idMaqFree) {
		int i = 0;

		while (i < nMaq) {
			if ((!Futures.get(i).isDone()) && (idFutures.get(i) == idMaqFree)) {
				Futures.get(i).cancel(true);
				System.out.println("");
				System.out.println("----------------------");
				System.out.println("Finalizando máquina " + (i + 1));
				System.out.println("----------------------");
				System.out.println("");
			}
			i++;
		}
	}
}
