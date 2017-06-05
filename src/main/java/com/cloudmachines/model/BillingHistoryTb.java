package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the billing_history_tb database table.
 * 
 */
@Entity
@Table(name="billing_history_tb")
@NamedQuery(name="BillingHistoryTb.findAll", query="SELECT b FROM BillingHistoryTb b")
public class BillingHistoryTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_billing_history")
	private int idBillingHistory;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="billing_date")
	private Date billingDate;

	@Column(name="billing_dialy_cost")
	private BigDecimal billingDialyCost;

	@Column(name="billing_dialy_hours_usage")
	private int billingDialyHoursUsage;

	//bi-directional many-to-one association to BillingTb
	@ManyToOne
	@JoinColumn(name="id_billing")
	private BillingTb billingTb;

	//bi-directional many-to-one association to VmTb
	@ManyToOne
	@JoinColumn(name="id_vm")
	private VmTb vmTb;

	public BillingHistoryTb() {
	}

	public int getIdBillingHistory() {
		return this.idBillingHistory;
	}

	public void setIdBillingHistory(int idBillingHistory) {
		this.idBillingHistory = idBillingHistory;
	}

	public Date getBillingDate() {
		return this.billingDate;
	}

	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}

	public BigDecimal getBillingDialyCost() {
		return this.billingDialyCost;
	}

	public void setBillingDialyCost(BigDecimal billingDialyCost) {
		this.billingDialyCost = billingDialyCost;
	}

	public int getBillingDialyHoursUsage() {
		return this.billingDialyHoursUsage;
	}

	public void setBillingDialyHoursUsage(int billingDialyHoursUsage) {
		this.billingDialyHoursUsage = billingDialyHoursUsage;
	}

	public BillingTb getBillingTb() {
		return this.billingTb;
	}

	public void setBillingTb(BillingTb billingTb) {
		this.billingTb = billingTb;
	}

	public VmTb getVmTb() {
		return this.vmTb;
	}

	public void setVmTb(VmTb vmTb) {
		this.vmTb = vmTb;
	}

}