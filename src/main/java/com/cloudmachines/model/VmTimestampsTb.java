package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the vm_timestamps_tb database table.
 * 
 */
@Entity
@Table(name="vm_timestamps_tb")
@NamedQuery(name="VmTimestampsTb.findAll", query="SELECT v FROM VmTimestampsTb v")
public class VmTimestampsTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_timestamp")
	private String idTimestamp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date start;

	@Temporal(TemporalType.TIMESTAMP)
	private Date stop;

	//bi-directional many-to-one association to StepTb
	@OneToMany(mappedBy="vmTimestampsTb")
	private List<StepTb> stepTbs;

	//bi-directional many-to-one association to MachineCapacityTb
	@ManyToOne
	@JoinColumn(name="id_machine_capacity")
	private MachineCapacityTb machineCapacityTb;

	//bi-directional many-to-one association to VmTb
	@ManyToOne
	@JoinColumn(name="id_vm")
	private VmTb vmTb;

	public VmTimestampsTb() {
	}

	public String getIdTimestamp() {
		return this.idTimestamp;
	}

	public void setIdTimestamp(String idTimestamp) {
		this.idTimestamp = idTimestamp;
	}

	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getStop() {
		return this.stop;
	}

	public void setStop(Date stop) {
		this.stop = stop;
	}

	public List<StepTb> getStepTbs() {
		return this.stepTbs;
	}

	public void setStepTbs(List<StepTb> stepTbs) {
		this.stepTbs = stepTbs;
	}

	public StepTb addStepTb(StepTb stepTb) {
		getStepTbs().add(stepTb);
		stepTb.setVmTimestampsTb(this);

		return stepTb;
	}

	public StepTb removeStepTb(StepTb stepTb) {
		getStepTbs().remove(stepTb);
		stepTb.setVmTimestampsTb(null);

		return stepTb;
	}

	public MachineCapacityTb getMachineCapacityTb() {
		return this.machineCapacityTb;
	}

	public void setMachineCapacityTb(MachineCapacityTb machineCapacityTb) {
		this.machineCapacityTb = machineCapacityTb;
	}

	public VmTb getVmTb() {
		return this.vmTb;
	}

	public void setVmTb(VmTb vmTb) {
		this.vmTb = vmTb;
	}

}