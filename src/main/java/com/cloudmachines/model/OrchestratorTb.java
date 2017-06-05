package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the orchestrator_tb database table.
 * 
 */
@Entity
@Table(name="orchestrator_tb")
@NamedQuery(name="OrchestratorTb.findAll", query="SELECT o FROM OrchestratorTb o")
public class OrchestratorTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_orchestrator")
	private int idOrchestrator;

	@Column(name="orchestrator_address")
	private String orchestratorAddress;

	@Column(name="orchestrator_desc")
	private String orchestratorDesc;

	//bi-directional many-to-one association to ManagementToolsTb
	@OneToMany(mappedBy="orchestratorTb")
	private List<ManagementToolsTb> managementToolsTbs;

	public OrchestratorTb() {
	}

	public int getIdOrchestrator() {
		return this.idOrchestrator;
	}

	public void setIdOrchestrator(int idOrchestrator) {
		this.idOrchestrator = idOrchestrator;
	}

	public String getOrchestratorAddress() {
		return this.orchestratorAddress;
	}

	public void setOrchestratorAddress(String orchestratorAddress) {
		this.orchestratorAddress = orchestratorAddress;
	}

	public String getOrchestratorDesc() {
		return this.orchestratorDesc;
	}

	public void setOrchestratorDesc(String orchestratorDesc) {
		this.orchestratorDesc = orchestratorDesc;
	}

	public List<ManagementToolsTb> getManagementToolsTbs() {
		return this.managementToolsTbs;
	}

	public void setManagementToolsTbs(List<ManagementToolsTb> managementToolsTbs) {
		this.managementToolsTbs = managementToolsTbs;
	}

	public ManagementToolsTb addManagementToolsTb(ManagementToolsTb managementToolsTb) {
		getManagementToolsTbs().add(managementToolsTb);
		managementToolsTb.setOrchestratorTb(this);

		return managementToolsTb;
	}

	public ManagementToolsTb removeManagementToolsTb(ManagementToolsTb managementToolsTb) {
		getManagementToolsTbs().remove(managementToolsTb);
		managementToolsTb.setOrchestratorTb(null);

		return managementToolsTb;
	}

}