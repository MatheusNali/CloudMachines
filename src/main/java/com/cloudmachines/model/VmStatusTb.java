package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vm_status_tb database table.
 * 
 */
@Entity
@Table(name="vm_status_tb")
@NamedQuery(name="VmStatusTb.findAll", query="SELECT v FROM VmStatusTb v")
public class VmStatusTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_vm_status")
	private int idVmStatus;

	@Column(name="vm_status_desc")
	private String vmStatusDesc;

	//bi-directional many-to-one association to VmTb
	@OneToMany(mappedBy="vmStatusTb")
	private List<VmTb> vmTbs;

	public VmStatusTb() {
	}

	public int getIdVmStatus() {
		return this.idVmStatus;
	}

	public void setIdVmStatus(int idVmStatus) {
		this.idVmStatus = idVmStatus;
	}

	public String getVmStatusDesc() {
		return this.vmStatusDesc;
	}

	public void setVmStatusDesc(String vmStatusDesc) {
		this.vmStatusDesc = vmStatusDesc;
	}

	public List<VmTb> getVmTbs() {
		return this.vmTbs;
	}

	public void setVmTbs(List<VmTb> vmTbs) {
		this.vmTbs = vmTbs;
	}

	public VmTb addVmTb(VmTb vmTb) {
		getVmTbs().add(vmTb);
		vmTb.setVmStatusTb(this);

		return vmTb;
	}

	public VmTb removeVmTb(VmTb vmTb) {
		getVmTbs().remove(vmTb);
		vmTb.setVmStatusTb(null);

		return vmTb;
	}

}