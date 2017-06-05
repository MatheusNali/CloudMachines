package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the ondemand_policy_tb database table.
 * 
 */
@Entity
@Table(name="ondemand_policy_tb")
@NamedQuery(name="OndemandPolicyTb.findAll", query="SELECT o FROM OndemandPolicyTb o")
public class OndemandPolicyTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ondemand_policy")
	private int idOndemandPolicy;

	@Column(name="actual_value")
	private BigDecimal actualValue;

	@Column(name="initial_value")
	private BigDecimal initialValue;

	//bi-directional many-to-one association to OndemandPolicyTypeTb
	@ManyToOne
	@JoinColumn(name="id_ondemand_policy_type")
	private OndemandPolicyTypeTb ondemandPolicyTypeTb;

	//bi-directional many-to-one association to PolicyTb
	@ManyToOne
	@JoinColumn(name="id_policy")
	private PolicyTb policyTb;

	public OndemandPolicyTb() {
	}

	public int getIdOndemandPolicy() {
		return this.idOndemandPolicy;
	}

	public void setIdOndemandPolicy(int idOndemandPolicy) {
		this.idOndemandPolicy = idOndemandPolicy;
	}

	public BigDecimal getActualValue() {
		return this.actualValue;
	}

	public void setActualValue(BigDecimal actualValue) {
		this.actualValue = actualValue;
	}

	public BigDecimal getInitialValue() {
		return this.initialValue;
	}

	public void setInitialValue(BigDecimal initialValue) {
		this.initialValue = initialValue;
	}

	public OndemandPolicyTypeTb getOndemandPolicyTypeTb() {
		return this.ondemandPolicyTypeTb;
	}

	public void setOndemandPolicyTypeTb(OndemandPolicyTypeTb ondemandPolicyTypeTb) {
		this.ondemandPolicyTypeTb = ondemandPolicyTypeTb;
	}

	public PolicyTb getPolicyTb() {
		return this.policyTb;
	}

	public void setPolicyTb(PolicyTb policyTb) {
		this.policyTb = policyTb;
	}

}