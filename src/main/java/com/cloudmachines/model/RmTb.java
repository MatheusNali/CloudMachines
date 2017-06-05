package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rm_tb database table.
 * 
 */
@Entity
@Table(name="rm_tb")
@NamedQuery(name="RmTb.findAll", query="SELECT r FROM RmTb r")
public class RmTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_rm")
	private int idRm;

	private String description;

	//bi-directional many-to-one association to MachineCapacityTb
	@ManyToOne
	@JoinColumn(name="id_machine_capacity")
	private MachineCapacityTb machineCapacityTb;

	//bi-directional many-to-one association to PowerStatusTb
	@ManyToOne
	@JoinColumn(name="id_power_status")
	private PowerStatusTb powerStatusTb;

	//bi-directional many-to-one association to ProviderTb
	@ManyToOne
	@JoinColumn(name="id_provider")
	private ProviderTb providerTb;

	//bi-directional many-to-one association to RmTimestampsTb
	@OneToMany(mappedBy="rmTb")
	private List<RmTimestampsTb> rmTimestampsTbs;

	//bi-directional many-to-one association to StepTb
	@OneToMany(mappedBy="rmTb")
	private List<StepTb> stepTbs;

	//bi-directional many-to-one association to VmTb
	@OneToMany(mappedBy="rmTb")
	private List<VmTb> vmTbs;

	public RmTb() {
	}

	public int getIdRm() {
		return this.idRm;
	}

	public void setIdRm(int idRm) {
		this.idRm = idRm;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MachineCapacityTb getMachineCapacityTb() {
		return this.machineCapacityTb;
	}

	public void setMachineCapacityTb(MachineCapacityTb machineCapacityTb) {
		this.machineCapacityTb = machineCapacityTb;
	}

	public PowerStatusTb getPowerStatusTb() {
		return this.powerStatusTb;
	}

	public void setPowerStatusTb(PowerStatusTb powerStatusTb) {
		this.powerStatusTb = powerStatusTb;
	}

	public ProviderTb getProviderTb() {
		return this.providerTb;
	}

	public void setProviderTb(ProviderTb providerTb) {
		this.providerTb = providerTb;
	}

	public List<RmTimestampsTb> getRmTimestampsTbs() {
		return this.rmTimestampsTbs;
	}

	public void setRmTimestampsTbs(List<RmTimestampsTb> rmTimestampsTbs) {
		this.rmTimestampsTbs = rmTimestampsTbs;
	}

	public RmTimestampsTb addRmTimestampsTb(RmTimestampsTb rmTimestampsTb) {
		getRmTimestampsTbs().add(rmTimestampsTb);
		rmTimestampsTb.setRmTb(this);

		return rmTimestampsTb;
	}

	public RmTimestampsTb removeRmTimestampsTb(RmTimestampsTb rmTimestampsTb) {
		getRmTimestampsTbs().remove(rmTimestampsTb);
		rmTimestampsTb.setRmTb(null);

		return rmTimestampsTb;
	}

	public List<StepTb> getStepTbs() {
		return this.stepTbs;
	}

	public void setStepTbs(List<StepTb> stepTbs) {
		this.stepTbs = stepTbs;
	}

	public StepTb addStepTb(StepTb stepTb) {
		getStepTbs().add(stepTb);
		stepTb.setRmTb(this);

		return stepTb;
	}

	public StepTb removeStepTb(StepTb stepTb) {
		getStepTbs().remove(stepTb);
		stepTb.setRmTb(null);

		return stepTb;
	}

	public List<VmTb> getVmTbs() {
		return this.vmTbs;
	}

	public void setVmTbs(List<VmTb> vmTbs) {
		this.vmTbs = vmTbs;
	}

	public VmTb addVmTb(VmTb vmTb) {
		getVmTbs().add(vmTb);
		vmTb.setRmTb(this);

		return vmTb;
	}

	public VmTb removeVmTb(VmTb vmTb) {
		getVmTbs().remove(vmTb);
		vmTb.setRmTb(null);

		return vmTb;
	}

}