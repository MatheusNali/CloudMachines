package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client_tb database table.
 * 
 */
@Entity
@Table(name="client_tb")
@NamedQuery(name="ClientTb.findAll", query="SELECT c FROM ClientTb c")
public class ClientTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_client")
	private int idClient;

	private String description;

	private String email;

	private String name;

	private String password;

	//bi-directional many-to-one association to BillingTb
	@OneToMany(mappedBy="clientTb")
	private List<BillingTb> billingTbs;

	//bi-directional many-to-many association to ManagementTb
	@ManyToMany(mappedBy="clientTbs")
	private List<ManagementTb> managementTbs;

	//bi-directional many-to-one association to ProviderTb
	@ManyToOne
	@JoinColumn(name="id_provider")
	private ProviderTb providerTb;

	//bi-directional many-to-one association to LogTb
	@OneToMany(mappedBy="clientTb")
	private List<LogTb> logTbs;

	//bi-directional many-to-one association to UserTb
	@OneToMany(mappedBy="clientTb")
	private List<UserTb> userTbs;

	//bi-directional many-to-one association to VmTb
	@OneToMany(mappedBy="clientTb")
	private List<VmTb> vmTbs;

	public ClientTb() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<BillingTb> getBillingTbs() {
		return this.billingTbs;
	}

	public void setBillingTbs(List<BillingTb> billingTbs) {
		this.billingTbs = billingTbs;
	}

	public BillingTb addBillingTb(BillingTb billingTb) {
		getBillingTbs().add(billingTb);
		billingTb.setClientTb(this);

		return billingTb;
	}

	public BillingTb removeBillingTb(BillingTb billingTb) {
		getBillingTbs().remove(billingTb);
		billingTb.setClientTb(null);

		return billingTb;
	}

	public List<ManagementTb> getManagementTbs() {
		return this.managementTbs;
	}

	public void setManagementTbs(List<ManagementTb> managementTbs) {
		this.managementTbs = managementTbs;
	}

	public ProviderTb getProviderTb() {
		return this.providerTb;
	}

	public void setProviderTb(ProviderTb providerTb) {
		this.providerTb = providerTb;
	}

	public List<LogTb> getLogTbs() {
		return this.logTbs;
	}

	public void setLogTbs(List<LogTb> logTbs) {
		this.logTbs = logTbs;
	}

	public LogTb addLogTb(LogTb logTb) {
		getLogTbs().add(logTb);
		logTb.setClientTb(this);

		return logTb;
	}

	public LogTb removeLogTb(LogTb logTb) {
		getLogTbs().remove(logTb);
		logTb.setClientTb(null);

		return logTb;
	}

	public List<UserTb> getUserTbs() {
		return this.userTbs;
	}

	public void setUserTbs(List<UserTb> userTbs) {
		this.userTbs = userTbs;
	}

	public UserTb addUserTb(UserTb userTb) {
		getUserTbs().add(userTb);
		userTb.setClientTb(this);

		return userTb;
	}

	public UserTb removeUserTb(UserTb userTb) {
		getUserTbs().remove(userTb);
		userTb.setClientTb(null);

		return userTb;
	}

	public List<VmTb> getVmTbs() {
		return this.vmTbs;
	}

	public void setVmTbs(List<VmTb> vmTbs) {
		this.vmTbs = vmTbs;
	}

	public VmTb addVmTb(VmTb vmTb) {
		getVmTbs().add(vmTb);
		vmTb.setClientTb(this);

		return vmTb;
	}

	public VmTb removeVmTb(VmTb vmTb) {
		getVmTbs().remove(vmTb);
		vmTb.setClientTb(null);

		return vmTb;
	}

}