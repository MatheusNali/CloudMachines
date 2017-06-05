package com.cloudmachines.
model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the management_tools_tb database table.
 * 
 */
@Entity
@Table(name="management_tools_tb")
@NamedQuery(name="ManagementToolsTb.findAll", query="SELECT m FROM ManagementToolsTb m")
public class ManagementToolsTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_management_tool")
	private int idManagementTool;

	//bi-directional many-to-one association to ManagementTb
	@OneToMany(mappedBy="managementToolsTb")
	private List<ManagementTb> managementTbs;

	//bi-directional many-to-one association to ApiTb
	@ManyToOne
	@JoinColumn(name="id_api")
	private ApiTb apiTb;

	//bi-directional many-to-one association to CliToolTb
	@ManyToOne
	@JoinColumn(name="id_cli_tool")
	private CliToolTb cliToolTb;

	//bi-directional many-to-one association to DashboardTb
	@ManyToOne
	@JoinColumn(name="id_dashboard")
	private DashboardTb dashboardTb;

	//bi-directional many-to-one association to HypervisorTb
	@ManyToOne
	@JoinColumn(name="id_hypervisor")
	private HypervisorTb hypervisorTb;

	//bi-directional many-to-one association to OrchestratorTb
	@ManyToOne
	@JoinColumn(name="id_orchestrator")
	private OrchestratorTb orchestratorTb;

	public ManagementToolsTb() {
	}

	public int getIdManagementTool() {
		return this.idManagementTool;
	}

	public void setIdManagementTool(int idManagementTool) {
		this.idManagementTool = idManagementTool;
	}

	public List<ManagementTb> getManagementTbs() {
		return this.managementTbs;
	}

	public void setManagementTbs(List<ManagementTb> managementTbs) {
		this.managementTbs = managementTbs;
	}

	public ManagementTb addManagementTb(ManagementTb managementTb) {
		getManagementTbs().add(managementTb);
		managementTb.setManagementToolsTb(this);

		return managementTb;
	}

	public ManagementTb removeManagementTb(ManagementTb managementTb) {
		getManagementTbs().remove(managementTb);
		managementTb.setManagementToolsTb(null);

		return managementTb;
	}

	public ApiTb getApiTb() {
		return this.apiTb;
	}

	public void setApiTb(ApiTb apiTb) {
		this.apiTb = apiTb;
	}

	public CliToolTb getCliToolTb() {
		return this.cliToolTb;
	}

	public void setCliToolTb(CliToolTb cliToolTb) {
		this.cliToolTb = cliToolTb;
	}

	public DashboardTb getDashboardTb() {
		return this.dashboardTb;
	}

	public void setDashboardTb(DashboardTb dashboardTb) {
		this.dashboardTb = dashboardTb;
	}

	public HypervisorTb getHypervisorTb() {
		return this.hypervisorTb;
	}

	public void setHypervisorTb(HypervisorTb hypervisorTb) {
		this.hypervisorTb = hypervisorTb;
	}

	public OrchestratorTb getOrchestratorTb() {
		return this.orchestratorTb;
	}

	public void setOrchestratorTb(OrchestratorTb orchestratorTb) {
		this.orchestratorTb = orchestratorTb;
	}

}