package cloudMachines;

import java.util.Scanner;

public class Entrada {

	public static void main(String[] args){

		Scanner Sc = new Scanner(System.in);
		int nMaq = 0, Pol = 0; //Variáveis para o número de máquinas e a para a política.

		System.out.println("Bem vindo, quantas máquinas deseja?");
		nMaq = Sc.nextInt();
		System.out.println("Qual política deseja utilizar? \n 1=ROI, 2=OnDemand, 3=DefineCost");
		Pol = Sc.nextInt();

		Sc.close();

		CriadorThreads cTh = new CriadorThreads();

		switch (Pol) { //switch com chamada dos métodos que criam as threads de cada política.
		case 1: Pol = 1;
			cTh.ROI(nMaq, Pol);
			break;
		case 2: Pol = 2;
			cTh.OnDemand(nMaq, Pol);
			break;
		case 3: Pol = 3;
			cTh.DefineCost(nMaq, Pol);
			break;
		default:
			break;
		}
	}
}
