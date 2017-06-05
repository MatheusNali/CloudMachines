package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cli_tool_tb database table.
 * 
 */
@Entity
@Table(name="cli_tool_tb")
@NamedQuery(name="CliToolTb.findAll", query="SELECT c FROM CliToolTb c")
public class CliToolTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_cli_tool")
	private int idCliTool;

	@Column(name="cli_tool_desc")
	private String cliToolDesc;

	@Column(name="cli_tool_name")
	private String cliToolName;

	//bi-directional many-to-one association to ManagementToolsTb
	@OneToMany(mappedBy="cliToolTb")
	private List<ManagementToolsTb> managementToolsTbs;

	public CliToolTb() {
	}

	public int getIdCliTool() {
		return this.idCliTool;
	}

	public void setIdCliTool(int idCliTool) {
		this.idCliTool = idCliTool;
	}

	public String getCliToolDesc() {
		return this.cliToolDesc;
	}

	public void setCliToolDesc(String cliToolDesc) {
		this.cliToolDesc = cliToolDesc;
	}

	public String getCliToolName() {
		return this.cliToolName;
	}

	public void setCliToolName(String cliToolName) {
		this.cliToolName = cliToolName;
	}

	public List<ManagementToolsTb> getManagementToolsTbs() {
		return this.managementToolsTbs;
	}

	public void setManagementToolsTbs(List<ManagementToolsTb> managementToolsTbs) {
		this.managementToolsTbs = managementToolsTbs;
	}

	public ManagementToolsTb addManagementToolsTb(ManagementToolsTb managementToolsTb) {
		getManagementToolsTbs().add(managementToolsTb);
		managementToolsTb.setCliToolTb(this);

		return managementToolsTb;
	}

	public ManagementToolsTb removeManagementToolsTb(ManagementToolsTb managementToolsTb) {
		getManagementToolsTbs().remove(managementToolsTb);
		managementToolsTb.setCliToolTb(null);

		return managementToolsTb;
	}

}