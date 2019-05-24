package com.PBKK.SIPTC.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Entity
@Table(name="admin")
// @Scope(value=WebApplicationContext.SCOPE_SESSION, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_admin")
	private int id_admin;
	
	@Column(name="nama_admin")
	private String nama_admin;
	
	@Column(name="nrp_admin")
	private String nrp_admin;
	
	@Column(name="no_telp")
	private String no_telp;
	
	@Column(name="email_admin")
	private String email_admin;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="admin")
	private Set<Transaksi> transactions;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String nama_admin, String nrp_admin, String no_telp, String email_admin, String password) {
		this.nama_admin = nama_admin;
		this.nrp_admin = nrp_admin;
		this.no_telp = no_telp;
		this.email_admin = email_admin;
		this.password = password;
	}

	public String getNama_admin() {
		return nama_admin;
	}

	public void setNama_admin(String nama_admin) {
		this.nama_admin = nama_admin;
	}

	public String getNrp_admin() {
		return nrp_admin;
	}

	public void setNrp_admin(String nrp_admin) {
		this.nrp_admin = nrp_admin;
	}

	public String getNo_telp() {
		return no_telp;
	}

	public void setNo_telp(String no_telp) {
		this.no_telp = no_telp;
	}

	public String getEmail_admin() {
		return email_admin;
	}

	public void setEmail_admin(String email_admin) {
		this.email_admin = email_admin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_admin() {
		return id_admin;
	}
}

