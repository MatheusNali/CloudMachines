package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hypervisor_tb database table.
 * 
 */
@Entity
@Table(name="hypervisor_tb")
@NamedQuery(name="HypervisorTb.findAll", query="SELECT h FROM HypervisorTb h")
public class HypervisorTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_hypervisor")
	private int idHypervisor;

	@Column(name="hypervisor_desc")
	private String hypervisorDesc;

	@Column(name="hypervisor_name")
	private String hypervisorName;

	//bi-directional many-to-one association to HypervisorTypeTb
	@ManyToOne
	@JoinColumn(name="id_hypervisor_type")
	private HypervisorTypeTb hypervisorTypeTb;

	//bi-directional many-to-one association to ManagementToolsTb
	@OneToMany(mappedBy="hypervisorTb")
	private List<ManagementToolsTb> managementToolsTbs;

	public HypervisorTb() {
	}

	public int getIdHypervisor() {
		return this.idHypervisor;
	}

	public void setIdHypervisor(int idHypervisor) {
		this.idHypervisor = idHypervisor;
	}

	public String getHypervisorDesc() {
		return this.hypervisorDesc;
	}

	public void setHypervisorDesc(String hypervisorDesc) {
		this.hypervisorDesc = hypervisorDesc;
	}

	public String getHypervisorName() {
		return this.hypervisorName;
	}

	public void setHypervisorName(String hypervisorName) {
		this.hypervisorName = hypervisorName;
	}

	public HypervisorTypeTb getHypervisorTypeTb() {
		return this.hypervisorTypeTb;
	}

	public void setHypervisorTypeTb(HypervisorTypeTb hypervisorTypeTb) {
		this.hypervisorTypeTb = hypervisorTypeTb;
	}

	public List<ManagementToolsTb> getManagementToolsTbs() {
		return this.managementToolsTbs;
	}

	public void setManagementToolsTbs(List<ManagementToolsTb> managementToolsTbs) {
		this.managementToolsTbs = managementToolsTbs;
	}

	public ManagementToolsTb addManagementToolsTb(ManagementToolsTb managementToolsTb) {
		getManagementToolsTbs().add(managementToolsTb);
		managementToolsTb.setHypervisorTb(this);

		return managementToolsTb;
	}

	public ManagementToolsTb removeManagementToolsTb(ManagementToolsTb managementToolsTb) {
		getManagementToolsTbs().remove(managementToolsTb);
		managementToolsTb.setHypervisorTb(null);

		return managementToolsTb;
	}

}