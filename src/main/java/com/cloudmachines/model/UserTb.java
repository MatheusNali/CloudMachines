package com.cloudmachines.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_tb database table.
 * 
 */
@Entity
@Table(name="user_tb")
@NamedQuery(name="UserTb.findAll", query="SELECT u FROM UserTb u")
public class UserTb implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_user")
	private int idUser;

	private String description;

	private String email;

	private String name;

	private String password;

	//bi-directional many-to-one association to ClientTb
	@ManyToOne
	@JoinColumn(name="id_client")
	private ClientTb clientTb;

	public UserTb() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ClientTb getClientTb() {
		return this.clientTb;
	}

	public void setClientTb(ClientTb clientTb) {
		this.clientTb = clientTb;
	}

}