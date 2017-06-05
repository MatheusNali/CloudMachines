package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the policy_type_tb database table.
 * 
 */
@Entity
@Table(name="policy_type_tb")
@NamedQuery(name="PolicyTypeTb.findAll", query="SELECT p FROM PolicyTypeTb p")
public class PolicyTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_policy_type")
	private int idPolicyType;

	@Column(name="policy_type_desc")
	private String policyTypeDesc;

	//bi-directional many-to-one association to PolicyTb
	@OneToMany(mappedBy="policyTypeTb")
	private List<PolicyTb> policyTbs;

	public PolicyTypeTb() {
	}

	public int getIdPolicyType() {
		return this.idPolicyType;
	}

	public void setIdPolicyType(int idPolicyType) {
		this.idPolicyType = idPolicyType;
	}

	public String getPolicyTypeDesc() {
		return this.policyTypeDesc;
	}

	public void setPolicyTypeDesc(String policyTypeDesc) {
		this.policyTypeDesc = policyTypeDesc;
	}

	public List<PolicyTb> getPolicyTbs() {
		return this.policyTbs;
	}

	public void setPolicyTbs(List<PolicyTb> policyTbs) {
		this.policyTbs = policyTbs;
	}

	public PolicyTb addPolicyTb(PolicyTb policyTb) {
		getPolicyTbs().add(policyTb);
		policyTb.setPolicyTypeTb(this);

		return policyTb;
	}

	public PolicyTb removePolicyTb(PolicyTb policyTb) {
		getPolicyTbs().remove(policyTb);
		policyTb.setPolicyTypeTb(null);

		return policyTb;
	}

}