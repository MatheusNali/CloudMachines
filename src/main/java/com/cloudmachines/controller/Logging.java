package com.cloudmachines.controller;

import java.util.ArrayList;
import java.util.Date;

public class Logging {

	public Logging(){
		ROI_List = new ArrayList<Integer>();
		OnDemand_List = new ArrayList<Integer>();
		DefineCost_List = new ArrayList<Integer>();
	}

	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}
	public Date getDataIni() {
		return DataIni;
	}
	public void setDataIni(Date dataIni) {
		DataIni = dataIni;
	}
	public Date getDataFim() {
		return DataFim;
	}
	public void setDataFim(Date dataFim) {
		DataFim = dataFim;
	}
	public int getIDCliente() {
		return IDCliente;
	}
	public void setIDCliente(int iDCliente) {
		IDCliente = iDCliente;
	}
	public ArrayList<Integer> getPolicy(int type){
		if (type == 1){
			return ROI_List;
		}
		else if (type == 2){
			return OnDemand_List;
		}
		else if (type == 3){
			return DefineCost_List;
		}
		return null;
	}
	public void setPolicy(int type, int ID){
		if (type == 1){
			ROI_List.add(ID);
		}
		else if (type == 2){
			OnDemand_List.add(ID);
		}
		else if (type == 3){
			DefineCost_List.add(ID);
		}
	}
	
	private int Estado;
	private Date DataIni;
	private Date DataFim;
	private int IDCliente;
	private ArrayList<Integer> ROI_List;
	private ArrayList<Integer> OnDemand_List;
	private ArrayList<Integer> DefineCost_List;
}
