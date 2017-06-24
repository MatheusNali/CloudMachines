package com.cloudmachines.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class VerLogController {
	
	ThreadMaster ThMaster;
	
	private static Logger logger = LoggerFactory.getLogger(cmController.class.getClass());
	//Necessário para log ele imprime tudo no console e cria um arquivo de log mais detalhado

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
	    logger.warn("---------------ATENÇÃO------------------");
		logger.warn(message);
	}
	
	//Função que gera um log básico para o estado das máquinas de um cliente.
	public void Standart_Log(){
		if (ThMaster != null && ThMaster.getLog() != null){
			Logging Log = ThMaster.getLog();
			String Estado;
			int i = 0;
			if (Log.getEstado() == 1) 
				Estado = "Ativo";
			else 
				Estado = "Inativo";
			LogMessage(true,"Cliente "+Integer.toString(Log.getIDCliente()));
			LogMessage(false,"Estado: "+Estado);
			LogMessage(false,"Início: "+Log.getDataIni().toString());
			if(Log.getDataFim() != null) LogMessage(false,"Fim: "+Log.getDataFim().toString());		
			LogMessage(false,"Políticas e número de máquinas:");
			LogMessage(false,"ROI: "+ThMaster.getArrLogROI().size()+" máquinas");
			if (!ThMaster.getArrLogROI().isEmpty()){
				while (i < ThMaster.getArrLogROI().size()){
					LogMessage(false,"Máquina:"+ThMaster.getArrLogROI().get(i).getMaqID());
					i++;

				}
			}
			i=0;
			if (!ThMaster.getArrLogOnDemand().isEmpty()){
				LogMessage(false,"OnDemand: "+ThMaster.getArrLogOnDemand().size());
				while (i < ThMaster.getArrLogOnDemand().size()){
					LogMessage(false,"Máquina: "+ThMaster.getArrLogOnDemand().get(i));
					i++;
				}
			}
			i=0;
			if (!ThMaster.getArrLogDefineCost().isEmpty()){
				LogMessage(false,"DefineCost: "+ThMaster.getArrLogDefineCost().size());
				while (i < ThMaster.getArrLogDefineCost().size()){
					LogMessage(false,"Máquina: "+ThMaster.getArrLogDefineCost().get(i));
					i++;
				}
			}
		}
		else
			LogWarn("Não foram encontradas máquinas alugadas");
	}
	
	@RequestMapping("CloudMachines/VerLog")
	public String VerLog(){
		return "VerLog";
	}

	public void add(ThreadMaster thMaster) {
		ThMaster = thMaster;
		
	}		
}
