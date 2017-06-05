package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the agent_tb database table.
 * 
 */
@Entity
@Table(name="agent_tb")
@NamedQuery(name="AgentTb.findAll", query="SELECT a FROM AgentTb a")
public class AgentTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_agent")
	private int idAgent;

	@Column(name="agent_class")
	private String agentClass;

	@Column(name="agent_name")
	private String agentName;

	//bi-directional many-to-one association to AgentArgsTb
	@OneToMany(mappedBy="agentTb")
	private List<AgentArgsTb> agentArgsTbs;

	//bi-directional many-to-one association to AgentTypeTb
	@ManyToOne
	@JoinColumn(name="id_agent_type")
	private AgentTypeTb agentTypeTb;

	public AgentTb() {
	}

	public int getIdAgent() {
		return this.idAgent;
	}

	public void setIdAgent(int idAgent) {
		this.idAgent = idAgent;
	}

	public String getAgentClass() {
		return this.agentClass;
	}

	public void setAgentClass(String agentClass) {
		this.agentClass = agentClass;
	}

	public String getAgentName() {
		return this.agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public List<AgentArgsTb> getAgentArgsTbs() {
		return this.agentArgsTbs;
	}

	public void setAgentArgsTbs(List<AgentArgsTb> agentArgsTbs) {
		this.agentArgsTbs = agentArgsTbs;
	}

	public AgentArgsTb addAgentArgsTb(AgentArgsTb agentArgsTb) {
		getAgentArgsTbs().add(agentArgsTb);
		agentArgsTb.setAgentTb(this);

		return agentArgsTb;
	}

	public AgentArgsTb removeAgentArgsTb(AgentArgsTb agentArgsTb) {
		getAgentArgsTbs().remove(agentArgsTb);
		agentArgsTb.setAgentTb(null);

		return agentArgsTb;
	}

	public AgentTypeTb getAgentTypeTb() {
		return this.agentTypeTb;
	}

	public void setAgentTypeTb(AgentTypeTb agentTypeTb) {
		this.agentTypeTb = agentTypeTb;
	}

}