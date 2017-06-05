package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the compute_type_tb database table.
 * 
 */
@Entity
@Table(name="compute_type_tb")
@NamedQuery(name="ComputeTypeTb.findAll", query="SELECT c FROM ComputeTypeTb c")
public class ComputeTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_compute_type")
	private int idComputeType;

	@Column(name="compute_type_desc")
	private String computeTypeDesc;

	@Column(name="compute_type_feature")
	private String computeTypeFeature;

	//bi-directional many-to-one association to ComputeTb
	@OneToMany(mappedBy="computeTypeTb")
	private List<ComputeTb> computeTbs;

	public ComputeTypeTb() {
	}

	public int getIdComputeType() {
		return this.idComputeType;
	}

	public void setIdComputeType(int idComputeType) {
		this.idComputeType = idComputeType;
	}

	public String getComputeTypeDesc() {
		return this.computeTypeDesc;
	}

	public void setComputeTypeDesc(String computeTypeDesc) {
		this.computeTypeDesc = computeTypeDesc;
	}

	public String getComputeTypeFeature() {
		return this.computeTypeFeature;
	}

	public void setComputeTypeFeature(String computeTypeFeature) {
		this.computeTypeFeature = computeTypeFeature;
	}

	public List<ComputeTb> getComputeTbs() {
		return this.computeTbs;
	}

	public void setComputeTbs(List<ComputeTb> computeTbs) {
		this.computeTbs = computeTbs;
	}

	public ComputeTb addComputeTb(ComputeTb computeTb) {
		getComputeTbs().add(computeTb);
		computeTb.setComputeTypeTb(this);

		return computeTb;
	}

	public ComputeTb removeComputeTb(ComputeTb computeTb) {
		getComputeTbs().remove(computeTb);
		computeTb.setComputeTypeTb(null);

		return computeTb;
	}

}