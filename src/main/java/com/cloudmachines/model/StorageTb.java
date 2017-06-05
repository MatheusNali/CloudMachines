package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the storage_tb database table.
 * 
 */
@Entity
@Table(name="storage_tb")
@NamedQuery(name="StorageTb.findAll", query="SELECT s FROM StorageTb s")
public class StorageTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_storage")
	private int idStorage;

	@Column(name="storage_max_size")
	private int storageMaxSize;

	@Column(name="storage_min_size")
	private int storageMinSize;

	@Column(name="storage_size")
	private int storageSize;

	//bi-directional many-to-one association to ResourceTb
	@OneToMany(mappedBy="storageTb")
	private List<ResourceTb> resourceTbs;

	//bi-directional many-to-one association to StorageTypeTb
	@ManyToOne
	@JoinColumn(name="id_storage_type")
	private StorageTypeTb storageTypeTb;

	public StorageTb() {
	}

	public int getIdStorage() {
		return this.idStorage;
	}

	public void setIdStorage(int idStorage) {
		this.idStorage = idStorage;
	}

	public int getStorageMaxSize() {
		return this.storageMaxSize;
	}

	public void setStorageMaxSize(int storageMaxSize) {
		this.storageMaxSize = storageMaxSize;
	}

	public int getStorageMinSize() {
		return this.storageMinSize;
	}

	public void setStorageMinSize(int storageMinSize) {
		this.storageMinSize = storageMinSize;
	}

	public int getStorageSize() {
		return this.storageSize;
	}

	public void setStorageSize(int storageSize) {
		this.storageSize = storageSize;
	}

	public List<ResourceTb> getResourceTbs() {
		return this.resourceTbs;
	}

	public void setResourceTbs(List<ResourceTb> resourceTbs) {
		this.resourceTbs = resourceTbs;
	}

	public ResourceTb addResourceTb(ResourceTb resourceTb) {
		getResourceTbs().add(resourceTb);
		resourceTb.setStorageTb(this);

		return resourceTb;
	}

	public ResourceTb removeResourceTb(ResourceTb resourceTb) {
		getResourceTbs().remove(resourceTb);
		resourceTb.setStorageTb(null);

		return resourceTb;
	}

	public StorageTypeTb getStorageTypeTb() {
		return this.storageTypeTb;
	}

	public void setStorageTypeTb(StorageTypeTb storageTypeTb) {
		this.storageTypeTb = storageTypeTb;
	}

}