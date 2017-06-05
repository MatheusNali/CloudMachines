package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the compute_tb database table.
 * 
 */
@Entity
@Table(name="compute_tb")
@NamedQuery(name="ComputeTb.findAll", query="SELECT c FROM ComputeTb c")
public class ComputeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_compute")
	private int idCompute;

	@Column(name="compute_desc")
	private String computeDesc;

	@Column(name="compute_freq")
	private BigDecimal computeFreq;

	@Column(name="compute_hyperthreading")
	private byte computeHyperthreading;

	@Column(name="compute_number_of_cores")
	private int computeNumberOfCores;

	//bi-directional many-to-one association to ComputeArchTb
	@ManyToOne
	@JoinColumn(name="id_compute_arch")
	private ComputeArchTb computeArchTb;

	//bi-directional many-to-one association to ComputeTypeTb
	@ManyToOne
	@JoinColumn(name="id_compute_type")
	private ComputeTypeTb computeTypeTb;

	//bi-directional many-to-one association to ResourceTb
	@OneToMany(mappedBy="computeTb")
	private List<ResourceTb> resourceTbs;

	public ComputeTb() {
	}

	public int getIdCompute() {
		return this.idCompute;
	}

	public void setIdCompute(int idCompute) {
		this.idCompute = idCompute;
	}

	public String getComputeDesc() {
		return this.computeDesc;
	}

	public void setComputeDesc(String computeDesc) {
		this.computeDesc = computeDesc;
	}

	public BigDecimal getComputeFreq() {
		return this.computeFreq;
	}

	public void setComputeFreq(BigDecimal computeFreq) {
		this.computeFreq = computeFreq;
	}

	public byte getComputeHyperthreading() {
		return this.computeHyperthreading;
	}

	public void setComputeHyperthreading(byte computeHyperthreading) {
		this.computeHyperthreading = computeHyperthreading;
	}

	public int getComputeNumberOfCores() {
		return this.computeNumberOfCores;
	}

	public void setComputeNumberOfCores(int computeNumberOfCores) {
		this.computeNumberOfCores = computeNumberOfCores;
	}

	public ComputeArchTb getComputeArchTb() {
		return this.computeArchTb;
	}

	public void setComputeArchTb(ComputeArchTb computeArchTb) {
		this.computeArchTb = computeArchTb;
	}

	public ComputeTypeTb getComputeTypeTb() {
		return this.computeTypeTb;
	}

	public void setComputeTypeTb(ComputeTypeTb computeTypeTb) {
		this.computeTypeTb = computeTypeTb;
	}

	public List<ResourceTb> getResourceTbs() {
		return this.resourceTbs;
	}

	public void setResourceTbs(List<ResourceTb> resourceTbs) {
		this.resourceTbs = resourceTbs;
	}

	public ResourceTb addResourceTb(ResourceTb resourceTb) {
		getResourceTbs().add(resourceTb);
		resourceTb.setComputeTb(this);

		return resourceTb;
	}

	public ResourceTb removeResourceTb(ResourceTb resourceTb) {
		getResourceTbs().remove(resourceTb);
		resourceTb.setComputeTb(null);

		return resourceTb;
	}

}