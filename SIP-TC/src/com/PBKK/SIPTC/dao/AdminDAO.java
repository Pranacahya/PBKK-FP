package com.PBKK.SIPTC.dao;

import com.PBKK.SIPTC.entity.Admin;

public interface AdminDAO {

	public Admin getAdmin(String nrp, String password);
}
