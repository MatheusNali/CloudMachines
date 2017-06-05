package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the power_status_tb database table.
 * 
 */
@Entity
@Table(name="power_status_tb")
@NamedQuery(name="PowerStatusTb.findAll", query="SELECT p FROM PowerStatusTb p")
public class PowerStatusTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_power_status")
	private int idPowerStatus;

	@Column(name="power_status_desc")
	private String powerStatusDesc;

	//bi-directional many-to-one association to RmTb
	@OneToMany(mappedBy="powerStatusTb")
	private List<RmTb> rmTbs;

	//bi-directional many-to-one association to StepTb
	@OneToMany(mappedBy="powerStatusTb")
	private List<StepTb> stepTbs;

	public PowerStatusTb() {
	}

	public int getIdPowerStatus() {
		return this.idPowerStatus;
	}

	public void setIdPowerStatus(int idPowerStatus) {
		this.idPowerStatus = idPowerStatus;
	}

	public String getPowerStatusDesc() {
		return this.powerStatusDesc;
	}

	public void setPowerStatusDesc(String powerStatusDesc) {
		this.powerStatusDesc = powerStatusDesc;
	}

	public List<RmTb> getRmTbs() {
		return this.rmTbs;
	}

	public void setRmTbs(List<RmTb> rmTbs) {
		this.rmTbs = rmTbs;
	}

	public RmTb addRmTb(RmTb rmTb) {
		getRmTbs().add(rmTb);
		rmTb.setPowerStatusTb(this);

		return rmTb;
	}

	public RmTb removeRmTb(RmTb rmTb) {
		getRmTbs().remove(rmTb);
		rmTb.setPowerStatusTb(null);

		return rmTb;
	}

	public List<StepTb> getStepTbs() {
		return this.stepTbs;
	}

	public void setStepTbs(List<StepTb> stepTbs) {
		this.stepTbs = stepTbs;
	}

	public StepTb addStepTb(StepTb stepTb) {
		getStepTbs().add(stepTb);
		stepTb.setPowerStatusTb(this);

		return stepTb;
	}

	public StepTb removeStepTb(StepTb stepTb) {
		getStepTbs().remove(stepTb);
		stepTb.setPowerStatusTb(null);

		return stepTb;
	}

}