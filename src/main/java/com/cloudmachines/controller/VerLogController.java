package com.cloudmachines.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class VerLogController {

	private static Logger logger = LoggerFactory.getLogger("com.cloudmachines.controller.LogController");
	//Necessario para log ele imprime tudo no console e cria um arquivo de log mais detalhado
	
	//Função genérica de log, usando o separator para um destaque no log
	//e o message para o texto que deve ser escrito
	public static void LogMessage(boolean separator, String message){
		if(separator){
			logger.info("---------------MENSAGEM-----------------");
		}
		logger.info(message);
	}
	
	public static void LogWarn(String message){
		logger.warn("");
	    logger.warn("---------------ATENCAO------------------");
		logger.warn(message);
	}
	
	//Função que gera um log básico para o estado das maquinas de um cliente
	public static void Standart_Log(){
		if (AlugarMaqController.ThMaster != null && AlugarMaqController.ThMaster.getLog() != null){
			Logging Log = AlugarMaqController.ThMaster.getLog();
			String estado;
			int i = 0;
			if (Log.getEstado() == 1) estado = "Ativo";
			else estado = "Inativo";
			LogMessage(true,"Cliente "+Integer.toString(Log.getIDCliente()));
			LogMessage(false,"Estado: "+estado);
			LogMessage(false,"Inicio: "+Log.getDataIni().toString());
			if(Log.getDataFim() != null) LogMessage(false,"Fim: "+Log.getDataFim().toString());		
			LogMessage(false,"Politicas e numero de maquinas:");
			LogMessage(false,"ROI: "+Integer.toString(Log.getPolicy(1).size())+" maquinas");
			if (!Log.getPolicy(1).isEmpty()){
				while (i < Log.getPolicy(1).size()){
					LogMessage(false,"Maquina: "+Integer.toString(Log.getPolicy(1).get(i)));
					i++;
				}
			}
			if (!Log.getPolicy(2).isEmpty()){
				LogMessage(false,"OnDemand: "+Integer.toString(Log.getPolicy(2).size()));
				while (i < Log.getPolicy(2).size()){
					LogMessage(false,"Maquina: "+Integer.toString(Log.getPolicy(2).get(i)));
					i++;
				}
			}
			if (!Log.getPolicy(3).isEmpty()){
				LogMessage(false,"DefineCost: "+Integer.toString(Log.getPolicy(3).size()));
				while (i < Log.getPolicy(3).size()){
					LogMessage(false,"Maquina: "+Integer.toString(Log.getPolicy(3).get(i)));
					i++;
				}
			}
		}
		else
			LogWarn("Nao foram encontradas maquinas alugadas");
	}
	
	@RequestMapping("CloudMachines/VerLog")
	public String VerLog(){
		return "VerLog";
	}		
}
