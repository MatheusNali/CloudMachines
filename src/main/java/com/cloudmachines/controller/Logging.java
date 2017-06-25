package com.cloudmachines.controller;

import java.util.Date;

public class Logging {
	
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
	public int getMaqID() {
		return MaqID;
	}
	public void setMaqID(int maqID) {
		MaqID = maqID;
	}
	public int Estado;
	public Date DataIni;
	public Date DataFim;
	public int IDCliente;
	public int MaqID;
	
	

}
