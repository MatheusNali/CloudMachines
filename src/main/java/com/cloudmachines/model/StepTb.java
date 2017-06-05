package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the step_tb database table.
 * 
 */
@Entity
@Table(name="step_tb")
@NamedQuery(name="StepTb.findAll", query="SELECT s FROM StepTb s")
public class StepTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_step")
	private int idStep;

	private String desc;

	@Column(name="id_vm_status")
	private int idVmStatus;

	@Column(name="response_time")
	private double responseTime;

	//bi-directional many-to-one association to LogTb
	@OneToMany(mappedBy="stepTb")
	private List<LogTb> logTbs;

	//bi-directional many-to-one association to BillingTb
	@ManyToOne
	@JoinColumn(name="id_billing")
	private BillingTb billingTb;

	//bi-directional many-to-one association to ManagementTb
	@ManyToOne
	@JoinColumn(name="id_management")
	private ManagementTb managementTb;

	//bi-directional many-to-one association to PolicyTb
	@ManyToOne
	@JoinColumn(name="id_policy")
	private PolicyTb policyTb;

	//bi-directional many-to-one association to PowerStatusTb
	@ManyToOne
	@JoinColumn(name="id_power_status")
	private PowerStatusTb powerStatusTb;

	//bi-directional many-to-one association to RmTb
	@ManyToOne
	@JoinColumn(name="id_rm")
	private RmTb rmTb;

	//bi-directional many-to-one association to RmTimestampsTb
	@ManyToOne
	@JoinColumn(name="id_timestamp_rm")
	private RmTimestampsTb rmTimestampsTb;

	//bi-directional many-to-one association to VmTb
	@ManyToOne
	@JoinColumn(name="id_vm")
	private VmTb vmTb;

	//bi-directional many-to-one association to VmTimestampsTb
	@ManyToOne
	@JoinColumn(name="id_timestamp_vm")
	private VmTimestampsTb vmTimestampsTb;

	public StepTb() {
	}

	public int getIdStep() {
		return this.idStep;
	}

	public void setIdStep(int idStep) {
		this.idStep = idStep;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getIdVmStatus() {
		return this.idVmStatus;
	}

	public void setIdVmStatus(int idVmStatus) {
		this.idVmStatus = idVmStatus;
	}

	public double getResponseTime() {
		return this.responseTime;
	}

	public void setResponseTime(double responseTime) {
		this.responseTime = responseTime;
	}

	public List<LogTb> getLogTbs() {
		return this.logTbs;
	}

	public void setLogTbs(List<LogTb> logTbs) {
		this.logTbs = logTbs;
	}

	public LogTb addLogTb(LogTb logTb) {
		getLogTbs().add(logTb);
		logTb.setStepTb(this);

		return logTb;
	}

	public LogTb removeLogTb(LogTb logTb) {
		getLogTbs().remove(logTb);
		logTb.setStepTb(null);

		return logTb;
	}

	public BillingTb getBillingTb() {
		return this.billingTb;
	}

	public void setBillingTb(BillingTb billingTb) {
		this.billingTb = billingTb;
	}

	public ManagementTb getManagementTb() {
		return this.managementTb;
	}

	public void setManagementTb(ManagementTb managementTb) {
		this.managementTb = managementTb;
	}

	public PolicyTb getPolicyTb() {
		return this.policyTb;
	}

	public void setPolicyTb(PolicyTb policyTb) {
		this.policyTb = policyTb;
	}

	public PowerStatusTb getPowerStatusTb() {
		return this.powerStatusTb;
	}

	public void setPowerStatusTb(PowerStatusTb powerStatusTb) {
		this.powerStatusTb = powerStatusTb;
	}

	public RmTb getRmTb() {
		return this.rmTb;
	}

	public void setRmTb(RmTb rmTb) {
		this.rmTb = rmTb;
	}

	public RmTimestampsTb getRmTimestampsTb() {
		return this.rmTimestampsTb;
	}

	public void setRmTimestampsTb(RmTimestampsTb rmTimestampsTb) {
		this.rmTimestampsTb = rmTimestampsTb;
	}

	public VmTb getVmTb() {
		return this.vmTb;
	}

	public void setVmTb(VmTb vmTb) {
		this.vmTb = vmTb;
	}

	public VmTimestampsTb getVmTimestampsTb() {
		return this.vmTimestampsTb;
	}

	public void setVmTimestampsTb(VmTimestampsTb vmTimestampsTb) {
		this.vmTimestampsTb = vmTimestampsTb;
	}

}