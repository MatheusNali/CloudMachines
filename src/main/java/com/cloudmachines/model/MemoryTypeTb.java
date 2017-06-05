package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the memory_type_tb database table.
 * 
 */
@Entity
@Table(name="memory_type_tb")
@NamedQuery(name="MemoryTypeTb.findAll", query="SELECT m FROM MemoryTypeTb m")
public class MemoryTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_memory_type")
	private int idMemoryType;

	@Column(name="memory_type_desc")
	private String memoryTypeDesc;

	@Column(name="memory_type_feature")
	private String memoryTypeFeature;

	//bi-directional many-to-one association to MemoryTb
	@OneToMany(mappedBy="memoryTypeTb")
	private List<MemoryTb> memoryTbs;

	public MemoryTypeTb() {
	}

	public int getIdMemoryType() {
		return this.idMemoryType;
	}

	public void setIdMemoryType(int idMemoryType) {
		this.idMemoryType = idMemoryType;
	}

	public String getMemoryTypeDesc() {
		return this.memoryTypeDesc;
	}

	public void setMemoryTypeDesc(String memoryTypeDesc) {
		this.memoryTypeDesc = memoryTypeDesc;
	}

	public String getMemoryTypeFeature() {
		return this.memoryTypeFeature;
	}

	public void setMemoryTypeFeature(String memoryTypeFeature) {
		this.memoryTypeFeature = memoryTypeFeature;
	}

	public List<MemoryTb> getMemoryTbs() {
		return this.memoryTbs;
	}

	public void setMemoryTbs(List<MemoryTb> memoryTbs) {
		this.memoryTbs = memoryTbs;
	}

	public MemoryTb addMemoryTb(MemoryTb memoryTb) {
		getMemoryTbs().add(memoryTb);
		memoryTb.setMemoryTypeTb(this);

		return memoryTb;
	}

	public MemoryTb removeMemoryTb(MemoryTb memoryTb) {
		getMemoryTbs().remove(memoryTb);
		memoryTb.setMemoryTypeTb(null);

		return memoryTb;
	}

}