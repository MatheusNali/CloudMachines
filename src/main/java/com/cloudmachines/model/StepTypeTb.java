package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the step_type_tb database table.
 * 
 */
@Entity
@Table(name="step_type_tb")
@NamedQuery(name="StepTypeTb.findAll", query="SELECT s FROM StepTypeTb s")
public class StepTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_step_type")
	private int idStepType;

	private String desc;

	//bi-directional many-to-one association to LogTb
	@OneToMany(mappedBy="stepTypeTb")
	private List<LogTb> logTbs;

	public StepTypeTb() {
	}

	public int getIdStepType() {
		return this.idStepType;
	}

	public void setIdStepType(int idStepType) {
		this.idStepType = idStepType;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<LogTb> getLogTbs() {
		return this.logTbs;
	}

	public void setLogTbs(List<LogTb> logTbs) {
		this.logTbs = logTbs;
	}

	public LogTb addLogTb(LogTb logTb) {
		getLogTbs().add(logTb);
		logTb.setStepTypeTb(this);

		return logTb;
	}

	public LogTb removeLogTb(LogTb logTb) {
		getLogTbs().remove(logTb);
		logTb.setStepTypeTb(null);

		return logTb;
	}

}