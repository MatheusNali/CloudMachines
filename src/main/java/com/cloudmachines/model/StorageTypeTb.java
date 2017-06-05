package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the storage_type_tb database table.
 * 
 */
@Entity
@Table(name="storage_type_tb")
@NamedQuery(name="StorageTypeTb.findAll", query="SELECT s FROM StorageTypeTb s")
public class StorageTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_storage_type")
	private int idStorageType;

	@Column(name="storage_desc")
	private String storageDesc;

	@Column(name="storage_feature")
	private String storageFeature;

	//bi-directional many-to-one association to StorageTb
	@OneToMany(mappedBy="storageTypeTb")
	private List<StorageTb> storageTbs;

	public StorageTypeTb() {
	}

	public int getIdStorageType() {
		return this.idStorageType;
	}

	public void setIdStorageType(int idStorageType) {
		this.idStorageType = idStorageType;
	}

	public String getStorageDesc() {
		return this.storageDesc;
	}

	public void setStorageDesc(String storageDesc) {
		this.storageDesc = storageDesc;
	}

	public String getStorageFeature() {
		return this.storageFeature;
	}

	public void setStorageFeature(String storageFeature) {
		this.storageFeature = storageFeature;
	}

	public List<StorageTb> getStorageTbs() {
		return this.storageTbs;
	}

	public void setStorageTbs(List<StorageTb> storageTbs) {
		this.storageTbs = storageTbs;
	}

	public StorageTb addStorageTb(StorageTb storageTb) {
		getStorageTbs().add(storageTb);
		storageTb.setStorageTypeTb(this);

		return storageTb;
	}

	public StorageTb removeStorageTb(StorageTb storageTb) {
		getStorageTbs().remove(storageTb);
		storageTb.setStorageTypeTb(null);

		return storageTb;
	}

}