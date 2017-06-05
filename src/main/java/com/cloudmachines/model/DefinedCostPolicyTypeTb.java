package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the defined_cost_policy_type_tb database table.
 * 
 */
@Entity
@Table(name="defined_cost_policy_type_tb")
@NamedQuery(name="DefinedCostPolicyTypeTb.findAll", query="SELECT d FROM DefinedCostPolicyTypeTb d")
public class DefinedCostPolicyTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_defined_cost_policy_type")
	private int idDefinedCostPolicyType;

	private String desc;

	//bi-directional many-to-one association to DefinedCostPolicyTb
	@OneToMany(mappedBy="definedCostPolicyTypeTb")
	private List<DefinedCostPolicyTb> definedCostPolicyTbs;

	public DefinedCostPolicyTypeTb() {
	}

	public int getIdDefinedCostPolicyType() {
		return this.idDefinedCostPolicyType;
	}

	public void setIdDefinedCostPolicyType(int idDefinedCostPolicyType) {
		this.idDefinedCostPolicyType = idDefinedCostPolicyType;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<DefinedCostPolicyTb> getDefinedCostPolicyTbs() {
		return this.definedCostPolicyTbs;
	}

	public void setDefinedCostPolicyTbs(List<DefinedCostPolicyTb> definedCostPolicyTbs) {
		this.definedCostPolicyTbs = definedCostPolicyTbs;
	}

	public DefinedCostPolicyTb addDefinedCostPolicyTb(DefinedCostPolicyTb definedCostPolicyTb) {
		getDefinedCostPolicyTbs().add(definedCostPolicyTb);
		definedCostPolicyTb.setDefinedCostPolicyTypeTb(this);

		return definedCostPolicyTb;
	}

	public DefinedCostPolicyTb removeDefinedCostPolicyTb(DefinedCostPolicyTb definedCostPolicyTb) {
		getDefinedCostPolicyTbs().remove(definedCostPolicyTb);
		definedCostPolicyTb.setDefinedCostPolicyTypeTb(null);

		return definedCostPolicyTb;
	}

}