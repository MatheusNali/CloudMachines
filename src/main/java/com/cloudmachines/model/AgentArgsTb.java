package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the agent_args_tb database table.
 * 
 */
@Entity
@Table(name="agent_args_tb")
@NamedQuery(name="AgentArgsTb.findAll", query="SELECT a FROM AgentArgsTb a")
public class AgentArgsTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_agent_args")
	private int idAgentArgs;

	@Column(name="agent_arg")
	private String agentArg;

	//bi-directional many-to-one association to AgentTb
	@ManyToOne
	@JoinColumn(name="id_agent")
	private AgentTb agentTb;

	public AgentArgsTb() {
	}

	public int getIdAgentArgs() {
		return this.idAgentArgs;
	}

	public void setIdAgentArgs(int idAgentArgs) {
		this.idAgentArgs = idAgentArgs;
	}

	public String getAgentArg() {
		return this.agentArg;
	}

	public void setAgentArg(String agentArg) {
		this.agentArg = agentArg;
	}

	public AgentTb getAgentTb() {
		return this.agentTb;
	}

	public void setAgentTb(AgentTb agentTb) {
		this.agentTb = agentTb;
	}

}