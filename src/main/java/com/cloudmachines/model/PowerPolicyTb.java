package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the power_policy_tb database table.
 * 
 */
@Entity
@Table(name="power_policy_tb")
@NamedQuery(name="PowerPolicyTb.findAll", query="SELECT p FROM PowerPolicyTb p")
public class PowerPolicyTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_power_policy")
	private int idPowerPolicy;

	@Column(name="power_consumption")
	private BigDecimal powerConsumption;

	//bi-directional many-to-one association to PeriodTb
	@ManyToOne
	@JoinColumn(name="id_period_end")
	private PeriodTb periodTb1;

	//bi-directional many-to-one association to PolicyTb
	@ManyToOne
	@JoinColumn(name="id_policy")
	private PolicyTb policyTb;

	//bi-directional many-to-one association to PeriodTb
	@ManyToOne
	@JoinColumn(name="id_period_start")
	private PeriodTb periodTb2;

	public PowerPolicyTb() {
	}

	public int getIdPowerPolicy() {
		return this.idPowerPolicy;
	}

	public void setIdPowerPolicy(int idPowerPolicy) {
		this.idPowerPolicy = idPowerPolicy;
	}

	public BigDecimal getPowerConsumption() {
		return this.powerConsumption;
	}

	public void setPowerConsumption(BigDecimal powerConsumption) {
		this.powerConsumption = powerConsumption;
	}

	public PeriodTb getPeriodTb1() {
		return this.periodTb1;
	}

	public void setPeriodTb1(PeriodTb periodTb1) {
		this.periodTb1 = periodTb1;
	}

	public PolicyTb getPolicyTb() {
		return this.policyTb;
	}

	public void setPolicyTb(PolicyTb policyTb) {
		this.policyTb = policyTb;
	}

	public PeriodTb getPeriodTb2() {
		return this.periodTb2;
	}

	public void setPeriodTb2(PeriodTb periodTb2) {
		this.periodTb2 = periodTb2;
	}

}