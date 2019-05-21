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


	@Override
	public String toString() {
		return "Transaksi [id=" + id + ", id_admin=" + id_admin + ", tanggal_transaksi=" + tanggal_transaksi
				+ ", waktu_transaksi=" + waktu_transaksi + ", nama_user=" + nama_user + ", nrp_user=" + nrp_user
				+ ", total_harga=" + total_harga + "]";
	}	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}


	public Transaksi() {
		
	}

	public Transaksi( int id_admin,String tanggal_transaksi, String waktu_transaksi, String nama_user, String nrp_user,
			int total_harga) 
	{	
		this.id_admin = id_admin;
		this.tanggal_transaksi = tanggal_transaksi;
		this.waktu_transaksi = waktu_transaksi;
		this.nama_user = nama_user;
		this.nrp_user = nrp_user;
		this.total_harga = total_harga;
	}
	


}
