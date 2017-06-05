package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the image_type_tb database table.
 * 
 */
@Entity
@Table(name="image_type_tb")
@NamedQuery(name="ImageTypeTb.findAll", query="SELECT i FROM ImageTypeTb i")
public class ImageTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_image_type")
	private int idImageType;

	@Column(name="image_desc")
	private String imageDesc;

	@Column(name="image_feature")
	private String imageFeature;

	//bi-directional many-to-one association to VolumeTb
	@OneToMany(mappedBy="imageTypeTb")
	private List<VolumeTb> volumeTbs;

	public ImageTypeTb() {
	}

	public int getIdImageType() {
		return this.idImageType;
	}

	public void setIdImageType(int idImageType) {
		this.idImageType = idImageType;
	}

	public String getImageDesc() {
		return this.imageDesc;
	}

	public void setImageDesc(String imageDesc) {
		this.imageDesc = imageDesc;
	}

	public String getImageFeature() {
		return this.imageFeature;
	}

	public void setImageFeature(String imageFeature) {
		this.imageFeature = imageFeature;
	}

	public List<VolumeTb> getVolumeTbs() {
		return this.volumeTbs;
	}

	public void setVolumeTbs(List<VolumeTb> volumeTbs) {
		this.volumeTbs = volumeTbs;
	}

	public VolumeTb addVolumeTb(VolumeTb volumeTb) {
		getVolumeTbs().add(volumeTb);
		volumeTb.setImageTypeTb(this);

		return volumeTb;
	}

	public VolumeTb removeVolumeTb(VolumeTb volumeTb) {
		getVolumeTbs().remove(volumeTb);
		volumeTb.setImageTypeTb(null);

		return volumeTb;
	}

}