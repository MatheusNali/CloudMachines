package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the resource_tb database table.
 * 
 */
@Entity
@Table(name="resource_tb")
@NamedQuery(name="ResourceTb.findAll", query="SELECT r FROM ResourceTb r")
public class ResourceTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_resource")
	private int idResource;

	@Column(name="resource_power_consume")
	private BigDecimal resourcePowerConsume;

	@Column(name="resource_price")
	private BigDecimal resourcePrice;

	//bi-directional many-to-one association to MachineCapacityTb
	@OneToMany(mappedBy="resourceTb")
	private List<MachineCapacityTb> machineCapacityTbs;

	//bi-directional many-to-one association to ComputeTb
	@ManyToOne
	@JoinColumn(name="id_compute")
	private ComputeTb computeTb;

	//bi-directional many-to-one association to MemoryTb
	@ManyToOne
	@JoinColumn(name="id_memory")
	private MemoryTb memoryTb;

	//bi-directional many-to-one association to NetworkTb
	@ManyToOne
	@JoinColumn(name="id_network")
	private NetworkTb networkTb;

	//bi-directional many-to-one association to ResourceManufacturerTb
	@ManyToOne
	@JoinColumn(name="id_resource_manufacturer")
	private ResourceManufacturerTb resourceManufacturerTb;

	//bi-directional many-to-one association to ResourceModelTb
	@ManyToOne
	@JoinColumn(name="id_resource_model")
	private ResourceModelTb resourceModelTb;

	//bi-directional many-to-one association to StorageTb
	@ManyToOne
	@JoinColumn(name="id_storage")
	private StorageTb storageTb;

	//bi-directional many-to-one association to VolumeTb
	@ManyToOne
	@JoinColumn(name="id_volume")
	private VolumeTb volumeTb;

	public ResourceTb() {
	}

	public int getIdResource() {
		return this.idResource;
	}

	public void setIdResource(int idResource) {
		this.idResource = idResource;
	}

	public BigDecimal getResourcePowerConsume() {
		return this.resourcePowerConsume;
	}

	public void setResourcePowerConsume(BigDecimal resourcePowerConsume) {
		this.resourcePowerConsume = resourcePowerConsume;
	}

	public BigDecimal getResourcePrice() {
		return this.resourcePrice;
	}

	public void setResourcePrice(BigDecimal resourcePrice) {
		this.resourcePrice = resourcePrice;
	}

	public List<MachineCapacityTb> getMachineCapacityTbs() {
		return this.machineCapacityTbs;
	}

	public void setMachineCapacityTbs(List<MachineCapacityTb> machineCapacityTbs) {
		this.machineCapacityTbs = machineCapacityTbs;
	}

	public MachineCapacityTb addMachineCapacityTb(MachineCapacityTb machineCapacityTb) {
		getMachineCapacityTbs().add(machineCapacityTb);
		machineCapacityTb.setResourceTb(this);

		return machineCapacityTb;
	}

	public MachineCapacityTb removeMachineCapacityTb(MachineCapacityTb machineCapacityTb) {
		getMachineCapacityTbs().remove(machineCapacityTb);
		machineCapacityTb.setResourceTb(null);

		return machineCapacityTb;
	}

	public ComputeTb getComputeTb() {
		return this.computeTb;
	}

	public void setComputeTb(ComputeTb computeTb) {
		this.computeTb = computeTb;
	}

	public MemoryTb getMemoryTb() {
		return this.memoryTb;
	}

	public void setMemoryTb(MemoryTb memoryTb) {
		this.memoryTb = memoryTb;
	}

	public NetworkTb getNetworkTb() {
		return this.networkTb;
	}

	public void setNetworkTb(NetworkTb networkTb) {
		this.networkTb = networkTb;
	}

	public ResourceManufacturerTb getResourceManufacturerTb() {
		return this.resourceManufacturerTb;
	}

	public void setResourceManufacturerTb(ResourceManufacturerTb resourceManufacturerTb) {
		this.resourceManufacturerTb = resourceManufacturerTb;
	}

	public ResourceModelTb getResourceModelTb() {
		return this.resourceModelTb;
	}

	public void setResourceModelTb(ResourceModelTb resourceModelTb) {
		this.resourceModelTb = resourceModelTb;
	}

	public StorageTb getStorageTb() {
		return this.storageTb;
	}

	public void setStorageTb(StorageTb storageTb) {
		this.storageTb = storageTb;
	}

	public VolumeTb getVolumeTb() {
		return this.volumeTb;
	}

	public void setVolumeTb(VolumeTb volumeTb) {
		this.volumeTb = volumeTb;
	}

}