package com.PBKK.SIPTC.dao;

import java.util.List;

import com.PBKK.SIPTC.entity.Status;

public interface StatusDAO {
	
	public List<Status> getAllStatus();
	
	public Status getStatus(int theId);
}
