package com.PBKK.SIPTC;

public class User {
	String nameUser;
	String nrpUser;	
	String urlUser;

	public User()
	{
		
	}

	public User(String nameUser, String nrpUser, String urlUser) {
		super();
		this.nameUser = nameUser;
		this.nrpUser = nrpUser;
		this.urlUser = urlUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getNrpUser() {
		return nrpUser;
	}

	public void setNrpUser(String nrpUser) {
		this.nrpUser = nrpUser;
	}

	public String getUrlUser() {
		return urlUser;
	}

	public void setUrlUser(String urlUser) {
		this.urlUser = urlUser;
	}
	
	
}
