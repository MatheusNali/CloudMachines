package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the scheduled_days_tb database table.
 * 
 */
@Entity
@Table(name="scheduled_days_tb")
@NamedQuery(name="ScheduledDaysTb.findAll", query="SELECT s FROM ScheduledDaysTb s")
public class ScheduledDaysTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_scheduled_days")
	private int idScheduledDays;

	@Column(name="day_of_month")
	private int dayOfMonth;

	//bi-directional many-to-one association to DefinedCostPolicyTb
	@ManyToOne
	@JoinColumn(name="id_defined_cost_policy")
	private DefinedCostPolicyTb definedCostPolicyTb;

	public ScheduledDaysTb() {
	}

	public int getIdScheduledDays() {
		return this.idScheduledDays;
	}

	public void setIdScheduledDays(int idScheduledDays) {
		this.idScheduledDays = idScheduledDays;
	}

	public int getDayOfMonth() {
		return this.dayOfMonth;
	}

	public void setDayOfMonth(int dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public DefinedCostPolicyTb getDefinedCostPolicyTb() {
		return this.definedCostPolicyTb;
	}

	public void setDefinedCostPolicyTb(DefinedCostPolicyTb definedCostPolicyTb) {
		this.definedCostPolicyTb = definedCostPolicyTb;
	}

}