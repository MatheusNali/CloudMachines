package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the algorithm_tb database table.
 * 
 */
@Entity
@Table(name="algorithm_tb")
@NamedQuery(name="AlgorithmTb.findAll", query="SELECT a FROM AlgorithmTb a")
public class AlgorithmTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_algorithm")
	private int idAlgorithm;

	@Column(name="algorithm_class")
	private String algorithmClass;

	@Column(name="algorithm_desc")
	private String algorithmDesc;

	//bi-directional many-to-one association to PolicyTb
	@OneToMany(mappedBy="algorithmTb")
	private List<PolicyTb> policyTbs;

	public AlgorithmTb() {
	}

	public int getIdAlgorithm() {
		return this.idAlgorithm;
	}

	public void setIdAlgorithm(int idAlgorithm) {
		this.idAlgorithm = idAlgorithm;
	}

	public String getAlgorithmClass() {
		return this.algorithmClass;
	}

	public void setAlgorithmClass(String algorithmClass) {
		this.algorithmClass = algorithmClass;
	}

	public String getAlgorithmDesc() {
		return this.algorithmDesc;
	}

	public void setAlgorithmDesc(String algorithmDesc) {
		this.algorithmDesc = algorithmDesc;
	}

	public List<PolicyTb> getPolicyTbs() {
		return this.policyTbs;
	}

	public void setPolicyTbs(List<PolicyTb> policyTbs) {
		this.policyTbs = policyTbs;
	}

	public PolicyTb addPolicyTb(PolicyTb policyTb) {
		getPolicyTbs().add(policyTb);
		policyTb.setAlgorithmTb(this);

		return policyTb;
	}

	public PolicyTb removePolicyTb(PolicyTb policyTb) {
		getPolicyTbs().remove(policyTb);
		policyTb.setAlgorithmTb(null);

		return policyTb;
	}

}