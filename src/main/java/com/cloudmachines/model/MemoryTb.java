package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the memory_tb database table.
 * 
 */
@Entity
@Table(name="memory_tb")
@NamedQuery(name="MemoryTb.findAll", query="SELECT m FROM MemoryTb m")
public class MemoryTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_memory")
	private int idMemory;

	@Column(name="memory_desc")
	private String memoryDesc;

	@Column(name="memory_freq")
	private BigDecimal memoryFreq;

	@Column(name="memory_size")
	private int memorySize;

	//bi-directional many-to-one association to MemoryTypeTb
	@ManyToOne
	@JoinColumn(name="id_memory_type")
	private MemoryTypeTb memoryTypeTb;

	//bi-directional many-to-one association to ResourceTb
	@OneToMany(mappedBy="memoryTb")
	private List<ResourceTb> resourceTbs;

	public MemoryTb() {
	}

	public int getIdMemory() {
		return this.idMemory;
	}

	public void setIdMemory(int idMemory) {
		this.idMemory = idMemory;
	}

	public String getMemoryDesc() {
		return this.memoryDesc;
	}

	public void setMemoryDesc(String memoryDesc) {
		this.memoryDesc = memoryDesc;
	}

	public BigDecimal getMemoryFreq() {
		return this.memoryFreq;
	}

	public void setMemoryFreq(BigDecimal memoryFreq) {
		this.memoryFreq = memoryFreq;
	}

	public int getMemorySize() {
		return this.memorySize;
	}

	public void setMemorySize(int memorySize) {
		this.memorySize = memorySize;
	}

	public MemoryTypeTb getMemoryTypeTb() {
		return this.memoryTypeTb;
	}

	public void setMemoryTypeTb(MemoryTypeTb memoryTypeTb) {
		this.memoryTypeTb = memoryTypeTb;
	}

	public List<ResourceTb> getResourceTbs() {
		return this.resourceTbs;
	}

	public void setResourceTbs(List<ResourceTb> resourceTbs) {
		this.resourceTbs = resourceTbs;
	}

	public ResourceTb addResourceTb(ResourceTb resourceTb) {
		getResourceTbs().add(resourceTb);
		resourceTb.setMemoryTb(this);

		return resourceTb;
	}

	public ResourceTb removeResourceTb(ResourceTb resourceTb) {
		getResourceTbs().remove(resourceTb);
		resourceTb.setMemoryTb(null);

		return resourceTb;
	}

}