package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the compute_arch_tb database table.
 * 
 */
@Entity
@Table(name="compute_arch_tb")
@NamedQuery(name="ComputeArchTb.findAll", query="SELECT c FROM ComputeArchTb c")
public class ComputeArchTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_compute_arch")
	private int idComputeArch;

	@Column(name="compute_arch_desc")
	private String computeArchDesc;

	@Column(name="compute_arch_feature")
	private String computeArchFeature;

	//bi-directional many-to-one association to ComputeTb
	@OneToMany(mappedBy="computeArchTb")
	private List<ComputeTb> computeTbs;

	public ComputeArchTb() {
	}

	public int getIdComputeArch() {
		return this.idComputeArch;
	}

	public void setIdComputeArch(int idComputeArch) {
		this.idComputeArch = idComputeArch;
	}

	public String getComputeArchDesc() {
		return this.computeArchDesc;
	}

	public void setComputeArchDesc(String computeArchDesc) {
		this.computeArchDesc = computeArchDesc;
	}

	public String getComputeArchFeature() {
		return this.computeArchFeature;
	}

	public void setComputeArchFeature(String computeArchFeature) {
		this.computeArchFeature = computeArchFeature;
	}

	public List<ComputeTb> getComputeTbs() {
		return this.computeTbs;
	}

	public void setComputeTbs(List<ComputeTb> computeTbs) {
		this.computeTbs = computeTbs;
	}

	public ComputeTb addComputeTb(ComputeTb computeTb) {
		getComputeTbs().add(computeTb);
		computeTb.setComputeArchTb(this);

		return computeTb;
	}

	public ComputeTb removeComputeTb(ComputeTb computeTb) {
		getComputeTbs().remove(computeTb);
		computeTb.setComputeArchTb(null);

		return computeTb;
	}

}