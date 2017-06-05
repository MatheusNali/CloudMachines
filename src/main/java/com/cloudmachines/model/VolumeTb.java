package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the volume_tb database table.
 * 
 */
@Entity
@Table(name="volume_tb")
@NamedQuery(name="VolumeTb.findAll", query="SELECT v FROM VolumeTb v")
public class VolumeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_volume")
	private int idVolume;

	@Column(name="id_encryption_type")
	private int idEncryptionType;

	@Column(name="volume_cloneable")
	private byte volumeCloneable;

	@Column(name="volume_desc")
	private String volumeDesc;

	@Column(name="volume_max_size")
	private int volumeMaxSize;

	@Column(name="volume_min_size")
	private int volumeMinSize;

	@Column(name="volume_name")
	private String volumeName;

	@Column(name="volume_path")
	private String volumePath;

	@Column(name="volume_pool")
	private String volumePool;

	@Column(name="volume_size")
	private int volumeSize;

	//bi-directional many-to-one association to ResourceTb
	@OneToMany(mappedBy="volumeTb")
	private List<ResourceTb> resourceTbs;

	//bi-directional many-to-one association to ImageTypeTb
	@ManyToOne
	@JoinColumn(name="id_image_type")
	private ImageTypeTb imageTypeTb;

	//bi-directional many-to-one association to VolumeTypeTb
	@ManyToOne
	@JoinColumn(name="id_volume_type")
	private VolumeTypeTb volumeTypeTb;

	public VolumeTb() {
	}

	public int getIdVolume() {
		return this.idVolume;
	}

	public void setIdVolume(int idVolume) {
		this.idVolume = idVolume;
	}

	public int getIdEncryptionType() {
		return this.idEncryptionType;
	}

	public void setIdEncryptionType(int idEncryptionType) {
		this.idEncryptionType = idEncryptionType;
	}

	public byte getVolumeCloneable() {
		return this.volumeCloneable;
	}

	public void setVolumeCloneable(byte volumeCloneable) {
		this.volumeCloneable = volumeCloneable;
	}

	public String getVolumeDesc() {
		return this.volumeDesc;
	}

	public void setVolumeDesc(String volumeDesc) {
		this.volumeDesc = volumeDesc;
	}

	public int getVolumeMaxSize() {
		return this.volumeMaxSize;
	}

	public void setVolumeMaxSize(int volumeMaxSize) {
		this.volumeMaxSize = volumeMaxSize;
	}

	public int getVolumeMinSize() {
		return this.volumeMinSize;
	}

	public void setVolumeMinSize(int volumeMinSize) {
		this.volumeMinSize = volumeMinSize;
	}

	public String getVolumeName() {
		return this.volumeName;
	}

	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}

	public String getVolumePath() {
		return this.volumePath;
	}

	public void setVolumePath(String volumePath) {
		this.volumePath = volumePath;
	}

	public String getVolumePool() {
		return this.volumePool;
	}

	public void setVolumePool(String volumePool) {
		this.volumePool = volumePool;
	}

	public int getVolumeSize() {
		return this.volumeSize;
	}

	public void setVolumeSize(int volumeSize) {
		this.volumeSize = volumeSize;
	}

	public List<ResourceTb> getResourceTbs() {
		return this.resourceTbs;
	}

	public void setResourceTbs(List<ResourceTb> resourceTbs) {
		this.resourceTbs = resourceTbs;
	}

	public ResourceTb addResourceTb(ResourceTb resourceTb) {
		getResourceTbs().add(resourceTb);
		resourceTb.setVolumeTb(this);

		return resourceTb;
	}

	public ResourceTb removeResourceTb(ResourceTb resourceTb) {
		getResourceTbs().remove(resourceTb);
		resourceTb.setVolumeTb(null);

		return resourceTb;
	}

	public ImageTypeTb getImageTypeTb() {
		return this.imageTypeTb;
	}

	public void setImageTypeTb(ImageTypeTb imageTypeTb) {
		this.imageTypeTb = imageTypeTb;
	}

	public VolumeTypeTb getVolumeTypeTb() {
		return this.volumeTypeTb;
	}

	public void setVolumeTypeTb(VolumeTypeTb volumeTypeTb) {
		this.volumeTypeTb = volumeTypeTb;
	}

}