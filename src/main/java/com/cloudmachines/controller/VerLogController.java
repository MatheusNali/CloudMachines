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

	public static void LogMessage(String message) {
		logger.info("	"+message);
	}

	public static void LogInit(boolean head) {
		if(head){
			logger.info("<log>");
		}
		else{
			logger.info("</log>");
		}
	}

	public static void LogWarn(String message) {
		logger.warn("	"+message);
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

			LogInit(true);
			if (ArrLogAc.size() != 0) {

				if (ArrLogAc.size() != 0) {
					LogMessage("<Client>" + ArrLogAc.get(0).getIDCliente() + "</Client>");
					LogMessage("	<Policy>" + "ROI" + "</Policy>");

					for (int j = 0; j < ArrLogAc.size(); j++) {
						LogMessage("	<Machine>");
						LogMessage("		<ID>" + ArrLogAc.get(j).getMaqID() + "</ID>");
						LogMessage("		<Status>" + "Ativa" + "</Status>");
						LogMessage("	</Machine>");
					}

					if (ArrLogIn.size() != 0) {
						for (int j = 0; j < ArrLogIn.size(); j++) {
							LogMessage("	<Machine>");
							LogMessage("		<ID>" + ArrLogIn.get(j).getMaqID() + "</ID>");
							LogMessage("		<Status>" + "Inativa" + "</Status>");
							LogMessage("	</Machine>");
						}
					}
				}
			}

			else if (ArrLogIn.size() != 0) {
				LogMessage("<Client>" + ArrLogIn.get(0).getIDCliente() + "</Client>");
				LogMessage("	<Policy>" + "ROI" + "</Policy>");
				for (int j = 0; j < ArrLogIn.size(); j++) {
					LogMessage("	<Machine>");
					LogMessage("		<ID>" + ArrLogIn.get(j).getMaqID() + "</ID>");
					LogMessage("		<Status>" + "Ativa" + "</Status>");
					LogMessage("	</Machine>");
				}
			}

			ArrLogAc = ThMaster.getArrLogOnDemand(1);
			ArrLogIn = ThMaster.getArrLogOnDemand(0);

			if (ArrLogAc.size() != 0) {

				if (ArrLogAc.size() != 0) {
					LogMessage("<Client>" + ArrLogAc.get(0).getIDCliente() + "</Client>");
					LogMessage("	<Policy>" + "OnDemand" + "</Policy>");

					for (int j = 0; j < ArrLogAc.size(); j++) {
						LogMessage("	<Machine>");
						LogMessage("		<ID>" + ArrLogAc.get(j).getMaqID() + "</ID>");
						LogMessage("		<Status>" + "Ativa" + "</Status>");
						LogMessage("	</Machine>");
					}

					if (ArrLogIn.size() != 0) {
						for (int j = 0; j < ArrLogIn.size(); j++) {
							LogMessage("	<Machine>");
							LogMessage("		<ID>" + ArrLogIn.get(j).getMaqID() + "</ID>");
							LogMessage("		<Status>" + "Inativa" + "</Status>");
							LogMessage("	</Machine>");
						}
					}
				}
			}

			else if (ArrLogIn.size() != 0) {
				LogMessage("<Client>" + ArrLogIn.get(0).getIDCliente() + "</Client>");
				LogMessage("	<Policy>" + "OnDemand" + "</Policy>");
				for (int j = 0; j < ArrLogIn.size(); j++) {
					LogMessage("	<Machine>");
					LogMessage("		<ID>" + ArrLogIn.get(j).getMaqID() + "</ID>");
					LogMessage("		<Status>" + "Inativa" + "</Status>");
					LogMessage("	</Machine>");
				}
			}

			ArrLogAc = ThMaster.getArrLogDefineCost(1);
			ArrLogIn = ThMaster.getArrLogDefineCost(0);
			if (ArrLogAc.size() != 0) {

				if (ArrLogAc.size() != 0) {
					LogMessage("<Client>" + ArrLogAc.get(0).getIDCliente() + "</Client>");
					LogMessage("	<Policy>" + "DefineCost" + "</Policy>");

					for (int j = 0; j < ArrLogAc.size(); j++) {
						LogMessage("	<Machine>");
						LogMessage("		<ID>" + ArrLogAc.get(j).getMaqID() + "</ID>");
						LogMessage("		<Status>" + "Ativa" + "</Status>");
						LogMessage("	</Machine>");
					}

					if (ArrLogIn.size() != 0) {
						for (int j = 0; j < ArrLogIn.size(); j++) {
							LogMessage("	<Machine>");
							LogMessage("		<ID>" + ArrLogIn.get(j).getMaqID() + "</ID>");
							LogMessage("		<Status>" + "Inativa" + "</Status>");
							LogMessage("	</Machine>");
						}
					}
				}
			}

			else if (ArrLogIn.size() != 0) {
				LogMessage("<Client>" + ArrLogIn.get(0).getIDCliente() + "</Client>");
				LogMessage("	<Policy>" + "DefineCost" + "</Policy>");
				for (int j = 0; j < ArrLogIn.size(); j++) {
					LogMessage("	<Machine>");
					LogMessage("		<ID>" + ArrLogIn.get(j).getMaqID() + "</ID>");
					LogMessage("		<Status>" + "Inativa" + "</Status>");
					LogMessage("	</Machine>");
				}
			}
			LogInit(false);
		}
	}
}
