package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vm_tb database table.
 * 
 */
@Entity
@Table(name="vm_tb")
@NamedQuery(name="VmTb.findAll", query="SELECT v FROM VmTb v")
public class VmTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_vm")
	private int idVm;

	private String description;

	private String name;

	//bi-directional many-to-one association to BillingHistoryTb
	@OneToMany(mappedBy="vmTb")
	private List<BillingHistoryTb> billingHistoryTbs;

	//bi-directional many-to-one association to StepTb
	@OneToMany(mappedBy="vmTb")
	private List<StepTb> stepTbs;

	//bi-directional many-to-one association to ClientTb
	@ManyToOne
	@JoinColumn(name="id_client")
	private ClientTb clientTb;

	//bi-directional many-to-one association to MachineCapacityTb
	@ManyToOne
	@JoinColumn(name="id_machine_capacity")
	private MachineCapacityTb machineCapacityTb;

	//bi-directional many-to-one association to RmTb
	@ManyToOne
	@JoinColumn(name="id_rm")
	private RmTb rmTb;

	//bi-directional many-to-one association to VmStatusTb
	@ManyToOne
	@JoinColumn(name="id_vm_status")
	private VmStatusTb vmStatusTb;

	//bi-directional many-to-one association to VmTimestampsTb
	@OneToMany(mappedBy="vmTb")
	private List<VmTimestampsTb> vmTimestampsTbs;

	public VmTb() {
	}

	public int getIdVm() {
		return this.idVm;
	}

	public void setIdVm(int idVm) {
		this.idVm = idVm;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BillingHistoryTb> getBillingHistoryTbs() {
		return this.billingHistoryTbs;
	}

	public void setBillingHistoryTbs(List<BillingHistoryTb> billingHistoryTbs) {
		this.billingHistoryTbs = billingHistoryTbs;
	}

	public BillingHistoryTb addBillingHistoryTb(BillingHistoryTb billingHistoryTb) {
		getBillingHistoryTbs().add(billingHistoryTb);
		billingHistoryTb.setVmTb(this);

		return billingHistoryTb;
	}

	public BillingHistoryTb removeBillingHistoryTb(BillingHistoryTb billingHistoryTb) {
		getBillingHistoryTbs().remove(billingHistoryTb);
		billingHistoryTb.setVmTb(null);

		return billingHistoryTb;
	}

	public List<StepTb> getStepTbs() {
		return this.stepTbs;
	}

	public void setStepTbs(List<StepTb> stepTbs) {
		this.stepTbs = stepTbs;
	}

	public StepTb addStepTb(StepTb stepTb) {
		getStepTbs().add(stepTb);
		stepTb.setVmTb(this);

		return stepTb;
	}

	public StepTb removeStepTb(StepTb stepTb) {
		getStepTbs().remove(stepTb);
		stepTb.setVmTb(null);

		return stepTb;
	}

	public ClientTb getClientTb() {
		return this.clientTb;
	}

	public void setClientTb(ClientTb clientTb) {
		this.clientTb = clientTb;
	}

	public MachineCapacityTb getMachineCapacityTb() {
		return this.machineCapacityTb;
	}

	public void setMachineCapacityTb(MachineCapacityTb machineCapacityTb) {
		this.machineCapacityTb = machineCapacityTb;
	}

	public RmTb getRmTb() {
		return this.rmTb;
	}

	public void setRmTb(RmTb rmTb) {
		this.rmTb = rmTb;
	}

	public VmStatusTb getVmStatusTb() {
		return this.vmStatusTb;
	}

	public void setVmStatusTb(VmStatusTb vmStatusTb) {
		this.vmStatusTb = vmStatusTb;
	}

	public List<VmTimestampsTb> getVmTimestampsTbs() {
		return this.vmTimestampsTbs;
	}

	public void setVmTimestampsTbs(List<VmTimestampsTb> vmTimestampsTbs) {
		this.vmTimestampsTbs = vmTimestampsTbs;
	}

	public VmTimestampsTb addVmTimestampsTb(VmTimestampsTb vmTimestampsTb) {
		getVmTimestampsTbs().add(vmTimestampsTb);
		vmTimestampsTb.setVmTb(this);

		return vmTimestampsTb;
	}

	public VmTimestampsTb removeVmTimestampsTb(VmTimestampsTb vmTimestampsTb) {
		getVmTimestampsTbs().remove(vmTimestampsTb);
		vmTimestampsTb.setVmTb(null);

		return vmTimestampsTb;
	}

}