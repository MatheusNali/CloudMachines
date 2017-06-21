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
			LogMessage(true,"Cliente "+Integer.toString(Log.getIDCliente()));
			LogMessage(false,"Estado: "+Integer.toString(Log.getEstado()));
			LogMessage(false,"Inicio: "+Log.getDataIni().toString());
			if(Log.getDataFim() != null) LogMessage(false,"Fim: "+Log.getDataFim().toString());		
		}
		else
			LogWarn("Nao foram encontradas maquinas alugadas");
	}
	
	@RequestMapping("CloudMachines/VerLog")
	public String VerLog(){
		return "VerLog";
	}		
}
