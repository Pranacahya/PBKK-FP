package com.PBKK.SIPTC;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaksi_print")
public class Transaksi {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="id_admin")
	private int id_admin;

	@Column(name="tanggal_transaksi")
	private String tanggal_transaksi;
	
	@Column(name="waktu_transaksi")
	private String waktu_transaksi;
	
	@Column(name="nama_user")
	private String nama_user;
	
	@Column(name="nrp_user")
	private String nrp_user;

	@Column(name="note_user")
	private String note_user;
	
	@Column(name="file_user")
	private String file_user;
	
	public String getFile_user() {
		return file_user;
	}

	public void setFile_user(String file_user) {
		this.file_user = file_user;
	}

	public int getId_admin() {
		return id_admin;
	}

	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}

	public String getTanggal_transaksi() {
		return tanggal_transaksi;
	}

	public void setTanggal_transaksi(String tanggal_transaksi) {
		this.tanggal_transaksi = tanggal_transaksi;
	}

	public String getWaktu_transaksi() {
		return waktu_transaksi;
	}

	public void setWaktu_transaksi(String waktu_transaksi) {
		this.waktu_transaksi = waktu_transaksi;
	}

	public String getNama_user() {
		return nama_user;
	}

	public void setNama_user(String nama_user) {
		this.nama_user = nama_user;
	}

	public String getNrp_user() {
		return nrp_user;
	}

	public Transaksi(int id_admin, String tanggal_transaksi, String waktu_transaksi, String nama_user, String nrp_user,
			String note_user, String file_user, int total_harga) {
		this.id_admin = id_admin;
		this.tanggal_transaksi = tanggal_transaksi;
		this.waktu_transaksi = waktu_transaksi;
		this.nama_user = nama_user;
		this.nrp_user = nrp_user;
		this.note_user = note_user;
		this.file_user = file_user;
		this.total_harga = total_harga;
	}

	public String getNote_user() {
		return note_user;
	}

	public void setNote_user(String note_user) {
		this.note_user = note_user;
	}

	public void setNrp_user(String nrp_user) {
		this.nrp_user = nrp_user;
	}

	public int getTotal_harga() {
		return total_harga;
	}

	public void setTotal_harga(int total_harga) {
		this.total_harga = total_harga;
	}

	@Column(name="total_harga")
	private int total_harga;

	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public Transaksi() {
		
	}


}
