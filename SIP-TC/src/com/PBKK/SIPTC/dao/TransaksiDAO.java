package com.PBKK.SIPTC.dao;

import com.PBKK.SIPTC.entity.Transaksi;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface TransaksiDAO {
	
	public List<Transaksi> getAllTransaksi();
	
	public Transaksi getTransaksi(int id);
	
	public void updateTransaksi(Transaksi transaksi);
	
	public void pushTransaksi(String user,
							String nrp,
							MultipartFile file,
							String copies, 
							String pages, 
							String color,
							String paper,
							String side,
							String note) ;
	
	public void deleteTransaksi(int id);
}