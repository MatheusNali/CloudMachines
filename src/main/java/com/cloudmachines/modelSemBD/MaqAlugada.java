package com.cloudmachines.modelSemBD;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaqAlugada {

	public int getnMaq() {
		return nMaq;
	}

	public void setnMaq(int nMaq) {
		this.nMaq = nMaq;
	}

	public Politica getPol() {
		return Pol;
	}

	public void setPol(Politica pol) {
		Pol = pol;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nMaq;

	@Enumerated(EnumType.STRING)
	private Politica Pol;

}
