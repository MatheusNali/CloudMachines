package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the resource_model_tb database table.
 * 
 */
@Entity
@Table(name="resource_model_tb")
@NamedQuery(name="ResourceModelTb.findAll", query="SELECT r FROM ResourceModelTb r")
public class ResourceModelTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_resource_model")
	private int idResourceModel;

	@Column(name="resource_model_desc")
	private String resourceModelDesc;

	//bi-directional many-to-one association to ResourceTb
	@OneToMany(mappedBy="resourceModelTb")
	private List<ResourceTb> resourceTbs;

	public ResourceModelTb() {
	}

	public int getIdResourceModel() {
		return this.idResourceModel;
	}

	public void setIdResourceModel(int idResourceModel) {
		this.idResourceModel = idResourceModel;
	}

	public String getResourceModelDesc() {
		return this.resourceModelDesc;
	}

	public void setResourceModelDesc(String resourceModelDesc) {
		this.resourceModelDesc = resourceModelDesc;
	}

	public List<ResourceTb> getResourceTbs() {
		return this.resourceTbs;
	}

	public void setResourceTbs(List<ResourceTb> resourceTbs) {
		this.resourceTbs = resourceTbs;
	}

	public ResourceTb addResourceTb(ResourceTb resourceTb) {
		getResourceTbs().add(resourceTb);
		resourceTb.setResourceModelTb(this);

		return resourceTb;
	}

	public ResourceTb removeResourceTb(ResourceTb resourceTb) {
		getResourceTbs().remove(resourceTb);
		resourceTb.setResourceModelTb(null);

		return resourceTb;
	}

}