package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the management_tb database table.
 * 
 */
@Entity
@Table(name="management_tb")
@NamedQuery(name="ManagementTb.findAll", query="SELECT m FROM ManagementTb m")
public class ManagementTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_management")
	private int idManagement;

	private String description;

	//bi-directional many-to-many association to ClientTb
	@ManyToMany
	@JoinTable(
		name="client_management_tb"
		, joinColumns={
			@JoinColumn(name="id_management")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_client")
			}
		)
	private List<ClientTb> clientTbs;

	//bi-directional many-to-one association to ManagementToolsTb
	@ManyToOne
	@JoinColumn(name="id_management_tool")
	private ManagementToolsTb managementToolsTb;

	//bi-directional many-to-one association to PolicyTb
	@ManyToOne
	@JoinColumn(name="id_policy")
	private PolicyTb policyTb;

	//bi-directional many-to-one association to StepTb
	@OneToMany(mappedBy="managementTb")
	private List<StepTb> stepTbs;

	public ManagementTb() {
	}

	public int getIdManagement() {
		return this.idManagement;
	}

	public void setIdManagement(int idManagement) {
		this.idManagement = idManagement;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ClientTb> getClientTbs() {
		return this.clientTbs;
	}

	public void setClientTbs(List<ClientTb> clientTbs) {
		this.clientTbs = clientTbs;
	}

	public ManagementToolsTb getManagementToolsTb() {
		return this.managementToolsTb;
	}

	public void setManagementToolsTb(ManagementToolsTb managementToolsTb) {
		this.managementToolsTb = managementToolsTb;
	}

	public PolicyTb getPolicyTb() {
		return this.policyTb;
	}

	public void setPolicyTb(PolicyTb policyTb) {
		this.policyTb = policyTb;
	}

	public List<StepTb> getStepTbs() {
		return this.stepTbs;
	}

	public void setStepTbs(List<StepTb> stepTbs) {
		this.stepTbs = stepTbs;
	}

	public StepTb addStepTb(StepTb stepTb) {
		getStepTbs().add(stepTb);
		stepTb.setManagementTb(this);

		return stepTb;
	}

	public StepTb removeStepTb(StepTb stepTb) {
		getStepTbs().remove(stepTb);
		stepTb.setManagementTb(null);

		return stepTb;
	}

}