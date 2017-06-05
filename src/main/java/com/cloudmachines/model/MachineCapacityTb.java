package com.cloudmachines.
model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the machine_capacity_tb database table.
 * 
 */
@Entity
@Table(name="machine_capacity_tb")
@NamedQuery(name="MachineCapacityTb.findAll", query="SELECT m FROM MachineCapacityTb m")
public class MachineCapacityTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_machine_capacity")
	private int idMachineCapacity;

	@Column(name="machine_capacity_desc")
	private String machineCapacityDesc;

	//bi-directional many-to-one association to ResourceTb
	@ManyToOne
	@JoinColumn(name="id_resource")
	private ResourceTb resourceTb;

	//bi-directional many-to-one association to SoftwareTb
	@ManyToOne
	@JoinColumn(name="id_software")
	private SoftwareTb softwareTb;

	//bi-directional many-to-one association to RmTb
	@OneToMany(mappedBy="machineCapacityTb")
	private List<RmTb> rmTbs;

	//bi-directional many-to-one association to VmTb
	@OneToMany(mappedBy="machineCapacityTb")
	private List<VmTb> vmTbs;

	//bi-directional many-to-one association to VmTimestampsTb
	@OneToMany(mappedBy="machineCapacityTb")
	private List<VmTimestampsTb> vmTimestampsTbs;

	public MachineCapacityTb() {
	}

	public int getIdMachineCapacity() {
		return this.idMachineCapacity;
	}

	public void setIdMachineCapacity(int idMachineCapacity) {
		this.idMachineCapacity = idMachineCapacity;
	}

	public String getMachineCapacityDesc() {
		return this.machineCapacityDesc;
	}

	public void setMachineCapacityDesc(String machineCapacityDesc) {
		this.machineCapacityDesc = machineCapacityDesc;
	}

	public ResourceTb getResourceTb() {
		return this.resourceTb;
	}

	public void setResourceTb(ResourceTb resourceTb) {
		this.resourceTb = resourceTb;
	}

	public SoftwareTb getSoftwareTb() {
		return this.softwareTb;
	}

	public void setSoftwareTb(SoftwareTb softwareTb) {
		this.softwareTb = softwareTb;
	}

	public List<RmTb> getRmTbs() {
		return this.rmTbs;
	}

	public void setRmTbs(List<RmTb> rmTbs) {
		this.rmTbs = rmTbs;
	}

	public RmTb addRmTb(RmTb rmTb) {
		getRmTbs().add(rmTb);
		rmTb.setMachineCapacityTb(this);

		return rmTb;
	}

	public RmTb removeRmTb(RmTb rmTb) {
		getRmTbs().remove(rmTb);
		rmTb.setMachineCapacityTb(null);

		return rmTb;
	}

	public List<VmTb> getVmTbs() {
		return this.vmTbs;
	}

	public void setVmTbs(List<VmTb> vmTbs) {
		this.vmTbs = vmTbs;
	}

	public VmTb addVmTb(VmTb vmTb) {
		getVmTbs().add(vmTb);
		vmTb.setMachineCapacityTb(this);

		return vmTb;
	}

	public VmTb removeVmTb(VmTb vmTb) {
		getVmTbs().remove(vmTb);
		vmTb.setMachineCapacityTb(null);

		return vmTb;
	}

	public List<VmTimestampsTb> getVmTimestampsTbs() {
		return this.vmTimestampsTbs;
	}

	public void setVmTimestampsTbs(List<VmTimestampsTb> vmTimestampsTbs) {
		this.vmTimestampsTbs = vmTimestampsTbs;
	}

	public VmTimestampsTb addVmTimestampsTb(VmTimestampsTb vmTimestampsTb) {
		getVmTimestampsTbs().add(vmTimestampsTb);
		vmTimestampsTb.setMachineCapacityTb(this);

		return vmTimestampsTb;
	}

	public VmTimestampsTb removeVmTimestampsTb(VmTimestampsTb vmTimestampsTb) {
		getVmTimestampsTbs().remove(vmTimestampsTb);
		vmTimestampsTb.setMachineCapacityTb(null);

		return vmTimestampsTb;
	}

}