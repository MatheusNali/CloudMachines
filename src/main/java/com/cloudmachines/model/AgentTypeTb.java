package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agent_type_tb database table.
 * 
 */
@Entity
@Table(name="agent_type_tb")
@NamedQuery(name="AgentTypeTb.findAll", query="SELECT a FROM AgentTypeTb a")
public class AgentTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_agent_type")
	private int idAgentType;

	private String desc;

	//bi-directional many-to-one association to AgentTb
	@OneToMany(mappedBy="agentTypeTb")
	private List<AgentTb> agentTbs;

	public AgentTypeTb() {
	}

	public int getIdAgentType() {
		return this.idAgentType;
	}

	public void setIdAgentType(int idAgentType) {
		this.idAgentType = idAgentType;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<AgentTb> getAgentTbs() {
		return this.agentTbs;
	}

	public void setAgentTbs(List<AgentTb> agentTbs) {
		this.agentTbs = agentTbs;
	}

	public AgentTb addAgentTb(AgentTb agentTb) {
		getAgentTbs().add(agentTb);
		agentTb.setAgentTypeTb(this);

		return agentTb;
	}

	public AgentTb removeAgentTb(AgentTb agentTb) {
		getAgentTbs().remove(agentTb);
		agentTb.setAgentTypeTb(null);

		return agentTb;
	}

}