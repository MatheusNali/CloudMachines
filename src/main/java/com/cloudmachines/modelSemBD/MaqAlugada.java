package com.cloudmachines.modelSemBD;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaqAlugada {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nMaq;

	@Enumerated(EnumType.STRING)
	private Politica Pol;

	public int getnMaq() {
		return nMaq;
	}

	public void setnMaq(int nMaq) {
		this.nMaq = nMaq;
	}

	public Politica getPolEnum() {
		return Pol;
	}

	public void setPol(Politica Pol) {
		this.Pol = Pol;
	}
}
