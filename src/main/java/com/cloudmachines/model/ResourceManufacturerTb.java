package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the resource_manufacturer_tb database table.
 * 
 */
@Entity
@Table(name="resource_manufacturer_tb")
@NamedQuery(name="ResourceManufacturerTb.findAll", query="SELECT r FROM ResourceManufacturerTb r")
public class ResourceManufacturerTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_resource_manufacturer")
	private int idResourceManufacturer;

	@Column(name="manufacturer_brand_name")
	private String manufacturerBrandName;

	@Column(name="manufacturer_email")
	private String manufacturerEmail;

	@Column(name="manufacturer_name")
	private String manufacturerName;

	//bi-directional many-to-one association to ResourceTb
	@OneToMany(mappedBy="resourceManufacturerTb")
	private List<ResourceTb> resourceTbs;

	public ResourceManufacturerTb() {
	}

	public int getIdResourceManufacturer() {
		return this.idResourceManufacturer;
	}

	public void setIdResourceManufacturer(int idResourceManufacturer) {
		this.idResourceManufacturer = idResourceManufacturer;
	}

	public String getManufacturerBrandName() {
		return this.manufacturerBrandName;
	}

	public void setManufacturerBrandName(String manufacturerBrandName) {
		this.manufacturerBrandName = manufacturerBrandName;
	}

	public String getManufacturerEmail() {
		return this.manufacturerEmail;
	}

	public void setManufacturerEmail(String manufacturerEmail) {
		this.manufacturerEmail = manufacturerEmail;
	}

	public String getManufacturerName() {
		return this.manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public List<ResourceTb> getResourceTbs() {
		return this.resourceTbs;
	}

	public void setResourceTbs(List<ResourceTb> resourceTbs) {
		this.resourceTbs = resourceTbs;
	}

	public ResourceTb addResourceTb(ResourceTb resourceTb) {
		getResourceTbs().add(resourceTb);
		resourceTb.setResourceManufacturerTb(this);

		return resourceTb;
	}

	public ResourceTb removeResourceTb(ResourceTb resourceTb) {
		getResourceTbs().remove(resourceTb);
		resourceTb.setResourceManufacturerTb(null);

		return resourceTb;
	}

}