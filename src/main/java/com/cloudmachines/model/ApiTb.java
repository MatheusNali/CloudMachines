package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the api_tb database table.
 * 
 */
@Entity
@Table(name="api_tb")
@NamedQuery(name="ApiTb.findAll", query="SELECT a FROM ApiTb a")
public class ApiTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_api")
	private int idApi;

	@Column(name="api_address")
	private String apiAddress;

	@Column(name="api_desc")
	private String apiDesc;

	@Column(name="api_name")
	private String apiName;

	//bi-directional many-to-one association to ManagementToolsTb
	@OneToMany(mappedBy="apiTb")
	private List<ManagementToolsTb> managementToolsTbs;

	public ApiTb() {
	}

	public int getIdApi() {
		return this.idApi;
	}

	public void setIdApi(int idApi) {
		this.idApi = idApi;
	}

	public String getApiAddress() {
		return this.apiAddress;
	}

	public void setApiAddress(String apiAddress) {
		this.apiAddress = apiAddress;
	}

	public String getApiDesc() {
		return this.apiDesc;
	}

	public void setApiDesc(String apiDesc) {
		this.apiDesc = apiDesc;
	}

	public String getApiName() {
		return this.apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public List<ManagementToolsTb> getManagementToolsTbs() {
		return this.managementToolsTbs;
	}

	public void setManagementToolsTbs(List<ManagementToolsTb> managementToolsTbs) {
		this.managementToolsTbs = managementToolsTbs;
	}

	public ManagementToolsTb addManagementToolsTb(ManagementToolsTb managementToolsTb) {
		getManagementToolsTbs().add(managementToolsTb);
		managementToolsTb.setApiTb(this);

		return managementToolsTb;
	}

	public ManagementToolsTb removeManagementToolsTb(ManagementToolsTb managementToolsTb) {
		getManagementToolsTbs().remove(managementToolsTb);
		managementToolsTb.setApiTb(null);

		return managementToolsTb;
	}

}