package com.cloudmachines.modelSemBD;

public enum Politica {

	ROI("ROI"),
	OnDemand("OnDemand"),
	DefineCost("DefineCost");
	
	private String Pol;
	
	Politica(String Pol){
		this.Pol = Pol;
	}
	
	public String getPol(){
		return Pol;
	}
}
