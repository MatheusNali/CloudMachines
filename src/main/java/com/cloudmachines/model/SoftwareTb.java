package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the software_tb database table.
 * 
 */
@Entity
@Table(name="software_tb")
@NamedQuery(name="SoftwareTb.findAll", query="SELECT s FROM SoftwareTb s")
public class SoftwareTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_software")
	private int idSoftware;

	@Column(name="software_cost")
	private BigDecimal softwareCost;

	@Column(name="software_desc")
	private String softwareDesc;

	@Column(name="software_manufacturer")
	private String softwareManufacturer;

	@Column(name="software_manufacturer_email")
	private String softwareManufacturerEmail;

	@Column(name="software_name")
	private String softwareName;

	@Column(name="software_number_of_licenses")
	private int softwareNumberOfLicenses;

	@Column(name="software_serial")
	private String softwareSerial;

	@Column(name="software_version")
	private String softwareVersion;

	//bi-directional many-to-one association to MachineCapacityTb
	@OneToMany(mappedBy="softwareTb")
	private List<MachineCapacityTb> machineCapacityTbs;

	//bi-directional many-to-one association to SoftwareTypeTb
	@ManyToOne
	@JoinColumn(name="id_software_type")
	private SoftwareTypeTb softwareTypeTb;

	public SoftwareTb() {
	}

	public int getIdSoftware() {
		return this.idSoftware;
	}

	public void setIdSoftware(int idSoftware) {
		this.idSoftware = idSoftware;
	}

	public BigDecimal getSoftwareCost() {
		return this.softwareCost;
	}

	public void setSoftwareCost(BigDecimal softwareCost) {
		this.softwareCost = softwareCost;
	}

	public String getSoftwareDesc() {
		return this.softwareDesc;
	}

	public void setSoftwareDesc(String softwareDesc) {
		this.softwareDesc = softwareDesc;
	}

	public String getSoftwareManufacturer() {
		return this.softwareManufacturer;
	}

	public void setSoftwareManufacturer(String softwareManufacturer) {
		this.softwareManufacturer = softwareManufacturer;
	}

	public String getSoftwareManufacturerEmail() {
		return this.softwareManufacturerEmail;
	}

	public void setSoftwareManufacturerEmail(String softwareManufacturerEmail) {
		this.softwareManufacturerEmail = softwareManufacturerEmail;
	}

	public String getSoftwareName() {
		return this.softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public int getSoftwareNumberOfLicenses() {
		return this.softwareNumberOfLicenses;
	}

	public void setSoftwareNumberOfLicenses(int softwareNumberOfLicenses) {
		this.softwareNumberOfLicenses = softwareNumberOfLicenses;
	}

	public String getSoftwareSerial() {
		return this.softwareSerial;
	}

	public void setSoftwareSerial(String softwareSerial) {
		this.softwareSerial = softwareSerial;
	}

	public String getSoftwareVersion() {
		return this.softwareVersion;
	}

	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	public List<MachineCapacityTb> getMachineCapacityTbs() {
		return this.machineCapacityTbs;
	}

	public void setMachineCapacityTbs(List<MachineCapacityTb> machineCapacityTbs) {
		this.machineCapacityTbs = machineCapacityTbs;
	}

	public MachineCapacityTb addMachineCapacityTb(MachineCapacityTb machineCapacityTb) {
		getMachineCapacityTbs().add(machineCapacityTb);
		machineCapacityTb.setSoftwareTb(this);

		return machineCapacityTb;
	}

	public MachineCapacityTb removeMachineCapacityTb(MachineCapacityTb machineCapacityTb) {
		getMachineCapacityTbs().remove(machineCapacityTb);
		machineCapacityTb.setSoftwareTb(null);

		return machineCapacityTb;
	}

	public SoftwareTypeTb getSoftwareTypeTb() {
		return this.softwareTypeTb;
	}

	public void setSoftwareTypeTb(SoftwareTypeTb softwareTypeTb) {
		this.softwareTypeTb = softwareTypeTb;
	}

}