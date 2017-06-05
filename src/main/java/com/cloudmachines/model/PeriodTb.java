package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the period_tb database table.
 * 
 */
@Entity
@Table(name="period_tb")
@NamedQuery(name="PeriodTb.findAll", query="SELECT p FROM PeriodTb p")
public class PeriodTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_period")
	private int idPeriod;

	private int day;

	private int hour;

	private int month;

	@Column(name="week_day")
	private int weekDay;

	private int year;

	//bi-directional many-to-one association to PowerPolicyTb
	@OneToMany(mappedBy="periodTb1")
	private List<PowerPolicyTb> powerPolicyTbs1;

	//bi-directional many-to-one association to PowerPolicyTb
	@OneToMany(mappedBy="periodTb2")
	private List<PowerPolicyTb> powerPolicyTbs2;

	//bi-directional many-to-one association to RoiPolicyTb
	@OneToMany(mappedBy="periodTb1")
	private List<RoiPolicyTb> roiPolicyTbs1;

	//bi-directional many-to-one association to RoiPolicyTb
	@OneToMany(mappedBy="periodTb2")
	private List<RoiPolicyTb> roiPolicyTbs2;

	public PeriodTb() {
	}

	public int getIdPeriod() {
		return this.idPeriod;
	}

	public void setIdPeriod(int idPeriod) {
		this.idPeriod = idPeriod;
	}

	public int getDay() {
		return this.day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getHour() {
		return this.hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getWeekDay() {
		return this.weekDay;
	}

	public void setWeekDay(int weekDay) {
		this.weekDay = weekDay;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<PowerPolicyTb> getPowerPolicyTbs1() {
		return this.powerPolicyTbs1;
	}

	public void setPowerPolicyTbs1(List<PowerPolicyTb> powerPolicyTbs1) {
		this.powerPolicyTbs1 = powerPolicyTbs1;
	}

	public PowerPolicyTb addPowerPolicyTbs1(PowerPolicyTb powerPolicyTbs1) {
		getPowerPolicyTbs1().add(powerPolicyTbs1);
		powerPolicyTbs1.setPeriodTb1(this);

		return powerPolicyTbs1;
	}

	public PowerPolicyTb removePowerPolicyTbs1(PowerPolicyTb powerPolicyTbs1) {
		getPowerPolicyTbs1().remove(powerPolicyTbs1);
		powerPolicyTbs1.setPeriodTb1(null);

		return powerPolicyTbs1;
	}

	public List<PowerPolicyTb> getPowerPolicyTbs2() {
		return this.powerPolicyTbs2;
	}

	public void setPowerPolicyTbs2(List<PowerPolicyTb> powerPolicyTbs2) {
		this.powerPolicyTbs2 = powerPolicyTbs2;
	}

	public PowerPolicyTb addPowerPolicyTbs2(PowerPolicyTb powerPolicyTbs2) {
		getPowerPolicyTbs2().add(powerPolicyTbs2);
		powerPolicyTbs2.setPeriodTb2(this);

		return powerPolicyTbs2;
	}

	public PowerPolicyTb removePowerPolicyTbs2(PowerPolicyTb powerPolicyTbs2) {
		getPowerPolicyTbs2().remove(powerPolicyTbs2);
		powerPolicyTbs2.setPeriodTb2(null);

		return powerPolicyTbs2;
	}

	public List<RoiPolicyTb> getRoiPolicyTbs1() {
		return this.roiPolicyTbs1;
	}

	public void setRoiPolicyTbs1(List<RoiPolicyTb> roiPolicyTbs1) {
		this.roiPolicyTbs1 = roiPolicyTbs1;
	}

	public RoiPolicyTb addRoiPolicyTbs1(RoiPolicyTb roiPolicyTbs1) {
		getRoiPolicyTbs1().add(roiPolicyTbs1);
		roiPolicyTbs1.setPeriodTb1(this);

		return roiPolicyTbs1;
	}

	public RoiPolicyTb removeRoiPolicyTbs1(RoiPolicyTb roiPolicyTbs1) {
		getRoiPolicyTbs1().remove(roiPolicyTbs1);
		roiPolicyTbs1.setPeriodTb1(null);

		return roiPolicyTbs1;
	}

	public List<RoiPolicyTb> getRoiPolicyTbs2() {
		return this.roiPolicyTbs2;
	}

	public void setRoiPolicyTbs2(List<RoiPolicyTb> roiPolicyTbs2) {
		this.roiPolicyTbs2 = roiPolicyTbs2;
	}

	public RoiPolicyTb addRoiPolicyTbs2(RoiPolicyTb roiPolicyTbs2) {
		getRoiPolicyTbs2().add(roiPolicyTbs2);
		roiPolicyTbs2.setPeriodTb2(this);

		return roiPolicyTbs2;
	}

	public RoiPolicyTb removeRoiPolicyTbs2(RoiPolicyTb roiPolicyTbs2) {
		getRoiPolicyTbs2().remove(roiPolicyTbs2);
		roiPolicyTbs2.setPeriodTb2(null);

		return roiPolicyTbs2;
	}

}