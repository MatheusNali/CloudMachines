package com.cloudmachines.
model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hypervisor_type_tb database table.
 * 
 */
@Entity
@Table(name="hypervisor_type_tb")
@NamedQuery(name="HypervisorTypeTb.findAll", query="SELECT h FROM HypervisorTypeTb h")
public class HypervisorTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_hypervisor_type")
	private int idHypervisorType;

	@Column(name="hypervisor_type_desc")
	private String hypervisorTypeDesc;

	//bi-directional many-to-one association to HypervisorTb
	@OneToMany(mappedBy="hypervisorTypeTb")
	private List<HypervisorTb> hypervisorTbs;

	public HypervisorTypeTb() {
	}

	public int getIdHypervisorType() {
		return this.idHypervisorType;
	}

	public void setIdHypervisorType(int idHypervisorType) {
		this.idHypervisorType = idHypervisorType;
	}

	public String getHypervisorTypeDesc() {
		return this.hypervisorTypeDesc;
	}

	public void setHypervisorTypeDesc(String hypervisorTypeDesc) {
		this.hypervisorTypeDesc = hypervisorTypeDesc;
	}

	public List<HypervisorTb> getHypervisorTbs() {
		return this.hypervisorTbs;
	}

	public void setHypervisorTbs(List<HypervisorTb> hypervisorTbs) {
		this.hypervisorTbs = hypervisorTbs;
	}

	public HypervisorTb addHypervisorTb(HypervisorTb hypervisorTb) {
		getHypervisorTbs().add(hypervisorTb);
		hypervisorTb.setHypervisorTypeTb(this);

		return hypervisorTb;
	}

	public HypervisorTb removeHypervisorTb(HypervisorTb hypervisorTb) {
		getHypervisorTbs().remove(hypervisorTb);
		hypervisorTb.setHypervisorTypeTb(null);

		return hypervisorTb;
	}

}