package com.cloudmachines.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerLogController {

	public ThreadMaster ThMaster;

	private static Logger logger = LoggerFactory.getLogger(cmController.class.getClass());
	// Necessário para log ele imprime tudo no console e cria um arquivo de log
	// mais detalhado

	// Função genérica de log, usando o separator para um destaque no log e o
	// message para o texto que deve ser escrito

	public static void LogMessage(boolean separator, String message) {
		if (separator) {
			logger.info("---------------MENSAGEM-----------------");
		}
		logger.info(message);
	}

	public static void LogWarn(String message) {
		logger.warn("");
		logger.warn("---------------ATENÇÃO------------------");
		logger.warn(message);
	}

	public void add(ThreadMaster thMaster) {
		ThMaster = thMaster;
	}

	// Função que imprime um log básico para o estado das máquinas de um cliente.
	public void Standart_Log() {

		if (ThMaster != null) {
			String Estado = null;

			ArrayList<Logging> ArrLogAc = null;
			ArrayList<Logging> ArrLogIn = null;

			ArrLogAc = ThMaster.getArrLogROI(1);
			ArrLogIn = ThMaster.getArrLogROI(0);

			if (ArrLogAc.size() != 0) {

				if (ArrLogAc.size() != 0) {
					LogMessage(true, "Cliente:" + ArrLogAc.get(0).getIDCliente());
					LogMessage(false, "ROI");

					for (int j = 0; j < ArrLogAc.size(); j++) {
						LogMessage(false, "Máquina:" + ArrLogAc.get(j).getMaqID() + ", Ativa");
					}

					if (ArrLogIn.size() != 0) {
						for (int j = 0; j < ArrLogIn.size(); j++) {
							LogMessage(false, "Máquina:" + ArrLogIn.get(j).getMaqID() + ", Inativa");
						}
					}
				}
			}

			else if (ArrLogIn.size() != 0) {
				LogMessage(true, "Cliente:" + ArrLogIn.get(0).getIDCliente());
				LogMessage(false, "ROI");
				for (int j = 0; j < ArrLogIn.size(); j++) {
					LogMessage(false, "Máquina:" + ArrLogIn.get(j).getMaqID() + ", Inativa");
				}
			}

			ArrLogAc = ThMaster.getArrLogOnDemand(1);
			ArrLogIn = ThMaster.getArrLogOnDemand(0);

			if (ArrLogAc.size() != 0) {

				if (ArrLogAc.size() != 0) {
					LogMessage(true, "Cliente:" + ArrLogAc.get(0).getIDCliente());
					LogMessage(false, "OnDemand");

					for (int j = 0; j < ArrLogAc.size(); j++) {
						LogMessage(false, "Máquina:" + ArrLogAc.get(j).getMaqID() + ", Ativa");
					}

					if (ArrLogIn.size() != 0) {
						for (int j = 0; j < ArrLogIn.size(); j++) {
							LogMessage(false, "Máquina:" + ArrLogIn.get(j).getMaqID() + ", Inativa");
						}
					}
				}
			}

			else if (ArrLogIn.size() != 0) {
				LogMessage(true, "Cliente:" + ArrLogIn.get(0).getIDCliente());
				LogMessage(false, "OnDemand");
				for (int j = 0; j < ArrLogIn.size(); j++) {
					LogMessage(false, "Máquina:" + ArrLogIn.get(j).getMaqID() + ", Inativa");
				}
			}

			ArrLogAc = ThMaster.getArrLogDefineCost(1);
			ArrLogIn = ThMaster.getArrLogDefineCost(0);
			if (ArrLogAc.size() != 0) {

				if (ArrLogAc.size() != 0) {
					LogMessage(true, "Cliente:" + ArrLogAc.get(0).getIDCliente());
					LogMessage(false, "DefineCost");

					for (int j = 0; j < ArrLogAc.size(); j++) {
						LogMessage(false, "Máquina:" + ArrLogAc.get(j).getMaqID() + ", Ativa");
					}

					if (ArrLogIn.size() != 0) {
						for (int j = 0; j < ArrLogIn.size(); j++) {
							LogMessage(false, "Máquina:" + ArrLogIn.get(j).getMaqID() + ", Inativa");
						}
					}
				}
			}

			else if (ArrLogIn.size() != 0) {
				LogMessage(true, "Cliente:" + ArrLogIn.get(0).getIDCliente());
				LogMessage(false, "DefineCost");
				for (int j = 0; j < ArrLogIn.size(); j++) {
					LogMessage(false, "Máquina:" + ArrLogIn.get(j).getMaqID() + ", Inativa");
				}
			}
		}
	}
}
