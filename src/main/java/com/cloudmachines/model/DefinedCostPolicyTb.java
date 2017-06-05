package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the defined_cost_policy_tb database table.
 * 
 */
@Entity
@Table(name="defined_cost_policy_tb")
@NamedQuery(name="DefinedCostPolicyTb.findAll", query="SELECT d FROM DefinedCostPolicyTb d")
public class DefinedCostPolicyTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_defined_cost_policy")
	private int idDefinedCostPolicy;

	@Column(name="actual_value")
	private BigDecimal actualValue;

	@Column(name="fixed_diary_value")
	private BigDecimal fixedDiaryValue;

	@Column(name="initial_value")
	private BigDecimal initialValue;

	//bi-directional many-to-one association to DefinedCostPolicyTypeTb
	@ManyToOne
	@JoinColumn(name="id_defined_cost_policy_type")
	private DefinedCostPolicyTypeTb definedCostPolicyTypeTb;

	//bi-directional many-to-one association to PolicyTb
	@ManyToOne
	@JoinColumn(name="id_policy")
	private PolicyTb policyTb;

	//bi-directional many-to-one association to ScheduledDaysTb
	@OneToMany(mappedBy="definedCostPolicyTb")
	private List<ScheduledDaysTb> scheduledDaysTbs;

	public DefinedCostPolicyTb() {
	}

	public int getIdDefinedCostPolicy() {
		return this.idDefinedCostPolicy;
	}

	public void setIdDefinedCostPolicy(int idDefinedCostPolicy) {
		this.idDefinedCostPolicy = idDefinedCostPolicy;
	}

	public BigDecimal getActualValue() {
		return this.actualValue;
	}

	public void setActualValue(BigDecimal actualValue) {
		this.actualValue = actualValue;
	}

	public BigDecimal getFixedDiaryValue() {
		return this.fixedDiaryValue;
	}

	public void setFixedDiaryValue(BigDecimal fixedDiaryValue) {
		this.fixedDiaryValue = fixedDiaryValue;
	}

	public BigDecimal getInitialValue() {
		return this.initialValue;
	}

	public void setInitialValue(BigDecimal initialValue) {
		this.initialValue = initialValue;
	}

	public DefinedCostPolicyTypeTb getDefinedCostPolicyTypeTb() {
		return this.definedCostPolicyTypeTb;
	}

	public void setDefinedCostPolicyTypeTb(DefinedCostPolicyTypeTb definedCostPolicyTypeTb) {
		this.definedCostPolicyTypeTb = definedCostPolicyTypeTb;
	}

	public PolicyTb getPolicyTb() {
		return this.policyTb;
	}

	public void setPolicyTb(PolicyTb policyTb) {
		this.policyTb = policyTb;
	}

	public List<ScheduledDaysTb> getScheduledDaysTbs() {
		return this.scheduledDaysTbs;
	}

	public void setScheduledDaysTbs(List<ScheduledDaysTb> scheduledDaysTbs) {
		this.scheduledDaysTbs = scheduledDaysTbs;
	}

	public ScheduledDaysTb addScheduledDaysTb(ScheduledDaysTb scheduledDaysTb) {
		getScheduledDaysTbs().add(scheduledDaysTb);
		scheduledDaysTb.setDefinedCostPolicyTb(this);

		return scheduledDaysTb;
	}

	public ScheduledDaysTb removeScheduledDaysTb(ScheduledDaysTb scheduledDaysTb) {
		getScheduledDaysTbs().remove(scheduledDaysTb);
		scheduledDaysTb.setDefinedCostPolicyTb(null);

		return scheduledDaysTb;
	}

}