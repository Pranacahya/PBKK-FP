package com.PBKK.SIPTC.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="status_transaksi")
public class Status {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id_status;
	
	@Column(name="nama_status")
	private String nama_status;
	
	@OneToMany(mappedBy="status")
	private Set<Transaksi> transactions;

	public Status(int id_status, String nama_status) {
		this.id_status = id_status;
		this.nama_status = nama_status;
	}

	public Status() {
		
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}

	public String getNama_status() {
		return nama_status;
	}

	public void setNama_status(String nama_status) {
		this.nama_status = nama_status;
	}

	public Set<Transaksi> getTransactions() {
		return transactions;
	}
}
