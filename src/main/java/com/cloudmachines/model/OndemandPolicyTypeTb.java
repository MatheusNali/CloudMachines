package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ondemand_policy_type_tb database table.
 * 
 */
@Entity
@Table(name="ondemand_policy_type_tb")
@NamedQuery(name="OndemandPolicyTypeTb.findAll", query="SELECT o FROM OndemandPolicyTypeTb o")
public class OndemandPolicyTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_ondemand_policy_type")
	private int idOndemandPolicyType;

	private String desc;

	//bi-directional many-to-one association to OndemandPolicyTb
	@OneToMany(mappedBy="ondemandPolicyTypeTb")
	private List<OndemandPolicyTb> ondemandPolicyTbs;

	public OndemandPolicyTypeTb() {
	}

	public int getIdOndemandPolicyType() {
		return this.idOndemandPolicyType;
	}

	public void setIdOndemandPolicyType(int idOndemandPolicyType) {
		this.idOndemandPolicyType = idOndemandPolicyType;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<OndemandPolicyTb> getOndemandPolicyTbs() {
		return this.ondemandPolicyTbs;
	}

	public void setOndemandPolicyTbs(List<OndemandPolicyTb> ondemandPolicyTbs) {
		this.ondemandPolicyTbs = ondemandPolicyTbs;
	}

	public OndemandPolicyTb addOndemandPolicyTb(OndemandPolicyTb ondemandPolicyTb) {
		getOndemandPolicyTbs().add(ondemandPolicyTb);
		ondemandPolicyTb.setOndemandPolicyTypeTb(this);

		return ondemandPolicyTb;
	}

	public OndemandPolicyTb removeOndemandPolicyTb(OndemandPolicyTb ondemandPolicyTb) {
		getOndemandPolicyTbs().remove(ondemandPolicyTb);
		ondemandPolicyTb.setOndemandPolicyTypeTb(null);

		return ondemandPolicyTb;
	}

}