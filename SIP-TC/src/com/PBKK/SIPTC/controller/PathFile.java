package com.PBKK.SIPTC.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="file_print")
public class PathFile {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="path_file")
	private String pathFile;

	public PathFile()
	{
		
	}


	public PathFile(String pathFile) {
		super();
		this.pathFile = pathFile;
	}


	public String getPathFile() {
		return pathFile;
	}


	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}


	public int getId() 
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

}
