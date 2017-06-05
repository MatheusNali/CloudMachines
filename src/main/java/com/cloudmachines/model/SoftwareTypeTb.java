package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the software_type_tb database table.
 * 
 */
@Entity
@Table(name="software_type_tb")
@NamedQuery(name="SoftwareTypeTb.findAll", query="SELECT s FROM SoftwareTypeTb s")
public class SoftwareTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_software_type")
	private int idSoftwareType;

	@Column(name="software_type_desc")
	private int softwareTypeDesc;

	//bi-directional many-to-one association to SoftwareTb
	@OneToMany(mappedBy="softwareTypeTb")
	private List<SoftwareTb> softwareTbs;

	public SoftwareTypeTb() {
	}

	public int getIdSoftwareType() {
		return this.idSoftwareType;
	}

	public void setIdSoftwareType(int idSoftwareType) {
		this.idSoftwareType = idSoftwareType;
	}

	public int getSoftwareTypeDesc() {
		return this.softwareTypeDesc;
	}

	public void setSoftwareTypeDesc(int softwareTypeDesc) {
		this.softwareTypeDesc = softwareTypeDesc;
	}

	public List<SoftwareTb> getSoftwareTbs() {
		return this.softwareTbs;
	}

	public void setSoftwareTbs(List<SoftwareTb> softwareTbs) {
		this.softwareTbs = softwareTbs;
	}

	public SoftwareTb addSoftwareTb(SoftwareTb softwareTb) {
		getSoftwareTbs().add(softwareTb);
		softwareTb.setSoftwareTypeTb(this);

		return softwareTb;
	}

	public SoftwareTb removeSoftwareTb(SoftwareTb softwareTb) {
		getSoftwareTbs().remove(softwareTb);
		softwareTb.setSoftwareTypeTb(null);

		return softwareTb;
	}

}