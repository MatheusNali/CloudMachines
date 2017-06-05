package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the rm_timestamps_tb database table.
 * 
 */
@Entity
@Table(name="rm_timestamps_tb")
@NamedQuery(name="RmTimestampsTb.findAll", query="SELECT r FROM RmTimestampsTb r")
public class RmTimestampsTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_timestamp")
	private String idTimestamp;

	@Temporal(TemporalType.TIMESTAMP)
	private Date start;

	@Temporal(TemporalType.TIMESTAMP)
	private Date stop;

	//bi-directional many-to-one association to RmTb
	@ManyToOne
	@JoinColumn(name="id_rm")
	private RmTb rmTb;

	//bi-directional many-to-one association to StepTb
	@OneToMany(mappedBy="rmTimestampsTb")
	private List<StepTb> stepTbs;

	public RmTimestampsTb() {
	}

	public String getIdTimestamp() {
		return this.idTimestamp;
	}

	public void setIdTimestamp(String idTimestamp) {
		this.idTimestamp = idTimestamp;
	}

	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getStop() {
		return this.stop;
	}

	public void setStop(Date stop) {
		this.stop = stop;
	}

	public RmTb getRmTb() {
		return this.rmTb;
	}

	public void setRmTb(RmTb rmTb) {
		this.rmTb = rmTb;
	}

	public List<StepTb> getStepTbs() {
		return this.stepTbs;
	}

	public void setStepTbs(List<StepTb> stepTbs) {
		this.stepTbs = stepTbs;
	}

	public StepTb addStepTb(StepTb stepTb) {
		getStepTbs().add(stepTb);
		stepTb.setRmTimestampsTb(this);

		return stepTb;
	}

	public StepTb removeStepTb(StepTb stepTb) {
		getStepTbs().remove(stepTb);
		stepTb.setRmTimestampsTb(null);

		return stepTb;
	}

}