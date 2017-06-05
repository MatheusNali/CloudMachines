package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the billing_tb database table.
 * 
 */
@Entity
@Table(name="billing_tb")
@NamedQuery(name="BillingTb.findAll", query="SELECT b FROM BillingTb b")
public class BillingTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_billing")
	private int idBilling;

	//bi-directional many-to-one association to BillingHistoryTb
	@OneToMany(mappedBy="billingTb")
	private List<BillingHistoryTb> billingHistoryTbs;

	//bi-directional many-to-one association to ClientTb
	@ManyToOne
	@JoinColumn(name="id_client")
	private ClientTb clientTb;

	//bi-directional many-to-one association to ProviderTb
	@ManyToOne
	@JoinColumn(name="id_provider")
	private ProviderTb providerTb;

	//bi-directional many-to-one association to StepTb
	@OneToMany(mappedBy="billingTb")
	private List<StepTb> stepTbs;

	public BillingTb() {
	}

	public int getIdBilling() {
		return this.idBilling;
	}

	public void setIdBilling(int idBilling) {
		this.idBilling = idBilling;
	}

	public List<BillingHistoryTb> getBillingHistoryTbs() {
		return this.billingHistoryTbs;
	}

	public void setBillingHistoryTbs(List<BillingHistoryTb> billingHistoryTbs) {
		this.billingHistoryTbs = billingHistoryTbs;
	}

	public BillingHistoryTb addBillingHistoryTb(BillingHistoryTb billingHistoryTb) {
		getBillingHistoryTbs().add(billingHistoryTb);
		billingHistoryTb.setBillingTb(this);

		return billingHistoryTb;
	}

	public BillingHistoryTb removeBillingHistoryTb(BillingHistoryTb billingHistoryTb) {
		getBillingHistoryTbs().remove(billingHistoryTb);
		billingHistoryTb.setBillingTb(null);

		return billingHistoryTb;
	}

	public ClientTb getClientTb() {
		return this.clientTb;
	}

	public void setClientTb(ClientTb clientTb) {
		this.clientTb = clientTb;
	}

	public ProviderTb getProviderTb() {
		return this.providerTb;
	}

	public void setProviderTb(ProviderTb providerTb) {
		this.providerTb = providerTb;
	}

	public List<StepTb> getStepTbs() {
		return this.stepTbs;
	}

	public void setStepTbs(List<StepTb> stepTbs) {
		this.stepTbs = stepTbs;
	}

	public StepTb addStepTb(StepTb stepTb) {
		getStepTbs().add(stepTb);
		stepTb.setBillingTb(this);

		return stepTb;
	}

	public StepTb removeStepTb(StepTb stepTb) {
		getStepTbs().remove(stepTb);
		stepTb.setBillingTb(null);

		return stepTb;
	}

}