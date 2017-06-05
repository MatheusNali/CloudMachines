package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the policy_tb database table.
 * 
 */
@Entity
@Table(name="policy_tb")
@NamedQuery(name="PolicyTb.findAll", query="SELECT p FROM PolicyTb p")
public class PolicyTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_policy")
	private int idPolicy;

	private String description;

	//bi-directional many-to-one association to DefinedCostPolicyTb
	@OneToMany(mappedBy="policyTb")
	private List<DefinedCostPolicyTb> definedCostPolicyTbs;

	//bi-directional many-to-one association to ManagementTb
	@OneToMany(mappedBy="policyTb")
	private List<ManagementTb> managementTbs;

	//bi-directional many-to-one association to OndemandPolicyTb
	@OneToMany(mappedBy="policyTb")
	private List<OndemandPolicyTb> ondemandPolicyTbs;

	//bi-directional many-to-one association to AlgorithmTb
	@ManyToOne
	@JoinColumn(name="id_algorithm")
	private AlgorithmTb algorithmTb;

	//bi-directional many-to-one association to PolicyTypeTb
	@ManyToOne
	@JoinColumn(name="id_policy_type")
	private PolicyTypeTb policyTypeTb;

	//bi-directional many-to-one association to PowerPolicyTb
	@OneToMany(mappedBy="policyTb")
	private List<PowerPolicyTb> powerPolicyTbs;

	//bi-directional many-to-one association to RoiPolicyTb
	@OneToMany(mappedBy="policyTb")
	private List<RoiPolicyTb> roiPolicyTbs;

	//bi-directional many-to-one association to StepTb
	@OneToMany(mappedBy="policyTb")
	private List<StepTb> stepTbs;

	public PolicyTb() {
	}

	public int getIdPolicy() {
		return this.idPolicy;
	}

	public void setIdPolicy(int idPolicy) {
		this.idPolicy = idPolicy;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DefinedCostPolicyTb> getDefinedCostPolicyTbs() {
		return this.definedCostPolicyTbs;
	}

	public void setDefinedCostPolicyTbs(List<DefinedCostPolicyTb> definedCostPolicyTbs) {
		this.definedCostPolicyTbs = definedCostPolicyTbs;
	}

	public DefinedCostPolicyTb addDefinedCostPolicyTb(DefinedCostPolicyTb definedCostPolicyTb) {
		getDefinedCostPolicyTbs().add(definedCostPolicyTb);
		definedCostPolicyTb.setPolicyTb(this);

		return definedCostPolicyTb;
	}

	public DefinedCostPolicyTb removeDefinedCostPolicyTb(DefinedCostPolicyTb definedCostPolicyTb) {
		getDefinedCostPolicyTbs().remove(definedCostPolicyTb);
		definedCostPolicyTb.setPolicyTb(null);

		return definedCostPolicyTb;
	}

	public List<ManagementTb> getManagementTbs() {
		return this.managementTbs;
	}

	public void setManagementTbs(List<ManagementTb> managementTbs) {
		this.managementTbs = managementTbs;
	}

	public ManagementTb addManagementTb(ManagementTb managementTb) {
		getManagementTbs().add(managementTb);
		managementTb.setPolicyTb(this);

		return managementTb;
	}

	public ManagementTb removeManagementTb(ManagementTb managementTb) {
		getManagementTbs().remove(managementTb);
		managementTb.setPolicyTb(null);

		return managementTb;
	}

	public List<OndemandPolicyTb> getOndemandPolicyTbs() {
		return this.ondemandPolicyTbs;
	}

	public void setOndemandPolicyTbs(List<OndemandPolicyTb> ondemandPolicyTbs) {
		this.ondemandPolicyTbs = ondemandPolicyTbs;
	}

	public OndemandPolicyTb addOndemandPolicyTb(OndemandPolicyTb ondemandPolicyTb) {
		getOndemandPolicyTbs().add(ondemandPolicyTb);
		ondemandPolicyTb.setPolicyTb(this);

		return ondemandPolicyTb;
	}

	public OndemandPolicyTb removeOndemandPolicyTb(OndemandPolicyTb ondemandPolicyTb) {
		getOndemandPolicyTbs().remove(ondemandPolicyTb);
		ondemandPolicyTb.setPolicyTb(null);

		return ondemandPolicyTb;
	}

	public AlgorithmTb getAlgorithmTb() {
		return this.algorithmTb;
	}

	public void setAlgorithmTb(AlgorithmTb algorithmTb) {
		this.algorithmTb = algorithmTb;
	}

	public PolicyTypeTb getPolicyTypeTb() {
		return this.policyTypeTb;
	}

	public void setPolicyTypeTb(PolicyTypeTb policyTypeTb) {
		this.policyTypeTb = policyTypeTb;
	}

	public List<PowerPolicyTb> getPowerPolicyTbs() {
		return this.powerPolicyTbs;
	}

	public void setPowerPolicyTbs(List<PowerPolicyTb> powerPolicyTbs) {
		this.powerPolicyTbs = powerPolicyTbs;
	}

	public PowerPolicyTb addPowerPolicyTb(PowerPolicyTb powerPolicyTb) {
		getPowerPolicyTbs().add(powerPolicyTb);
		powerPolicyTb.setPolicyTb(this);

		return powerPolicyTb;
	}

	public PowerPolicyTb removePowerPolicyTb(PowerPolicyTb powerPolicyTb) {
		getPowerPolicyTbs().remove(powerPolicyTb);
		powerPolicyTb.setPolicyTb(null);

		return powerPolicyTb;
	}

	public List<RoiPolicyTb> getRoiPolicyTbs() {
		return this.roiPolicyTbs;
	}

	public void setRoiPolicyTbs(List<RoiPolicyTb> roiPolicyTbs) {
		this.roiPolicyTbs = roiPolicyTbs;
	}

	public RoiPolicyTb addRoiPolicyTb(RoiPolicyTb roiPolicyTb) {
		getRoiPolicyTbs().add(roiPolicyTb);
		roiPolicyTb.setPolicyTb(this);

		return roiPolicyTb;
	}

	public RoiPolicyTb removeRoiPolicyTb(RoiPolicyTb roiPolicyTb) {
		getRoiPolicyTbs().remove(roiPolicyTb);
		roiPolicyTb.setPolicyTb(null);

		return roiPolicyTb;
	}

	public List<StepTb> getStepTbs() {
		return this.stepTbs;
	}

	public void setStepTbs(List<StepTb> stepTbs) {
		this.stepTbs = stepTbs;
	}

	public StepTb addStepTb(StepTb stepTb) {
		getStepTbs().add(stepTb);
		stepTb.setPolicyTb(this);

		return stepTb;
	}

	public StepTb removeStepTb(StepTb stepTb) {
		getStepTbs().remove(stepTb);
		stepTb.setPolicyTb(null);

		return stepTb;
	}

}