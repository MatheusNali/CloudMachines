package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the provider_tb database table.
 * 
 */
@Entity
@Table(name="provider_tb")
@NamedQuery(name="ProviderTb.findAll", query="SELECT p FROM ProviderTb p")
public class ProviderTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_provider")
	private int idProvider;

	private String description;

	private String email;

	private String name;

	private String password;

	//bi-directional many-to-one association to BillingTb
	@OneToMany(mappedBy="providerTb")
	private List<BillingTb> billingTbs;

	//bi-directional many-to-one association to ClientTb
	@OneToMany(mappedBy="providerTb")
	private List<ClientTb> clientTbs;

	//bi-directional many-to-one association to LogTb
	@OneToMany(mappedBy="providerTb")
	private List<LogTb> logTbs;

	//bi-directional many-to-one association to RmTb
	@OneToMany(mappedBy="providerTb")
	private List<RmTb> rmTbs;

	public ProviderTb() {
	}

	public int getIdProvider() {
		return this.idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
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
		billingTb.setProviderTb(this);

		return billingTb;
	}

	public BillingTb removeBillingTb(BillingTb billingTb) {
		getBillingTbs().remove(billingTb);
		billingTb.setProviderTb(null);

		return billingTb;
	}

	public List<ClientTb> getClientTbs() {
		return this.clientTbs;
	}

	public void setClientTbs(List<ClientTb> clientTbs) {
		this.clientTbs = clientTbs;
	}

	public ClientTb addClientTb(ClientTb clientTb) {
		getClientTbs().add(clientTb);
		clientTb.setProviderTb(this);

		return clientTb;
	}

	public ClientTb removeClientTb(ClientTb clientTb) {
		getClientTbs().remove(clientTb);
		clientTb.setProviderTb(null);

		return clientTb;
	}

	public List<LogTb> getLogTbs() {
		return this.logTbs;
	}

	public void setLogTbs(List<LogTb> logTbs) {
		this.logTbs = logTbs;
	}

	public LogTb addLogTb(LogTb logTb) {
		getLogTbs().add(logTb);
		logTb.setProviderTb(this);

		return logTb;
	}

	public LogTb removeLogTb(LogTb logTb) {
		getLogTbs().remove(logTb);
		logTb.setProviderTb(null);

		return logTb;
	}

	public List<RmTb> getRmTbs() {
		return this.rmTbs;
	}

	public void setRmTbs(List<RmTb> rmTbs) {
		this.rmTbs = rmTbs;
	}

	public RmTb addRmTb(RmTb rmTb) {
		getRmTbs().add(rmTb);
		rmTb.setProviderTb(this);

		return rmTb;
	}

	public RmTb removeRmTb(RmTb rmTb) {
		getRmTbs().remove(rmTb);
		rmTb.setProviderTb(null);

		return rmTb;
	}

}