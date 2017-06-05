package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the roi_policy_tb database table.
 * 
 */
@Entity
@Table(name="roi_policy_tb")
@NamedQuery(name="RoiPolicyTb.findAll", query="SELECT r FROM RoiPolicyTb r")
public class RoiPolicyTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_roi")
	private int idRoi;

	@Column(name="actual_value")
	private BigDecimal actualValue;

	private BigDecimal amount;

	@Column(name="initial_value")
	private BigDecimal initialValue;

	@Column(name="rate_applied")
	private BigDecimal rateApplied;

	@Column(name="return")
	private BigDecimal return_;

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

	public RoiPolicyTb() {
	}

	public int getIdRoi() {
		return this.idRoi;
	}

	public void setIdRoi(int idRoi) {
		this.idRoi = idRoi;
	}

	public BigDecimal getActualValue() {
		return this.actualValue;
	}

	public void setActualValue(BigDecimal actualValue) {
		this.actualValue = actualValue;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getInitialValue() {
		return this.initialValue;
	}

	public void setInitialValue(BigDecimal initialValue) {
		this.initialValue = initialValue;
	}

	public BigDecimal getRateApplied() {
		return this.rateApplied;
	}

	public void setRateApplied(BigDecimal rateApplied) {
		this.rateApplied = rateApplied;
	}

	public BigDecimal getReturn_() {
		return this.return_;
	}

	public void setReturn_(BigDecimal return_) {
		this.return_ = return_;
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