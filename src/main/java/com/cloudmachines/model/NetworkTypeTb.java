package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the network_type_tb database table.
 * 
 */
@Entity
@Table(name="network_type_tb")
@NamedQuery(name="NetworkTypeTb.findAll", query="SELECT n FROM NetworkTypeTb n")
public class NetworkTypeTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_network_type")
	private int idNetworkType;

	@Column(name="network_type_desc")
	private String networkTypeDesc;

	@Column(name="network_type_feature")
	private String networkTypeFeature;

	//bi-directional many-to-one association to NetworkTb
	@OneToMany(mappedBy="networkTypeTb")
	private List<NetworkTb> networkTbs;

	public NetworkTypeTb() {
	}

	public int getIdNetworkType() {
		return this.idNetworkType;
	}

	public void setIdNetworkType(int idNetworkType) {
		this.idNetworkType = idNetworkType;
	}

	public String getNetworkTypeDesc() {
		return this.networkTypeDesc;
	}

	public void setNetworkTypeDesc(String networkTypeDesc) {
		this.networkTypeDesc = networkTypeDesc;
	}

	public String getNetworkTypeFeature() {
		return this.networkTypeFeature;
	}

	public void setNetworkTypeFeature(String networkTypeFeature) {
		this.networkTypeFeature = networkTypeFeature;
	}

	public List<NetworkTb> getNetworkTbs() {
		return this.networkTbs;
	}

	public void setNetworkTbs(List<NetworkTb> networkTbs) {
		this.networkTbs = networkTbs;
	}

	public NetworkTb addNetworkTb(NetworkTb networkTb) {
		getNetworkTbs().add(networkTb);
		networkTb.setNetworkTypeTb(this);

		return networkTb;
	}

	public NetworkTb removeNetworkTb(NetworkTb networkTb) {
		getNetworkTbs().remove(networkTb);
		networkTb.setNetworkTypeTb(null);

		return networkTb;
	}

}