package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the encryption_type database table.
 * 
 */
@Entity
@Table(name="encryption_type")
@NamedQuery(name="EncryptionType.findAll", query="SELECT e FROM EncryptionType e")
public class EncryptionType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_encryption_type")
	private int idEncryptionType;

	@Column(name="encryption_desc")
	private String encryptionDesc;

	@Column(name="encryption_feature")
	private String encryptionFeature;

	public EncryptionType() {
	}

	public int getIdEncryptionType() {
		return this.idEncryptionType;
	}

	public void setIdEncryptionType(int idEncryptionType) {
		this.idEncryptionType = idEncryptionType;
	}

	public String getEncryptionDesc() {
		return this.encryptionDesc;
	}

	public void setEncryptionDesc(String encryptionDesc) {
		this.encryptionDesc = encryptionDesc;
	}

	public String getEncryptionFeature() {
		return this.encryptionFeature;
	}

	public void setEncryptionFeature(String encryptionFeature) {
		this.encryptionFeature = encryptionFeature;
	}

}