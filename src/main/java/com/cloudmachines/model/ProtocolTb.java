package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the protocol_tb database table.
 * 
 */
@Entity
@Table(name="protocol_tb")
@NamedQuery(name="ProtocolTb.findAll", query="SELECT p FROM ProtocolTb p")
public class ProtocolTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_protocol")
	private int idProtocol;

	@Column(name="procotol_acronym")
	private String procotolAcronym;

	@Column(name="protocol_desc")
	private String protocolDesc;

	@Column(name="protocol_feature")
	private String protocolFeature;

	//bi-directional many-to-one association to NetworkTb
	@OneToMany(mappedBy="protocolTb")
	private List<NetworkTb> networkTbs;

	public ProtocolTb() {
	}

	public int getIdProtocol() {
		return this.idProtocol;
	}

	public void setIdProtocol(int idProtocol) {
		this.idProtocol = idProtocol;
	}

	public String getProcotolAcronym() {
		return this.procotolAcronym;
	}

	public void setProcotolAcronym(String procotolAcronym) {
		this.procotolAcronym = procotolAcronym;
	}

	public String getProtocolDesc() {
		return this.protocolDesc;
	}

	public void setProtocolDesc(String protocolDesc) {
		this.protocolDesc = protocolDesc;
	}

	public String getProtocolFeature() {
		return this.protocolFeature;
	}

	public void setProtocolFeature(String protocolFeature) {
		this.protocolFeature = protocolFeature;
	}

	public List<NetworkTb> getNetworkTbs() {
		return this.networkTbs;
	}

	public void setNetworkTbs(List<NetworkTb> networkTbs) {
		this.networkTbs = networkTbs;
	}

	public NetworkTb addNetworkTb(NetworkTb networkTb) {
		getNetworkTbs().add(networkTb);
		networkTb.setProtocolTb(this);

		return networkTb;
	}

	public NetworkTb removeNetworkTb(NetworkTb networkTb) {
		getNetworkTbs().remove(networkTb);
		networkTb.setProtocolTb(null);

		return networkTb;
	}

}