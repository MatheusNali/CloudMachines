package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the dashboard_tb database table.
 * 
 */
@Entity
@Table(name="dashboard_tb")
@NamedQuery(name="DashboardTb.findAll", query="SELECT d FROM DashboardTb d")
public class DashboardTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_dashboard")
	private int idDashboard;

	@Column(name="dashboard_address")
	private String dashboardAddress;

	@Column(name="dashboard_desc")
	private String dashboardDesc;

	//bi-directional many-to-one association to ManagementToolsTb
	@OneToMany(mappedBy="dashboardTb")
	private List<ManagementToolsTb> managementToolsTbs;

	public DashboardTb() {
	}

	public int getIdDashboard() {
		return this.idDashboard;
	}

	public void setIdDashboard(int idDashboard) {
		this.idDashboard = idDashboard;
	}

	public String getDashboardAddress() {
		return this.dashboardAddress;
	}

	public void setDashboardAddress(String dashboardAddress) {
		this.dashboardAddress = dashboardAddress;
	}

	public String getDashboardDesc() {
		return this.dashboardDesc;
	}

	public void setDashboardDesc(String dashboardDesc) {
		this.dashboardDesc = dashboardDesc;
	}

	public List<ManagementToolsTb> getManagementToolsTbs() {
		return this.managementToolsTbs;
	}

	public void setManagementToolsTbs(List<ManagementToolsTb> managementToolsTbs) {
		this.managementToolsTbs = managementToolsTbs;
	}

	public ManagementToolsTb addManagementToolsTb(ManagementToolsTb managementToolsTb) {
		getManagementToolsTbs().add(managementToolsTb);
		managementToolsTb.setDashboardTb(this);

		return managementToolsTb;
	}

	public ManagementToolsTb removeManagementToolsTb(ManagementToolsTb managementToolsTb) {
		getManagementToolsTbs().remove(managementToolsTb);
		managementToolsTb.setDashboardTb(null);

		return managementToolsTb;
	}

}