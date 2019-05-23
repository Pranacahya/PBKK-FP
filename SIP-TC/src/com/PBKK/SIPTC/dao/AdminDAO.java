package com.PBKK.SIPTC.dao;

import java.util.List;

import com.PBKK.SIPTC.entity.Admin;
import com.PBKK.SIPTC.entity.Transaksi;

public interface AdminDAO {

	public Admin getAdmin(String nrp, String password);
}
