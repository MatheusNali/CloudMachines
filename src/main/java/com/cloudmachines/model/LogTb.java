package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the log_tb database table.
 * 
 */
@Entity
@Table(name="log_tb")
@NamedQuery(name="LogTb.findAll", query="SELECT l FROM LogTb l")
public class LogTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_log")
	private int idLog;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_time")
	private Date dateTime;

	//bi-directional many-to-one association to ClientTb
	@ManyToOne
	@JoinColumn(name="id_client")
	private ClientTb clientTb;

	//bi-directional many-to-one association to ProviderTb
	@ManyToOne
	@JoinColumn(name="id_provider")
	private ProviderTb providerTb;

	//bi-directional many-to-one association to StepTb
	@ManyToOne
	@JoinColumn(name="id_step")
	private StepTb stepTb;

	//bi-directional many-to-one association to StepTypeTb
	@ManyToOne
	@JoinColumn(name="id_step_type")
	private StepTypeTb stepTypeTb;

	public LogTb() {
	}

	public int getIdLog() {
		return this.idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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

	public StepTb getStepTb() {
		return this.stepTb;
	}

	public void setStepTb(StepTb stepTb) {
		this.stepTb = stepTb;
	}

	public StepTypeTb getStepTypeTb() {
		return this.stepTypeTb;
	}

	public void setStepTypeTb(StepTypeTb stepTypeTb) {
		this.stepTypeTb = stepTypeTb;
	}

}