package com.cloudmachines.modelSemBD;

public enum Politica {

	ROI("Roi"),
	ONDEMAND("OnDemand"),
	DEFINECOST("DefineCost");
	
	private String pol;
	
	Politica(String pol){
		this.pol = pol;
	}
	
	public String getPol(){
		return pol;
	}
}
