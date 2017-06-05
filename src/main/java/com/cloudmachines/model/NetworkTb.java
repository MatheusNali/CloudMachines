package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the network_tb database table.
 * 
 */
@Entity
@Table(name="network_tb")
@NamedQuery(name="NetworkTb.findAll", query="SELECT n FROM NetworkTb n")
public class NetworkTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_network")
	private int idNetwork;

	@Column(name="network_bandwidth")
	private int networkBandwidth;

	@Column(name="network_desc")
	private String networkDesc;

	@Column(name="network_route")
	private String networkRoute;

	@Column(name="network_security")
	private byte networkSecurity;

	//bi-directional many-to-one association to NetworkTypeTb
	@ManyToOne
	@JoinColumn(name="id_network_type")
	private NetworkTypeTb networkTypeTb;

	//bi-directional many-to-one association to ProtocolTb
	@ManyToOne
	@JoinColumn(name="id_protocol")
	private ProtocolTb protocolTb;

	//bi-directional many-to-one association to ResourceTb
	@OneToMany(mappedBy="networkTb")
	private List<ResourceTb> resourceTbs;

	public NetworkTb() {
	}

	public int getIdNetwork() {
		return this.idNetwork;
	}

	public void setIdNetwork(int idNetwork) {
		this.idNetwork = idNetwork;
	}

	public int getNetworkBandwidth() {
		return this.networkBandwidth;
	}

	public void setNetworkBandwidth(int networkBandwidth) {
		this.networkBandwidth = networkBandwidth;
	}

	public String getNetworkDesc() {
		return this.networkDesc;
	}

	public void setNetworkDesc(String networkDesc) {
		this.networkDesc = networkDesc;
	}

	public String getNetworkRoute() {
		return this.networkRoute;
	}

	public void setNetworkRoute(String networkRoute) {
		this.networkRoute = networkRoute;
	}

	public byte getNetworkSecurity() {
		return this.networkSecurity;
	}

	public void setNetworkSecurity(byte networkSecurity) {
		this.networkSecurity = networkSecurity;
	}

	public NetworkTypeTb getNetworkTypeTb() {
		return this.networkTypeTb;
	}

	public void setNetworkTypeTb(NetworkTypeTb networkTypeTb) {
		this.networkTypeTb = networkTypeTb;
	}

	public ProtocolTb getProtocolTb() {
		return this.protocolTb;
	}

	public void setProtocolTb(ProtocolTb protocolTb) {
		this.protocolTb = protocolTb;
	}

	public List<ResourceTb> getResourceTbs() {
		return this.resourceTbs;
	}

	public void setResourceTbs(List<ResourceTb> resourceTbs) {
		this.resourceTbs = resourceTbs;
	}

	public ResourceTb addResourceTb(ResourceTb resourceTb) {
		getResourceTbs().add(resourceTb);
		resourceTb.setNetworkTb(this);

		return resourceTb;
	}

	public ResourceTb removeResourceTb(ResourceTb resourceTb) {
		getResourceTbs().remove(resourceTb);
		resourceTb.setNetworkTb(null);

		return resourceTb;
	}

}