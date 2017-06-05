package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the volume_type_tb database table.
 * 
 */
@Entity
@Table(name="volume_type_tb")
@NamedQuery(name="VolumeTypeTb.findAll", query="SELECT v FROM VolumeTypeTb v")
public class VolumeTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_volume_type")
	private int idVolumeType;

	@Column(name="volume_desc")
	private String volumeDesc;

	@Column(name="volume_feature")
	private String volumeFeature;

	//bi-directional many-to-one association to VolumeTb
	@OneToMany(mappedBy="volumeTypeTb")
	private List<VolumeTb> volumeTbs;

	public VolumeTypeTb() {
	}

	public int getIdVolumeType() {
		return this.idVolumeType;
	}

	public void setIdVolumeType(int idVolumeType) {
		this.idVolumeType = idVolumeType;
	}

	public String getVolumeDesc() {
		return this.volumeDesc;
	}

	public void setVolumeDesc(String volumeDesc) {
		this.volumeDesc = volumeDesc;
	}

	public String getVolumeFeature() {
		return this.volumeFeature;
	}

	public void setVolumeFeature(String volumeFeature) {
		this.volumeFeature = volumeFeature;
	}

	public List<VolumeTb> getVolumeTbs() {
		return this.volumeTbs;
	}

	public void setVolumeTbs(List<VolumeTb> volumeTbs) {
		this.volumeTbs = volumeTbs;
	}

	public VolumeTb addVolumeTb(VolumeTb volumeTb) {
		getVolumeTbs().add(volumeTb);
		volumeTb.setVolumeTypeTb(this);

		return volumeTb;
	}

	public VolumeTb removeVolumeTb(VolumeTb volumeTb) {
		getVolumeTbs().remove(volumeTb);
		volumeTb.setVolumeTypeTb(null);

		return volumeTb;
	}

}